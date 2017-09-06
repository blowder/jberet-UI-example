package org.jberet.test.batch.paralell;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.batch.api.chunk.ItemWriter;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * Created by sesshoumaru on 9/6/17.
 */
@Named
public class IntWriter implements ItemWriter {
    private static Logger LOGGER = LoggerFactory.getLogger(IntWriter.class);

    @Override
    public void open(Serializable serializable) throws Exception {

    }

    @Override
    public void close() throws Exception {

    }

    @Override
    public void writeItems(List<Object> list) throws Exception {
        LOGGER.info(list.toString());
    }

    @Override
    public Serializable checkpointInfo() throws Exception {
        return null;
    }
}
