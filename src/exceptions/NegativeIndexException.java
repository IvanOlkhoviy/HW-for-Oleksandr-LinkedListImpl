package exceptions;


public class NegativeIndexException extends RuntimeException {

    private int entrNumber;

    public int getEntrNumber() {
        return entrNumber;
    }

    public NegativeIndexException(String message) {
        super(message);
    }

    public NegativeIndexException(String message, Number num) {
        super(message);
        num = this.entrNumber;
    }
}
