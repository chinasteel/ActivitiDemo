package com.steel.activiti;

import static org.junit.Assert.assertNotNull;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StartService {
	@Autowired
	RepositoryService repositoryService ;
	@Autowired
	RuntimeService runtimeService;
	
	@Transactional
	public void hello() throws FileNotFoundException {
		repositoryService.createDeployment().addInputStream("myProcess.bpmn20.xml",
				new FileInputStream("D:/workspace/git/ActivitiDemos/ActivitiDemo/src/main/resources/diagrams/MyProcess.bpmn")).deploy();
		// here you can do transactional stuff in your domain model
		// and it will be combined in the same transaction as
		// the startProcessInstanceByKey to the Activiti RuntimeService
		Map<String, Object> variableMap = new HashMap<String, Object>();
		variableMap.put("name", "Activiti");
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("myProcess", variableMap);
		assertNotNull(processInstance.getId());
		System.out.println("id " + processInstance.getId() + " " + processInstance.getProcessDefinitionId());
	}
}
