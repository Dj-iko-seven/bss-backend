package bi.bss.backend.administrateur.repository;

import bi.bss.backend.administrateur.entity.DemandeAdministrateurPublic;
import bi.bss.backend.enums.StatutDemandeAdminPublic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DemandeAdministrateurPublicRepository extends JpaRepository<DemandeAdministrateurPublic, Long> {

    List<DemandeAdministrateurPublic> findByUtilisateurId(Long utilisateurId);

    List<DemandeAdministrateurPublic> findByInstitutionId(Long institutionId);

    List<DemandeAdministrateurPublic> findByStatut(StatutDemandeAdminPublic statut);
}
