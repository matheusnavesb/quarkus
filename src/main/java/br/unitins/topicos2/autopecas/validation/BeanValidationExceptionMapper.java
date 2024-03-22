package br.unitins.topicos2.autopecas.validation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;

public class BeanValidationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(ConstraintViolationException exception) {
        
        ValidationError validationError = new ValidationError("400", "Erro de Validação");

        for (ConstraintViolation<?> violation : exception.getConstraintViolations()) {
            String fullFieldName = violation.getPropertyPath().toString();
            String parts[] = fullFieldName.split("\\.");
            String fieldName = parts[parts.length -1];
            String message = violation.getMessage();
            validationError.addFieldError(fieldName, message);
        }

        return Response.status(Response.Status.BAD_REQUEST).entity(validationError).build();

    
    }
    
}
