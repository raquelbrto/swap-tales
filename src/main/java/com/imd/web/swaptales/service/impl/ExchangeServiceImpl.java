package com.imd.web.swaptales.service.impl;

import com.imd.web.swaptales.model.Exchange;
import com.imd.web.swaptales.repository.ExchangeRepository;
import com.imd.web.swaptales.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExchangeServiceImpl implements ExchangeService {

    @Autowired
    private ExchangeRepository exchangeRepository;

    @Override
    public List<Exchange> getAllExchangesByIdUser(Long idUser) {
        return exchangeRepository.findAllExchangesByIdUser(idUser);
    }

    @Override
    public Exchange createExchange(Exchange exchange) {
        return exchangeRepository.save(exchange);
    }

    @Override
    public Optional<Exchange> getExchangeById(Long idExchange) {
        return exchangeRepository.findById(idExchange);
    }

    @Override
    public Exchange updateExchange(Exchange exchange) {
        return exchangeRepository.save(exchange);
    }

    @Override
    public void deleteExchangeById(Long idExchange) {
        exchangeRepository.deleteById(idExchange);
    }
}
