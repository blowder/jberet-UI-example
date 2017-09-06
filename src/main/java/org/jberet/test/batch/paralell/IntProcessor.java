package org.jberet.test.batch.paralell;

import javax.batch.api.chunk.ItemProcessor;
import javax.inject.Named;

/**
 * Created by sesshoumaru on 9/6/17.
 */
@Named
public class IntProcessor implements ItemProcessor {
    @Override
    public Object processItem(Object o) throws Exception {
        Thread.sleep(1000);
        return o;
    }
}
