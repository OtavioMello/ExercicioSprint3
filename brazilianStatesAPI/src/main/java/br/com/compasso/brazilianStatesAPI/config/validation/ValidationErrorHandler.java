package br.com.compasso.brazilianStatesAPI.config.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

//Error message validation Class
@RestControllerAdvice
public class ValidationErrorHandler {

    @Autowired
    private MessageSource messageSource;

    //Bad request status validation method
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ArgumentNotValidDTO> handlerBadRequest(MethodArgumentNotValidException methodArgumentNotValidException){

        List<ArgumentNotValidDTO> errorsDTO = new ArrayList<>();

        List<FieldError> fieldErrors = methodArgumentNotValidException.getBindingResult().getFieldErrors();

       fieldErrors.stream().forEach(error ->{
           String messageError = messageSource.getMessage(error, LocaleContextHolder.getLocale());
           ArgumentNotValidDTO argumentNotValidDTO = new ArgumentNotValidDTO(error.getField(), messageError);
           errorsDTO.add(argumentNotValidDTO);
       });

       return errorsDTO;

    }

    //Bad request status validation method
    // Não sei se esse é o método correto de validar esse erro, porém, consegui fazer com que aquele
    // json bugado pare de aparecer com essa exception. Mas, gostaria de saber mais sobre esses tratamento
    // de exceptions do HTTP, dei uma pesquisada e não consegui encontrar muita coisa, teria algum material
    // para indicar???
    @ResponseStatus(code = HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public void handlerNotAllowed(HttpRequestMethodNotSupportedException httpRequestMethodNotSupportedException){

    }

}
