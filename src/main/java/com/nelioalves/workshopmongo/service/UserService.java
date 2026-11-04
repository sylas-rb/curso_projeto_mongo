package com.nelioalves.workshopmongo.service;

import com.nelioalves.workshopmongo.domain.User;
import com.nelioalves.workshopmongo.dto.UserDTO;
import com.nelioalves.workshopmongo.repository.UserRepository;
import com.nelioalves.workshopmongo.service.exception.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository Repository) {
        this.repository = Repository;
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {
        User user  = repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado."));
        return user;
    }

    public User insert(User user) {
        return repository.save(user);
    }

    public User fromDTO(UserDTO obj) {
        return new User(obj.getId(), obj.getName(), obj.getEmail());
    }
}
