package io.testemongo.testespringmongodb.controller;

import io.testemongo.testespringmongodb.domain.Post;
import io.testemongo.testespringmongodb.service.PostService;
import io.testemongo.testespringmongodb.util.URL;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping(path = "/get/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post post = postService.findById(id);
        return ResponseEntity.ok().body(post);
    }

    @GetMapping(path = "/get/titlesearch/{text}")
    public ResponseEntity<List<Post>> findByTitleContaining(@PathVariable String text) {
        text = URL.decodeParam(text);
        List<Post> post = postService.findByTitle(text);
        return ResponseEntity.ok().body(post);
    }

}
