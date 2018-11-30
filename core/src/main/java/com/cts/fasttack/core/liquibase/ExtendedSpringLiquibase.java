package com.cts.fasttack.core.liquibase;

import liquibase.integration.spring.SpringLiquibase;
import liquibase.util.file.FilenameUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.util.ResourceUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.HashSet;
import java.util.Set;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

/**
 * @author Anton Leliuk
 */
public class ExtendedSpringLiquibase extends SpringLiquibase {

    public class ExtendedSpringResourceOpener extends SpringLiquibase.SpringResourceOpener {

        private String parentFile;
        public ExtendedSpringResourceOpener(String parentFile) {
            super(parentFile);
            this.parentFile = parentFile;
        }

        @Override
        protected void init() {
            super.init();
            try {
                Resource[] resources = ResourcePatternUtils.getResourcePatternResolver(getResourceLoader()).getResources("");
                if (resources.length == 0 || resources.length == 1 && !resources[0].exists()) { //sometimes not able to look up by empty string, try all the liquibase packages
                    Set<String> liquibasePackages = new HashSet<>();
                    for (Resource manifest : ResourcePatternUtils.getResourcePatternResolver(getResourceLoader()).getResources("META-INF/MANIFEST.MF")) {
                        if (manifest.exists()) {
                            InputStream inputStream = null;
                            try {
                                inputStream = manifest.getInputStream();
                                Manifest manifestObj = new Manifest(inputStream);
                                Attributes attributes = manifestObj.getAttributes("Liquibase-Package");
                                if (attributes != null) {
                                    for (Object attr : attributes.values()) {
                                        String packages = "\\s*,\\s*";

                                        for (String fullPackage : attr.toString().split(packages)) {
                                            liquibasePackages.add(fullPackage.split("\\.")[0]);
                                        }
                                    }
                                }
                            } finally {
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                            }
                        }
                    }

                    if (liquibasePackages.size() == 0) {
                        log.warning("No Liquibase-Packages entry found in MANIFEST.MF. Using fallback of entire 'liquibase' package");
                        liquibasePackages.add("liquibase");
                    }

                    for (String foundPackage : liquibasePackages) {
                        resources = ResourcePatternUtils.getResourcePatternResolver(getResourceLoader()).getResources(foundPackage);
                        for (Resource res : resources) {
                            addRootPath(res.getURL());
                        }
                    }
                } else {
                    for (Resource res : resources) {
                        addRootPath(res.getURL());
                    }
                }
            } catch (IOException e) {
                log.warning("Error initializing SpringLiquibase", e);
            }
        }

        @Override
        public Set<String> list(String relativeTo, String path, boolean includeFiles, boolean includeDirectories, boolean recursive) throws IOException {
            if (path == null) {
                return null;
            }

            Set<String> returnSet = new HashSet<>();

            String tempFile = FilenameUtils.concat(FilenameUtils.getFullPath(relativeTo), path);

            /*
             * remove the last slash, which added by liquibase to make path like folder,
             * in our case we need to use standard spring resource pattern
             */
            if(tempFile.endsWith("/")){
                tempFile = tempFile.substring(0, path.lastIndexOf("/"));
            }

            Resource[] resources = ResourcePatternUtils.getResourcePatternResolver(getResourceLoader()).getResources(adjustClasspath(tempFile));

            for (Resource res : resources) {
                String resourcePath = res.getURL().getPath();
                returnSet.add(resourcePath.substring(resourcePath.indexOf("/liquibase/migration")));
            }

            return returnSet;
        }

        @Override
        public Set<InputStream> getResourcesAsStream(String path) throws IOException {
            if (path == null) {
                return null;
            }
            Set<InputStream> returnSet = new HashSet<>();
            Resource[] resources = ResourcePatternUtils.getResourcePatternResolver(getResourceLoader()).getResources(adjustClasspath(path));

            if (resources == null || resources.length == 0) {
                return null;
            }
            for (Resource resource : resources) {
                log.debug("Opening "+resource.getURL().toExternalForm()+" as "+path);
                URLConnection connection = resource.getURL().openConnection();
                connection.setUseCaches(false);
                returnSet.add(connection.getInputStream());
            }

            return returnSet;
        }

        private String adjustPrefix(String file, String prefix){
            if (file == null) {
                return null;
            }
            return isPrefixPresent(parentFile) && !isPrefixPresent(file) ? prefix + file : file;
        }

        private String adjustClasspath(String file) {
            return adjustPrefix(file, ResourceUtils.CLASSPATH_URL_PREFIX);
        }

        public boolean isPrefixPresent(String file) {
            return file != null && (file.startsWith("classpath") || file.startsWith(ResourceUtils.FILE_URL_PREFIX) || file.startsWith("url:"));
        }

        @Override
        public ClassLoader toClassLoader() {
            return getResourceLoader().getClassLoader();
        }
    }

    /**
     * Create a new resourceOpener.
     */
    protected ExtendedSpringLiquibase.SpringResourceOpener createResourceOpener() {
        return new ExtendedSpringLiquibase.ExtendedSpringResourceOpener(getChangeLog());
    }

    @Override
    public String toString() {
        return getClass().getName() + "(" + this.getResourceLoader().toString() + ")";
    }
}
