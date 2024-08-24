package com.makersharks.suppliersearch.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.makersharks.suppliersearch.model.ManufacturingProcess;
import com.makersharks.suppliersearch.model.NatureOfBusiness;
import com.makersharks.suppliersearch.model.Supplier;
import com.makersharks.suppliersearch.repository.SupplierRepository;

import java.util.List;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public Page<Supplier> findSuppliers(String location, NatureOfBusiness natureOfBusiness, ManufacturingProcess manufacturingProcess, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return supplierRepository.findAllByLocationAndNatureOfBusinessAndManufacturingProcessesContaining(location, natureOfBusiness, manufacturingProcess, pageable);
    }

	public Page<Supplier> searchSuppliers(String location, NatureOfBusiness natureOfBusiness,
			ManufacturingProcess process, java.awt.print.Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}
}
