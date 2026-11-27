package bi.bss.backend.service.repository;

import bi.bss.backend.enums.StatutServicePublic;
import bi.bss.backend.service.entity.ServicePublic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServicePublicRepository extends JpaRepository<ServicePublic, Long> {

    List<ServicePublic> findByInstitutionId(Long institutionId);

    List<ServicePublic> findByStatut(StatutServicePublic statut);
}
