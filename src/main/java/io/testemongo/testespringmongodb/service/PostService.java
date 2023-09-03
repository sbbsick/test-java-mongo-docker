package io.testemongo.testespringmongodb.service;

import io.testemongo.testespringmongodb.domain.Post;
import io.testemongo.testespringmongodb.exception.notfound.ObjectNotFoundException;
import io.testemongo.testespringmongodb.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public Post findById(String id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Post not found with id: " + id));
    }

    public List<Post> findByTitle(String text) {
        return postRepository.findByTitleContainingIgnoreCase(text);
    }
}
