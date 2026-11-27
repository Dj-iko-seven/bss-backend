package bi.bss.backend.securite.repository;

import bi.bss.backend.securite.entity.SessionUtilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SessionUtilisateurRepository extends JpaRepository<SessionUtilisateur, Long> {

    Optional<SessionUtilisateur> findByJtiHash(String jtiHash);

    List<SessionUtilisateur> findByUtilisateurId(Long utilisateurId);
}
