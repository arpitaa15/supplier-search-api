package com.makersharks.suppliersearch.controller;

import java.awt.print.Pageable;

import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.makersharks.suppliersearch.model.ManufacturingProcess;
import com.makersharks.suppliersearch.model.NatureOfBusiness;
import com.makersharks.suppliersearch.model.Supplier;
import com.makersharks.suppliersearch.service.SupplierService;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;
    
    @PostMapping("/query")
    public ResponseEntity<Page<Supplier>> querySuppliers(
            @RequestParam@NotNull String location,
            @RequestParam@NotNull NatureOfBusiness natureOfBusiness,
            @RequestParam@NotNull ManufacturingProcess process,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = (Pageable) PageRequest.of(page, size);
        Page<Supplier> suppliers = supplierService.searchSuppliers(location, natureOfBusiness, process, pageable);
        return ResponseEntity.ok(suppliers);
    }


    
}
