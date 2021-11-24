package co.usa.ciclo3.ciclo3.web;


import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerSecurity extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.antMatcher("/**").authorizeRequests()
    	
    		.antMatchers(new String[] {"/api/Category/**","/api/Client/**",
            		"/api/Admin/**", "/api/Score/**", "/api/Lib/**",
            		"/api/Message/**","/api/Reservation/**"}).permitAll()
    	.anyRequest().authenticated()
    	.and()
    	.oauth2Login();
    	
    	 
    	
     
    }
 
    
    
}
