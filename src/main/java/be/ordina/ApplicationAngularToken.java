package be.ordina;

import be.ordina.authentication.CsrfHeaderFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by MaBa on 15/03/2016.
 * <p>
 * http://localhost:8080/springBootAngular/
 */
@SpringBootApplication
@RestController
public class ApplicationAngularToken {


    public static void main(String[] args) {
        SpringApplication.run(ApplicationAngularToken.class, args);
    }

    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }

    @RequestMapping("/resource")
    public Map<String, Object> home() {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("id", UUID.randomUUID().toString());
        model.put("content", "Hello World");
        return model;
    }

    /**
     * Let css, js and views/*.html passthrough in Spring Security
     *
     * The server create a cookie: XSRF-TOKEN
     * Angular will then append a X-XSRF-TOKEN in every header request
     */
    @Configuration
    @Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
    protected static class SecurityConfiguration extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.httpBasic().and()
                    .authorizeRequests()
                    .antMatchers(
                            "/app/views/**/*.html",
                            "/app/**/*.js",
                            "/bower_components/**",
                            "/css/**", "/index.html",
                            "/home.html",
                            "/login.html",
                            "/").permitAll().anyRequest()
                    .authenticated().and()
                    .csrf().csrfTokenRepository(csrfTokenRepository())
                    .and().addFilterAfter(new CsrfHeaderFilter(), CsrfFilter.class);
        }


        /**
         * Angular will send a header with: X-XSRF-TOKEN.
         *
         * Here we configure what spring is expecting in every request
         * @return
         */
        private CsrfTokenRepository csrfTokenRepository() {
            HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
            repository.setHeaderName("X-XSRF-TOKEN");
            return repository;
        }
    }
}
