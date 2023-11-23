package com.imd.web.swaptales.repository;

import com.imd.web.swaptales.enums.StatusExchange;
import com.imd.web.swaptales.model.Exchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExchangeRepository extends JpaRepository<Exchange, Long> {
    @Query("SELECT e FROM Exchange e LEFT JOIN FETCH e.book b LEFT JOIN FETCH b.ownerUser WHERE e.user.id = :idUser OR b.ownerUser.id = :idUser")
    List<Exchange> findAllExchangesByIdUser(@Param("idUser") Long idUser);

    @Query("SELECT e FROM Exchange e LEFT JOIN FETCH e.book b LEFT JOIN FETCH b.ownerUser WHERE b.ownerUser.id = :idUser AND e.status = :status")
    List<Exchange> findAllExchangesByIdUserAndByStatus(@Param("idUser") Long idUser, @Param("status")StatusExchange status);

    @Modifying
    @Query("UPDATE Exchange e SET e.status = :newStatus WHERE e.id = :exchangeId")
    void updateExchangeStatusById(@Param("exchangeId") Long exchangeId, @Param("newStatus") StatusExchange newStatus);


}
