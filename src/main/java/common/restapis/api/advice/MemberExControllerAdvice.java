package common.restapis.api.advice;

import common.restapis.api.messages.ErrorMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice //에러를 적용할 컨트롤러를 지정할 수 있다.
public class MemberExControllerAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler
    public ErrorMessage inputErrorHandler(Exception e) {
        log.info("error={}", e.getMessage());
        return new ErrorMessage(HttpStatus.BAD_REQUEST, e.getMessage());
    }
}
