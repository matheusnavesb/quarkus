package br.unitins.topicos2.autopecas.validation;

public class ValidationException extends RuntimeException {
    
    private String fieldName;

    public ValidationException(String fieldName, String message) {
        super(message);
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }
}
