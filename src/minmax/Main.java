package minmax;
import controller.Board;
import config.*;
import controller.Coin;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello Minimax");
        Board board = new Board(Config.SIZE_X, Config.SIZE_Y);
        board.PrintBoard();

        board.InsertCoin(Color.RED, 0, 0);
        board.InsertCoin(Color.RED, 4, 0);
        board.InsertCoin(Color.YELLOW, 9, 0);
        board.InsertCoin(Color.YELLOW, 1, 0);

        board.PrintBoard();


        board.InsertCoin(Color.RED, 0, 0);
        board.InsertCoin(Color.YELLOW, 4, 2);
        board.PrintBoard();

        Coin field;
        field = board.GetField(0,0);
        System.out.println("Field: [" + field.getPosition().x + ", " +  field.getPosition().y + "]-" + field.getColor());

        field = board.GetField(1,0);
        System.out.println("Field: [" + field.getPosition().x + ", " +  field.getPosition().y + "]-" + field.getColor());

        field = board.GetField(4,2);
        System.out.println("Field: [" + field.getPosition().x + ", " +  field.getPosition().y + "]-" + field.getColor());

        field = board.GetField(9,0);
        if (field == null){
            System.out.println("Null");
        }


    }
}
