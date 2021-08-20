package com.login.app.repository;

import com.login.app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User getByEmail(String email);

    boolean existsByEmailIgnoreCase(String email);

}
