package com.nelioalves.workshopmongo.resources;

import com.nelioalves.workshopmongo.domain.Post;
import com.nelioalves.workshopmongo.resources.util.URL;
import com.nelioalves.workshopmongo.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/posts")
public class PostResource {
    private final PostService service;

    public PostResource(PostService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post obj = service.findById(id);

        return ResponseEntity.ok().body(obj);
    }

    @GetMapping("/titlesearch")
    public ResponseEntity<List<Post>>  findByTitle(@RequestParam(value="text", defaultValue = "") String text) {
        text = URL.decodeParam(text);
        List<Post> obj = service.findByTitle(text);
        return ResponseEntity.ok().body(obj);
    }
}
