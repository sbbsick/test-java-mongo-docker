package io.testemongo.testespringmongodb.dto;

import io.testemongo.testespringmongodb.domain.User;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class AuthorDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;

    public AuthorDTO(){};

    public AuthorDTO(User user){
        this.id = user.getId();
        this.name = user.getName();
    }
}
