package br.com.manegerfiles;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ManegerFilesApplicationTests.class)
@ActiveProfiles("test")
class ManegerFilesApplicationTests {

	@Test
	public void contextLoads() {
		assertTrue("This will succeed. Dummy Tests", true);
	}

}
