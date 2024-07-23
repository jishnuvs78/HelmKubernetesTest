package com.camel.HelmKubernetesTest.Service;

import com.camel.HelmKubernetesTest.Repository.PayloadRepository;
import com.camel.HelmKubernetesTest.model.Payload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PayloadService {

    @Autowired
    private PayloadRepository payloadRepository;

    @Transactional
    public Payload save(Payload payload){
        int i=0;

        try {
//            if(i==0){
//                throw new Exception("Failed to Insert to DB");
//            }
            return payloadRepository.save(payload);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }

    }


}
