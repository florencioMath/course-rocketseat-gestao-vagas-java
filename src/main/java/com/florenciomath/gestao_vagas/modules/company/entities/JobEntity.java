package com.florenciomath.gestao_vagas.modules.company.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "job")
@Data
public class JobEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String description;
    private String benefits;

    @NotBlank(message = "Esse campo é obrigátorio")
    private String level;

    @ManyToOne()
    @JoinColumn(name = "company_id")
    private CompanyEntity companyEntity;

    @Column(name="company_id", nullable = false, insertable = false, updatable = false)
    private UUID companyId;

    @CreationTimestamp
    private LocalDateTime createdAt;

}
