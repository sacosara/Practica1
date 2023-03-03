package com.kairos.server.model;

import lombok.Data;

@Data
public class TaskResponse {
	 private int id;
	 private String text;
	 private int progress;
	 private boolean completed;
	 private String result;

	 public void copy(TaskResponse task) {
		setText(task.getText());
		setCompleted(task.isCompleted());
		setProgress(task.getProgress());
		setResult(task.getResult());
	}

}
