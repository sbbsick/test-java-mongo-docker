package io.testemongo.testespringmongodb.exception.badrequest;

import io.testemongo.testespringmongodb.exception.ExceptionDetails;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class BadRequestExceptionDetails extends ExceptionDetails {
}
