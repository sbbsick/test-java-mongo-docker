package io.testemongo.testespringmongodb.dto;

import io.testemongo.testespringmongodb.domain.User;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class UserDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String email;

    public UserDTO(){};

    public UserDTO(User user){
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
    }

    public static UserDTO convertUserToUserDto(User user){
        return new UserDTO(user);
    }

    public static List<UserDTO> convertAllUsersToUserDto(List<User> users){
        // Transforma a lista de User em uma lista de UserDTO
        return users.stream().map(UserDTO::new).toList();
    }

    public static User convertUserDtoToUser(UserDTO userDto){
        return new User(userDto.getId(), userDto.getName(), userDto.getEmail());
    }

    public static List<User> convertAllUserDtoToUsers(List<UserDTO> userDtos){
        // Transforma a lista de UserDTO em uma lista de User
        return userDtos.stream().map(UserDTO::convertUserDtoToUser).toList();
    }

}
