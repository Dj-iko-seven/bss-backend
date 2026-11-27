package bi.bss.backend.audit.entity;

import bi.bss.backend.securite.entity.Utilisateur;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "evenements_audit")
@Getter
@Setter
@NoArgsConstructor
public class EvenementAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    @Column(name = "type_evenement", nullable = false, length = 80)
    private String typeEvenement;

    @Column(name = "entite", length = 80)
    private String entite;

    @Column(name = "entite_id")
    private Long entiteId;

    @CreationTimestamp
    @Column(name = "date_evenement", nullable = false, updatable = false)
    private Instant dateEvenement;
}
