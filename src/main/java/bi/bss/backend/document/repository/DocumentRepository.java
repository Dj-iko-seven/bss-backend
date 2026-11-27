package bi.bss.backend.document.repository;

import bi.bss.backend.document.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DocumentRepository extends JpaRepository<Document, Long> {

    List<Document> findByProprietaireUtilisateurId(Long utilisateurId);

    List<Document> findByTypeDocumentCode(String code);

    Optional<Document> findByCleStockage(String cleStockage);
}
