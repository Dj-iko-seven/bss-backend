package bi.bss.backend.assistance.repository;

import bi.bss.backend.assistance.entity.DemandeAssistance;
import bi.bss.backend.enums.StatutAssistance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DemandeAssistanceRepository extends JpaRepository<DemandeAssistance, Long> {

    Optional<DemandeAssistance> findByReference(String reference);

    List<DemandeAssistance> findByUtilisateurId(Long utilisateurId);

    List<DemandeAssistance> findByInstitutionId(Long institutionId);

    List<DemandeAssistance> findByStatut(StatutAssistance statut);
}
