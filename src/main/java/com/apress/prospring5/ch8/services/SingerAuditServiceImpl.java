package com.apress.prospring5.ch8.services;

import com.apress.prospring5.ch8.entities.SingerAudit;
import com.apress.prospring5.ch8.repos.SingerAuditRepository;
import org.hibernate.Session;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service("singerAuditService")
@Transactional
public class SingerAuditServiceImpl implements SingerAuditService {
    @Autowired
    private SingerAuditRepository singerAuditRepository;
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly=true)
    @Override
    public List<SingerAudit> findAll() {
        return StreamSupport.stream(singerAuditRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @Override
    public SingerAudit findById(Long id) {
        return singerAuditRepository.findOne(id).get();
    }

    @Override
    public SingerAudit save(SingerAudit singer) {
        return singerAuditRepository.save(singer);
    }

    @Override
    public SingerAudit findAuditByRevision(Long id, int revision) {
        AuditReader auditReader = AuditReaderFactory.get((Session) entityManager);
        return auditReader.find(SingerAudit.class, id, revision);
    }
}
