package br.comar.ricardo.stuff.concurrentjob.client.schedule;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.core.ILock;

@Data
public class LockSchedule {

	private HazelcastClient hzClient;

	public void doSomething() {
		
		ILock lock = hzClient.getLock("lockSchedule");

		if (lock.tryLock()) {
			String now = SimpleDateFormat.getDateTimeInstance().format(new Date());
			System.out.println("My turn !! - " + now);
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
			}
			
			System.out.println("Finished !! - " + now);
			
		} else {
			System.out.println("Not this time...");
		}
		
		lock.unlock();
	}
}
