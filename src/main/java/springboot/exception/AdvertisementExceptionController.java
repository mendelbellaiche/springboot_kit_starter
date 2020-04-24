package springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class AdvertisementExceptionController {

    @ExceptionHandler(value = AdvertisementNotFoundException.class)
    public ResponseEntity<Object> exception(AdvertisementNotFoundException exception) {
        return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
    }

}
