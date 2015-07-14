package demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.comar.ricardo.stuff.concurrentjob.ConcurrentJobApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ConcurrentJobApplication.class)
public class DemoApplicationTests {

	@Test
	public void contextLoads() {
	}

}
