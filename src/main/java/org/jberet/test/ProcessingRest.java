package org.jberet.test;

import org.jberet.test.cdi.SomeProcessingService;
import org.jberet.test.dao.entities.ProcessingEntity;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by sesshoumaru on 8/13/17.
 */
@Path("/")
public class ProcessingRest {

    @Inject
    private SomeProcessingService processingService;

    @GET
    @Path("hello")
    public String hello() {
        return processingService.produceHello();
    }

    @GET
    @Path("process")
    @Produces(MediaType.APPLICATION_JSON)
    public ProcessingEntity put(@QueryParam("key") String key, @QueryParam("value") String value) {
        return processingService.processData(key, value);
    }

    @GET
    @Path("show")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProcessingEntity> put() {
        return processingService.getAllProcessedData();
    }
}
