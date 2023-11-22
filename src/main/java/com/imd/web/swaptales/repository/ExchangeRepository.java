package com.imd.web.swaptales.repository;

import com.imd.web.swaptales.model.Loan;
import com.imd.web.swaptales.model.Exchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExchangeRepository extends JpaRepository<Exchange, Long> {
    @Query("SELECT e FROM Exchange e WHERE e.user.id = :idUser OR e.book.ownerUser.id = :idUser")
    List<Exchange> findAllExchangesByIdUser(@Param("idUser") Long idUser);

}
