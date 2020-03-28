package minmax;
import controller.Board;
import config.*;
import controller.Evaluator;
import controller.Field;
import controller.SearchLogic;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello Minimax");
        Board board = new Board(Config.SIZE_X, Config.SIZE_Y);

        board.InsertField(Color.YELLOW, 1);
        board.InsertField(Color.YELLOW, 1);
        board.InsertField(Color.YELLOW, 1);

        board.InsertField(Color.RED, 3);
        board.InsertField(Color.RED, 3);
        board.InsertField(Color.YELLOW, 3);
        board.InsertField(Color.YELLOW, 3);
        board.InsertField(Color.YELLOW, 3);

        board.InsertField(Color.RED, 4);
        board.InsertField(Color.RED, 4);
        board.InsertField(Color.RED, 4);
        board.InsertField(Color.YELLOW, 4);

        board.InsertField(Color.YELLOW, 5);

        board.InsertField(Color.RED, 6);
        board.InsertField(Color.YELLOW, 6);




        board.PrintBoard();

//        board.GetField(6,2);
//
        Evaluator evaluator = new Evaluator(board.board);
        evaluator.GetMaxScoreField(Color.RED);
//
//
//        System.out.println("Overall Field Score: " + evaluator.GetFieldScore(5,5, Color.RED));
//

//        SearchLogic searchLogic = new SearchLogic();

//        searchLogic.PrintTree(searchLogic.root);

//        searchLogic.BuildTree(searchLogic.x, board, Config.DEPTH);

//        searchLogic.PrintTree(searchLogic.x);



    }
}
