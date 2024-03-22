package br.unitins.topicos2.autopecas.validation;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;

public class ValidationExceptionMapper implements ExceptionMapper<ValidationException> {

    @Override
    public Response toResponse(ValidationException exception) {
        ValidationError validationError = new ValidationError("400", "Erro de Validação");
        validationError.addFieldError(exception.getFieldName(), exception.getMessage());

        return Response.status(Response.Status.BAD_REQUEST).entity(validationError).build();
    }

}
