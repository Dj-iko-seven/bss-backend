package bi.bss.backend.securite.repository;

import bi.bss.backend.enums.CodeRole;
import bi.bss.backend.securite.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByCode(CodeRole code);
}
