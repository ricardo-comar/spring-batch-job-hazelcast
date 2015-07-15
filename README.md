# spring-batch-job-hazelcast

Simple PoC project, created using Spring Boot, with Maven 3, Spring Batch and a Hazelcast server configured to run as a stand-alone instance or cluster, automaticaly changing the connection ports as new instances are up (or down).

### Usage
- Download the repo
- Package with `mvn package`
- And run with `java -jar target/spring-batch-hazelcast-0.1-SNAPSHOT.jar`

### How it works
- An instance will be online in a few seconds. 
- After 20s a scheduled job will start running (forever, waiting 1s), each time trying to acquire the lock. 
- If successful, will work for 5s (a simple `Thread.sleep(5000)`, emulating some hard processing work) and finish. 
- If the lock is not available will end without sleeping.

### Under the hood
- The job is a single instance, running synchronously. In a single instance the job will always accquire the lock and nothing cool will happen.
- If you start another local terminal and run a second instance, the Hazelcast's instances will communicate with each other to set a cluster. And the second job will compete with the first for the lock, and the magic will occur !!
- This PoC was made to run up to 3 servers. Until you don't have all of them running, you will keep facing a warning from Hazelcast that not all instances are up and running.

