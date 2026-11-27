package bi.bss.backend.administrateur.entity;

import bi.bss.backend.enums.StatutProfessionnel;
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
@Table(name = "profils_administrateurs_publics")
@Getter
@Setter
@NoArgsConstructor
public class ProfilAdministrateurPublic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "utilisateur_id", nullable = false, unique = true)
    private Utilisateur utilisateur;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "institution_id", nullable = false)
    private InstitutionPublique institution;

    @Column(name = "fonction", length = 150)
    private String fonction;

    @Column(name = "service_departement", length = 150)
    private String serviceDepartement;

    @Column(name = "telephone_professionnel", length = 30)
    private String telephoneProfessionnel;

    @Column(name = "email_professionnel", length = 255)
    private String emailProfessionnel;

    @Enumerated(EnumType.STRING)
    @Column(name = "statut_professionnel", nullable = false, length = 30)
    private StatutProfessionnel statutProfessionnel = StatutProfessionnel.ACTIF;

    @CreationTimestamp
    @Column(name = "date_rattachement", nullable = false)
    private Instant dateRattachement;

    @CreationTimestamp
    @Column(name = "date_creation", nullable = false, updatable = false)
    private Instant dateCreation;

    @UpdateTimestamp
    @Column(name = "date_modification", nullable = false)
    private Instant dateModification;
}
