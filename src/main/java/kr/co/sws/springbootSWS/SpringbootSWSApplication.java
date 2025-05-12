package kr.co.sws.springbootSWS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // created_at, updated_at 자동 수정
@SpringBootApplication
public class SpringbootSWSApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootSWSApplication.class, args);
    }
}
