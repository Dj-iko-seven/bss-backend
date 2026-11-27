package bi.bss.backend.profil.repository;

import bi.bss.backend.profil.entity.SpecialiteProfessionnelle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpecialiteProfessionnelleRepository extends JpaRepository<SpecialiteProfessionnelle, Long> {

    Optional<SpecialiteProfessionnelle> findByLibelle(String libelle);
}
