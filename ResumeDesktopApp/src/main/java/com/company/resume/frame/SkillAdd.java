/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.company.resume.frame;

import com.company.dao.inter.SkillDaoInter;
import com.company.entity.Skill;
import com.company.entity.User;
import com.company.entity.UserSkill;
import com.company.main.Context;
import com.company.resume.config.Config;
import com.company.resume.main.MainUser;
import com.company.resume.entityUI.SkillUI;
import com.formdev.flatlaf.FlatLightLaf;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author PC
 */
public class SkillAdd extends javax.swing.JFrame {

    SkillDaoInter skillDao = Context.instanceSkillDao();

    /**
     * Creates new form SkillAdd
     */
    public SkillAdd() {
        initComponents();
        fillWindow();
    }

    private void fillWindow() {
        List<Skill> skills = skillDao.getAll();
        cbSkill.addItem(null);
        skills.forEach(skill -> cbSkill.addItem(new SkillUI(skill)));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlSkill = new javax.swing.JPanel();
        lblSkill = new javax.swing.JLabel();
        cbSkill = new javax.swing.JComboBox<>();
        sliderSkillPower = new javax.swing.JSlider();
        txtSkill = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        lblPower = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        lblSkill.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSkill.setText("Skill :");

        cbSkill.setToolTipText("");

        sliderSkillPower.setMaximum(10);
        sliderSkillPower.setMinimum(1);
        sliderSkillPower.setToolTipText("1");
        sliderSkillPower.setValue(1);
        sliderSkillPower.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderSkillPowerStateChanged(evt);
            }
        });

        txtSkill.setToolTipText("Skill");

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        lblPower.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblPower.setText("Power :");

        javax.swing.GroupLayout pnlSkillLayout = new javax.swing.GroupLayout(pnlSkill);
        pnlSkill.setLayout(pnlSkillLayout);
        pnlSkillLayout.setHorizontalGroup(
            pnlSkillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSkillLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSkillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPower)
                    .addComponent(lblSkill, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlSkillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlSkillLayout.createSequentialGroup()
                        .addComponent(cbSkill, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(txtSkill, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(sliderSkillPower, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAdd)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlSkillLayout.setVerticalGroup(
            pnlSkillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSkillLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSkillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbSkill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSkill, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSkill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlSkillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sliderSkillPower, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd)
                    .addComponent(lblPower))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlSkill, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlSkill, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void sliderSkillPowerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderSkillPowerStateChanged
        // TODO add your handling code here:
        sliderSkillPower.setToolTipText(new Integer(sliderSkillPower.getValue()).toString());
    }//GEN-LAST:event_sliderSkillPowerStateChanged

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        callAdd();
    }//GEN-LAST:event_btnAddActionPerformed

    private void callAdd() {
        if (cbSkill.getSelectedItem() != null) {
            int resultId = addUserSkill((Skill) cbSkill.getSelectedItem());

            if (resultId < 0) {
                JOptionPane.showMessageDialog(rootPane, "This skill has already been noted", "Existing skill", HEIGHT);
            }
        }

        if (!txtSkill.getText().trim().isEmpty()) {
            Skill skill = fillSkill();
            int resultId = addSkill();

            if (resultId < 0) {
                JOptionPane.showMessageDialog(rootPane, "This skill is present in the system", "Existing skill", HEIGHT);
                return;
            }

            skill.setId(resultId);
            addUserSkill(skill);
            cbSkill.addItem(new SkillUI(skill));
        }
    }

    private int addUserSkill(Skill skill) {
        return Context.instanceUserSkillDao().addUserSkill(fillUserSkill(skill));
    }

    private int addSkill() {
        return Context.instanceSkillDao().addSkill(fillSkill());
    }

    private UserSkill fillUserSkill(Skill skill) {
        User user = Config.loggedInUser;
        int power = sliderSkillPower.getValue();

        UserSkill userSkill = new UserSkill();
        userSkill.setUser(user);
        userSkill.setSkill(skill);
        userSkill.setPower(power);

        return userSkill;
    }

    private Skill fillSkill() {
        Skill skill = new Skill();
        skill.setName(txtSkill.getText());

        return skill;
    }

    /**
     * @param args the command line arguments
     */
    public static void showWindow() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(MainUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SkillAdd().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JComboBox<Skill> cbSkill;
    private javax.swing.JLabel lblPower;
    private javax.swing.JLabel lblSkill;
    private javax.swing.JPanel pnlSkill;
    private javax.swing.JSlider sliderSkillPower;
    private javax.swing.JTextField txtSkill;
    // End of variables declaration//GEN-END:variables
}