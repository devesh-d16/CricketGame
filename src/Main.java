import controller.GameController;
import service.GameService;
import ui.UI;
import utils.GameUtils;

public class Main {
    public static void main(String[] args){
        UI ui = new UI();
        GameUtils utils = new GameUtils();
        GameService gameService = new GameService(ui, utils);
        GameController gameController = new GameController(ui, gameService);
        gameController.startGame();
    }
}