package com.example;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@JsonInclude(Include.NON_NULL)
public class TaskMessage implements Serializable{
    @JsonProperty("id")
    private Integer id;
    @JsonProperty ("result")
    private String result;
    @JsonProperty ("progress")
    private Integer progress;
    @JsonProperty ("completed")
    private Boolean completed;


    public Integer getId(){
        return id;
    }

    public String getResult(){
        return result;
    }

    public Integer getProgress(){
        return progress;
    }
    public boolean isCompleted(){
        return completed;
    }

    public static class Builder{
        private final TaskMessage object;

        public Builder(){
            object = new TaskMessage();
        }

        public Builder withCompleted(boolean completed){
            this.object.completed = completed;
            return this;
        }
        public Builder withResult( Strign result){
            this.object.result = result;
            return this;
        }

        public Builder withId(Integer id){
            this.object.id = id;
            return this;
        }

        public Builder withProgress(Integer progress){
            this.object.progress = progress;
            return this;
        }

        public TaskMessage build(){
            return this.object;
        }
    }
}
