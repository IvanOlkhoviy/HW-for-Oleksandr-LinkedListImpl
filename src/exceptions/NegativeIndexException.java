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
        super("You try to put negative index, your index = " + num);
        num = this.entrNumber;
    }
}
