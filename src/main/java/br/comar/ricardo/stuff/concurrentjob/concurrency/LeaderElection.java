package br.comar.ricardo.stuff.concurrentjob.concurrency;

/**
 * Leader election is the process of designating a
 * single node as the organizer of some distributed
 * task among several nodes in the cluster.
 *
 * @author Andreas Lindfalk
 */
public interface LeaderElection {
 
    /**
     * Get whether this node is the leader
     * in the cluster or not.
     *
     * @return {@code true} if it is this node
     * that is the leader, else {@code false}
     */
    boolean isLeader();
} 