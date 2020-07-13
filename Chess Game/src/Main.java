import Interfaces.UI;

public class Main {

    public static void main(String[] args) {
        UI ui = new UI();
        System.out.println("Welcome to Paul's Chess Game(still in work)");
        UI.getBoard().printBoard();
        System.out.println("White player starts!");
        while(1 == 1)
        {
            UI.readMove();
        }
    }
}