package com.nelioalves.workshopmongo.service;

import com.nelioalves.workshopmongo.domain.Post;
import com.nelioalves.workshopmongo.repository.PostRepository;
import com.nelioalves.workshopmongo.service.exception.ObjectNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class PostService {
    private final PostRepository repository;

    public PostService(PostRepository Repository) {
        this.repository = Repository;
    }

    public Post findById(String id) {
        Post post  = repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado."));
        return post;
    }
}
