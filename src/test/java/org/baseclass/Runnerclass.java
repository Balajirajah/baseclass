package org.baseclass;

import java.util.List;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Runnerclass {

	public static void main(String[] args) {
		Result runnerclass=JUnitCore.runClasses(Suitclass.class);
		
		int failurecount=runnerclass.getFailureCount();
		System.out.println(failurecount);
		
		List<Failure>fail=runnerclass.getFailures();
		for(Failure fails:fail) {
			String str=fails.toString();
			System.out.println(str);
		}
		boolean wasSuccessful=runnerclass.wasSuccessful();
		System.out.println(wasSuccessful);
		
		

	}

}
