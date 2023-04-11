package blog.sunn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SunnApplication {

	public static void main(String[] args) {
		SpringApplication.run(SunnApplication.class, args);
	}

}
