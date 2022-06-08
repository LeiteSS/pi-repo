package br.edu.fateczl.radar.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends Exception {

    public NotFoundException(String nomeDesaparecido) {
        super(String.format("O Desaparecido %s não foi encontrado.", nomeDesaparecido));
    }

    public NotFoundException(Long id) {
        super(String.format("O Desaparecido nº %s não foi encontrado.", id));
    }

}
