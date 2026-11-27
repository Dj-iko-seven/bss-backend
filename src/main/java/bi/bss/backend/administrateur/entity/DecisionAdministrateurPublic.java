package bi.bss.backend.administrateur.entity;

import bi.bss.backend.enums.DecisionDemandeAdminPublic;
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

import java.time.Instant;

@Entity
@Table(name = "decisions_administrateurs_publics")
@Getter
@Setter
@NoArgsConstructor
public class DecisionAdministrateurPublic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "demande_id", nullable = false)
    private DemandeAdministrateurPublic demande;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "decideur_utilisateur_id", nullable = false)
    private Utilisateur decideurUtilisateur;

    @Enumerated(EnumType.STRING)
    @Column(name = "decision", nullable = false, length = 50)
    private DecisionDemandeAdminPublic decision;

    @Column(name = "motif")
    private String motif;

    @CreationTimestamp
    @Column(name = "date_decision", nullable = false, updatable = false)
    private Instant dateDecision;
}
