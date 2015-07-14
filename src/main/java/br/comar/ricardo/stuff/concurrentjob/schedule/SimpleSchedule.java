package br.comar.ricardo.stuff.concurrentjob.schedule;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.comar.ricardo.stuff.concurrentjob.concurrency.LeaderElection;

@Component
public class SimpleSchedule {

	@Resource
	private LeaderElection leaderElection;

	@Scheduled(initialDelay = 100, fixedRate = 5000)
	@Async
	public void doSomething() {

		if (leaderElection.isLeader()) {
			System.out.println("My turn !!");
			try {
				Thread.sleep(15000);
			} catch (InterruptedException e) {
			}
		} else {
			System.out.println("Not this time...");
		}
	}
}
