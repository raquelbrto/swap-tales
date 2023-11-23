package com.imd.web.swaptales.repository;

import com.imd.web.swaptales.enums.StatusLoan;
import com.imd.web.swaptales.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {

    @Query("SELECT l FROM Loan l WHERE l.book.ownerUser.id = :idUser")
    List<Loan> findAllBorrowedByIdUser(@Param("idUser") Long idUser);

    @Query("SELECT l FROM Loan l WHERE l.user.id = :idUser")
    List<Loan> findAllLoanedByIdUser(@Param("idUser") Long idUser);

    @Query("SELECT l FROM Loan l LEFT JOIN FETCH l.book b LEFT JOIN FETCH b.ownerUser WHERE b.ownerUser.id = :idUser AND l.status = :status")
    List<Loan> findAllBorrowedByIdUserAndByStatus(@Param("idUser") Long idUser, @Param("status") StatusLoan status);
}
