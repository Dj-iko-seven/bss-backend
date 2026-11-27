package bi.bss.backend.document.entity;

import bi.bss.backend.enums.StatutAntivirus;
import bi.bss.backend.enums.StatutDocument;
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
@Table(name = "documents")
@Getter
@Setter
@NoArgsConstructor
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "proprietaire_utilisateur_id", nullable = false)
    private Utilisateur proprietaireUtilisateur;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "type_document_id", nullable = false)
    private TypeDocument typeDocument;

    @Column(name = "nom_original", nullable = false, length = 255)
    private String nomOriginal;

    @Column(name = "nom_interne", nullable = false, unique = true, length = 255)
    private String nomInterne;

    @Column(name = "type_mime", nullable = false, length = 150)
    private String typeMime;

    @Column(name = "taille", nullable = false)
    private Long taille;

    @Column(name = "empreinte_sha256", nullable = false, length = 64)
    private String empreinteSha256;

    @Column(name = "cle_stockage", nullable = false, unique = true, length = 512)
    private String cleStockage;

    @Enumerated(EnumType.STRING)
    @Column(name = "statut", nullable = false, length = 30)
    private StatutDocument statut = StatutDocument.DISPONIBLE;

    @Enumerated(EnumType.STRING)
    @Column(name = "statut_antivirus", nullable = false, length = 30)
    private StatutAntivirus statutAntivirus = StatutAntivirus.NON_VERIFIE;

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

    @CreationTimestamp
    @Column(name = "date_depot", nullable = false, updatable = false)
    private Instant dateDepot;
}
