package com.isge.ic3.webServiceRestoTRIANDE.repository;

import com.isge.ic3.webServiceRestoTRIANDE.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
