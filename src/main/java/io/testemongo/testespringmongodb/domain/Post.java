package io.testemongo.testespringmongodb.domain;

import com.mongodb.lang.NonNull;
import io.testemongo.testespringmongodb.dto.AuthorDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@Document(collection = "posts")
public class Post implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @NonNull
    private String title;

    @NonNull
    private String body;

    @NonNull
    private Date date;

    @NonNull
    private AuthorDTO author;
}
