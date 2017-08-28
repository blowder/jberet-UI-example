package org.jberet.test.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.batch.api.AbstractBatchlet;
import javax.batch.runtime.context.JobContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.UUID;

/**
 * Created by sesshoumaru on 8/13/17.
 */

@Named
public class MyBatchlet extends AbstractBatchlet {
    private static Logger LOGGER = LoggerFactory.getLogger(MyBatchlet.class);
    @Inject
    private JobContext jobContext;


    public String process() throws Exception {
        LOGGER.info(UUID.randomUUID().toString());
        Thread.sleep(10000);
        return "Processed";
    }
}
