package bi.bss.backend.profil.entity;

import bi.bss.backend.document.entity.Document;
import bi.bss.backend.enums.StatutVerificationEntreprise;
import bi.bss.backend.geographie.entity.Localisation;
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
@Table(name = "profils_entreprises")
@Getter
@Setter
@NoArgsConstructor
public class ProfilEntreprise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "utilisateur_id", nullable = false, unique = true)
    private Utilisateur utilisateur;

    @Column(name = "nom_officiel", nullable = false, length = 255)
    private String nomOfficiel;

    @Column(name = "nom_commercial", length = 255)
    private String nomCommercial;

    @Column(name = "numero_enregistrement", length = 100)
    private String numeroEnregistrement;

    @Column(name = "identifiant_fiscal", length = 100)
    private String identifiantFiscal;

    @Column(name = "description_activite")
    private String descriptionActivite;

    @Column(name = "telephone_entreprise", length = 30)
    private String telephoneEntreprise;

    @Column(name = "email_entreprise", length = 255)
    private String emailEntreprise;

    @Column(name = "adresse", length = 255)
    private String adresse;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "localisation_id")
    private Localisation localisation;

    @Enumerated(EnumType.STRING)
    @Column(name = "statut_verification", nullable = false, length = 30)
    private StatutVerificationEntreprise statutVerification = StatutVerificationEntreprise.EN_ATTENTE;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "document_logo_id")
    private Document documentLogo;

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
