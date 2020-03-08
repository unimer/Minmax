package minmax;
import controller.Board;
import config.*;
import controller.Evaluator;
import controller.Field;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello Minimax");
        Board board = new Board(Config.SIZE_X, Config.SIZE_Y);

        board.InsertField(Color.RED, 2,0);
        board.InsertField(Color.YELLOW, 3,0);
        board.InsertField(Color.RED, 4,0);

        board.InsertField(Color.RED, 1,1);
        board.InsertField(Color.RED, 2,1);
        board.InsertField(Color.RED, 3,1);
        board.InsertField(Color.RED, 4,1);

        board.InsertField(Color.YELLOW, 2,2);
        board.InsertField(Color.YELLOW, 3,2);
        board.InsertField(Color.YELLOW, 4,2);

        board.InsertField(Color.RED, 1,3);
        board.InsertField(Color.RED, 3,3);
        board.InsertField(Color.YELLOW, 4,3);
        board.InsertField(Color.RED, 5,3);

        board.InsertField(Color.RED, 4,4);
        board.InsertField(Color.RED, 5,4);
        board.InsertField(Color.YELLOW, 6,4);

        board.InsertField(Color.RED, 6,0);
        board.InsertField(Color.RED, 6,1);
        board.InsertField(Color.RED, 6,2);


        board.PrintBoard();

        board.GetField(6,2);

        Evaluator evaluator = new Evaluator(board.board);

        evaluator.GetHorizontalScore(board.board[6][3], Color.RED);
        evaluator.GetVerticalScore(board.board[6][3], Color.RED);
        evaluator.GetDiagonalUpScore(board.board[2][2], Color.RED);
        evaluator.GetDiagonalDownScore(board.board[2][2], Color.RED);


    }
}
