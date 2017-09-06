package org.jberet.test.batch.paralell;

import javax.batch.api.partition.PartitionMapper;
import javax.batch.api.partition.PartitionPlan;
import javax.batch.api.partition.PartitionPlanImpl;
import javax.inject.Named;
import java.util.Properties;

/**
 * Created by sesshoumaru on 9/6/17.
 */
@Named
public class IntMapper implements PartitionMapper {

    @Override
    public PartitionPlan mapPartitions() throws Exception {
        PartitionPlanImpl partitionPlan = new PartitionPlanImpl();
        partitionPlan.setThreads(2);
        partitionPlan.setPartitions(2);

        Properties properties = new Properties();
        properties.setProperty("batch.start", String.valueOf(0));
        properties.setProperty("batch.stop", String.valueOf(5));
        Properties properties1 = new Properties();
        properties1.setProperty("batch.start", String.valueOf(5));
        properties1.setProperty("batch.stop", String.valueOf(9));

        Properties[] result = new Properties[2];
        result[0] = properties;
        result[1] = properties1;
        partitionPlan.setPartitionProperties(result);
        return partitionPlan;
    }
}
