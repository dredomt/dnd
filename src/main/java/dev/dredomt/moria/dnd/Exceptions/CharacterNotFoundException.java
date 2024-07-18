package dev.dredomt.moria.dnd.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CharacterNotFoundException extends RuntimeException {

    public CharacterNotFoundException() {
        super("Character Not Found");
    }
}
