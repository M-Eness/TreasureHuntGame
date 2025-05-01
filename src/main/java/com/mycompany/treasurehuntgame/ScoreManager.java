package com.mycompany.treasurehuntgame;

import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ScoreManager {
    private static final String FILE_NAME = "score.txt";

    public static void saveScore(User user, int level) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            bw.write(user.username + ", " + "level " + level + ", " + user.score);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String[]> loadUserScores(String username) {
        List<String[]> scores = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("score.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(", ");
                if (parts[0].equals(username)) {
                    scores.add(parts);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return scores;
    }
}