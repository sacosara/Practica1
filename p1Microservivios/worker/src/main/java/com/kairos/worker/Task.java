package com.example.worker.worker;

@JsonInclude(Include.NON_NULL)
public class Task implements Serializable {
    
    private Task(){

    }

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("text")
    private String text;

    public Integer getId(){
        return id;
    }

    public String getText(){
        return text;
    }

    public static class Builder{
        private final Task object;

        public Builder(){
            object = new Task();
        }

        public Builder withId(Integer id){
            this.object.id = id;
            return this;
        }

        public Builder withText(String text){
            this.object.text = text;
            return this;
        }

        public Task build(){
            return this.object;
        }
   }
}
