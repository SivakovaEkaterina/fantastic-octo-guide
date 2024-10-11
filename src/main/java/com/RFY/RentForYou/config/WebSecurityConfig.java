package com.RFY.RentForYou.config;

import com.RFY.RentForYou.models.RoleEnum;
import com.RFY.RentForYou.models.UserModel;
import com.RFY.RentForYou.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Collection;
import java.util.Collections;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public WebSecurityConfig(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void createDefaultUser(){
        if (!userRepository.existsByUsername("admin")){
            UserModel user = new UserModel();
            user.setNickNameUser("admin");
            user.setFirstNameUser("админ");
            user.setSecondNameUser("админ");
            user.setPasswordUser(passwordEncoder.encode("Admin123"));
            user.setLoginUser("admin");
            user.setActive(true);
            user.setRoles(Collections.singleton(RoleEnum.Admin));
        }
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(nickNameUser -> {
                    UserModel user = userRepository.findByUsername(nickNameUser);
                    if (user == null) {
                        throw new UsernameNotFoundException("Такой пользователь не существует!");
                    }
                    return new org.springframework.security.core.userdetails.User(
                            user.getNickNameUser(),
                            user.getPasswordUser(),
                            user.isActive(),
                            true,
                            true,
                            true,
                            user.getRoles()
                    );
                }
        ).passwordEncoder(passwordEncoder);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorize ->
                        authorize.requestMatchers("/login", "/registration").permitAll()
                                .anyRequest().authenticated())
                .formLogin(form -> form.loginPage("/login").defaultSuccessUrl("/user").permitAll())
                .logout(logout -> logout.permitAll())
                .csrf(csrf -> csrf.disable())
                .cors(cors -> cors.disable());

        return http.build();

    }

}
