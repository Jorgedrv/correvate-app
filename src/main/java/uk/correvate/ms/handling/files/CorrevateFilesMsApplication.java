package uk.correvate.ms.handling.files;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication(scanBasePackages = { "uk.correvate.ms.handling.files" })
public class CorrevateFilesMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CorrevateFilesMsApplication.class, args);
	}

}
