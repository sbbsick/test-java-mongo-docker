package io.testemongo.testespringmongodb.controller;

import io.testemongo.testespringmongodb.domain.User;
import io.testemongo.testespringmongodb.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<User>> AllUsers() {
        List<User> lst = userService.listAll();
        return ResponseEntity.ok().body(lst);
    }

    @PostMapping("/add")
    public ResponseEntity<User> AddUser() {
        User user = new User();
        user.setName("teste 2222");
        user.setEmail("adsaadasdad@gmail.com");
        User user2 = userService.addUser(user);
        return ResponseEntity.ok().body(user2);
}

}
