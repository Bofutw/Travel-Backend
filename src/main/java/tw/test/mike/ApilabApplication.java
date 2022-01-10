package tw.test.mike;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
//@EnableTransactionManagement
public class ApilabApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApilabApplication.class, args);
	}

}
