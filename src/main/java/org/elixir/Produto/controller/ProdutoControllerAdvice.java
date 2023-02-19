package org.elixir.Produto.controller;

import org.elixir.Produto.exception.ProductNullException;
import org.elixir.Produto.exception.ProductPriceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

/*
Sera um controller de erros, esta classe tera metodos que tratará os erros
*/
@ControllerAdvice
public class ProdutoControllerAdvice extends ResponseEntityExceptionHandler {

    /*
    capituraErroNull -  sera um metodo que receberá o productNullException e retorná um tratamento para tal erro
    */
    @ExceptionHandler(ProductNullException.class)
    public ResponseEntity<Object> capturarErroNull() {
        Map<String, Object> body = new HashMap<>();
        body.put("message", "Consulte os campos do produto");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }
    /*
       capituraErroPrice -  sera um metodo que receberá o productNullException e retorná um tratamento para tal erro
       */
    @ExceptionHandler(ProductPriceException.class)
    public ResponseEntity<Object> capturarErroPrice() {
        Map<String, Object> body = new HashMap<>();
        body.put("message", "Consulte os valor do produto");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }
}

