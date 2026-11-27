package bi.bss.backend.administrateur.entity;

import bi.bss.backend.enums.StatutDemandeAdminPublic;
import bi.bss.backend.institution.entity.InstitutionPublique;
import bi.bss.backend.securite.entity.Utilisateur;
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
@Table(name = "demandes_administrateurs_publics")
@Getter
@Setter
@NoArgsConstructor
public class DemandeAdministrateurPublic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "utilisateur_id", nullable = false)
    private Utilisateur utilisateur;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "institution_id", nullable = false)
    private InstitutionPublique institution;

    @Column(name = "fonction", nullable = false, length = 150)
    private String fonction;

    @Column(name = "service_departement", length = 150)
    private String serviceDepartement;

    @Column(name = "telephone_professionnel", length = 30)
    private String telephoneProfessionnel;

    @Column(name = "email_professionnel", length = 255)
    private String emailProfessionnel;

    @Column(name = "responsabilites")
    private String responsabilites;

    @Enumerated(EnumType.STRING)
    @Column(name = "statut", nullable = false, length = 50)
    private StatutDemandeAdminPublic statut = StatutDemandeAdminPublic.EN_ATTENTE;

    @Column(name = "motif_rejet")
    private String motifRejet;

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
