package com.ericsontrenergia.ericsontrenergia.exceptions;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class GlobalException {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardErro> objectNotFoundException(ObjectNotFoundException ex,
			HttpServletRequest request) {

		StandardErro se = new StandardErro(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), ex.getMessage(),
				request.getRequestURI());

		return ResponseEntity.ok().body(se);

	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardErro> handleValidationExceptions(MethodArgumentNotValidException ex,
			HttpServletRequest request) {

		String message = ex.getBindingResult().getAllErrors().get(0).getDefaultMessage();
		StandardErro se = new StandardErro(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), message,
				request.getRequestURI());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(se);
	}

	// Exceção criada, para o campo idade, vazio estava dando erro que n era tratado
	// no (MethodArgumentNotValidException)
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<StandardErro> httpMessageNotReadableException(HttpMessageNotReadableException ex,
			HttpServletRequest request) {

		StandardErro se = new StandardErro(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), "Erro no campo idade",
				request.getRequestURI());

		return ResponseEntity.ok().body(se);
	}

	// Exceção criada para tratar o CPF inválido
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<StandardErro> constraintViolationException(ConstraintViolationException ex,
			HttpServletRequest request) {

		StandardErro se = new StandardErro(LocalDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR.value(),
				"CPF Inválido", request.getRequestURI());

		return ResponseEntity.ok().body(se);

	}

	// Exceção caso usuário pesquisar por CPF sem informar o CPF
	@ExceptionHandler(NoResourceFoundException.class)
	public ResponseEntity<StandardErro> noResourceFoundException(NoResourceFoundException ex,
			HttpServletRequest request) {

		StandardErro se = new StandardErro(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), "Informe o campo do CPF",
				request.getRequestURI());

		return ResponseEntity.ok().body(se);

	}
	
	//Exceção caso o CPF informado já esteja cadastrado no BD
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<StandardErro> illegalArgumentException(IllegalArgumentException ex,
			HttpServletRequest request) {

		StandardErro se = new StandardErro(LocalDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR.value(),
				ex.getMessage(), request.getRequestURI());

		return ResponseEntity.ok().body(se);
	}

}