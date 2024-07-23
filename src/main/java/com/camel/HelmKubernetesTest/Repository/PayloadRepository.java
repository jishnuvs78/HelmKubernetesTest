package com.camel.HelmKubernetesTest.Repository;

import com.camel.HelmKubernetesTest.model.Payload;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayloadRepository extends CrudRepository<Payload,Long> {
}
