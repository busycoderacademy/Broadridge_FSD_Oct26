package com.bankapp.config;

import com.bankapp.filter.AfterLoginDemoFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//We have filter based sec url based sec: filter
//we have aop based sec : method level sec, Around advice
@EnableMethodSecurity(prePostEnabled = true)
@Configuration
@EnableWebSecurity(debug = true)
public class SecConfig {

    @Autowired
    private AfterLoginDemoFilter afterLoginDemoFilter;

    @Autowired
    private AuthenticationEntryPoint authenticationEntryPoint;

    @Autowired
    private UserDetailsService userDetailsService;

    //DaoAuthenticationProvider
    @Bean
    public DaoAuthenticationProvider userDetailsService(PasswordEncoder passwordEncoder) {
        DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
        return  daoAuthenticationProvider;
    }
//    @Bean
//    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
//        UserDetails raj = User.withUsername("raj")
//                .password(passwordEncoder.encode("raj123"))
//                .roles("ADMIN")
//                .build();
//
//        UserDetails ekta= User.withUsername("ekta")
//                .password(passwordEncoder.encode("ekta123"))
//                .roles("MGR")
//                .build();
//
//        UserDetails gun= User.withUsername("gun")
//                .password(passwordEncoder.encode("gun123"))
//                .roles("CLERK")
//                .build();
//        return new InMemoryUserDetailsManager(raj,ekta, gun);
//    }

    //authroization?

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.csrf(AbstractHttpConfigurer::disable)
                .cors(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(registry -> registry.anyRequest().authenticated())
//                .authorizeHttpRequests(registry ->
//                        registry.requestMatchers("/admin/**").hasAnyRole("ADMIN")
//                                .requestMatchers("/mgr/**").hasAnyRole("ADMIN","MGR")
//                                .requestMatchers("/clerk/**").hasAnyRole("ADMIN","MGR","CLERK")
//                                .requestMatchers("/home/**").permitAll()
//                                .anyRequest().authenticated()
//                )
//                .httpBasic(Customizer.withDefaults())
                .httpBasic(hbc ->hbc.authenticationEntryPoint(authenticationEntryPoint) )
                .addFilterAfter(afterLoginDemoFilter, UsernamePasswordAuthenticationFilter.class)
                .sessionManagement(httpSecuritySessionManagementConfigurer ->
                        httpSecuritySessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();
    }

    //keep username password in plan text
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
