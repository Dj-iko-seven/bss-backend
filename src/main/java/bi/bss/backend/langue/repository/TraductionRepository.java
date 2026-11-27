package bi.bss.backend.langue.repository;

import bi.bss.backend.langue.entity.Traduction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TraductionRepository extends JpaRepository<Traduction, Long> {

    Optional<Traduction> findByCleAndLangueCode(String cle, String codeLangue);
}
