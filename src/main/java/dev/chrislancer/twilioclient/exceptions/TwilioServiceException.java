package dev.chrislancer.twilioclient.exceptions;

import dev.chrislancer.twilioclient.dto.responses.ErrorResponse;
import lombok.Getter;

@Getter
public class TwilioServiceException extends Exception {

    private final ErrorResponse error;

    public TwilioServiceException(String message, ErrorResponse error) {
        super(message);
        this.error = error;
    }

}
