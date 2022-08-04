package com.gui.frame;

import com.dao.operations.DepartmentManager;
import javax.swing.JOptionPane;

public class DepartmentAdd extends javax.swing.JFrame {

    DepartmentManager departmentManager = new DepartmentManager();
    boolean globalOpStatus;
    private String departmentConstructorName = null;
    private int departmentID = 0;

    public DepartmentAdd() {
        initComponents();
        setLocationRelativeTo(null);
    }

    public DepartmentAdd(String departmentName, int departmentID) {
        initComponents();
        setLocationRelativeTo(null);
        this.departmentConstructorName = departmentName;
        this.departmentID = departmentID;
        addDepartment.setText("Yenilə");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        container = new javax.swing.JPanel();
        departmentName = new javax.swing.JLabel();
        departmentNameField = new javax.swing.JTextField();
        addDepartment = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setFocusTraversalPolicyProvider(true);
        setMinimumSize(new java.awt.Dimension(337, 94));
        setResizable(false);

        container.setBackground(new java.awt.Color(255, 255, 255));

        departmentName.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        departmentName.setForeground(new java.awt.Color(0, 0, 0));
        departmentName.setText("Kafedra ad");

        departmentNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                departmentNameFieldActionPerformed(evt);
            }
        });

        addDepartment.setText("Əlavə et");
        addDepartment.setFocusPainted(false);
        addDepartment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDepartmentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout containerLayout = new javax.swing.GroupLayout(container);
        container.setLayout(containerLayout);
        containerLayout.setHorizontalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(departmentName)
                .addGap(18, 18, 18)
                .addComponent(departmentNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(addDepartment)
                .addGap(28, 28, 28))
        );
        containerLayout.setVerticalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(departmentName, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(departmentNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addDepartment))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void departmentNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_departmentNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_departmentNameFieldActionPerformed

    private void addDepartmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDepartmentActionPerformed
        if (departmentConstructorName != null && departmentID > 0) {
            updateDepartmentInformantion();
        } else {
            int nameLength = departmentNameField.getText().length();
            String name = departmentNameField.getText();
            if (nameLength > 0) {
                if (departmentManager.addDepartment(name)) {
                    JOptionPane.showMessageDialog(this, name + " kafedrası əlavə edildi.", "Əməliyyat uğurla icra olundu", WIDTH);
                }
            }
        }
    }//GEN-LAST:event_addDepartmentActionPerformed

    private void updateDepartmentInformantion() {
        int nameLength = departmentNameField.getText().length();
        String name = departmentNameField.getText();
        if (nameLength > 0) {
            if (departmentManager.updateDepartment(departmentID, name)) {
                JOptionPane.showMessageDialog(this, name + " kafedrası ilə əvəz edildi.", "Əməliyyat uğurla icra olundu", WIDTH);
            }
        }
    }

    public boolean isGlobalOpStatus() {
        return globalOpStatus;
    }

    public void setGlobalOpStatus(boolean globalOpStatus) {
        this.globalOpStatus = globalOpStatus;
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
            java.util.logging.Logger.getLogger(DepartmentAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DepartmentAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DepartmentAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DepartmentAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DepartmentAdd().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton addDepartment;
    private javax.swing.JPanel container;
    private javax.swing.JLabel departmentName;
    private javax.swing.JTextField departmentNameField;
    // End of variables declaration//GEN-END:variables
}
