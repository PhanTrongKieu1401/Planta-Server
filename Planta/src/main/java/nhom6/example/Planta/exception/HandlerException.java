package nhom6.example.Planta.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import nhom6.example.Planta.payload.ApiResponse;


@ControllerAdvice
public class HandlerException {
	
	@ExceptionHandler(value = Exception.class)
    public ResponseEntity<ApiResponse<?>> handlingException(Exception exception) {
        ApiResponse<?> apiResponse = new ApiResponse<>();
        apiResponse.setSuccess(false);
        apiResponse.setCode(500);
        apiResponse.setMessage("Chưa được phân loại tồn tại");
        return ResponseEntity.internalServerError().body(apiResponse);
    }
    
    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<ApiResponse<?>> handlingAppException(RuntimeException exception) {
    	ApiResponse<?> apiResponse = new ApiResponse<>();
        apiResponse.setSuccess(false);
        apiResponse.setCode(404);
        apiResponse.setMessage(exception.getMessage());
        return ResponseEntity.badRequest().body(apiResponse);
    }

}
