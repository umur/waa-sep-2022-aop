package edu.miu.aspect.exception;

public class AopIsAwesomeHeaderException extends RuntimeException {
    public AopIsAwesomeHeaderException() {
    }

    public AopIsAwesomeHeaderException(String message) {
        super(message);
    }

    public AopIsAwesomeHeaderException(String message, Throwable cause) {
        super(message, cause);
    }
}
