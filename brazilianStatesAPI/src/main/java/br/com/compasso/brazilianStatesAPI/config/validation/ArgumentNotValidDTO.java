package br.com.compasso.brazilianStatesAPI.config.validation;

public class ArgumentNotValidDTO {

    private String errorField;
    private String errorDescription;

    public ArgumentNotValidDTO(String errorField, String errorDescription){

        this.errorField = errorField;
        this.errorDescription = errorDescription;
    }

    public String getErrorField() {
        return errorField;
    }

    public String getErrorDescription() {
        return errorDescription;
    }
}
