package com.imd.web.swaptales.service.impl;

import com.imd.web.swaptales.model.Sale;
import com.imd.web.swaptales.repository.SaleRepository;
import com.imd.web.swaptales.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaleServiceImpl implements SaleService {

    @Autowired
    private SaleRepository saleRepository;

    @Override
    public List<Sale> findAllSoldByIdUser(Long idUser) {
        return saleRepository.findAllSoldByIdUser(idUser);
    }

    @Override
    public List<Sale> findAllPurchasedByIdUser(Long idUser) {
        return saleRepository.findAllPurchasedByIdUser(idUser);
    }

    @Override
    public Sale createSale(Sale sale) {
        return saleRepository.save(sale);
    }

    @Override
    public Optional<Sale> getSaleById(Long idSale) {
        return saleRepository.findById(idSale);
    }

    @Override
    public Sale updateSale(Sale sale) {
        return saleRepository.save(sale);
    }

    @Override
    public void deleteSale(Long idSale) {
        saleRepository.deleteById(idSale);
    }
}
