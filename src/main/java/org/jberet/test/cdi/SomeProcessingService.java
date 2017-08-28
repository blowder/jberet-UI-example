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
        JobOperatorImpl jobOperator = (JobOperatorImpl) JobOperatorContext.getJobOperatorContext().getJobOperator();

        Job job = new JobBuilder("MyJob")
                .restartable(false)
                .property("jobk1", "J")
                .step(new StepBuilder("process").batchlet("myBatchlet").build())
                .build();

        jobOperator.start(job, null);

    }
}
