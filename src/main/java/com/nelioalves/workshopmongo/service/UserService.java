package com.nelioalves.workshopmongo.service;

import com.nelioalves.workshopmongo.domain.User;
import com.nelioalves.workshopmongo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository Repository;

    public UserService(UserRepository Repository) {
        this.Repository = Repository;
    }

    public List<User> findAll() {
        return Repository.findAll();
    }
}
