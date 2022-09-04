package uk.correvate.ms.handling.files;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import uk.correvate.ms.handling.files.interfaces.rest.FileController;

@SpringBootTest
class CorrevateFilesMsApplicationTests {

	@Autowired
	private FileController controller;

	@Test
	void contextLoads() {
		Assertions.assertThat(controller).isNotNull();
	}

}
