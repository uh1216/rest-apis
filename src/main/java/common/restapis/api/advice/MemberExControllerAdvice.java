package common.restapis.api.advice;

import common.restapis.api.messages.ErrorMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice //에러를 적용할 컨트롤러를 지정할 수 있다. (RestController, Controller 따로 가능)
public class MemberExControllerAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler // 적용할 에러를 지정할 수 있다. (빈 값이면 아래 함수 매개변수의 에러가 지정된다)
    public ErrorMessage inputErrorHandler(Exception e) {
        log.info("error={}", e.getMessage());
        return new ErrorMessage(HttpStatus.BAD_REQUEST, e.getMessage());
    }
}
