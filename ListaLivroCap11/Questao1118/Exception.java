class ExceptionA2 extends Exception {
    public ExceptionA2(String message) {
        super(message);
    }
}

class ExceptionB2 extends ExceptionA2 {
    public ExceptionB2(String message) {
        super(message);
    }
}