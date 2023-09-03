package io.testemongo.testespringmongodb.controller;

import io.testemongo.testespringmongodb.domain.Post;
import io.testemongo.testespringmongodb.domain.User;
import io.testemongo.testespringmongodb.dto.UserDTO;
import io.testemongo.testespringmongodb.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> AllUsers() {
        List<User> userList = userService.listAll();
        List<UserDTO> dtoList = UserDTO.convertAllUsersToUserDto(userList);
        return ResponseEntity.ok().body(dtoList);
    }

    @GetMapping(path = "/get/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
        User user = userService.findById(id);
        UserDTO dto = UserDTO.convertUserToUserDto(user);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping(path = "/ids")
    public ResponseEntity<List<UserDTO>> findUsersByIds(@RequestParam List<String> ids) {
        List<User> userList = userService.findUsersByIds(ids);
        List<UserDTO> dtoList = UserDTO.convertAllUsersToUserDto(userList);
        return ResponseEntity.ok().body(dtoList);
    }

    @PostMapping(path = "/insert")
    public ResponseEntity<UserDTO> insert(@RequestBody UserDTO userDTO) {
        User user = UserDTO.convertUserDtoToUser(userDTO);
        user = userService.insert(user);
        userDTO = UserDTO.convertUserToUserDto(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userDTO);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<UserDTO> update(@RequestBody UserDTO userDTO, @PathVariable String id) {
        User user = UserDTO.convertUserDtoToUser(userDTO);
        user.setId(id);
        user = userService.update(user);
        userDTO = UserDTO.convertUserToUserDto(user);
        return ResponseEntity.ok().body(userDTO);
    }

    @GetMapping(path = "/get/{id}/posts")
    public ResponseEntity<List<Post>> findPosts(@PathVariable String id) {
        User user = userService.findById(id);
        return ResponseEntity.ok().body(user.getPosts());
    }
}
