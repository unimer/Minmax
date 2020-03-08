package minmax;
import controller.Board;
import config.*;
import controller.Coin;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello Minimax");
        Board board = new Board(Config.SIZE_X, Config.SIZE_Y);

        board.InsertCoin(Color.RED, 2,0);
        board.InsertCoin(Color.YELLOW, 3,0);
        board.InsertCoin(Color.YELLOW, 4,0);

        board.InsertCoin(Color.RED, 1,1);
        board.InsertCoin(Color.RED, 2,1);
        board.InsertCoin(Color.RED, 3,1);
        board.InsertCoin(Color.RED, 4,1);

        board.InsertCoin(Color.YELLOW, 2,2);
        board.InsertCoin(Color.YELLOW, 3,2);
        board.InsertCoin(Color.YELLOW, 4,2);

        board.InsertCoin(Color.RED, 1,3);
        board.InsertCoin(Color.RED, 3,3);
        board.InsertCoin(Color.YELLOW, 4,3);
        board.InsertCoin(Color.RED, 5,3);

        board.InsertCoin(Color.RED, 4,4);
        board.InsertCoin(Color.RED, 5,4);
        board.InsertCoin(Color.YELLOW, 6,4);

        board.PrintBoard();

        board.GetField(6,2);
    }
}
