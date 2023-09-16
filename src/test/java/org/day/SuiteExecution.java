package org.day;

import java.util.List;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ Sample.class, Sample2.class, Sample3.class })

public class SuiteExecution {
    
    
    public static void main(String[] args) {
	
	Result r = JUnitCore.runClasses(SuiteExecution.class);
	
	int runCount = r.getRunCount();
	System.out.println("Total Method executed :"+runCount);
	
	int ignoreCount = r.getIgnoreCount();
	System.out.println("Total Ignore count :"+ignoreCount);
	
	int failureCount = r.getFailureCount();
	System.out.println("Total Failure Count :"+failureCount);
	
	List<Failure> failures = r.getFailures();
	
	for (int i = 0; i < failures.size(); i++) {
	    Failure failure = failures.get(i);
	    System.out.println(failure);
	}
	
    }
    

}
