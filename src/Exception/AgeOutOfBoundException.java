package Exception;

public class AgeOutOfBoundException extends RuntimeException {
    public AgeOutOfBoundException(String message) {
        super(message);
    }

    public AgeOutOfBoundException() {
    }
}
