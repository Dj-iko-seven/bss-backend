package bi.bss.backend.audit.entity;

import bi.bss.backend.enums.ResultatOperation;
import bi.bss.backend.securite.entity.Role;
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
@Table(name = "journaux_activite")
@Getter
@Setter
@NoArgsConstructor
public class JournalActivite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private Role role;

    @Column(name = "action", nullable = false, length = 100)
    private String action;

    @Column(name = "entite", length = 80)
    private String entite;

    @Column(name = "entite_id")
    private Long entiteId;

    @Column(name = "adresse_ip", length = 45)
    private String adresseIp;

    @Column(name = "appareil", length = 255)
    private String appareil;

    @Enumerated(EnumType.STRING)
    @Column(name = "resultat", nullable = false, length = 20)
    private ResultatOperation resultat;

    @CreationTimestamp
    @Column(name = "date_action", nullable = false, updatable = false)
    private Instant dateAction;
}
