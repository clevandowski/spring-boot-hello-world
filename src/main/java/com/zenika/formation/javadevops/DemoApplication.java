package com.zenika.formation.javadevops;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Enumeration;

import org.springframework.beans.factory.annotation.Autowired;
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

//  @Value("${username}")
  private String username;
  
  @Autowired
  Environment environment;

  @Autowired
  private DemoConfig demoConfig;

  @RequestMapping("/")
  @ResponseBody
  String home() {
    try {
      return demoConfig.getCustomMessage() + " " + username + "@" + InetAddress.getLocalHost().getHostAddress() + ":"
          + environment.getProperty("local.server.port") + "\n";
    } catch (UnknownHostException e) {
      throw new RuntimeException("Error when trying to get local IP address", e);
    }
  }

  public static void main(String[] args) {
    Enumeration<?> propertyEnum = System.getProperties().propertyNames();
  
    while (propertyEnum.hasMoreElements()) {
      String key = (String) propertyEnum.nextElement();
      String value = (String) System.getProperty(key);
      System.out.println(key + "=" + value);
    }
    
    SpringApplication.run(DemoApplication.class, args);
  }
}
