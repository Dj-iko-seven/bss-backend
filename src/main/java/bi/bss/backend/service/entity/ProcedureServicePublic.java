package bi.bss.backend.service.entity;

import bi.bss.backend.enums.StatutProcedure;
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
@Table(name = "procedures_services_publics")
@Getter
@Setter
@NoArgsConstructor
public class ProcedureServicePublic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "service_id", nullable = false)
    private ServicePublic service;

    @Column(name = "titre", nullable = false, length = 255)
    private String titre;

    @Column(name = "description")
    private String description;

    @Column(name = "delai_traitement", length = 100)
    private String delaiTraitement;

    @Column(name = "cout", precision = 19, scale = 4)
    private BigDecimal cout;

    @Column(name = "devise", nullable = false, length = 10)
    private String devise = "BIF";

    @Enumerated(EnumType.STRING)
    @Column(name = "statut", nullable = false, length = 30)
    private StatutProcedure statut = StatutProcedure.BROUILLON;

    @CreationTimestamp
    @Column(name = "date_creation", nullable = false, updatable = false)
    private Instant dateCreation;

    @UpdateTimestamp
    @Column(name = "date_modification", nullable = false)
    private Instant dateModification;
}
