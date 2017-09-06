package org.jberet.test.batch.paralell;

import javax.batch.api.BatchProperty;
import javax.batch.api.chunk.ItemReader;
import javax.batch.runtime.context.StepContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by sesshoumaru on 9/6/17.
 */
@Named
public class IntReader implements ItemReader {

    @Inject
    private StepContext ctx;

    @Inject
    @BatchProperty(name = "start")
    private int start;
    @Inject
    @BatchProperty(name = "stop")
    private int stop;

    private int cursor = 0;

    private List<Integer> collect;

    public void open(Serializable serializable) throws Exception {
        this.collect = IntStream.range(0, 10).boxed().collect(Collectors.toList());

    }

    public void close() throws Exception {

    }

    public Object readItem() throws Exception {
        if (cursor < start)
            cursor = start;
        if (cursor == stop)
            return null;
        return collect.get(cursor++);
    }

    public Serializable checkpointInfo() throws Exception {
        return null;
    }
}
