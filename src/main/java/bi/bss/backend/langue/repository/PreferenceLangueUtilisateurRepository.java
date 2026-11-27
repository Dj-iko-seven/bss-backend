package bi.bss.backend.langue.repository;

import bi.bss.backend.langue.entity.PreferenceLangueUtilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PreferenceLangueUtilisateurRepository extends JpaRepository<PreferenceLangueUtilisateur, Long> {

    Optional<PreferenceLangueUtilisateur> findByUtilisateurId(Long utilisateurId);
}
