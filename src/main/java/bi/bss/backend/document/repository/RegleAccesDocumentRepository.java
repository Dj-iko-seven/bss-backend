package bi.bss.backend.document.repository;

import bi.bss.backend.document.entity.RegleAccesDocument;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegleAccesDocumentRepository extends JpaRepository<RegleAccesDocument, Long> {

    List<RegleAccesDocument> findByTypeDocumentIdAndRoleId(Long typeDocumentId, Long roleId);
}
