package bi.bss.backend.securite.repository;

import bi.bss.backend.enums.CodeRole;
import bi.bss.backend.securite.entity.UtilisateurRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UtilisateurRoleRepository extends JpaRepository<UtilisateurRole, Long> {

    List<UtilisateurRole> findByUtilisateurId(Long utilisateurId);

    boolean existsByUtilisateurIdAndRoleCode(Long utilisateurId, CodeRole code);
}
