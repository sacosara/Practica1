package com.kairos.server.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

import com.kairos.server.model.TaskManager;
import com.kairos.server.model.TaskResponse;

import jakarta.websocket.server.ServerEndpoint;

@RestController
@EnableWebSocket
@ServerEndpoint("/tasks")
@RequestMapping("/tasks")
public class ServerController {

	TaskManager taskManager = new TaskManager();
	
	@PostMapping("/{text}")
	public int get (@PathVariable String text) {
		return taskManager.sendtask(text);
	}
	
	
	@PostMapping("/consult/{id}")
	public TaskResponse consult(@PathVariable int id) {		
		return taskManager.consulTask(id);
	}
}
