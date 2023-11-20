package com.imd.web.swaptales.repository;

import com.imd.web.swaptales.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Long> {

    @Query("SELECT l FROM Loan l INNER JOIN Book b on b.id = l.book.id WHERE b.ownerUser = :idUser")
    List<Loan> findAllBorrowedByIdUser(@Param("idUser") Long idUser);

    @Query("SELECT l FROM Loan l WHERE l.user.id = :idUser")
    List<Loan> findAllLoanedByIdUser(@Param("idUser") Long idUser);
}
