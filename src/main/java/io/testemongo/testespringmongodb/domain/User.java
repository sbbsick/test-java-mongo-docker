package io.testemongo.testespringmongodb.domain;

import com.mongodb.lang.NonNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "user")
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @NonNull
    private String name;

    @NonNull
    private String email;

    @DBRef(lazy = true) // Serve para referenciar os posts do usuário e o lazy serve para não carregar os posts automaticamente
    private List<Post> posts = new ArrayList<>();
    public User () { }

    public User (String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
