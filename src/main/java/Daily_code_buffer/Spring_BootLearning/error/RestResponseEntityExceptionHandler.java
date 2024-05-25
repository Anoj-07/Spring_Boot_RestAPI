package Daily_code_buffer.Spring_BootLearning.error;

import Daily_code_buffer.Spring_BootLearning.entity.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/*handle all exception and send all respond back
* Rest Response Entity Exception Handler*/

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    /*WebRequest is inbuilt interface
    * adding DepartmentNotFoundException java class as parameter*/

    @ExceptionHandler(DepartmentNotFoundException.class)

    /*Wrap with ResponseEntity to ErrorMessage to make wrapper class*/

    public ResponseEntity <ErrorMessage> departmentNotFoundException(DepartmentNotFoundException exception, WebRequest request){
        ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(message);
    }

}
