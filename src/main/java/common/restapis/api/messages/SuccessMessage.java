package common.restapis.api.messages;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class SuccessMessage {

    private HttpStatus httpStatus;
    private String message;
    private Object object;

    public SuccessMessage(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public SuccessMessage(HttpStatus httpStatus, String message, Object object) {
        this.httpStatus = httpStatus;
        this.message = message;
        this.object = object;
    }
}
