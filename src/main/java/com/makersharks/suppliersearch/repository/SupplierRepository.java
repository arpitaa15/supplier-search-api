package com.makersharks.suppliersearch.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.makersharks.suppliersearch.model.ManufacturingProcess;
import com.makersharks.suppliersearch.model.NatureOfBusiness;
import com.makersharks.suppliersearch.model.Supplier;

import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

    Page<Supplier> findAllByLocationAndNatureOfBusinessAndManufacturingProcessesContaining(
        String location, 
        NatureOfBusiness natureOfBusiness, 
        ManufacturingProcess manufacturingProcess, 
        Pageable pageable
    );
}
