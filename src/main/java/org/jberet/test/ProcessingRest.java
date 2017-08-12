package org.jberet.test;

import org.jberet.test.cdi.SomeProcessingService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Created by sesshoumaru on 8/13/17.
 */
@Path("process")
public class ProcessingRest {

    @Inject
    private SomeProcessingService processingService;

    @GET
    @Path("hello")
    public String hello(){
        return processingService.produceHello();
    }

}
