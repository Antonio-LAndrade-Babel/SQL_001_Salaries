package com.helloworld.salaries.controllers;

import com.helloworld.salaries.company.salary.services.OfficeService;
import com.helloworld.salaries.model.Office;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/office")
public class OfficeController {
    private final OfficeService officeService;

    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }

    @GetMapping
    @Operation(summary = "Listar todas las oficinas existentes.")
    public ResponseEntity<List<Office>> getAllOffices() {
        List<Office> offices = officeService.findAllOffices();
        return ResponseEntity.ok().body(offices);
    }
}
