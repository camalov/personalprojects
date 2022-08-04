package com.swing.workshops.notepadwithmenu;

import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Notepad extends javax.swing.JFrame {

    private String savedFilePath = "", openedFilePath = "";

    public Notepad() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        contentArea = new javax.swing.JTextArea();
        jMenuBar2 = new javax.swing.JMenuBar();
        file = new javax.swing.JMenu();
        openFile = new javax.swing.JMenuItem();
        save = new javax.swing.JMenuItem();
        saveAndExit = new javax.swing.JMenuItem();
        edit = new javax.swing.JMenu();
        color = new javax.swing.JMenu();
        changeColor = new javax.swing.JMenuItem();
        font = new javax.swing.JMenu();
        arial = new javax.swing.JMenuItem();
        timesNewRoman = new javax.swing.JMenuItem();

        jMenu2.setText("jMenu2");

        jMenu3.setText("jMenu3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        contentArea.setColumns(20);
        contentArea.setRows(5);
        jScrollPane1.setViewportView(contentArea);

        file.setText("Fayl");

        openFile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        openFile.setText("Fayl aç");
        openFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFileActionPerformed(evt);
            }
        });
        file.add(openFile);

        save.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        save.setText("Yadda saxla");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        file.add(save);

        saveAndExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        saveAndExit.setText("Yadda saxla və çıx");
        saveAndExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAndExitActionPerformed(evt);
            }
        });
        file.add(saveAndExit);

        jMenuBar2.add(file);

        edit.setText("Redaktə");

        color.setText("Rəng");

        changeColor.setText("Rəngi Dəyiş");
        changeColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeColorActionPerformed(evt);
            }
        });
        color.add(changeColor);

        edit.add(color);

        font.setText("Şrift");

        arial.setText("Arial");
        arial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arialActionPerformed(evt);
            }
        });
        font.add(arial);

        timesNewRoman.setText("Times New Roman");
        timesNewRoman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timesNewRomanActionPerformed(evt);
            }
        });
        font.add(timesNewRoman);

        edit.add(font);

        jMenuBar2.add(edit);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 735, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void openFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openFileActionPerformed
        JFileChooser fc = new JFileChooser();
        int selectedFile = fc.showOpenDialog(this);

        if (selectedFile == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            String content = "";
            openedFilePath = fc.getSelectedFile().getPath();
            System.out.println(openedFilePath);
            try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(file)))) {
                while (scanner.hasNextLine()) {
                    content += scanner.nextLine() + "\n";
                }
                contentArea.setText(content);
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "Fayl tapılmadı", "Fayl seçimini düzgün edin", HEIGHT);
            }

        }
    }//GEN-LAST:event_openFileActionPerformed

    private void timesNewRomanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timesNewRomanActionPerformed
        Font font = new Font("Times New Roman", Font.PLAIN, 20);
        contentArea.setFont(font);
    }//GEN-LAST:event_timesNewRomanActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        JFileChooser fc = new JFileChooser();
        int answer = fc.showSaveDialog(this);
        String content = String.valueOf(contentArea.getText());

        if (answer == JFileChooser.APPROVE_OPTION) {
            String filePath = fc.getSelectedFile().getPath();
            savedFilePath = filePath;

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
                //for (Integer i = 0; i < content.length(); i++) {
                bw.write(content);
                //}

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Fayl saxlanılarkən xəta baş verdi.", "IOException", HEIGHT);
            }
        } else if (!savedFilePath.equals("")) {
            int checkAnswer = JOptionPane.showConfirmDialog(this, "Yaddaşda saxlanılmadan davam edilsin ?", "Yadda saxlanılmadı", WIDTH);

            if (checkAnswer == 1) {
                saveActionPerformed(evt);
            } else if (checkAnswer == 2) {

            } else {
                System.exit(0);
            }
        }

    }//GEN-LAST:event_saveActionPerformed

    private void saveAndExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAndExitActionPerformed
        if (!savedFilePath.equals("")) {
            String content = String.valueOf(contentArea.getText());
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(savedFilePath))) {
                //for (Integer i = 0; i < content.length(); i++) {
                bw.write(content);
                //}
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Fayl saxlanılarkən xəta baş verdi.", "IOException", HEIGHT);
            }
            System.exit(0);
        } else if (!openedFilePath.equals("")) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(openedFilePath))) {
                String content = contentArea.getText();
                bw.write(content);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Fayl saxlanılarkən xəta baş verdi.", "IOException", HEIGHT);
            }
            System.exit(0);
        } else {
            saveActionPerformed(evt);
        }
    }//GEN-LAST:event_saveAndExitActionPerformed

    private void changeColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeColorActionPerformed
        Color color = JColorChooser.showDialog(this, "Rəng seçin", Color.PINK);
        contentArea.setForeground(color);
    }//GEN-LAST:event_changeColorActionPerformed

    private void arialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arialActionPerformed
        Font font = new Font("Arial", Font.PLAIN, 20);
        contentArea.setFont(font);
    }//GEN-LAST:event_arialActionPerformed

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
            java.util.logging.Logger.getLogger(Notepad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Notepad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Notepad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Notepad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Notepad().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem arial;
    private javax.swing.JMenuItem changeColor;
    private javax.swing.JMenu color;
    private javax.swing.JTextArea contentArea;
    private javax.swing.JMenu edit;
    private javax.swing.JMenu file;
    private javax.swing.JMenu font;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem openFile;
    private javax.swing.JMenuItem save;
    private javax.swing.JMenuItem saveAndExit;
    private javax.swing.JMenuItem timesNewRoman;
    // End of variables declaration//GEN-END:variables
}
