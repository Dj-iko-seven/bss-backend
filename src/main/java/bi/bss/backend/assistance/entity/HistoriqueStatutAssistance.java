package bi.bss.backend.assistance.entity;

import bi.bss.backend.enums.StatutAssistance;
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
@Table(name = "historique_statuts_assistance")
@Getter
@Setter
@NoArgsConstructor
public class HistoriqueStatutAssistance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "demande_id", nullable = false)
    private DemandeAssistance demande;

    @Column(name = "statut_precedent", length = 30)
    private String statutPrecedent;

    @Enumerated(EnumType.STRING)
    @Column(name = "statut_nouveau", nullable = false, length = 30)
    private StatutAssistance statutNouveau;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    @CreationTimestamp
    @Column(name = "date_changement", nullable = false, updatable = false)
    private Instant dateChangement;
}
