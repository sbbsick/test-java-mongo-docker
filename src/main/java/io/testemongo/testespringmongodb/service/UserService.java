package io.testemongo.testespringmongodb.service;

import io.testemongo.testespringmongodb.domain.User;
import io.testemongo.testespringmongodb.dto.UserDTO;
import io.testemongo.testespringmongodb.exception.badrequest.BadRequestException;
import io.testemongo.testespringmongodb.exception.notfound.ObjectNotFoundException;
import io.testemongo.testespringmongodb.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> listAll() {
        List<User> userList = userRepository.findAll();

        if (userList.isEmpty()) {
            throw new ObjectNotFoundException("No users found");
        }

        return userList;
    }

    public User findById(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("User not found with id: " + id));
    }

    public List<User> findUsersByIds(List<String> ids) {
        if (ids.stream().anyMatch(id -> id == null || id.isBlank())) {
            throw new BadRequestException("The list of ids must not have null or blank elements");
        }

        return userRepository.findAllById(ids);
    }

    @Transactional
    public User insert(User user) {
        if(user.getId() != null) {
            throw new BadRequestException("When creating a user, the id must be null");
        }
        return userRepository.save(user);
    }

    //ToDo: Implementar o InsertAll

    @Transactional
    public void delete(String id) {
        findById(id);
        userRepository.deleteById(id);
    }

    @Transactional
    public User update(User user) {
        User newUser = findById(user.getId());
        updateData(newUser, user);
        return userRepository.save(newUser);
    }

    private void updateData(User newUser, User user) {
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
    }
}
