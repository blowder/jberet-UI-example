package org.jberet.test;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Created by sesshoumaru on 8/13/17.
 */
@Path("process")
public class ProcessingRest {

    @GET
    @Path("hello")
    public String hello(){
        return "Hello";
    }

}
