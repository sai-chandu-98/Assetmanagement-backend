package com.assetmanagement.excpection;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class AMSExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ EmployeeNotFoundException.class })
	public ResponseEntity<Object> handleEmpolyeNotFoundExpection(EmployeeNotFoundException ex, WebRequest request) {
		return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR,
				request);
	}
	
	@ExceptionHandler({ AssetNotFoundException.class })
	public ResponseEntity<Object> handleAssetNotFoundException(AssetNotFoundException ex, WebRequest request) {
		return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR,
				request);
	}


	@ExceptionHandler({ RequestAssetsNotFoundException.class })
	public ResponseEntity<Object> handleRequestAssetsNotFoundExpection(RequestAssetsNotFoundException ex, WebRequest request) {
		return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR,
				request);
	}
	
	@ExceptionHandler({ EmployeAlreadyExistedException.class })
	public ResponseEntity<Object> handleEmployeAlreadyExistedExpection(EmployeAlreadyExistedException ex, WebRequest request) {
		return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST,
				request);
	}
	
	@ExceptionHandler({ ValidationExpection.class })
	public ResponseEntity<Object> handleValidationExpection(ValidationExpection ex, WebRequest request) {
		return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}
}
