package com.imd.web.swaptales.repository;

import com.imd.web.swaptales.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
    @Query("SELECT s FROM Sale s WHERE s.book.ownerUser.id = :idUser")
    List<Sale> findAllSoldByIdUser(@Param("idUser") Long idUser);

    @Query("SELECT s FROM Sale s WHERE s.user.id = :idUser")
    List<Sale> findAllPurchasedByIdUser(@Param("idUser") Long idUser);
}
