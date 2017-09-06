package org.jberet.test.cdi;

import org.jberet.job.model.Job;
import org.jberet.job.model.JobBuilder;
import org.jberet.job.model.StepBuilder;
import org.jberet.operations.JobOperatorImpl;
import org.jberet.spi.JobOperatorContext;
import org.jberet.test.dao.EntityRepository;
import org.jberet.test.dao.entities.ProcessingEntity;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.Properties;

/**
 * Created by sesshoumaru on 8/13/17.
 */

@Stateless
public class SomeProcessingService {

    @Inject
    private EntityRepository<ProcessingEntity> entityRepository;

    public String produceHello() {
        return "Hello";
    }

    public ProcessingEntity processData(String key, String value) {
        return entityRepository.save(new ProcessingEntity(key, value));
    }

    public List<ProcessingEntity> getAllProcessedData() {
        return entityRepository.getAll(ProcessingEntity.class);
    }

    public void batch() {
        Properties properties = new Properties();
        properties.put("batchstart", 0);
        properties.put("batchstop", 5);
        Properties properties1 = new Properties();
        properties1.put("batchstart", 6);
        properties1.put("batchstop", 10);

        JobOperatorImpl jobOperator = (JobOperatorImpl) JobOperatorContext.getJobOperatorContext().getJobOperator();
        Job job = new JobBuilder("MyJob")
                .restartable(true)
                .step(new StepBuilder("stepId")
                        .reader("intReader",
                                new String[]{"start", "#{partitionPlan['batch.start']}"},
                                new String[]{"stop", "#{partitionPlan['batch.stop']}"})
                        .processor("intProcessor", new Properties())
                        .writer("intWriter", new Properties())
                        //.partitionPlan(2, 2,Arrays.asList(properties,properties1))
                        .partitionMapper("intMapper")

                        /*.partitionMapper("intMapper")*/
                        .build()
                ).build();

        /*Job job = new JobBuilder("MyJob")
                .restartable(false)
                .property("jobk1", "J")
                .step(new StepBuilder("process").batchlet("myBatchlet").build())
                .build();*/

        jobOperator.start(job, null);

    }
}
