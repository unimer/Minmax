package controller;

import config.Color;
import config.Config;

import java.util.ArrayList;
import java.util.HashMap;

public class Evaluator {

    private Field[][] board;

    public Evaluator(Field[][] board){
        //cloning needed probably
        this.board = board;
    }

    public double EvaluateSide(Field field, String side, Color color){
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

        return score;
    }

    public double GetHorizontalScore(Field field, Color color){
        double leftScore = EvaluateSide(field, "Left", color );

        System.out.println("Left Score: " + leftScore);

        return leftScore;
    }

    public int GetFieldScore(int x, int y){



        return 0;
    }

}
