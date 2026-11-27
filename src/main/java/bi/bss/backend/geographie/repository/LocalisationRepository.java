package bi.bss.backend.geographie.repository;

import bi.bss.backend.geographie.entity.Localisation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocalisationRepository extends JpaRepository<Localisation, Long> {

    List<Localisation> findByCommuneId(Long communeId);
}
