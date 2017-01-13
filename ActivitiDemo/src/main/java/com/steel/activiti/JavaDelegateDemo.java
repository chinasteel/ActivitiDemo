package com.steel.activiti;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class JavaDelegateDemo implements JavaDelegate{

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		System.out.println("JavaDelegate execute..");
		execution.setVariable("steel", "steel");
		Object variableName = execution.getVariable("name");
		System.out.println("variableName: " + variableName);
	}
}
