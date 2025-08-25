package com.ems.serviceImpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.ems.config.AppConstant;
import com.ems.entity.Project;
import com.ems.entity.User;

@Service
public class NotificationProducer {

	@Autowired
	private KafkaTemplate<String,Object> kafkaTemplate;
	
	public void sendProjectAssignedTopic(User user,Project project) {
		Map<String,Object>  event=new HashMap<String, Object>();
		event.put("employeeID", user.getUserId());
		event.put("projectID", project.getProjectId());
		event.put("projectName", project.getProjectName());
		event.put("email", user.getEmail());
		event.put("event", "PROJECT ASSIGNED");
		kafkaTemplate.send(AppConstant.TOPIC_NAME,event);
		System.out.println("Published Event:"+event);
		
	}
}
