package bi.bss.backend.cms.repository;

import bi.bss.backend.cms.entity.SectionCms;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SectionCmsRepository extends JpaRepository<SectionCms, Long> {

    List<SectionCms> findByPageIdOrderByOrdreAffichageAsc(Long pageId);
}
