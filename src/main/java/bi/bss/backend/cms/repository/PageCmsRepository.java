package bi.bss.backend.cms.repository;

import bi.bss.backend.cms.entity.PageCms;
import bi.bss.backend.enums.StatutCms;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PageCmsRepository extends JpaRepository<PageCms, Long> {

    Optional<PageCms> findByCode(String code);

    List<PageCms> findByStatut(StatutCms statut);
}
