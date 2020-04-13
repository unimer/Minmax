package controller;

import config.Color;
import config.Config;
import javafx.geometry.Side;
import model.Position;

import java.util.ArrayList;
import java.util.HashMap;

class SideResult{
    public int consecutive;
    public int siblings;
    public int spaceToGrow;

    public SideResult(int consecutive, int siblings, int spaceToGrow){
        this.consecutive = consecutive;
        this.siblings = siblings;
        this.spaceToGrow = spaceToGrow;
    }
}

public class Evaluator {

    private Field[][] board;

    public Evaluator(Field[][] board){
        //cloning needed probably
        this.board = board;
    }

    public Evaluator(){

    }

    public double CalculateScore(SideResult left, SideResult right){
        int consecutive = left.consecutive + right.consecutive;
        int siblings = left.siblings + right.siblings;
        int spaceToGrow = left.spaceToGrow + right.spaceToGrow;

        int sum = 0;
        if (consecutive >= 3) {
            return Config.FOUR_IN_A_ROW;
        } else {
            double consecutive_normalized = consecutive * Config.CONSECUTIVE;
            double siblings_normalized = siblings * Config.SIBLINGS;
            double spaceToGrow_normalized = spaceToGrow * Config.SPACE_TO_GROW;
            return (Math.pow(2, consecutive_normalized) * spaceToGrow_normalized) + (1 * siblings_normalized);
        }
    }

    public SideResult EvaluateSide(Field field, String side){
        /*
        TODO:
            - calculate how much space it can grow
            - calculate consecutive
            - sum those from above and calculate how much of same are i the same row
            - evaluate upper field to score opponents move
         */

        int consecutive = 0;
        int siblings = 0;
        double score = 0;
        int spaceToGrow = 0;

        ArrayList<Field> list = field.surroundings.get(side);
        boolean gap = false;
        boolean opponentCoin = false;
        for (int i=0; i<list.size(); i++){
            if (list.get(i).color != Color.BLANK && list.get(i).color != field.color) {
                break;
            }

            if (list.get(i).color == Color.BLANK){
                spaceToGrow++;
                gap = true;
            }

            if (list.get(i).color == field.color) {
                siblings ++;
                if (!gap) {
                    consecutive++;
                }
            }
        }

        System.out.println("-------------------------------");
        System.out.println("Consecutive: " + consecutive);
        System.out.println("Left: " + siblings);
        System.out.println("Space to grow: " + spaceToGrow);


        return new SideResult(consecutive, siblings, spaceToGrow);
    }

    public double GetHorizontalScore(Field field){
        SideResult leftSide = EvaluateSide(field, "Left");
        SideResult rightSide = EvaluateSide(field, "Right");

//        System.out.println("Score: " + (CalculateScore(leftSide, rightSide)));
        return CalculateScore(leftSide, rightSide);
    }

    public double GetVerticalScore(Field field){
        SideResult leftSide = EvaluateSide(field, "Up");
        SideResult rightSide = EvaluateSide(field, "Down");
//        System.out.println("Score: " + (CalculateScore(leftSide, rightSide)));

        return CalculateScore(leftSide, rightSide);
    }

    public double GetDiagonalUpScore(Field field){
        SideResult leftSide = EvaluateSide(field, "DownLeft" );
        SideResult rightSide = EvaluateSide(field, "UpRight");

        return CalculateScore(leftSide, rightSide);
    }

    public double GetDiagonalDownScore(Field field){
        SideResult leftSide = EvaluateSide(field, "UpLeft");
        SideResult rightSide = EvaluateSide(field, "DownRight");

        return CalculateScore(leftSide, rightSide);
    }

    public double GetFieldScore(int x, int y){
        Field field = board[x][y];
        double horizontal = GetHorizontalScore(field);
        double vertical = GetVerticalScore(field);
        double diagonalUp = GetDiagonalUpScore(field);
        double diagonalDown = GetDiagonalDownScore(field);
        return horizontal + vertical + diagonalUp + diagonalDown;
    }
    public double GetFieldScore(Field field) {
        double horizontal = GetHorizontalScore(field);
        double vertical = GetVerticalScore(field);
        double diagonalUp = GetDiagonalUpScore(field);
        double diagonalDown = GetDiagonalDownScore(field);
        return horizontal + vertical + diagonalUp + diagonalDown;
    }

    public Score GetMaxScoreField(Color color){
        Score maxScore = new Score();
        for (int i=0; i<Config.SIZE_X; i++){
            int j = 0;
            while(board[i][j].color != Color.BLANK){
                j++;
            }
            System.out.println("x: " + i + "y: " + j);
            double currentFieldScore = GetFieldScore(i, j);
            if (currentFieldScore > maxScore.value){
                maxScore.value = currentFieldScore;
                maxScore.position = new Position(i, j);
            }
        }

        System.out.println("Max Score: " + maxScore.value + " Position: " + maxScore.position.x + ", " + maxScore.position.y );
        return maxScore;
    }

}
