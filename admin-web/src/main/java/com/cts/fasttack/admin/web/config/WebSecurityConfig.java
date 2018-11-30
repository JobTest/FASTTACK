package com.cts.fasttack.admin.web.config;

import java.util.Collections;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.vote.AffirmativeBased;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.ReflectionSaltSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.access.expression.WebExpressionVoter;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.web.context.request.RequestContextListener;
import com.cts.fasttack.admin.web.security.auth.AjaxAwareAccessDeniedHandler;
import com.cts.fasttack.admin.web.security.auth.AjaxAwareAuthenticationEntryPoint;
import com.cts.fasttack.admin.web.security.auth.AuthenticationFailureHandler;
import com.cts.fasttack.admin.web.security.auth.AuthenticationSuccessHandler;
import com.cts.fasttack.admin.web.security.auth.WebAuthDetailsSource;
import com.cts.fasttack.admin.web.security.filter.ReAuthenticationFilterSecurityInterceptor;
import com.cts.fasttack.admin.web.security.listener.UserDetailsHttpSessionListener;
import com.cts.fasttack.admin.web.security.provider.ReAuthenticationDaoAuthenticationProvider;
import com.cts.fasttack.admin.web.security.provider.UserDaoAuthenticationProvider;
import com.cts.fasttack.admin.web.security.provider.AlfaBankAuthenticationProvider;
import com.cts.fasttack.admin.web.security.userdetails.UserPreAuthenticationChecks;
import com.cts.fasttack.admin.web.service.UserService;
import com.cts.fasttack.admin.web.util.DigestEncoderHelper;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, proxyTargetClass = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private static final Logger log = LogManager.getLogger(WebSecurityConfig.class);

    @Autowired
    private UserService userService;

    @Autowired
    private UserPreAuthenticationChecks userPreAuthenticationChecks;

    @Autowired
    private AlfaBankAuthenticationProvider alfaBankAuthenticationProvider;

    @Override
    protected void configure(HttpSecurity security) throws Exception {
        security.authorizeRequests()
                .accessDecisionManager(new AffirmativeBased(Collections.singletonList(new WebExpressionVoter())))
                .antMatchers("/login.htm").permitAll()
                .antMatchers("/template/login/**").permitAll()
                .antMatchers("/restorePassword/*").permitAll()
                .antMatchers("/**/*.htm").authenticated()
                .antMatchers("/**/*.json").authenticated();

        security.formLogin()
                .loginPage("/login.htm")
                .loginProcessingUrl("/login/process-login.htm")
                .usernameParameter("j_username")
                .passwordParameter("j_password")
                .defaultSuccessUrl("/index.htm", true)
                .successHandler(authenticationSuccessHandler())
                .failureHandler(authenticationFailureHandler())
                .authenticationDetailsSource(new WebAuthDetailsSource());

        security.logout()
                .logoutUrl("/logout.htm")
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true);

        security.rememberMe()
                .disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                .sessionFixation().newSession()
                .invalidSessionUrl("/login.htm");

        security.exceptionHandling()
                .accessDeniedPage("/accessDenied.htm")
                .authenticationEntryPoint(new AjaxAwareAuthenticationEntryPoint("/login.htm"))
                .accessDeniedHandler(new AjaxAwareAccessDeniedHandler());

        security.addFilterBefore(reAuthenticationFilterSecurityInterceptor(), FilterSecurityInterceptor.class);

        security.csrf();

        security.anonymous();

        security.headers()
                .frameOptions().sameOrigin()
                .xssProtection().xssProtectionEnabled(true)
                .and()
                .contentTypeOptions()
                .and()
                .cacheControl().disable();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/assets/**", "/resources/**", "/messageBundles.json");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        if (alfaBankAuthenticationProvider.isLdapFromAlfaBank()) auth.authenticationProvider(alfaBankAuthenticationProvider());
        auth.authenticationProvider(daoAuthenticationProvider());
        auth.authenticationProvider(reAuthenticationDaoAuthenticationProvider());
    }

    @Bean("authenticationManager")
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler() {
        return new AuthenticationSuccessHandler();
    }

    @Bean
    public AuthenticationFailureHandler authenticationFailureHandler() {
        AuthenticationFailureHandler authenticationFailureHandler = new AuthenticationFailureHandler();
        authenticationFailureHandler.setDefaultFailureUrl("/login.htm");
        return authenticationFailureHandler;
    }

    @Bean
    public UserDaoAuthenticationProvider daoAuthenticationProvider() {
        UserDaoAuthenticationProvider daoAuthenticationProvider = new UserDaoAuthenticationProvider();
        daoAuthenticationProvider.setSaltSource(reflectionSaltSource());
        daoAuthenticationProvider.setUserDetailsService(userService);
        daoAuthenticationProvider.setPreAuthenticationChecks(userPreAuthenticationChecks);
        daoAuthenticationProvider.setPasswordEncoder(DigestEncoderHelper.SHA_PASSWORD_ENCODER);
        return daoAuthenticationProvider;
    }

    @Bean
    public ReAuthenticationDaoAuthenticationProvider reAuthenticationDaoAuthenticationProvider() {
        ReAuthenticationDaoAuthenticationProvider reAuthenticationDaoAuthenticationProvider = new ReAuthenticationDaoAuthenticationProvider();
        reAuthenticationDaoAuthenticationProvider.setSaltSource(reflectionSaltSource());
        reAuthenticationDaoAuthenticationProvider.setUserDetailsService(userService);
        reAuthenticationDaoAuthenticationProvider.setPreAuthenticationChecks(userPreAuthenticationChecks);
        reAuthenticationDaoAuthenticationProvider.setPasswordEncoder(DigestEncoderHelper.SHA_PASSWORD_ENCODER);
        return reAuthenticationDaoAuthenticationProvider;
    }

    public AlfaBankAuthenticationProvider alfaBankAuthenticationProvider() {
        log.warn("Is used Ldap Security Authentication from Alfa-Bank");

        return alfaBankAuthenticationProvider;
    }

    @Bean
    public ReflectionSaltSource reflectionSaltSource() {
        ReflectionSaltSource reflectionSaltSource = new ReflectionSaltSource();
        reflectionSaltSource.setUserPropertyToUse("username");
        return reflectionSaltSource;
    }

    @Bean
    public UserDetailsHttpSessionListener userDetailsHttpSessionListener() {
        return new UserDetailsHttpSessionListener();
    }

    @Bean
    public RequestContextListener requestContextListener() {
        return new RequestContextListener();
    }

    @Bean
    public ReAuthenticationFilterSecurityInterceptor reAuthenticationFilterSecurityInterceptor() {
        return new ReAuthenticationFilterSecurityInterceptor();
    }

}
