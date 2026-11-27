package bi.bss.backend.institution.repository;

import bi.bss.backend.enums.StatutInstitution;
import bi.bss.backend.institution.entity.InstitutionPublique;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InstitutionPubliqueRepository extends JpaRepository<InstitutionPublique, Long> {

    Optional<InstitutionPublique> findByNomOfficiel(String nomOfficiel);

    List<InstitutionPublique> findByStatut(StatutInstitution statut);
}
