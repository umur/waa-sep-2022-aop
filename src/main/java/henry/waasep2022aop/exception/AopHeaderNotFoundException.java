package henry.waasep2022aop.exception;

public class AopHeaderNotFoundException extends RuntimeException {
    public AopHeaderNotFoundException() {
    }

    public AopHeaderNotFoundException(String msg) {
        super(msg);
    }

    public AopHeaderNotFoundException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

    public AopHeaderNotFoundException(Throwable throwable) {
        super(throwable);
    }
}
