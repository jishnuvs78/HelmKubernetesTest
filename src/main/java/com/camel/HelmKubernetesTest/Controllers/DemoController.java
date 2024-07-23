package com.camel.HelmKubernetesTest.Controllers;

import com.camel.HelmKubernetesTest.Service.PayloadService;
import com.camel.HelmKubernetesTest.model.Payload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
@RestController
@RequestMapping("/api")
public class DemoController {

    @Autowired
    private PayloadService payloadService;

    @Value("${myapp.message}")
    private String message;

    @GetMapping(value = "/print", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter printMessage() {

        SseEmitter emitter = new SseEmitter();
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        Runnable task = () -> {
            try{
                LocalDateTime now = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String formattedNow=now.format(formatter);

                emitter.send(formattedNow + " - " + message);
            }catch(IOException e){
                emitter.completeWithError(e);
            }

        };



//        System.out.println(message);

//        return message;

        executor.scheduleAtFixedRate(task, 0, 1, TimeUnit.SECONDS);

        return emitter;
    }

//    @PostMapping("/setPayload")
//    public void setPayload(){
//
//        try {
//
//            String uuid = UUID.randomUUID().toString();
//
//            Payload payload=new Payload();
//
//            payload.setHermes_id(uuid);
//            payload.setPayload(exchange.getIn().getBody(String.class));
//
//            payload.setStg_id(1);
//
//            Payload newPayload=payloadService.save(payload);
//
//            System.out.println(newPayload);
//
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//
//
//    }

}
