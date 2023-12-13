package br.com.gestor.controller.exception;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class ProjetoException{
	
    @ExceptionHandler(BindException.class)
    public void handleBindException(BindException ex,
    								RedirectAttributes redirectAttributes) {
    	List<String> errors = new ArrayList<>();
    	errors = ex.getFieldErrors().stream().map(erros -> erros.getDefaultMessage()).collect(Collectors.toList());
    	redirectAttributes.addFlashAttribute("erros", errors);
    }
}
