package com.swing.workshops.letterandwordfrequency;

import java.util.Arrays;

public class LetterAndWordCount extends javax.swing.JFrame {

    public LetterAndWordCount() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        wordCount = new javax.swing.JLabel();
        letterCount = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Söz və Hərf Sayı");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        textArea.setColumns(20);
        textArea.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        textArea.setRows(5);
        textArea.setAutoscrolls(false);
        textArea.setBorder(null);
        textArea.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        textArea.setHighlighter(null);
        textArea.setVerifyInputWhenFocusTarget(false);
        textArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textAreaKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(textArea);

        wordCount.setText("Söz sayı : ");

        letterCount.setText("Hərf  (simwol) sayı :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(511, Short.MAX_VALUE)
                .addComponent(wordCount)
                .addGap(66, 66, 66)
                .addComponent(letterCount)
                .addGap(101, 101, 101))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(wordCount)
                    .addComponent(letterCount))
                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textAreaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textAreaKeyTyped
        String text = textArea.getText(), trimmedText = text.trim();
        String[] words = text.split(" ");
        int wordCount = words.length, letterCount = 0;

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != ' ') {
                letterCount++;
            }
        }

        if (text.length() > 0) {
            this.wordCount.setText("Söz sayı : " + Integer.valueOf(wordCount));
        } else {
            this.wordCount.setText("Söz sayı : " + 0);
        }

        if (letterCount >= Arrays.toString(words).length()) {
            letterCount = Arrays.toString(words).length();
            System.out.println(letterCount + "\n" + Arrays.toString(words).length());
        }

        if (text.length() > 0) {
            this.letterCount.setText("Hərf (simwol) sayı : " + Integer.valueOf(letterCount + 1));
        } else {
            this.letterCount.setText("Hərf (simwol) sayı : " + Integer.valueOf(letterCount));
        }
    }//GEN-LAST:event_textAreaKeyTyped

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LetterAndWordCount().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel letterCount;
    private javax.swing.JTextArea textArea;
    private javax.swing.JLabel wordCount;
    // End of variables declaration//GEN-END:variables

}
