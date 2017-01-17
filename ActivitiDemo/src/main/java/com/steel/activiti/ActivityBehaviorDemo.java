package com.steel.activiti;

import org.activiti.engine.impl.pvm.delegate.ActivityBehavior;
import org.activiti.engine.impl.pvm.delegate.ActivityExecution;

public class ActivityBehaviorDemo implements ActivityBehavior {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2024798863899024394L;

	@Override
	public void execute(ActivityExecution execution) throws Exception {
		System.out.println("ActivityBehavior execute..");
		execution.setVariable("steels", "steels");
		Object variableName = execution.getVariable("name");
		System.out.println("variableName:" + variableName);
	}

}
