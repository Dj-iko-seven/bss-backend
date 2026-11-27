package bi.bss.backend.institution.entity;

import bi.bss.backend.enums.StatutInstitution;
import bi.bss.backend.geographie.entity.Commune;
import bi.bss.backend.geographie.entity.Localisation;
import bi.bss.backend.geographie.entity.Province;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Entity
@Table(name = "institutions_publiques")
@Getter
@Setter
@NoArgsConstructor
public class InstitutionPublique {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom_officiel", nullable = false, length = 255)
    private String nomOfficiel;

    @Column(name = "type_institution", length = 100)
    private String typeInstitution;

    @Column(name = "ministere_rattachement", length = 150)
    private String ministereRattachement;

    @Column(name = "adresse", length = 255)
    private String adresse;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "province_id")
    private Province province;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "commune_id")
    private Commune commune;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "localisation_id")
    private Localisation localisation;

    @Column(name = "telephone", length = 30)
    private String telephone;

    @Column(name = "adresse_email", length = 255)
    private String adresseEmail;

    @Enumerated(EnumType.STRING)
    @Column(name = "statut", nullable = false, length = 30)
    private StatutInstitution statut = StatutInstitution.ACTIF;

    @Column(name = "est_supprime", nullable = false)
    private Boolean estSupprime = false;

    @Column(name = "date_suppression")
    private Instant dateSuppression;

    @Column(name = "supprime_par")
    private Long supprimePar;

    @Column(name = "cree_par")
    private Long creePar;

    @Column(name = "modifie_par")
    private Long modifiePar;

    @CreationTimestamp
    @Column(name = "date_creation", nullable = false, updatable = false)
    private Instant dateCreation;

    @UpdateTimestamp
    @Column(name = "date_modification", nullable = false)
    private Instant dateModification;
}
