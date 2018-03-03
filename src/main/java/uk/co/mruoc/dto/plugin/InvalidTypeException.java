package uk.co.mruoc.dto.plugin;

public class InvalidTypeException extends RuntimeException {

    public InvalidTypeException(String message, Throwable cause) {
        super(message, cause);
    }

}
