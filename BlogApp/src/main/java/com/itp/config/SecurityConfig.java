/*
 * package com.itup.config;
 * 
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.security.authentication.AuthenticationManager; import
 * org.springframework.security.config.annotation.authentication.builders.
 * AuthenticationManagerBuilder; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * EnableWebSecurity; import
 * org.springframework.security.config.annotation.web.configuration.
 * WebSecurityConfigurerAdapter; import
 * org.springframework.security.config.http.SessionCreationPolicy; import
 * org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; import
 * org.springframework.security.crypto.password.PasswordEncoder; import
 * org.springframework.security.web.authentication.
 * UsernamePasswordAuthenticationFilter;
 * 
 * import com.itup.security.CustomUserDetailService; import
 * com.itup.security.JwtAuthenticationEntryPoint; import
 * com.itup.security.JwtAuthenticationFilter;
 * 
 * 
 * 
 * @Configuration
 * 
 * @EnableWebSecurity public class SecurityConfig extends
 * WebSecurityConfigurerAdapter {
 * 
 * @Autowired private CustomUserDetailService customUserDetailService;
 * 
 * @Autowired private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
 * 
 * @Autowired private JwtAuthenticationFilter jwtAuthenticationFilter;
 * 
 * @Override protected void configure(HttpSecurity http) throws Exception {
 * 
 * http.csrf() .disable() .authorizeHttpRequests() .anyRequest()
 * .authenticated() .and() .exceptionHandling().authenticationEntryPoint(this.
 * jwtAuthenticationEntryPoint) .and() .sessionManagement()
 * .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
 * 
 * // http.addFilterBefore(this.jwtAuthenticationFilter,
 * UsernamePasswordAuthenticationFilter.class);
 * 
 * }
 * 
 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
 * Exception {
 * 
 * auth.userDetailsService(customUserDetailService).passwordEncoder(
 * passwordEncoder()); }
 * 
 * @Bean public PasswordEncoder passwordEncoder() {
 * 
 * return new BCryptPasswordEncoder(); }
 * 
 * @Bean
 * 
 * @Override public AuthenticationManager authenticationManagerBean() throws
 * Exception {
 * 
 * return super.authenticationManagerBean(); }
 * 
 * 
 * }
 */


