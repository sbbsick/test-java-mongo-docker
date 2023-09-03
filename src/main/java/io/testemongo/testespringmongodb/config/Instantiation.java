package io.testemongo.testespringmongodb.config;

import io.testemongo.testespringmongodb.domain.Post;
import io.testemongo.testespringmongodb.domain.User;
import io.testemongo.testespringmongodb.dto.AuthorDTO;
import io.testemongo.testespringmongodb.repository.PostRepository;
import io.testemongo.testespringmongodb.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;

@RequiredArgsConstructor
@Configuration
public class Instantiation implements CommandLineRunner {
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User user1 = new User(null, "teste 1", "teste1@gmail");
        User user2 = new User(null, "teste 2", "teste2@gmail");
        User user3 = new User(null, "teste 3", "teste3@gmail");

        userRepository.saveAll(List.of(user1, user2, user3));

        Post post1 = new Post(null,"Post 01", "teste de body 01", sdf.parse("21/03/2023"), new AuthorDTO(user1));
        Post post2 = new Post(null,"Post 02", "teste de body 02", sdf.parse("21/05/2023"), new AuthorDTO(user1));
        Post post3 = new Post(null,"Post 03", "teste de body 03", sdf.parse("21/10/2023"), new AuthorDTO(user3));

        postRepository.saveAll(List.of(post1, post2, post3));

        user1.getPosts().addAll(List.of(post1, post2));
        user3.getPosts().add(post3);

        userRepository.saveAll(List.of(user1, user3));
    }
}
