package bi.bss.backend.profil.repository;

import bi.bss.backend.enums.StatutVerificationEntreprise;
import bi.bss.backend.profil.entity.ProfilEntreprise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProfilEntrepriseRepository extends JpaRepository<ProfilEntreprise, Long> {

    Optional<ProfilEntreprise> findByUtilisateurId(Long utilisateurId);

    List<ProfilEntreprise> findByStatutVerification(StatutVerificationEntreprise statut);
}
