package bi.bss.backend.geographie.repository;

import bi.bss.backend.geographie.entity.Commune;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommuneRepository extends JpaRepository<Commune, Long> {

    List<Commune> findByProvinceId(Long provinceId);
}
