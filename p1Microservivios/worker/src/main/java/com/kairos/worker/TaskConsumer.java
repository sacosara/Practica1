package com.example.worker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;
import com.TaskProducer;
import com.example.TaskMessage;
import es.

@Service
public class TaskConsumer {
    private static final int MAX_LOOP = 100;
    private static final Logger log = LoggerFactory.getLogger(TaskConsumer.class);
    @GrpcClient("service")
    private ServiceBlockingStub client;

    @Autowired
    private TaskProducer taskProducer;

    @RabbitListener(queues = "newTasks", ackMode = "AUTO")
    public void received (Task message) throws InterruptedException{
        log.info("Received message as generic: {}", message.toString());
        final Request request = Request.newBuilder().setText(message.getText()).build();
        final Response response = client.toUpperCase(request);
        for (int i = 1; i< MAX_LOOP; i++){
            Thread.sleep(1000);
            taskProducer.sendMessage(getDefaultMessage(i));
        }
        taskProducer.sendMessage(getFinalMessage(result));
    }

    private TaskMessage getDefaultMessage (int i ){
        return new TaskMessage.builder()
                .withCompleted(Boolean.FALSE)
                .withId(0)
                .withProgress(i)
                .build();
    }

    private TaskMessage getFinalMessage( final Streing result){
        return new TaskMassage.builder()
                    .withCompleted(Boolean.TRUE)
                    .withResult(result)
                    .withId(0)
                    .withProgress(100)
                    .build();
    }
}
