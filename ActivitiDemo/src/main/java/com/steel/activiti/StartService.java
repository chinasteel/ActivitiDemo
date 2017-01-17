package com.steel.activiti;

import static org.junit.Assert.assertNotNull;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StartService {
	@Autowired
	RuntimeService runtimeService;
	
	@Transactional
	public void hello() throws FileNotFoundException {
		// here you can do transactional stuff in your domain model
		// and it will be combined in the same transaction as
		// the startProcessInstanceByKey to the Activiti RuntimeService
		Map<String, Object> variableMap = new HashMap<String, Object>();
		variableMap.put("name", "Activiti");
		variableMap.put("steel", "steel");
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("myProcess2", variableMap);
		assertNotNull(processInstance.getId());
		System.out.println("id " + processInstance.getId() + " " + processInstance.getProcessDefinitionId());
	}
}
