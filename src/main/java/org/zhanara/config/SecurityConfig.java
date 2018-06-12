package org.zhanara.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    DataSource dataSource;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
//        auth.inMemoryAuthentication().withUser("admin").password("123").roles("Admin");
        auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery(
                "select login,password,'true' as enabled from market_users where login=?").
                authoritiesByUsernameQuery("select u.login, r.name from market_users u join market_roles r on u.role_id = r.id where login=?");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/","/home").permitAll()
                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/cashier/**").access("hasRole('ROLE_CASHIER')")
                .antMatchers("/products/**").access("hasRole('ROLE_CASHIER')")
                .and().formLogin().loginPage("/login").defaultSuccessUrl("/index")
                .and().exceptionHandling();
    }
}
