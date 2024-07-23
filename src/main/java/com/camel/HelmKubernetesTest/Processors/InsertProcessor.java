package com.camel.HelmKubernetesTest.Processors;

import com.camel.HelmKubernetesTest.Service.PayloadService;
import com.camel.HelmKubernetesTest.model.Payload;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class InsertProcessor implements Processor {

    @Autowired
    private PayloadService payloadService;

    @Override
    public void process(Exchange exchange) throws Exception {

        try {

            String xml="\"<bulkmessage>\n" +
                    "  <payload1>New Msg1</payload1>\n" +
                    "  <payload2>New Msg2</payload2>\n" +
                    "  <payload3>New Msg3</payload3>\n" +
                    "</bulkmessage>\"";

            String uuid = UUID.randomUUID().toString();

            Payload payload=new Payload();

            payload.setHermes_id(uuid);
            payload.setPayload(xml);
            exchange.setProperty("payload",payload.getPayload());
            exchange.setProperty("hermesId",uuid);
            payload.setStg_id(1);

            Payload newPayload=payloadService.save(payload);

            System.out.println(newPayload);

        }catch(Exception e){
            e.printStackTrace();
        }

    }


}
