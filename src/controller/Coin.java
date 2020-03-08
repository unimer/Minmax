package controller;
import config.Color;
import config.Config;
import model.Position;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class Coin {

    public Color color;
    public Position position;
    public HashMap<String, ArrayList> surroundings;

    public Coin(Color color, int x, int y){
        this.color = color;
        this.position = new Position();
        this.position.x = x;
        this.position.y = y;
        surroundings = new HashMap<String, ArrayList>();
    }

    public Position getPosition() {
        return position;
    }

    public Color getColor() {
        return color;
    }

    private ArrayList<Coin> UpInform(Coin[][] board){
        ArrayList<Coin> list = new ArrayList<Coin>();
        for (int i=position.y + 1; i<Config.SIZE_Y; i++){
            list.add(board[position.x][i]);
        }
        return list;
    }

    private ArrayList<Coin> DownInform(Coin[][] board){
        ArrayList<Coin> list = new ArrayList<Coin>();
        for (int i=position.y - 1; i>=0; i--){
            list.add(board[position.x][i]);
        }
        return list;
    }

    private ArrayList<Coin> LeftInform(Coin[][] board){
        ArrayList<Coin> list = new ArrayList<Coin>();
        for (int i=position.x -1; i>=0; i--){
            list.add(board[i][position.y]);
        }
        return list;
    }

    private ArrayList<Coin> RightInform(Coin[][] board){
        ArrayList<Coin> list = new ArrayList<Coin>();
        for (int i=position.x + 1; i<Config.SIZE_X; i++){
            list.add(board[i][position.y]);
        }
        return list;
    }

    private ArrayList<Coin> UpRightInform(Coin[][] board){
        ArrayList<Coin> list = new ArrayList<Coin>();
        int y = position.y;
        for (int i=position.x + 1; i<Config.SIZE_X; i++){
            y++;
            if (y >= Config.SIZE_Y) break;
            list.add(board[i][y]);
        }
        return list;
    }

    private ArrayList<Coin> DownRightInform(Coin[][] board){
        ArrayList<Coin> list = new ArrayList<Coin>();
        int y = position.y;
        for (int i=position.x + 1; i<Config.SIZE_X; i++){
            y--;
            if (y < 0) break;
            list.add(board[i][y]);
        }
        return list;

    }

    private ArrayList<Coin> UpLeftInform(Coin[][] board){
        ArrayList<Coin> list = new ArrayList<Coin>();
        int y = position.y;
        for (int i=position.x - 1; i>=0; i--){
            y++;
            if (y >= Config.SIZE_Y) break;
            list.add(board[i][y]);
        }
        return list;
    }

    private ArrayList<Coin> DownLeftInform(Coin[][] board){
        ArrayList<Coin> list = new ArrayList<Coin>();
        int y = position.y;
        for (int i=position.x - 1; i>=0; i--){
            y--;
            if (y < 0) break;
            list.add(board[i][y]);
        }
        return list;
    }


    public HashMap<String, ArrayList> SenseSurroundings(Coin[][] board){
        surroundings.put("Up", UpInform(board));
        surroundings.put("Down", DownInform(board));
        surroundings.put("Left", LeftInform(board));
        surroundings.put("Right", RightInform(board));
        surroundings.put("UpRight", UpRightInform(board));
        surroundings.put("DownRight", DownRightInform(board));
        surroundings.put("UpLeft", UpLeftInform(board));
        surroundings.put("DownLeft", DownLeftInform(board));
        return surroundings;
    }

    public void printSurroundings(){
        for (String name: surroundings.keySet()){
            String key = name.toString();
            System.out.print(key +  ":: ");
            for(int i=0; i<surroundings.get(name).size(); i++){
                ArrayList<Coin> list = surroundings.get(name);
                System.out.print("[" + list.get(i).position.x + "," + list.get(i).position.y + "|" + list.get(i).color + "]," );
            }
            System.out.println();

        }
    }
}
