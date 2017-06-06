package com.mins.demo;

import static org.apache.camel.model.rest.RestParamType.path;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;
/**
 * 
 * Camel route for rest services.
 *
 */
@Component
public class ATMRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        restConfiguration()
            .component("servlet")
            .bindingMode(RestBindingMode.json)
            .dataFormatProperty("prettyPrint", "true");

        
        rest("/atms").description("User REST service")
            .consumes("application/json")
            .produces("application/json")

            .get().description("List all ATMS").outType(String.class)
                .responseMessage().code(200).message("All ATMs details are successfully retrieved").endResponseMessage()
                .to("bean:atmDataService?method=allATM").produces("application/json")
        
            .get("/city/{cityName}").description("List ATMS by CityName")
                .outType(String.class)
                .param().name("cityName").type(path).description("Name of the city").dataType("string").endParam()
                .responseMessage().code(200).message("All ATMs of  successfully retrieved").endResponseMessage()
                .to("bean:atmDataService?method=findATMByCity(${header.cityName})").produces("application/json");
    }
}
