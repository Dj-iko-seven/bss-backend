package bi.bss.backend.profil.repository;

import bi.bss.backend.profil.entity.SpecialiteCitoyen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpecialiteCitoyenRepository extends JpaRepository<SpecialiteCitoyen, Long> {

    List<SpecialiteCitoyen> findByProfilCitoyenId(Long profilCitoyenId);
}
