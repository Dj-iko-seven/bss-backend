package bi.bss.backend.geographie.repository;

import bi.bss.backend.geographie.entity.Province;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProvinceRepository extends JpaRepository<Province, Long> {

    Optional<Province> findByCode(String code);
}
