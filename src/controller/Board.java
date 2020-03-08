package controller;
import config.Color;
public class Board {

    private int size_x, size_y;
    public Field board[][];

    public Board(int size_x, int size_y){
        this.size_x = size_x;
        this.size_y = size_y;
        board = new Field[size_x][size_y];
        InitBoard();
    }

    public void InitBoard(){
//        Fill board with blank spaces
        for(int i=0; i<this.size_x; i++){
            for(int j=0; j<this.size_y; j++){
                board[i][j] = new Field(Color.BLANK, i, j);
            }
        }
//        Sense surrounding for every field
        for(int i=0; i<this.size_x; i++){
            for(int j=0; j<this.size_y; j++){
                board[i][j].SenseSurroundings(board);
            }
        }
    }

    public void PrintBoard(){
        System.out.println("========================================");
        for(int i=this.size_y - 1; i>=0; i--){
            for(int j=0; j<this.size_x; j++){
                switch(board[j][i].color) {
                    case RED:
                        System.out.print(2 + " ");
                        break;
                    case YELLOW:
                        System.out.print(1 + " ");
                        break;
                    case BLANK:
                        System.out.print(0 + " ");
                        break;
                    default:
                        System.out.print(-1 + " ");
                }
            }
            System.out.println();
        }
        System.out.println("=========================================");
    }

    public void InsertField(Color color, int x, int y){
        if ((x >= 0 && x < size_x) && (y >= 0 && y<size_y)){
            if (board[x][y].color == Color.BLANK)
            {
                board[x][y].position.x = x;
                board[x][y].position.y = y;
                board[x][y].color = color;

                board[x][y].SenseSurroundings(board);
            } else {
                System.out.println("[" + x + ", " + y + "] already taken [" + board[x][y].color + "]");
            }
        } else {
            System.out.println("Error inserting " + x + ", " + y);
        }
    }

    public Field GetField(int x, int y){
        if ((x >= 0 && x < size_x) && (y >= 0 && y<size_y)){
            board[x][y].printSurroundings();
            return board[x][y];
        }
        return null;
    }
}
