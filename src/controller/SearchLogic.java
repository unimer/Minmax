package controller;

import config.Color;
import config.Config;

import javax.swing.*;
import java.util.ArrayList;

class Node {
    public Node[] children; //pointers to other nodes
    public double score = 0; //Node Value
    public int height = 0; //Node Value
    public Board board;
    public Node(){
        children = null;
    }
}

public class SearchLogic {

    public Node[] root = new Node[Config.SIZE_X];

    public Color FlipColor (Color color) {
        return color == Color.RED ? Color.YELLOW : Color.RED;
    }
    public void BuildTree (Node[] root, Board board, int height, Color player){
        if (height < 0) return;
        for (int i = 0; i < root.length; i++){
            root[i] = new Node();
            root[i].height = height;
            root[i].board = new Board(board);
            Field field = root[i].board.InsertField(player, i);
            Evaluator evaluator = new Evaluator();
            root[i].score = evaluator.GetFieldScore(field);
            System.out.println("[Height: " + root[i].height + "]: " + root[i].score);
            root[i].board.PrintBoard();
            if (height > 0) {
                root[i].children = new Node[root.length];
                BuildTree(root[i].children, root[i].board, height - 1, FlipColor(player));
            }
        }
    }

    public void PrintTree (Node [] root){
        if (root == null) return;
        for (int i = 0; i < root.length; i++){
//            System.out.println("[Height: " + root[i].height + "]: " + root[i].score);
//            root[i].board.PrintBoard();
//            PrintTree(root[i].children);
        }
    }




  }
