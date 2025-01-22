import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Scanner sc = new Scanner(System.in);
        UI ui = new UI();

        Game game = new Game();
        game.run(sc, ui);
    }
}