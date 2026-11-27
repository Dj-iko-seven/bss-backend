package bi.bss.backend.assistance.repository;

import bi.bss.backend.assistance.entity.MessageAssistance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageAssistanceRepository extends JpaRepository<MessageAssistance, Long> {

    List<MessageAssistance> findByDemandeId(Long demandeId);
}
