package personal.leo.serviceManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServiceManagerLauncher {
    public static void main(String[] args) {
        try {
            SpringApplication.run(ServiceManagerLauncher.class, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
