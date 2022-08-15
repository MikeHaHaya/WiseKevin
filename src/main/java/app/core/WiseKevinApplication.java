package app.core;

import static app.core.Globals.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WiseKevinApplication {

    public static void main(String[] args) {
        SpringApplication.run(WiseKevinApplication.class, args);

        System.out.println(random.nextInt());
    }

}
