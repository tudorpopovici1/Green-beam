package server.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import server.security.JwtAuthenticationEntryPoint;
import server.security.JwtAuthenticationProvider;
import server.security.JwtAuthenticationTokenFilter;
import server.security.JwtSuccessHandler;

import java.util.Collections;

@SuppressWarnings("WeakerAccess")
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
@Configuration
@Order(1000)
class JwtSecurityConfig extends WebSecurityConfigurerAdapter {

    @SuppressWarnings("WeakerAccess")
    @Autowired
    JwtAuthenticationProvider authenticationProvider;

    @SuppressWarnings("WeakerAccess")
    @Autowired
    JwtAuthenticationEntryPoint entryPoint;

    @Bean
    public AuthenticationManager authenticationManager() {
        return new
                ProviderManager(Collections.singletonList(authenticationProvider));
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests().antMatchers("**/rest/**").authenticated()
                .and()
                .authorizeRequests()
                .antMatchers("/rest/save/user")
                .permitAll()
                .and()
                .exceptionHandling().authenticationEntryPoint(entryPoint)
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(authenticationTokenFilter(),
                UsernamePasswordAuthenticationFilter.class);

        http.headers().cacheControl();
    }

    @Bean
    public JwtAuthenticationTokenFilter authenticationTokenFilter() {

        JwtAuthenticationTokenFilter filter = new JwtAuthenticationTokenFilter();
        filter.setAuthenticationManager(authenticationManager());
        filter.setAuthenticationSuccessHandler(new JwtSuccessHandler());
        return filter;
    }

}
