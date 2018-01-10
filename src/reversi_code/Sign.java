package reversi_code;

public enum Sign {
    BLACK('X'), WHITE('O'), EMPTY(' ');

    private final char signAsChar;

    private Sign(char signAsChar) {
        this.signAsChar = signAsChar;
    }
    public char asChar() {
        return signAsChar;
    }
}