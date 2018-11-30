#!/bin/bash

#
# release-version-up.sh<TO>
#
# ./release-version-up.sh 1.1.649
#

version_file="version.txt"

RELEASE_VER_FROM=$(cat "$version_file")
RELEASE_VER_TO=$1
POM_FILE='pom.xml'


COUNTER=0

shopt -s globstar

for pom_file in **/$POM_FILE
do
    if [ -f "$pom_file" ];
    then
        COUNTER=$((COUNTER+1))
        echo "$COUNTER. $pom_file"
        pom_file_version=$pom_file".tmp1"
        pom_file_dev=$pom_file".tmp2"
        pom_file_release=$pom_file".tmp3"

        #
        # Up Version for RELEASE profile
        #
        sed '/<project / {
            :start
            N
            /<\/project>$/!b start
            /<groupId>com.cts.fasttack/ {
                s/\(<version>\)'"$RELEASE_VER_FROM"'\(<\/version>\)/\1'"$RELEASE_VER_TO"'\2/
            }
        }' $pom_file > $pom_file_version

        #
        # Off default DEV profile
        #
        sed '/<project / {
            :start
            N
            /<\/project>$/!b start
            /<id>release<\/id>/ {
                s/\(<activeByDefault>\)'"false"'\(<\/activeByDefault>\)/\1'"true"'\2/
            }
        }' $pom_file_version > $pom_file_dev

        #
        # On default RELEASE profile
        #
        sed '/<project / {
            :start
            N
            /<\/project>$/!b start
            /<id>dev<\/id>/ {
                s/\(<activeByDefault>\)'"true"'\(<\/activeByDefault>\)/\1'"false"'\2/
            }
        }' $pom_file_dev > $pom_file_release

        cp $pom_file_release $pom_file
        echo $RELEASE_VER_TO > $version_file
        rm $pom_file_version
        rm $pom_file_dev
        rm $pom_file_release
    fi
done
