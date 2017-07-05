package com.zenika.formation.javadevops;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Enumeration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
@ComponentScan("com.zenika.formation.javadevops")
public class DemoApplication {

  @Autowired
  Environment environment;

  @Autowired
  private DemoConfig demoConfig;

  @Autowired
  private SecretConfig secretConfig;

  @RequestMapping("/")
  @ResponseBody
  String home() {
    try {
      return demoConfig.getCustomMessage() + " " + secretConfig.getUsername() + "@" + InetAddress.getLocalHost().getHostAddress() + ":"
          + environment.getProperty("local.server.port") + "\n";
    } catch (UnknownHostException e) {
      throw new RuntimeException("Error when trying to get local IP address", e);
    }
  }

  public static void main(String[] args) {
    displaySystemProperties();
    
    SpringApplication.run(DemoApplication.class, args);
  }
  
  private static void displaySystemProperties() {
    Enumeration<?> propertyEnum = System.getProperties().propertyNames();
    while (propertyEnum.hasMoreElements()) {
      String key = (String) propertyEnum.nextElement();
      String value = (String) System.getProperty(key);
      System.out.println(key + "=" + value);
    }    
  }
}
