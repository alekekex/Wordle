public class Letter {
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String GRAY = "\u001B[38;5;244m";
    private static final String RESET = "\u001B[0m";
    private String letter;
    private String color;

    public Letter(String letter) {
        this.letter = letter;
        this.color = null;
    }

    public String getLetter() {
        return this.letter;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColoredLetter() {
        String coloredLetter = this.letter;

        if(this.color != null) {
            if(this.color.equals("GREEN"))
                coloredLetter = GREEN + this.letter + RESET;
            else if(this.color.equals("YELLOW"))
                coloredLetter = YELLOW + this.letter + RESET;
            else if(this.color.equals("GRAY"))
                coloredLetter = GRAY + this.letter + RESET;
        }

        return coloredLetter;
    }
}
