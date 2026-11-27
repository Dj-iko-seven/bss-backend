package bi.bss.backend.service.repository;

import bi.bss.backend.service.entity.ProcedureServicePublic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProcedureServicePublicRepository extends JpaRepository<ProcedureServicePublic, Long> {

    List<ProcedureServicePublic> findByServiceId(Long serviceId);
}
