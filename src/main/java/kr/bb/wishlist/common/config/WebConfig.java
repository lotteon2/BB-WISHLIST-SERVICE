package kr.bb.wishlist.common.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@RequiredArgsConstructor
@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**")
        .allowedOrigins("http://localhost:3000", "http://localhost:3001", "http://localhost:3002",
            "https://blooming.blooms.mall.stockey.kr",
            "https://blooming.blooms.store.stockey.kr",
            "https://blooming.blooms.admin.stockey.kr")
        .allowedMethods("*")
        .allowedHeaders("*")
        .exposedHeaders("*")
        .allowCredentials(true);

  }


}

