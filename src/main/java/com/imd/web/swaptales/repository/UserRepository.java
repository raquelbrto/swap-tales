package com.imd.web.swaptales.repository;

import com.imd.web.swaptales.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    Optional<User> findByUsername(String username);

    Optional<User> findByEmailAndPassword(String email, String password);


    @Query("SELECT u FROM User u ORDER BY u.countFollowers DESC")
    List<User> listTopUsers();
}
