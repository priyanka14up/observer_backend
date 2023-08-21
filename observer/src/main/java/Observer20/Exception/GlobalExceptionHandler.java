package Observer20.Exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import Observer20.Response.ApiResponse;




@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException ex)
	{
		String message=ex.getMessage();
		ApiResponse apiResponse=new ApiResponse (message,false);
		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);
		
		}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public  ResponseEntity<Map<String,String>> handelMethodArgsNotValidException(MethodArgumentNotValidException ex)
	{
		
		Map<String,String> resp=new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error)-> {
			String fieldName= ((FieldError) error).getField();
		String message=error.getDefaultMessage();
		resp.put(fieldName, message);
		});
		return new ResponseEntity<Map<String,String>>(resp,HttpStatus.BAD_REQUEST);
		
	}
	
	  @ExceptionHandler(org.springframework.dao.InvalidDataAccessApiUsageException.class) 
	  public ResponseEntity<ApiResponse>InvalidDataAccessApiUsageExceptionHandler(org.springframework.dao.InvalidDataAccessApiUsageException ex) 
	  { 
		  String message=ex.getLocalizedMessage();
	  ApiResponse apiResponse=new ApiResponse (message,false); return new
	  ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);
	  
	  }
	 
	  @ExceptionHandler(org.springframework.dao.DataIntegrityViolationException.class) 
	  public ResponseEntity<ApiResponse> DataIntegrityViolationExceptionHandler(org.springframework.dao.DataIntegrityViolationException ex) 
	  { 
		  String message=ex.getLocalizedMessage();
	  ApiResponse apiResponse=new ApiResponse (message,false); return new
	  ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);
	  
	  }
	  
	  @ExceptionHandler(ApiException.class)
		public ResponseEntity<ApiResponse> handelApiException(ApiException ex)
		{
			String message=ex.getMessage();
			ApiResponse apiResponse=new ApiResponse (message,false);
			return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.BAD_REQUEST);
			
			}
	  
	 

}

