package com.imd.web.swaptales.service.impl;

import com.imd.web.swaptales.enums.StatusExchange;
import com.imd.web.swaptales.model.Exchange;
import com.imd.web.swaptales.repository.ExchangeRepository;
import com.imd.web.swaptales.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ExchangeServiceImpl implements ExchangeService {

    @Autowired
    private ExchangeRepository exchangeRepository;

    @Override
    public List<Exchange> getAllExchangesByIdUser(Long idUser) {


        List<Exchange> listBD = exchangeRepository.findAllExchangesByIdUser(idUser);

        List<Exchange> listResult = listBD.stream()
                .filter(obj-> !(StatusExchange.PENDENTE.equals(obj.getStatus()) || StatusExchange.RECUSADO.equals(obj.getStatus())))
                .collect(Collectors.toList());

        return listResult;
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

    @Override
    public List<Exchange> getAllExchangesPendentByIdUser(Long idUser) {
        return exchangeRepository.findAllExchangesByIdUserAndByStatus(idUser, StatusExchange.PENDENTE);
    }

    @Override
    public Exchange acceptExchange(Long id){
        Exchange exchange = exchangeRepository.findById(id).get();
        exchange.setStatus(StatusExchange.ACEITO);
        return exchangeRepository.save(exchange);
    }
}
