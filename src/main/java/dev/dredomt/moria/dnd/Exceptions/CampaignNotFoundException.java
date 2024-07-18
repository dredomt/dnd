package dev.dredomt.moria.dnd.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CampaignNotFoundException extends RuntimeException {

    public CampaignNotFoundException() {
        super("Campaign Not Found");
    }
}
