package bi.bss.backend.service.entity;

import bi.bss.backend.enums.TypeContact;
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

@Entity
@Table(name = "contacts_services_publics")
@Getter
@Setter
@NoArgsConstructor
public class ContactServicePublic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "service_id", nullable = false)
    private ServicePublic service;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_contact", nullable = false, length = 30)
    private TypeContact typeContact;

    @Column(name = "valeur", nullable = false, length = 255)
    private String valeur;
}
