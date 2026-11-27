package bi.bss.backend.profil.repository;

import bi.bss.backend.profil.entity.CompetenceUtilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompetenceUtilisateurRepository extends JpaRepository<CompetenceUtilisateur, Long> {

    List<CompetenceUtilisateur> findByUtilisateurId(Long utilisateurId);
}
