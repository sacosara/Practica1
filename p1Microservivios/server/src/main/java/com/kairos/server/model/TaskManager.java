package com.kairos.server.model;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import java.util.HashMap;

public class TaskManager {
	private int serialIdTask = 0;
	private RabbitSender rabbitSender;
	private ObjectMapper objectMapper;
	private static HashMap<Integer, TaskResponse> taskStore = new HashMap<>();

	public TaskManager(){
		rabbitSender = new RabbitSender(new RabbitTemplate());
		objectMapper = new ObjectMapper();

	}
	
	private synchronized int getId(){
		int id = serialIdTask;
		serialIdTask++;
		return id;
	}

	public int sendtask(String text){
		int id = getId();
		TaskToSend msg = new TaskToSend();
		msg.setId(id);
		msg.setMessage(text);
		String jsonMsg = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(msg);
		rabbitSender.send(jsonMsg);
		insertTaskIntoStore(msg);
		return id;
	}

	private void insertTaskIntoStore(TaskToSend msg) {
		TaskResponse task = new TaskResponse();
		task.setCompleted(false);
		task.setId(msg.getId());
		task.setProgress(0);
		task.setText(msg.getMessage());
		taskStore.put(task.getId(), task);
	}
	
	public TaskResponse consulTask(int id){
		TaskResponse taskResponse = taskStore.get(id);
		if (taskResponse == null)
		{
			// mensaje de error si ese id no existe
			// return error de alguna manera
		}
		return taskResponse;
	}

	public static void storeTask(TaskResponse task) {
        TaskResponse taskTemp = taskStore.get(task.getId());
        if(taskTemp != null) {
            taskTemp.copy(task);
            taskStore.put(taskTemp.getId(), taskTemp);
        }
        else {
            //taskStore.put(task.getId(), task);
			System.out.println("Error la tarea no existe");
        }
    }
	
	public void receiveTask() {
		rabbitReceiver.receive();
		// meter la info en el store (HashMap con toda la info)
	}
}
