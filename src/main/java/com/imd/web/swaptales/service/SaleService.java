package com.imd.web.swaptales.service;

import com.imd.web.swaptales.model.Exchange;
import com.imd.web.swaptales.model.Loan;
import com.imd.web.swaptales.model.Sale;

import java.util.List;
import java.util.Optional;

public interface SaleService {

    List<Sale> findAllSoldByIdUser(Long idUser);

    List<Sale> findAllPurchasedByIdUser(Long idUser);

    Sale createSale(Sale sale);

    Optional<Sale> getSaleById(Long idSale);

    Sale updateSale(Sale sale);

    void deleteSale(Long idSale);
}
