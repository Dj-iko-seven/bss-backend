package bi.bss.backend.securite.repository;

import bi.bss.backend.securite.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

    Optional<Utilisateur> findByAdresseEmail(String adresseEmail);

    boolean existsByAdresseEmail(String adresseEmail);
}
