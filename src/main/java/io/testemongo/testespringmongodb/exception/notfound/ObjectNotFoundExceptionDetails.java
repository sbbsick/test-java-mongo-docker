package io.testemongo.testespringmongodb.exception.notfound;

import io.testemongo.testespringmongodb.exception.ExceptionDetails;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class ObjectNotFoundExceptionDetails extends ExceptionDetails {

}
