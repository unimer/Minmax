package controller;
import config.Color;
public class Board {

    private int size_x, size_y;
    public Coin board[][];

    public Board(int size_x, int size_y){
        this.size_x = size_x;
        this.size_y = size_y;
        board = new Coin[size_x][size_y];
        InitBoard();
    }

    public void InitBoard(){
        for(int i=0; i<this.size_x; i++){
            for(int j=0; j<this.size_y; j++){
                board[i][j] = new Coin(Color.BLANK, i, j);
            }
        }
    }

    public void PrintBoard(){
        System.out.println("========================================");
        for(int i=0; i<this.size_x; i++){
            for(int j=0; j<this.size_y; j++){
                switch(board[i][j].color) {
                    case RED:
                        System.out.print(1 + " ");
                        break;
                    case YELLOW:
                        System.out.print(2 + " ");
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

    public void InsertCoin(Color color, int x, int y){
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

    public Coin GetField(int x, int y){
        if ((x >= 0 && x < size_x) && (y >= 0 && y<size_y)){
            System.out.println(board[x][y].surroundings.get("Up"));
            System.out.println(board[x][y].surroundings.get("Down"));
            System.out.println(board[x][y].surroundings.get("Left"));
            System.out.println(board[x][y].surroundings.get("Right"));
            System.out.println(board[x][y].surroundings.get("UpRight"));
            return board[x][y];
        }
        return null;
    }
}
