package bi.bss.backend.notification.entity;

import bi.bss.backend.enums.CanalNotification;
import bi.bss.backend.enums.StatutEnvoi;
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

import java.time.Instant;

@Entity
@Table(name = "envois_notifications")
@Getter
@Setter
@NoArgsConstructor
public class EnvoiNotification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "notification_id", nullable = false)
    private Notification notification;

    @Enumerated(EnumType.STRING)
    @Column(name = "canal", nullable = false, length = 20)
    private CanalNotification canal;

    @Column(name = "fournisseur", length = 80)
    private String fournisseur;

    @Column(name = "reference_fournisseur", length = 255)
    private String referenceFournisseur;

    @Enumerated(EnumType.STRING)
    @Column(name = "statut", nullable = false, length = 20)
    private StatutEnvoi statut = StatutEnvoi.EN_ATTENTE;

    @Column(name = "tentatives", nullable = false)
    private Integer tentatives = 0;

    @Column(name = "erreur")
    private String erreur;

    @Column(name = "date_envoi")
    private Instant dateEnvoi;
}
