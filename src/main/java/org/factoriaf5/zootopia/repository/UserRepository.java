package org.factoriaf5.zootopia.repository;

import java.util.Optional;

import org.factoriaf5.zootopia.models.User;



import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    
    public Optional<User> findByUsername(String username);
}