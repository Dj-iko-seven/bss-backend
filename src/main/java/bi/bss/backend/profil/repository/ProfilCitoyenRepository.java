package bi.bss.backend.profil.repository;

import bi.bss.backend.profil.entity.ProfilCitoyen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfilCitoyenRepository extends JpaRepository<ProfilCitoyen, Long> {

    Optional<ProfilCitoyen> findByUtilisateurId(Long utilisateurId);
}
