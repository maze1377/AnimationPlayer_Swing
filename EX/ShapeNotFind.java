package EX;

public class ShapeNotFind extends RuntimeException {
    public ShapeNotFind() {
        super("ShapeNotFind..");
    }

    public ShapeNotFind(String message) {
        super(message);
    }
}
