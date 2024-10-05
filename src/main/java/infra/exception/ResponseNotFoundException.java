package infra.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResponseNotFoundException extends RuntimeException {
    public ResponseNotFoundException(Long id){
        super("Response with id: " +id +"  not found");
    }
}
