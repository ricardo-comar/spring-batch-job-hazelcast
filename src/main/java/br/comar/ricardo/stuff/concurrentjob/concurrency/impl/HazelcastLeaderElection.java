package br.comar.ricardo.stuff.concurrentjob.concurrency.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import br.comar.ricardo.stuff.concurrentjob.concurrency.LeaderElection;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.Member;

/**
 * A simple leader election implementation based on a Hazelcast cluster that
 * simply elects the oldest member in the cluster as the leader.
 * 
 * @author Andreas Lindfalk
 */
@Component
public class HazelcastLeaderElection implements LeaderElection {

	@Resource
	private HazelcastInstance instance;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isLeader() {

		// The first member in the set is the
		// oldest member, this is the one that
		// we always will point out as leader

		Member oldestMember = instance.getCluster().getMembers().iterator()
				.next();

		return oldestMember.localMember();
	}
}
