package controller;

import config.Color;
import config.Config;
import javafx.geometry.Side;

import java.util.ArrayList;
import java.util.HashMap;

class SideResult{
    public double score;
    public int consecutive;

    public SideResult(double score, int consecutive){
        this.score = score;
        this.consecutive = consecutive;
    }
}

public class Evaluator {

    private Field[][] board;

    public Evaluator(Field[][] board){
        //cloning needed probably
        this.board = board;
    }

    public SideResult EvaluateSide(Field field, String side, Color color){
        int consecutive = 0;
        int siblings = 0;
        double score = 0;

        ArrayList<Field> list = field.surroundings.get(side);
        boolean gap = true;
        if (list.size() > 0){
            if (list.get(0).color == color){
                gap = false;
            }
        }
        for (int i=0; i<list.size(); i++){
            if (list.get(i).color == color){
                if (!gap) consecutive++;
                siblings++;
            }
            else if (list.get(i).color == Color.BLANK){
                gap = true;
                continue;
            }
            else{
                break;
            }
        }

        System.out.println("-------------------------------");
        System.out.println("Consecutive: " + consecutive);
        System.out.println("Left: " + siblings);

        // Evaluate Consecutive
        switch (consecutive){
            case 0:
                score += 0;
                break;
            case 1:
                score += Config.TWO_IN_A_ROW;
                break;
            case 2:
                score += Config.THREE_IN_A_ROW;
                break;
            case 3:
                score += Config.FOUR_IN_A_ROW;
                break;
            default:
                score += 1;
        }

        switch (siblings - consecutive){
            case 1:
                score += Config.TWO_IN_A_ROW_W_SPACES;
                break;
            case 2:
                score += Config.THREE_IN_A_ROW_W_SPACES;
                break;
            default:
                score += 0;
        }

        return new SideResult(score, consecutive);
    }

    public double GetHorizontalScore(Field field, Color color){
        SideResult leftSide = EvaluateSide(field, "Left", color );
        SideResult rightSide = EvaluateSide(field, "Right", color);
        double totalScore = leftSide.score + rightSide.score;

        if(leftSide.consecutive + rightSide.consecutive >= 3){
            totalScore = Config.FOUR_IN_A_ROW;
        }

        System.out.println("==============================");
        System.out.println("Horizontal Score");
        System.out.println("==============================");
        System.out.println("Left Score: " + leftSide.score);
        System.out.println("Right Score: " + rightSide.score);
        System.out.println("Total Score: " + totalScore);
        return totalScore;
    }

    public double GetVerticalScore(Field field, Color color){
        SideResult leftSide = EvaluateSide(field, "Up", color );
        SideResult rightSide = EvaluateSide(field, "Down", color);
        double totalScore = leftSide.score + rightSide.score;

        if(leftSide.consecutive + rightSide.consecutive >= 3){
            totalScore = Config.FOUR_IN_A_ROW;
        }

        System.out.println("==============================");
        System.out.println("Vertical Score");
        System.out.println("==============================");
        System.out.println("Left Score: " + leftSide.score);
        System.out.println("Right Score: " + rightSide.score);
        System.out.println("Total Score: " + totalScore);
        return totalScore;
    }

    public double GetDiagonalUpScore(Field field, Color color){
        SideResult leftSide = EvaluateSide(field, "DownLeft", color );
        SideResult rightSide = EvaluateSide(field, "UpRight", color);
        double totalScore = leftSide.score + rightSide.score;

        if(leftSide.consecutive + rightSide.consecutive >= 3){
            totalScore = Config.FOUR_IN_A_ROW;
        }

        System.out.println("==============================");
        System.out.println("Diagonal UP Score");
        System.out.println("==============================");
        System.out.println("Left Score: " + leftSide.score);
        System.out.println("Right Score: " + rightSide.score);
        System.out.println("Total Score: " + totalScore);
        return totalScore;
    }

    public double GetDiagonalDownScore(Field field, Color color){
        SideResult leftSide = EvaluateSide(field, "UpLeft", color );
        SideResult rightSide = EvaluateSide(field, "DownRight", color);
        double totalScore = leftSide.score + rightSide.score;

        if(leftSide.consecutive + rightSide.consecutive >= 3){
            totalScore = Config.FOUR_IN_A_ROW;
        }

        System.out.println("==============================");
        System.out.println("Diagonal Down Score");
        System.out.println("==============================");
        System.out.println("Left Score: " + leftSide.score);
        System.out.println("Right Score: " + rightSide.score);
        System.out.println("Total Score: " + totalScore);
        return totalScore;
    }

    public int GetFieldScore(int x, int y){

        return 0;
    }

}
