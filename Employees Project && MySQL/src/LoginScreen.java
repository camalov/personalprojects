
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class LoginScreen extends javax.swing.JFrame {

    private static Timer spaceControlTimer = new Timer(1, null);
    private static Timer timer = new javax.swing.Timer(150, null);
    private static String value = "Müasir";
    private static int level = 0, i = 0, increamentCount = 0;
    EmployeesOperations eo = new EmployeesOperations();
    private boolean loginButtonEnable = false;

    public LoginScreen() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        messageLabel1.setVisible(false);
        messageLabel2.setVisible(false);
        messageLabel3.setVisible(false);
        loginButton.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        container = new javax.swing.JPanel();
        loginButton = new javax.swing.JLabel();
        signUpLabel = new javax.swing.JLabel();
        loginLabel = new javax.swing.JLabel();
        userNameLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        userNameField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        jSeparator2 = new javax.swing.JSeparator();
        messageLabel3 = new javax.swing.JLabel();
        messageLabel2 = new javax.swing.JLabel();
        messageLabel1 = new javax.swing.JLabel();
        fastLabel = new javax.swing.JLabel();
        modernLabel = new javax.swing.JLabel();
        comfortLabel = new javax.swing.JLabel();
        rightLayout = new javax.swing.JLabel();
        leftLayout = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Daxil Olun");
        setAutoRequestFocus(false);
        setPreferredSize(new java.awt.Dimension(945, 430));

        container.setPreferredSize(new java.awt.Dimension(940, 350));
        container.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        loginButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loginButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\PC\\Programming\\Java\\Employees Project && MySQL\\Icons\\icons8-ok-50.png")); // NOI18N
        loginButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                loginButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                loginButtonMouseReleased(evt);
            }
        });
        container.add(loginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 310, 120, 90));

        signUpLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        signUpLabel.setIcon(new javax.swing.ImageIcon("C:\\Users\\PC\\Programming\\Java\\Employees Project && MySQL\\Icons\\signUp.png")); // NOI18N
        container.add(signUpLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 20, 100, 70));

        loginLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loginLabel.setIcon(new javax.swing.ImageIcon("C:\\Users\\PC\\Programming\\Java\\Employees Project && MySQL\\Icons\\login.png")); // NOI18N
        container.add(loginLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 20, 110, 70));

        userNameLabel.setFont(new java.awt.Font("Monospaced", 1, 20)); // NOI18N
        userNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        userNameLabel.setText("İstifadəçi adı");
        container.add(userNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 80, 220, 70));

        passwordLabel.setFont(new java.awt.Font("Monospaced", 1, 20)); // NOI18N
        passwordLabel.setForeground(new java.awt.Color(255, 255, 255));
        passwordLabel.setText("Şifrə");
        container.add(passwordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 200, 220, 60));

        jSeparator1.setBackground(new java.awt.Color(51, 51, 51));
        jSeparator1.setForeground(new java.awt.Color(51, 51, 51));
        container.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 192, 390, -1));

        userNameField.setBackground(new java.awt.Color(17, 11, 45));
        userNameField.setFont(new java.awt.Font("Meiryo UI", 0, 14)); // NOI18N
        userNameField.setForeground(new java.awt.Color(102, 102, 102));
        userNameField.setText("İstifadəçi adını daxil edin");
        userNameField.setBorder(null);
        userNameField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                userNameFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                userNameFieldFocusLost(evt);
            }
        });
        userNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userNameFieldActionPerformed(evt);
            }
        });
        userNameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                userNameFieldKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                userNameFieldKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                userNameFieldKeyTyped(evt);
            }
        });
        container.add(userNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 150, 390, 40));

        passwordField.setBackground(new java.awt.Color(17, 11, 45));
        passwordField.setFont(new java.awt.Font("Meiryo UI", 0, 14)); // NOI18N
        passwordField.setForeground(new java.awt.Color(102, 102, 102));
        passwordField.setText("       ");
        passwordField.setBorder(null);
        passwordField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passwordFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                passwordFieldFocusLost(evt);
            }
        });
        passwordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordFieldKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                passwordFieldKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                passwordFieldKeyTyped(evt);
            }
        });
        container.add(passwordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 260, 390, 40));

        jSeparator2.setBackground(new java.awt.Color(51, 51, 51));
        jSeparator2.setForeground(new java.awt.Color(51, 51, 51));
        container.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 298, 390, -1));

        messageLabel3.setFont(new java.awt.Font("Meiryo UI", 1, 14)); // NOI18N
        messageLabel3.setForeground(new java.awt.Color(204, 0, 51));
        messageLabel3.setText("və yenidən cəhd edin.");
        container.add(messageLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 360, 220, 40));

        messageLabel2.setFont(new java.awt.Font("Meiryo UI", 1, 14)); // NOI18N
        messageLabel2.setForeground(new java.awt.Color(204, 0, 51));
        messageLabel2.setText("Məlumatların düzgünlüyünü yoxlayın,");
        container.add(messageLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 340, 320, 40));

        messageLabel1.setFont(new java.awt.Font("Meiryo UI", 1, 14)); // NOI18N
        messageLabel1.setForeground(new java.awt.Color(204, 0, 51));
        messageLabel1.setText("İstifadəçi tapılmadı.");
        container.add(messageLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 320, 280, 40));

        fastLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        fastLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        container.add(fastLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 100, 40));

        modernLabel.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        container.add(modernLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 130, 40));

        comfortLabel.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        comfortLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        container.add(comfortLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 110, 40));

        rightLayout.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        rightLayout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rightLayout.setIcon(new javax.swing.ImageIcon("C:\\Users\\PC\\Programming\\Java\\Employees Project && MySQL\\Layouts\\bg-purple.png")); // NOI18N
        container.add(rightLayout, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, 510, 410));

        leftLayout.setFont(new java.awt.Font("Meiryo UI", 1, 24)); // NOI18N
        leftLayout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        leftLayout.setIcon(new javax.swing.ImageIcon("C:\\Users\\PC\\Programming\\Java\\Employees Project && MySQL\\Layouts\\red-paper-airplane-fly-dark-blue-background_44481-304.jpg")); // NOI18N
        container.add(leftLayout, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 410));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(container, javax.swing.GroupLayout.PREFERRED_SIZE, 980, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(container, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void userNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userNameFieldActionPerformed

    private void userNameFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_userNameFieldFocusGained
        if (userNameField.getText().equals("İstifadəçi adını daxil edin")) {
            userNameField.setText("");
        }
    }//GEN-LAST:event_userNameFieldFocusGained

    private void userNameFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_userNameFieldFocusLost
        if (userNameField.getText().equals("")) {
            userNameField.setText("İstifadəçi adını daxil edin");
        }
    }//GEN-LAST:event_userNameFieldFocusLost

    private void passwordFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFieldFocusGained
        String password = new String(passwordField.getPassword());

        if (password.equals("       ")) {
            passwordField.setText("");
        }
    }//GEN-LAST:event_passwordFieldFocusGained

    private void passwordFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFieldFocusLost
        String password = new String(passwordField.getPassword());

        if (password.equals("")) {
            passwordField.setText("       ");
        }
    }//GEN-LAST:event_passwordFieldFocusLost

    private void loginButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginButtonMousePressed
        int me = evt.getButton();
        if (me == 1 && loginButtonEnable) {
            loginButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\PC\\Programming\\Java\\Employees Project && MySQL\\Icons\\icons8-checked-80.png"));
            String userName = userNameField.getText();
            String password = String.valueOf(passwordField.getPassword());
            if (!userName.trim().equals("") && !password.trim().equals("")) {
                boolean loginSuccess = eo.login(userName, password);
                if (loginSuccess) {
                    messageLabel1.setVisible(false);
                    messageLabel2.setVisible(false);
                    messageLabel3.setVisible(false);
                    setVisible(false);
                    EmployeesScreen employeesScreen = new EmployeesScreen(this, true);
                    employeesScreen.setVisible(true);
                    System.exit(0);
                } else {
                    loginButton.setEnabled(false);
                    loginButtonEnable = false;
                    messageLabel1.setVisible(true);
                    messageLabel2.setVisible(true);
                    messageLabel3.setVisible(true);
                }
            }
        }
    }//GEN-LAST:event_loginButtonMousePressed

    private void loginButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginButtonMouseReleased
        loginButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\PC\\Programming\\Java\\Employees Project && MySQL\\Icons\\icons8-ok-50.png"));
    }//GEN-LAST:event_loginButtonMouseReleased

    private void userNameFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userNameFieldKeyPressed
        spaceControlTimer.addActionListener((ActionEvent e) -> {
            spaceCharControl();
        });
        spaceControlTimer.start();
    }//GEN-LAST:event_userNameFieldKeyPressed

    private void userNameFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userNameFieldKeyTyped

    }//GEN-LAST:event_userNameFieldKeyTyped

    private void userNameFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userNameFieldKeyReleased
        spaceControlTimer.stop();
    }//GEN-LAST:event_userNameFieldKeyReleased

    private void passwordFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordFieldKeyPressed
        spaceControlTimer.addActionListener((ActionEvent e) -> {
            spaceCharControl();
        });
        spaceControlTimer.start();
    }//GEN-LAST:event_passwordFieldKeyPressed

    private void passwordFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordFieldKeyReleased
        spaceControlTimer.stop();
    }//GEN-LAST:event_passwordFieldKeyReleased

    private void passwordFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordFieldKeyTyped
        spaceControlTimer.addActionListener((ActionEvent e) -> {
            spaceCharControl();
        });
        spaceControlTimer.start();
    }//GEN-LAST:event_passwordFieldKeyTyped

    public static void startWriting() {
        if (increamentCount >= 3) {
            for (; i <= value.length(); i++) {
                if (level == 0 && i != value.length()) {
                    modernLabel.setText(String.valueOf(modernLabel.getText() + value.charAt(i)));
                    i++;
                } else if (level == 0 && i == value.length()) {
                    i = 0;
                    level++;
                    value = "Rahat";
                }

                if (level == 1 && i != value.length()) {
                    comfortLabel.setText(String.valueOf(comfortLabel.getText() + value.charAt(i)));
                    i++;
                } else if (level == 1 && i == value.length()) {
                    i = 0;
                    level++;
                    value = "Və sürətli";
                }

                if (level == 2 && i != value.length()) {
                    fastLabel.setText(String.valueOf(fastLabel.getText() + value.charAt(i)));
                    i++;
                } else if (level == 2 && i == value.length()) {
                    timer.stop();
                }
                return;
            }
        }
        increamentCount++;
    }

    public void spaceCharControl() {
        String password = new String(passwordField.getPassword());
        if (userNameField.getText().contains(" ")) {
            userNameField.setText(userNameField.getText().trim());
        }

        if (password.trim().equals("") && password.length() == 7) {
            return;
        }

        if (password.contains(" ")) {
            passwordField.setText(password.trim());
        }

        if (userNameField.getText().length() >= 3 && password.length() >= 6) {
            loginButtonEnable = true;
            loginButton.setEnabled(true);
        } else {
            loginButtonEnable = false;
            loginButton.setEnabled(false);
        }
    }

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
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginScreen().setVisible(true);
            }
        });
        timer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startWriting();
            }
        });
        timer.start();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JLabel comfortLabel;
    private javax.swing.JPanel container;
    private static javax.swing.JLabel fastLabel;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel leftLayout;
    private javax.swing.JLabel loginButton;
    private javax.swing.JLabel loginLabel;
    private javax.swing.JLabel messageLabel1;
    private javax.swing.JLabel messageLabel2;
    private javax.swing.JLabel messageLabel3;
    private static javax.swing.JLabel modernLabel;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel rightLayout;
    private javax.swing.JLabel signUpLabel;
    private javax.swing.JTextField userNameField;
    private javax.swing.JLabel userNameLabel;
    // End of variables declaration//GEN-END:variables
}
