package com.unibank.sistemabancario.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.unibank.sistemabancario.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    @Transactional(readOnly = true)
    User findUserByEmail(String email);

    @Transactional(readOnly = true)
    User findUserById(Long id);
    
}
