/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.treasurehuntgame;

import java.awt.Color;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author mehmetenes
 */
public class Game extends javax.swing.JFrame {

    /**
     * Creates new form Game
     */
    // Userı tutmak için Game sınıfı user alıyor.
    static User user;
    public JLabel[] mapLabels;
    public LinkedListMap map;
    int currentLevel = 3; // Güncel leveli tutar.

    ImageIcon forwardIcon = new ImageIcon(getClass().getResource("/images/forward_icon.png"));
    ImageIcon backwardIcon = new ImageIcon(getClass().getResource("/images/backward_icon.png"));
    ImageIcon trapIcon = new ImageIcon(getClass().getResource("/images/trap.png"));
    ImageIcon treasureIcon = new ImageIcon(getClass().getResource("/images/treasure_chest.png"));
    ImageIcon characterIcon = new ImageIcon(getClass().getResource("/images/character.png"));
    ImageIcon poisonIcon = new ImageIcon(getClass().getResource("/images/poison.png"));
    ImageIcon healIcon = new ImageIcon(getClass().getResource("/images/heal.png"));
    ImageIcon mysteryIcon = new ImageIcon(getClass().getResource("/images/mystery_box.png"));
    ImageIcon startIcon = new ImageIcon(getClass().getResource("/images/start.png"));

    public Game(User user) {
        this.user = user;
        initComponents();

        mapLabels = new JLabel[]{
            jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6,
            jLabel7, jLabel8, jLabel9, jLabel10, jLabel11, jLabel12,
            jLabel13, jLabel14, jLabel15, jLabel16, jLabel17, jLabel18,
            jLabel19, jLabel20, jLabel21, jLabel22, jLabel23, jLabel24,
            jLabel25, jLabel26, jLabel27, jLabel28, jLabel29, jLabel30
        };
        System.out.println(user.username); // Kullanıcı kontrolü
        startGame(user);
    }

    public void initializeMapDisplay(LinkedListMap map, JLabel[] mapLabels) {
        MapNode current = map.head;
        int i = 0;
        while (current != null && i < mapLabels.length) {
            ImageIcon icon = switch (current.type) {
                case "treasure" ->
                    treasureIcon;
                case "trap" ->
                    trapIcon;
                case "forward" ->
                    forwardIcon;
                case "backward" ->
                    backwardIcon;
                case "poison" ->
                    poisonIcon;
                case "heal" ->
                    healIcon;
                case "mystery_box" ->
                    mysteryIcon;
                case "start" ->
                    startIcon;
                default ->
                    null;
            };
            mapLabels[i].setIcon(icon);
            current = current.next;
            i++;
        }
    }

    public void startGame(User user) {
        map = new LinkedListMap(30, currentLevel); // Güncel levele göre harita üretir.
        initializeMapDisplay(map, mapLabels);
        map.displayMap();
        diceLabel.setText("0");
        System.out.println(getClass().getResource("/images/forward_icon.png"));
        Random rand = new Random();
        user.resetPosition();
        user.resetScore();
        // Poison ve Heal Göstergeleri Başlangıçta Kapalı
        System.out.println(currentLevel);
        if (currentLevel != 3) {
            jLabel35.setVisible(false);
            jLabel36.setVisible(false);
            jLabel37.setVisible(false);
            jLabel38.setVisible(false);
        } else {
            jLabel35.setVisible(true);
            jLabel36.setVisible(true);
            jLabel37.setVisible(true);
            jLabel38.setVisible(true);
        }
    }

    private void updatePlayerPosition(int oldPos, int newPos, String oldType) {
        System.out.println("old: " + oldPos + " new: " + newPos);
        ImageIcon icon = switch (oldType) {
            case "treasure" ->
                treasureIcon;
            case "trap" ->
                trapIcon;
            case "forward" ->
                forwardIcon;
            case "backward" ->
                backwardIcon;
            case "poison" ->
                poisonIcon;
            case "heal" ->
                healIcon;
            case "mystery_box" ->
                mysteryIcon;
            case "start" ->
                startIcon;
            default ->
                null;
        };

        if (oldPos >= 0 && oldPos < mapLabels.length) {
            mapLabels[oldPos].setIcon(icon); // eski iconu yerine koy
        }
        if (newPos >= 0 && newPos < mapLabels.length) {
            mapLabels[newPos].setIcon(characterIcon); // oyuncunun yeri
        }
    }

    private void isOver() {
        ScoreManager.saveScore(user, currentLevel);
        if (currentLevel >= 3) {
            JOptionPane.showMessageDialog(null, "Game Over! You completed all levels.");
            this.dispose();  // Oyunu kapat
            return;
        }

        Continue screen = new Continue(this, true, this);
        screen.setSize(400, 400);
        screen.setLocationRelativeTo(null);
        screen.setVisible(true);
        //this.dispose();

//        int result = JOptionPane.showConfirmDialog(null, "Level " + currentLevel + " is over. Do you want to continue to Level " + (currentLevel + 1) + "?", "Continue?",
//                JOptionPane.YES_NO_OPTION,
//                JOptionPane.QUESTION_MESSAGE);
//
//        if (result == JOptionPane.YES_OPTION) {
//            currentLevel++;
//            mapLabels[user.currentNode.index].setForeground(null);
//            diceLabel.setText("0");
//            startGame(user);
//        } else {
//            JOptionPane.showMessageDialog(null, "Game Over! Thanks for playing.");
//            this.dispose();  // Oyunu kapat
//        }
    }

    private void advancedLevelMovement() {
        while (user.currentNode != null && (user.currentNode.type == "forward" || user.currentNode.type == "backward")) {
            if (user.currentNode.index + user.currentNode.jumpAmount > 29) { //Jump değeriyle beraber hesaplanıyor.
                isOver();
            } else {
                user.currentNode.type = "empty";
                updatePlayerPosition(user.currentNode.index, user.currentNode.jump.index, user.currentNode.type);
                user.currentNode = user.currentNode.jump;
            }
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        diceLabel = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        scoreLabel = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(330, 600, 70, 70);
        getContentPane().add(jLabel2);
        jLabel2.setBounds(400, 560, 80, 70);
        getContentPane().add(jLabel3);
        jLabel3.setBounds(490, 530, 70, 80);
        getContentPane().add(jLabel4);
        jLabel4.setBounds(580, 540, 100, 80);
        getContentPane().add(jLabel5);
        jLabel5.setBounds(670, 550, 100, 80);
        getContentPane().add(jLabel6);
        jLabel6.setBounds(780, 560, 90, 70);
        getContentPane().add(jLabel7);
        jLabel7.setBounds(880, 520, 70, 80);
        getContentPane().add(jLabel8);
        jLabel8.setBounds(890, 450, 80, 70);
        getContentPane().add(jLabel9);
        jLabel9.setBounds(820, 400, 70, 70);
        getContentPane().add(jLabel10);
        jLabel10.setBounds(730, 380, 80, 80);
        getContentPane().add(jLabel11);
        jLabel11.setBounds(640, 390, 90, 80);
        getContentPane().add(jLabel12);
        jLabel12.setBounds(560, 380, 80, 80);
        getContentPane().add(jLabel13);
        jLabel13.setBounds(470, 380, 80, 70);
        getContentPane().add(jLabel14);
        jLabel14.setBounds(380, 340, 80, 80);
        getContentPane().add(jLabel15);
        jLabel15.setBounds(290, 320, 80, 80);
        getContentPane().add(jLabel16);
        jLabel16.setBounds(200, 300, 90, 80);
        getContentPane().add(jLabel17);
        jLabel17.setBounds(130, 270, 90, 60);
        getContentPane().add(jLabel18);
        jLabel18.setBounds(120, 190, 80, 70);
        getContentPane().add(jLabel19);
        jLabel19.setBounds(170, 110, 90, 80);
        getContentPane().add(jLabel20);
        jLabel20.setBounds(240, 80, 80, 80);
        getContentPane().add(jLabel21);
        jLabel21.setBounds(330, 80, 80, 80);
        getContentPane().add(jLabel22);
        jLabel22.setBounds(420, 100, 90, 80);
        getContentPane().add(jLabel23);
        jLabel23.setBounds(470, 160, 80, 90);
        getContentPane().add(jLabel24);
        jLabel24.setBounds(460, 240, 90, 80);
        getContentPane().add(jLabel25);
        jLabel25.setBounds(530, 280, 100, 70);
        getContentPane().add(jLabel26);
        jLabel26.setBounds(660, 280, 90, 80);
        getContentPane().add(jLabel27);
        jLabel27.setBounds(750, 240, 90, 80);
        getContentPane().add(jLabel28);
        jLabel28.setBounds(820, 180, 80, 90);
        getContentPane().add(jLabel29);
        jLabel29.setBounds(900, 120, 90, 90);
        getContentPane().add(jLabel30);
        jLabel30.setBounds(960, 60, 80, 70);

        jLabel33.setFont(new java.awt.Font("Kokonor", 1, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(0, 0, 0));
        jLabel33.setText("Dice: ");
        getContentPane().add(jLabel33);
        jLabel33.setBounds(30, 120, 44, 40);

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dice.png"))); // NOI18N
        getContentPane().add(jLabel32);
        jLabel32.setBounds(0, 0, 150, 120);

        diceLabel.setFont(new java.awt.Font("Kokonor", 0, 18)); // NOI18N
        getContentPane().add(diceLabel);
        diceLabel.setBounds(80, 130, 60, 20);

        jLabel34.setFont(new java.awt.Font("Kokonor", 1, 30)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(0, 0, 0));
        jLabel34.setText("Score: ");
        getContentPane().add(jLabel34);
        jLabel34.setBounds(470, 20, 80, 51);

        scoreLabel.setFont(new java.awt.Font("Kokonor", 0, 30)); // NOI18N
        scoreLabel.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(scoreLabel);
        scoreLabel.setBounds(560, 20, 80, 50);

        jLabel35.setFont(new java.awt.Font("Kokonor", 0, 15)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(0, 0, 0));
        jLabel35.setText("Heal:");
        getContentPane().add(jLabel35);
        jLabel35.setBounds(30, 180, 34, 26);

        jLabel36.setFont(new java.awt.Font("Kokonor", 0, 15)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(jLabel36);
        jLabel36.setBounds(70, 180, 49, 20);

        jLabel37.setFont(new java.awt.Font("Kokonor", 0, 15)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(0, 0, 0));
        jLabel37.setText("Poison:");
        getContentPane().add(jLabel37);
        jLabel37.setBounds(30, 210, 49, 17);

        jLabel38.setFont(new java.awt.Font("Kokonor", 0, 15)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(jLabel38);
        jLabel38.setBounds(80, 210, 49, 17);

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/background.png"))); // NOI18N
        getContentPane().add(jLabel31);
        jLabel31.setBounds(0, 0, 1100, 710);

        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(50, 0, 90, 120);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Random rand = new Random();
        int dice = rand.nextInt(6) + 1;
        diceLabel.setText(String.valueOf(dice));
        System.out.println("Zar: " + dice);
        int oldIndex = -1;

        if (user.currentNode != null) {
            oldIndex = user.currentNode.index;
        }

        jLabel31.setText("zar: " + dice);
        if (user.currentNode == null) {
            user.currentNode = map.getNodeAtFirst(dice);
            updatePlayerPosition(oldIndex, user.currentNode.index, "");

        } else if (user.currentNode.index + dice <= 29) {
            String oldType = user.currentNode.type;
            user.moveForward(dice);
            updatePlayerPosition(oldIndex, user.currentNode.index, oldType);
        } else {
            isOver();
        }
        if (currentLevel == 2) {
            advancedLevelMovement();
        }
        else if (currentLevel == 3) {
            advancedLevelMovement();
            if ((user.currentNode != null) && (user.currentNode.type == "poison" || user.currentNode.type == "heal" || user.currentNode.type == "mystery_box")) {
                // Node bunlardan biri ise özellik alındıktan sonra Node empty olacak
                if (user.currentNode.type == "poison") {
                    user.poison++;
                } else if (user.currentNode.type == "heal") {
                    user.heal++;
                } else if (user.currentNode.type == "mystery_box") {
                    user.updateScore(user.currentNode.type);
                }

                System.out.println("You get " + user.currentNode.type);
                System.out.println("Poison " + user.poison);
                System.out.println("Heal " + user.heal);
                jLabel36.setText(String.valueOf(user.heal));
                jLabel38.setText(String.valueOf(user.poison));
                user.currentNode.type = "empty";
            }
            if (user.currentNode.type == "start") {
                updatePlayerPosition(user.currentNode.index, user.currentNode.jump.index, user.currentNode.type);
                user.currentNode = user.currentNode.jump;
                System.out.println("current node ındex : " + user.currentNode.index);
                System.out.println("Node tipi start olduğu için başa gidildi");
              
            }
        }
        if (user.currentNode != null) {
            System.out.println(user.currentNode.type);
            user.updateScore(user.currentNode.type);
        }
        scoreLabel.setText(String.valueOf(user.score));
        System.out.println("Score: " + user.score);

    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Game.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Game.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Game.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Game.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Game(user).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel diceLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel scoreLabel;
    // End of variables declaration//GEN-END:variables
}
