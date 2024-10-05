package infra.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SugestionNotFoundException extends RuntimeException {
    public SugestionNotFoundException(Long id){
        super("Suggestion with id: " +id +"  not found");
    }
}
