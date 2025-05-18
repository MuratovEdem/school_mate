package codereview.school_mate.exception;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
@Hidden
public class ExceptionController {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handleIllegalArgumentException(NotFoundException e) {
        log.error(e.getMessage(), e);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(IncorrectUsernameException.class)
    public ResponseEntity<?> handleIncorrectUsernameException(IncorrectUsernameException e) {
        log.error(e.getMessage(), e);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(JwtTokenException.class)
    public ResponseEntity<?> handleJwtTokenException(JwtTokenException e) {
        log.error(e.getMessage(), e);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
    }
}
