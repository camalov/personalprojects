package com.gui.frame;

import com.gui.elements.FontManager;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

public class DropdownSidebar extends javax.swing.JFrame {

    FontManager fontManager;
    DepartmentsPanel dp = new DepartmentsPanel();
    TeachersPanel teachersPanel = new TeachersPanel();
    DepartmentAdd da = new DepartmentAdd();
    ArrayList<JLabel> menuLabels = new ArrayList<>();
    ArrayList<JInternalFrame> internalFrames = new ArrayList<>();

    public DropdownSidebar() {
        initComponents();
        setLocationRelativeTo(null);
        // Menu Label'ları
        menuLabels.add(deparmentsLabel);
        menuLabels.add(teachersLabel);
        menuLabels.add(teachingSubjects);
        menuLabels.add(specialties);

        // InternalFrame'lər
        internalFrames.add(dp);
        internalFrames.add(teachersPanel);

        // Font
        String fontRobotoBlackURL
                = "C:\\Users\\PC\\Projects\\Desktop\\Java\\Faculty System\\Fonts\\Roboto\\Roboto-Medium.ttf";
        startingWindow();
        //dp.setSize(jPanel4.getSize());
        // da.setSize(1052, da.getHeight());
        //jPanel4.removeAll();
        //jPanel4.add(da).setVisible(true);
    }

    public void startingWindow() {
        //dashboard.removeAll();
        //setOfClickedMenu(deparmentsLabel);
        //dashboard.add(dp).setVisible(true);
        //dashboard.setSize(dp.getWidth() + 50, dp.getHeight());

        setOfClickedMenu(deparmentsLabel);
        addInternalFrame(dp);
    }

    private void setOfClickedMenu(JLabel menuLabel) {
        menuLabels.forEach(menu -> {
            if (menu.getText().equals(menuLabel.getText())) {
                menu.setBackground(new Color(78, 133, 227));
                menu.setOpaque(true);
            } else {
                menu.setBackground(new Color(44, 53, 76));
                menu.setOpaque(false);
            }
        });
    }

    private void addInternalFrame(JInternalFrame internalFrame) {
        if (dashboard != null) {
            dashboard.removeAll();
        }
        internalFrames.forEach(frame -> {
            if (frame.equals(internalFrame)) {
                dashboard.add(frame).setVisible(true);
                dashboard.setSize(dp.getWidth() + 50, dp.getHeight());
            } else {
                frame.setVisible(false);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        container2 = new javax.swing.JPanel();
        menuBar = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        deparmentsLabel = new javax.swing.JLabel();
        teachersLabel = new javax.swing.JLabel();
        teachingSubjects = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        userProfileMenuIcon = new javax.swing.JLabel();
        exitMenuIcon = new javax.swing.JLabel();
        specialties = new javax.swing.JLabel();
        dashboard = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1310, 462));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        menuBar.setBackground(new java.awt.Color(35, 42, 60));
        menuBar.setPreferredSize(new java.awt.Dimension(50, 350));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\PC\\Projects\\Desktop\\Java\\Faculty System\\Icons\\university_32px.png")); // NOI18N

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\PC\\Projects\\Desktop\\Java\\Faculty System\\Icons\\dashboard_32px.png")); // NOI18N

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\PC\\Projects\\Desktop\\Java\\Faculty System\\Icons\\department_32px.png")); // NOI18N

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\PC\\Projects\\Desktop\\Java\\Faculty System\\Icons\\ClickedMenuSidebarIcons\\student_male_32px.png")); // NOI18N

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\PC\\Projects\\Desktop\\Java\\Faculty System\\Icons\\scorecard_32px.png")); // NOI18N

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\PC\\Projects\\Desktop\\Java\\Faculty System\\Icons\\ClickedMenuSidebarIcons\\scholarship_32px.png")); // NOI18N

        javax.swing.GroupLayout menuBarLayout = new javax.swing.GroupLayout(menuBar);
        menuBar.setLayout(menuBarLayout);
        menuBarLayout.setHorizontalGroup(
            menuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuBarLayout.createSequentialGroup()
                .addGroup(menuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(menuBarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
        );
        menuBarLayout.setVerticalGroup(
            menuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuBarLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(45, 45, 45)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(162, 162, 162))
        );

        jPanel1.setBackground(new java.awt.Color(44, 53, 76));

        deparmentsLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        deparmentsLabel.setForeground(new java.awt.Color(255, 255, 255));
        deparmentsLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        deparmentsLabel.setText("Kafedralar");
        deparmentsLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deparmentsLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deparmentsLabelMouseClicked(evt);
            }
        });

        teachersLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        teachersLabel.setForeground(new java.awt.Color(255, 255, 255));
        teachersLabel.setText("Müəllimlər");
        teachersLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        teachersLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                teachersLabelMouseClicked(evt);
            }
        });

        teachingSubjects.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        teachingSubjects.setForeground(new java.awt.Color(255, 255, 255));
        teachingSubjects.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        teachingSubjects.setText("Tədris Fənnləri");
        teachingSubjects.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        teachingSubjects.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                teachingSubjectsMouseClicked(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(35, 42, 60));

        userProfileMenuIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        userProfileMenuIcon.setIcon(new javax.swing.ImageIcon("C:\\Users\\PC\\Projects\\Desktop\\Java\\Faculty System\\Icons\\SidebarBottomIcons\\male_user_40px.png")); // NOI18N

        exitMenuIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exitMenuIcon.setIcon(new javax.swing.ImageIcon("C:\\Users\\PC\\Projects\\Desktop\\Java\\Faculty System\\Icons\\SidebarBottomIcons\\exit_32px.png")); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(userProfileMenuIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                    .addComponent(exitMenuIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(userProfileMenuIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(exitMenuIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap()))
        );

        specialties.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        specialties.setForeground(new java.awt.Color(255, 255, 255));
        specialties.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        specialties.setText("İxtisaslar");
        specialties.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        specialties.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                specialtiesMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(teachingSubjects, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(specialties)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(deparmentsLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(teachersLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(deparmentsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(teachersLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(teachingSubjects, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(specialties)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout container2Layout = new javax.swing.GroupLayout(container2);
        container2.setLayout(container2Layout);
        container2Layout.setHorizontalGroup(
            container2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(container2Layout.createSequentialGroup()
                .addComponent(menuBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        container2Layout.setVerticalGroup(
            container2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(menuBar, javax.swing.GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)
        );

        dashboard.setBackground(new java.awt.Color(255, 255, 255));
        dashboard.setMinimumSize(new java.awt.Dimension(1052, 462));
        dashboard.setName(""); // NOI18N

        javax.swing.GroupLayout dashboardLayout = new javax.swing.GroupLayout(dashboard);
        dashboard.setLayout(dashboardLayout);
        dashboardLayout.setHorizontalGroup(
            dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1052, Short.MAX_VALUE)
        );
        dashboardLayout.setVerticalGroup(
            dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(container2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(dashboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(container2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(dashboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        if (dp != null) {
            dp.setSize(dashboard.getSize());
        }
        if (da != null) {
            da.setSize(dashboard.getSize());
        }
        if (teachersPanel != null) {
            teachersPanel.setSize(dashboard.getSize());
        }
    }//GEN-LAST:event_formComponentResized

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        //MainPage mp = new MainPage();
        //mp.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
    }//GEN-LAST:event_formWindowClosing

    private void teachersLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_teachersLabelMouseClicked
        int getClickedButton = evt.getButton();

        if (getClickedButton == 1) {
            setOfClickedMenu(teachersLabel);
            teachersPanel.viewTeachers();
            if (teachersPanel.imgPath == null) {
                // Keçidlərdə yenilənmə
            }
            addInternalFrame(teachersPanel);
        }
    }//GEN-LAST:event_teachersLabelMouseClicked

    private void teachingSubjectsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_teachingSubjectsMouseClicked
        int getClickedButton = evt.getButton();

        if (getClickedButton == 1) {
            setOfClickedMenu(teachingSubjects);
        }
    }//GEN-LAST:event_teachingSubjectsMouseClicked

    private void specialtiesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_specialtiesMouseClicked
        int getClickedButton = evt.getButton();

        if (getClickedButton == 1) {
            setOfClickedMenu(specialties);
        }
    }//GEN-LAST:event_specialtiesMouseClicked

    private void deparmentsLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deparmentsLabelMouseClicked
        int getClickedButton = evt.getButton();

        if (getClickedButton == 1) {
            setOfClickedMenu(deparmentsLabel);
            //keçidlərdə yenilənmə dp.view..();
            dp.viewDepartments();
            addInternalFrame(dp);
        }
    }//GEN-LAST:event_deparmentsLabelMouseClicked

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
            java.util.logging.Logger.getLogger(DropdownSidebar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DropdownSidebar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DropdownSidebar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DropdownSidebar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DropdownSidebar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel container2;
    private javax.swing.JPanel dashboard;
    private javax.swing.JLabel deparmentsLabel;
    private javax.swing.JLabel exitMenuIcon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel menuBar;
    private javax.swing.JLabel specialties;
    private javax.swing.JLabel teachersLabel;
    private javax.swing.JLabel teachingSubjects;
    private javax.swing.JLabel userProfileMenuIcon;
    // End of variables declaration//GEN-END:variables
}
