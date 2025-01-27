package model;

public enum Designation {
    BATTER,
    BOWLER;

    public static Designation inputDesignation(String input) {
        return switch (input.toUpperCase()) {
            case "BAT", "BATSMAN", "BATTER" -> BATTER;
            case "BOWL", "BOWLER" -> BOWLER;
            default -> throw new IllegalArgumentException("Invalid input. Must be 'BATTER/BATSMAN/BAT' for Batter or 'BOWL/BOWLER' for Bowler.");
        };
    }
}
