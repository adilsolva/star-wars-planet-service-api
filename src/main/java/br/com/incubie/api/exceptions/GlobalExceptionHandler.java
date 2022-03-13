package br.com.incubie.api.exceptions;

import io.undertow.util.BadRequestException;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = BadRequestException.class)
	public ResponseEntity<Object> handleBadRequest(BadRequestException ex) {
		var error = ErrorResponse.builder()
				.status(HttpStatus.BAD_REQUEST.value())
				.message(ex.getMessage())
				.error(null)
				.build();

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}

	@ExceptionHandler(value = NotFoundException.class)
	public ResponseEntity<Object> handleNotFound(Exception ex) {
		var error = ErrorResponse.builder()
				.status(HttpStatus.NOT_FOUND.value())
				.message(ex.getMessage())
				.error(null)
				.build();

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	@ExceptionHandler(value = NoSuchElementException.class)
	public ResponseEntity<Object> handleNoSuchElement(Exception ex) {
		
		return handleNotFound(ex);
	}

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<Object> handleException(Exception ex) {
		var error = ErrorResponse.builder()
				.status(HttpStatus.INTERNAL_SERVER_ERROR.value())
				.error("Internal Server Error")
				.message(ex.getMessage())
				.build();
		ex.printStackTrace();
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
	}

	@Data
	@Builder
	static class ErrorResponse {

		private Integer status;
		private String error;
		private String message;
	}
}