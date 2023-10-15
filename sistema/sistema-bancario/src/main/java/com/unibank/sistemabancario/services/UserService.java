package com.unibank.sistemabancario.services;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import com.unibank.sistemabancario.models.User;
import com.unibank.sistemabancario.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    

    @Autowired
    private UserRepository userRepository;

    public User findById(Long id) {
        Optional<User> user = this.userRepository.findById(id);
        return user.orElseThrow(() -> new RuntimeException(
            "Usuário não encontrado! Id: " + id + ", Tipo: " + User.class.getName()
        ));
        
    }

    @Transactional
    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
        
    }

    @Transactional
    public User create(User user) {
        if (userRepository.findUserByEmail(user.getEmail()) != null) {
            throw new IllegalArgumentException("O e-mail já está sendo usado.");
        }
    
        return userRepository.save(user);
    }
    
    @Transactional
    public User update(User obj){
        User newObj = findById(obj.getId());
        newObj.setEmail(obj.getEmail());
        newObj.setNome(obj.getNome());
        newObj.setPassword(obj.getPassword());

        return this.userRepository.save(newObj);
    }

    @Transactional
    public void delete(Long id) {
        findById(id);
        try {
            this.userRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não é possível excluir, pois há entidades relacionadas!");
        }
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
    

    @Transactional
    public User authenticateUser(String email, String password) {
        User user = userRepository.findUserByEmail(email);

        if (user != null && user.getPassword().equals(password)) {
            return user;
        } else {
            return null;
        }
    }

    


}
