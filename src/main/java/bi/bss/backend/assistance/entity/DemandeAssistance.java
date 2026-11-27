package bi.bss.backend.assistance.entity;

import bi.bss.backend.enums.StatutAssistance;
import bi.bss.backend.enums.TypeDemandeAssistance;
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
@Table(name = "demandes_assistance")
@Getter
@Setter
@NoArgsConstructor
public class DemandeAssistance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "reference", nullable = false, unique = true, length = 50)
    private String reference;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "utilisateur_id", nullable = false)
    private Utilisateur utilisateur;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "institution_id")
    private InstitutionPublique institution;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_demande", nullable = false, length = 30)
    private TypeDemandeAssistance typeDemande;

    @Column(name = "titre", nullable = false, length = 255)
    private String titre;

    @Column(name = "description", nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "statut", nullable = false, length = 30)
    private StatutAssistance statut = StatutAssistance.NOUVELLE;

    @Column(name = "date_cloture")
    private Instant dateCloture;

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
