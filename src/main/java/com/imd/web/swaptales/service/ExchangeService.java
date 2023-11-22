package com.imd.web.swaptales.service;

import com.imd.web.swaptales.model.Exchange;

import java.util.List;
import java.util.Optional;

public interface ExchangeService {

    List<Exchange> getAllExchangesByIdUser(Long idUser);

    Exchange createExchange(Exchange exchange);

    Optional<Exchange> getExchangeById(Long idExchange);

    Exchange updateExchange(Exchange exchange);

    void deleteExchangeById(Long idExchange);
}
