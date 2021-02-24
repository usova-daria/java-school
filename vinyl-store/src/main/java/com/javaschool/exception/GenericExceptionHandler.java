package com.javaschool.exception;

import com.javaschool.domainlogic.user.profile.exception.UserNotFoundException;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

@Log4j
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GenericExceptionHandler {

    private static final String ERROR_PAGE = "exception/error";

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @ExceptionHandler(value = MultipartException.class)
    public ModelAndView handleFileUploadException(MultipartException mpex, HttpServletRequest request) {
        ModelAndView modelAndVew = new ModelAndView(ERROR_PAGE);
        modelAndVew.addObject("errorMessage", mpex.getMessage());
        return modelAndVew;
    }

    @ExceptionHandler(value = NoHandlerFoundException.class)
    public String handleNoHandlerFoundException(Exception e) {
        return "exception/404";
    }

    @ExceptionHandler(value = UserNotFoundException.class)
    public String handleUserNotFoundException() {
        return ERROR_PAGE;
    }

    @ExceptionHandler(value = Exception.class)
    public String handleException(Exception e, HttpServletRequest request) throws Exception {
        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null) {
            throw e;
        }

        log.error(e.getMessage(), e);
        return ERROR_PAGE;
    }

}
