package org.jberet.test.cdi;

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
}
