package com.service.security.repository;

import com.service.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String name);

    @Query(value = "select * from users where username =:data", nativeQuery = true)
    User encontrarUsuarioPorUserName(@PathVariable("data") String data);

    //@Query(value = "SELECT ua FROM User ua where ua.username =:data")
    //User findUserByUserName(@PathVariable("data") String data);
}
