package com.nelioalves.workshopmongo.service;

import com.nelioalves.workshopmongo.domain.Post;
import com.nelioalves.workshopmongo.repository.PostRepository;
import com.nelioalves.workshopmongo.service.exception.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


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

    public List<Post> findByTitle(String text) {
        return repository.searchTitle(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return repository.fullSearch(text, minDate, maxDate);
    }
}
