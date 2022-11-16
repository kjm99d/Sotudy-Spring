package hello.core;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.web.WebAppConfiguration;

@WebAppConfiguration
@SpringBootTest
class CoreApplicationTests {

	@Test
	void contextLoads() {
		//ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

	}

}
