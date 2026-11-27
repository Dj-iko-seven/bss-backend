package bi.bss.backend.administrateur.entity;

import bi.bss.backend.enums.ResultatVerification;
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
@Table(name = "verifications_administrateurs_publics")
@Getter
@Setter
@NoArgsConstructor
public class VerificationAdministrateurPublic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "demande_id", nullable = false)
    private DemandeAdministrateurPublic demande;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "verificateur_utilisateur_id", nullable = false)
    private Utilisateur verificateurUtilisateur;

    @Enumerated(EnumType.STRING)
    @Column(name = "resultat", nullable = false, length = 40)
    private ResultatVerification resultat;

    @Column(name = "observations")
    private String observations;

    @CreationTimestamp
    @Column(name = "date_verification", nullable = false, updatable = false)
    private Instant dateVerification;
}
