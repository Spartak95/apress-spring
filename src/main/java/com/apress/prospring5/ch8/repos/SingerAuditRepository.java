package com.apress.prospring5.ch8.repos;

import com.apress.prospring5.ch8.entities.SingerAudit;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SingerAuditRepository extends CrudRepository<SingerAudit, Long> {
    Optional<SingerAudit> findOne(Long id);
}
