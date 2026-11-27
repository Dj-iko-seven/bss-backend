package bi.bss.backend.langue.repository;

import bi.bss.backend.langue.entity.Langue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LangueRepository extends JpaRepository<Langue, Long> {

    Optional<Langue> findByCode(String code);

    Optional<Langue> findByEstDefautTrue();
}
