
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Lottery extends javax.swing.JFrame implements KeyListener {

    private String filePath = "", oldUserCountText = "";
    private ArrayList<String> users = new ArrayList<>();
    private Set<String> winners = new TreeSet<>();
    private DefaultListModel model = new DefaultListModel();
    private int okClickCount = 0, opCount = 0, firstClick;

    public Lottery() {
        initComponents();
        setLocationRelativeTo(null);

        winnersList.setModel(model);
        model = (DefaultListModel) winnersList.getModel();
        if (model.getSize() == 0) {
            usersCount.setEnabled(false);
        }

        clearList.setVisible(false);
        saveWinners.setVisible(false);
    }

    static Lottery lottery = new Lottery();

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backgroundPanel = new javax.swing.JPanel();
        selectedFileDir = new javax.swing.JTextField();
        browse = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        winnersList = new javax.swing.JList<>();
        selectWinners = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        clearList = new javax.swing.JButton();
        saveWinners = new javax.swing.JButton();
        usersCount = new javax.swing.JComboBox<>();
        pleaseWait = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Çəkiliş");
        setAutoRequestFocus(false);
        setResizable(false);

        backgroundPanel.setBackground(new java.awt.Color(255, 255, 255));

        selectedFileDir.setEditable(false);
        selectedFileDir.setFocusable(false);

        browse.setText("Göz at");
        browse.setFocusCycleRoot(true);
        browse.setOpaque(false);
        browse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(winnersList);

        selectWinners.setText("Qalibləri seç");
        selectWinners.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectWinnersActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 41, 48));
        jLabel1.setText("Qazananlar");

        clearList.setText("Siyahını Təmizlə");

        saveWinners.setText("Yadda saxla");

        usersCount.setEditable(true);
        usersCount.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "25", "10", "15", "20" }));
        usersCount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usersCountActionPerformed(evt);
            }
        });

        pleaseWait.setForeground(new java.awt.Color(93, 34, 118));

        javax.swing.GroupLayout backgroundPanelLayout = new javax.swing.GroupLayout(backgroundPanel);
        backgroundPanel.setLayout(backgroundPanelLayout);
        backgroundPanelLayout.setHorizontalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundPanelLayout.createSequentialGroup()
                        .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                            .addComponent(selectedFileDir, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(browse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(selectWinners, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(clearList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(saveWinners, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(usersCount, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(backgroundPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pleaseWait, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        backgroundPanelLayout.setVerticalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectedFileDir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(browse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pleaseWait, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(backgroundPanelLayout.createSequentialGroup()
                        .addComponent(usersCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(selectWinners, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clearList, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saveWinners, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void launchTheLottery() {
        if (usersCount.getSelectedIndex() == -1) {
            if (model.getSize() > 0) {
                winners.removeAll(winners);
            }
        } else {
            if (model.getSize() > 0) {
                model.removeAllElements();
                winners.removeAll(winners);
            }

            while (winners.size() != Integer.parseInt(usersCount.getSelectedItem().toString())) {
                int randomUser = getRandomUserIndex();
                winners.add(String.valueOf(users.get(randomUser)));
            }
        }
    }

    public void readUsers() {
        if (users.size() > 0) {
            users.removeAll(users);
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "ISO-8859-9"))) {
            String user;

            while ((user = reader.readLine()) != null) {
                users.add(user);
                System.out.println(user);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Lottery.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Lottery.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Lottery.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(users.size());
        if (users.isEmpty() || users.size() == 1) {
            if (users.size() == 1) {
                JOptionPane.showMessageDialog(this, "Ən azı iki iştirakçı olmalıdır.", "İştirakçı  sayı", HEIGHT);
            } else {
                JOptionPane.showMessageDialog(this, "Boş fayl daxil etməyin", "Boş fayl", HEIGHT);
            }
            usersCount.setEnabled(false);
            clearPath();
            users.removeAll(users);
        } else if (Integer.parseInt(usersCount.getItemAt(0)) >= users.size()) {
            int randomUser = getRandomValue();
            usersCount.setSelectedIndex(0);
            usersCount.setSelectedItem(randomUser);
            usersCount.setSelectedIndex(usersCount.getItemCount() - 1);
            usersCount.setEnabled(true);
            selectedFileDir.setText(filePath);
        } else {
            usersCount.setEnabled(true);
            selectedFileDir.setText(filePath);
        }
    }

    public void clearPath() {
        filePath = "";
        selectedFileDir.setText(filePath);
    }

    public int getRandomValue() {
        Random random = new Random();
        int randomValue = 1 + random.nextInt(users.size() - 1);
        return randomValue;
    }

    public int getRandomUserIndex() {
        Random random = new Random();
        int randomUser = random.nextInt(users.size());
        return randomUser;
    }

    public void clipSound() {
        try {
            AudioInputStream clipSoundStream = AudioSystem.getAudioInputStream(new File("alkış.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(clipSoundStream);
            clip.start();
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(Lottery.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Lottery.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(Lottery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void browseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseActionPerformed
        pleaseWait.setText("Zəhmət olmasa, gözləyin. İştirakçılar daxil edilir...");
        JFileChooser fileChooser = new JFileChooser();
        int selectedFile = fileChooser.showOpenDialog(this);
        Timer timer = new Timer(3000, null);
        timer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pleaseWait.setText("");
                timer.stop();
            }
        });

        if (selectedFile == JFileChooser.APPROVE_OPTION) {
            filePath = fileChooser.getSelectedFile().getPath();
            readUsers();
            timer.stop();
            timer.start();
            pleaseWait.setText("");
        }

        pleaseWait.setText(users.size() + " iştirakçı daxil edildi.");
        timer.start();
    }//GEN-LAST:event_browseActionPerformed

    private void selectWinnersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectWinnersActionPerformed
        if (this.filePath.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Zəhmət olmasa, çəkiliş faylı seçin. (.txt, .docx)", "Fayl seçilməyib", HEIGHT);
        } else {
            launchTheLottery();

            for (String winner : winners) {
                model.addElement(winner);
            }
            clipSound();
        }
    }//GEN-LAST:event_selectWinnersActionPerformed

    private void usersCountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usersCountActionPerformed
        if (!oldUserCountText.equals(usersCount.getSelectedItem().toString())) {
            okClickCount = 0;
            opCount = 0;
            firstClick = 0;
        }

        okClickCount++;
        opCount++;

        System.out.println("Ilkin " + okClickCount + " " + firstClick + " " + opCount);
        if (okClickCount == 1) {
            keyPressed(new KeyEvent(browse, WIDTH, WIDTH, SOMEBITS, ERROR));
            firstClick++;
        } else if (okClickCount > 2) {
            keyPressed(new KeyEvent(browse, WIDTH, WIDTH, SOMEBITS, ERROR));
            firstClick++;
        }

        if (okClickCount == 4 && firstClick == 3 && opCount == 4) {
            okClickCount = 0;
            firstClick = 0;
            return;
        }

        if ((firstClick >= 2 || okClickCount >= 2) && opCount >= 4) {
            okClickCount = 0;
            firstClick = 0;
        }

        if (opCount >= 4 && opCount % 2 == 0) {
            keyPressed(new KeyEvent(browse, WIDTH, WIDTH, SOMEBITS, ERROR));
        }

        System.out.println("Sonra " + okClickCount + " " + firstClick + " " + opCount);
        /*
        okClickCount++;
        if (okClickCount == 1 || opCount > 0) {
            System.out.println("Klikləndiyi an: " + okClickCount);
            keyPressed(new KeyEvent(browse, WIDTH, WIDTH, SOMEBITS, ERROR));
            if (opCount > 0) {
                opCount = 0;
                okClickCount = 0;
                firstClick = 0;
                System.out.println("Sıfırlandı.");
            } else if (firstClick > 0) {
                opCount++;
            }
        } else if (okClickCount == 2 || opCount == 0) {
            System.out.println("Loops zamanı : " + okClickCount);
            okClickCount = 0;
            opCount++;
            if (firstClick > 0 && okClickCount > 2) {
                keyPressed(new KeyEvent(browse, WIDTH, WIDTH, SOMEBITS, ERROR));
            }
        }
        firstClick++;
         */
    }//GEN-LAST:event_usersCountActionPerformed

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int pressedKey = e.getKeyCode();

        if (pressedKey == 64) {
            try {
                int intTypeControl = Integer.parseInt(usersCount.getSelectedItem().toString());
                ArrayList<String> items = new ArrayList<>();
                int itemSize = usersCount.getItemCount();
                boolean containsVal = false;
                oldUserCountText = usersCount.getSelectedItem().toString();

                for (int i = 0; i < itemSize; i++) {
                    items.add(usersCount.getItemAt(i));
                    if (items.get(i).equals(String.valueOf(intTypeControl))) {
                        containsVal = true;
                    }
                }

                if (!containsVal && users.size() > intTypeControl && intTypeControl >= 1) {
                    usersCount.addItem(String.valueOf(intTypeControl));
                    usersCount.setSelectedIndex(usersCount.getItemCount() - 1);
                } else if (!(users.size() > intTypeControl)) {
                    JOptionPane.showMessageDialog(this, "Qalib iştirakçıların sayı, ümumi iştirakçıların sayından çox ola bilməz", "İştirakçı sayı", HEIGHT);

                    if (usersCount.getSelectedIndex() > -1) {
                        usersCount.removeItemAt(usersCount.getSelectedIndex());
                        usersCount.setSelectedIndex(usersCount.getItemCount() - 1);
                        System.out.println(users.size());
                    }
                }

            } catch (HeadlessException | NumberFormatException ex) {
                System.out.println("False");
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

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
            java.util.logging.Logger.getLogger(Lottery.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Lottery.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Lottery.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Lottery.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Lottery().setVisible(true);
            }
        });

        lottery.addKeyListener(lottery);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel backgroundPanel;
    private javax.swing.JButton browse;
    private javax.swing.JButton clearList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel pleaseWait;
    private javax.swing.JButton saveWinners;
    private javax.swing.JButton selectWinners;
    private javax.swing.JTextField selectedFileDir;
    private javax.swing.JComboBox<String> usersCount;
    private javax.swing.JList<String> winnersList;
    // End of variables declaration//GEN-END:variables

}
