package com.camel.HelmKubernetesTest.Routes;

import com.camel.HelmKubernetesTest.Processors.InsertProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestRoute extends RouteBuilder {

    @Autowired
    private InsertProcessor insertProcessor;

    @Override
    public void configure() throws Exception {

        from("file:input_box?noop=true")
        .process(insertProcessor);

    }

}
