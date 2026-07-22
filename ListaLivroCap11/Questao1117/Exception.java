import java.io.IOException;

class ExceptionA1 extends Exception {
    public ExceptionA1(String message) {
        super(message);
    }
}

class ExceptionB1 extends ExceptionA1 {
    public ExceptionB1(String message) {
        super(message);
    }
}