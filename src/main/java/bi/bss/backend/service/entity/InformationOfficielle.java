package bi.bss.backend.service.entity;

import bi.bss.backend.enums.StatutCms;
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
@Table(name = "informations_officielles")
@Getter
@Setter
@NoArgsConstructor
public class InformationOfficielle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "institution_id", nullable = false)
    private InstitutionPublique institution;

    @Column(name = "titre", nullable = false, length = 255)
    private String titre;

    @Column(name = "contenu", nullable = false)
    private String contenu;

    @Column(name = "type_information", length = 80)
    private String typeInformation;

    @Column(name = "date_publication")
    private Instant datePublication;

    @Enumerated(EnumType.STRING)
    @Column(name = "statut", nullable = false, length = 20)
    private StatutCms statut = StatutCms.BROUILLON;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "auteur_utilisateur_id")
    private Utilisateur auteurUtilisateur;

    @CreationTimestamp
    @Column(name = "date_creation", nullable = false, updatable = false)
    private Instant dateCreation;

    @UpdateTimestamp
    @Column(name = "date_modification", nullable = false)
    private Instant dateModification;
}
