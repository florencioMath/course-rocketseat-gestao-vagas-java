package com.florenciomath.gestao_vagas.modules.company.controllers;

import com.florenciomath.gestao_vagas.modules.company.entities.CompanyEntity;
import com.florenciomath.gestao_vagas.modules.company.useCases.CreateCompanyUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CreateCompanyUseCase createCompanyUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody CompanyEntity companyEntity) {
        System.out.println("AAAAA");
        try {
            System.out.println("SUCCESS");
            var result = this.createCompanyUseCase.execute(companyEntity);
            return  ResponseEntity.ok().body(result);
        } catch (Exception e) {
            System.out.println("ERROR");
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
