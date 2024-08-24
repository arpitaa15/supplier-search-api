package com.makersharks.suppliersearch;



import com.makersharks.suppliersearch.model.NatureOfBusiness;
import com.makersharks.suppliersearch.model.ManufacturingProcess;
import com.makersharks.suppliersearch.model.Supplier;
import com.makersharks.suppliersearch.repository.SupplierRepository;
import com.makersharks.suppliersearch.service.SupplierService;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class SupplierServiceTests {

    @Mock
    private SupplierRepository supplierRepository;

    @InjectMocks
    private SupplierService supplierService;

    public SupplierServiceTests() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindSuppliers() {
        Supplier supplier = new Supplier();
        supplier.setSupplierId(1L);
        supplier.setCompanyName("Test Company");

        Page<Supplier> page = new PageImpl<>(Collections.singletonList(supplier), PageRequest.of(0, 1), 1);
        when(supplierRepository.findAllByLocationAndNatureOfBusinessAndManufacturingProcessesContaining(
            any(), any(), any(), any(Pageable.class))
        ).thenReturn(page);

        Page<Supplier> result = supplierService.findSuppliers("India", NatureOfBusiness.SMALL_SCALE, ManufacturingProcess.MOULDING, 0, 1);
        assertEquals(1, result.getTotalElements());
        assertEquals("Test Company", result.getContent().get(0).getCompanyName());
    }
}
