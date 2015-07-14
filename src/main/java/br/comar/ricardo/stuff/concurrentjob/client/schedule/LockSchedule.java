package br.comar.ricardo.stuff.concurrentjob.client.schedule;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.core.ILock;

@Component
@Lazy(true)
public class LockSchedule {

	@Resource
	private HazelcastClient hzClient;

	public void doSomething() {
		
		ILock lock = hzClient.getLock("lockSchedule");

		if (lock.tryLock()) {
			String now = SimpleDateFormat.getDateTimeInstance().format(new Date());
			System.err.println("My turn !! - " + now);
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
			}
			
			System.err.println("Finished !! - " + now);
			
		} else {
			System.out.println("Not this time...");
		}
		
		lock.unlock();
	}
}
