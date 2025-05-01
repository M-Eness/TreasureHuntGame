package com.mycompany.treasurehuntgame;

import javax.swing.JLabel;

public class BSTNode {

    int score;
    String username;
    String level;
    BSTNode left, right;

    public BSTNode(String username, String level, int score) {
        this.score = score;
        this.username = username;
        this.level = level;
    }
}

class ScoreBST {

    BSTNode root;

    public void insert(int score, String username, String level) {
        root = insertRec(root, score, username, level);
    }

    private BSTNode insertRec(BSTNode node, int score, String username, String level) {
        if (node == null) {
            return new BSTNode(username, level, score);
        }
        if (score < node.score) {
            node.left = insertRec(node.left, score, username, level);
        } else {
            node.right = insertRec(node.right, score, username, level);
        }
        return node;
    }

    public void printScores(BSTNode root, JLabel label) {
        if (root != null) {
            printScores(root.left, label);
            label.setText(label.getText() + " -> " + root.score + " (" + root.level + ")");
            printScores(root.right, label);
        }
    }

    public String findMin(BSTNode node) {
        if (node.left == null) {
            return "Score: " + node.score + " (" + node.level + ")";
        }
        return findMin(node.left);
    }

    public String findMax(BSTNode node) {
        if (node.right == null) {
            return "Score: " + node.score + " (" + node.level + ")";
        }
        return findMax(node.right);
    }
}
