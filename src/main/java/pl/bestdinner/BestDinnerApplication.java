package pl.bestdinner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BestDinnerApplication {

  public static void main(String[] args) {
    SpringApplication.run(BestDinnerApplication.class, args);
  }

}


