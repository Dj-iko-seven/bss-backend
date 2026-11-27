package bi.bss.backend.service.entity;

import bi.bss.backend.enums.StatutServicePublic;
import bi.bss.backend.geographie.entity.Localisation;
import bi.bss.backend.institution.entity.InstitutionPublique;
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

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "services_publics")
@Getter
@Setter
@NoArgsConstructor
public class ServicePublic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "institution_id", nullable = false)
    private InstitutionPublique institution;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categorie_id")
    private CategorieServicePublic categorie;

    @Column(name = "nom", nullable = false, length = 255)
    private String nom;

    @Column(name = "description")
    private String description;

    @Column(name = "conditions_acces")
    private String conditionsAcces;

    @Column(name = "cout", precision = 19, scale = 4)
    private BigDecimal cout;

    @Column(name = "devise", nullable = false, length = 10)
    private String devise = "BIF";

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "localisation_id")
    private Localisation localisation;

    @Column(name = "lien_officiel", length = 512)
    private String lienOfficiel;

    @Enumerated(EnumType.STRING)
    @Column(name = "statut", nullable = false, length = 30)
    private StatutServicePublic statut = StatutServicePublic.BROUILLON;

    @Column(name = "date_publication")
    private Instant datePublication;

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
