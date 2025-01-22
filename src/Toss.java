public enum Toss {
    HEADS, TAILS;

    public static Toss inputToss(String input) {
        switch (input.toUpperCase()){
            case "H":
            case "HEADS":
                return HEADS;
            case "T":
            case "TAILS":
                return TAILS;
            default:
                throw new IllegalArgumentException("Invalid input. Must be 'H' for Heads or 'T' for Tails.");
        }
    }
}


//    public Toss inputToss(String input) {
//        return switch (input.toUpperCase()) {
//            case "H", "HEADS" -> HEADS;
//            case "T", "TAILS" -> TAILS;
//            default -> throw new IllegalArgumentException("Invalid input. Must be 'H' for Heads or 'T' for Tails.");
//        };
//    }
