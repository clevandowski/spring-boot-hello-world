package com.zenika.formation.javadevops;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ConfigurationProperties
@PropertySource("file:${spring.cloud.kubernetes.secrets.paths}")
public class SecretConfig {
  
  private String username;
  private String password;
  
  public SecretConfig() {
    
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
