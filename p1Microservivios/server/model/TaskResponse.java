package com.kairos.server.model;

import lombok.Data;

@Data
public class TaskResponse {
	 private int id;
	 private String text;
	 private int progress;
	 private boolean completed;
	 private String result;

}
