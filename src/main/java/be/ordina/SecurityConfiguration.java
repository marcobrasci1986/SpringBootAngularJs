package be.ordina;

import be.ordina.authentication.CsrfHeaderFilter;
import be.ordina.authentication.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

/**
 * Let css, js and views/*.html passthrough in Spring Security
 * <p>
 * The server create a cookie: XSRF-TOKEN
 * Angular will then append a X-XSRF-TOKEN in every header request
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)// enable preAuthorize
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailService customUserDetailService;


//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
//        authenticationManagerBuilder
//                .inMemoryAuthentication()
//                .withUser("jimi").password("hendrix").roles("USER")
//                .and()
//                .withUser("admin").password("admin").roles("USER", "ADMIN");
//    }


    /**
     * Register custom userDetailService {@link CustomUserDetailService} and specify password encoding
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        ShaPasswordEncoder encoder = new ShaPasswordEncoder(256);
        auth.userDetailsService(customUserDetailService).passwordEncoder(encoder);
    }



    /**
     * Configure Spring security
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and()
                .authorizeRequests()
                .antMatchers(
                        "/app/views/**/*.html",
                        "/app/**/*.js",
                        "/bower_components/**",
                        "/css/**",
                        "/index.html",
                        "/home.html",
                        "/login.html",
                        "/").permitAll().anyRequest()
                .authenticated().and()
                .csrf().csrfTokenRepository(csrfTokenRepository())
                .and().addFilterAfter(new CsrfHeaderFilter(), CsrfFilter.class);
    }


    /**
     * Angular will send a header with: X-XSRF-TOKEN.
     * <p>
     * Here we configure what spring is expecting in every request
     *
     * @return
     */
    private CsrfTokenRepository csrfTokenRepository() {
        HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
        repository.setHeaderName("X-XSRF-TOKEN");
        return repository;
    }
}