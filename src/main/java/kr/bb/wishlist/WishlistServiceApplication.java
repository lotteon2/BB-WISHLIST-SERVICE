package kr.bb.wishlist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableFeignClients
@EnableEurekaClient
@EnableJpaRepositories
@EnableJpaAuditing
@SpringBootApplication
public class WishlistServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(WishlistServiceApplication.class, args);
    }

}
