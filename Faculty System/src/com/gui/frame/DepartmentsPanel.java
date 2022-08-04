package com.gui.frame;

import com.dao.objects.Department;
import com.dao.operations.DepartmentManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

public class DepartmentsPanel extends javax.swing.JInternalFrame {

    DepartmentAdd departmentAdd = new DepartmentAdd();
    DepartmentAdd departmentAddCons;
    DefaultTableModel model;
    DepartmentManager departmentManager = new DepartmentManager();
    private boolean anyRefreshTime;

    public DepartmentsPanel() {
        initComponents();
        model = (DefaultTableModel) departmentsTable.getModel();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI) this.getUI();
        bi.setNorthPane(null);
        viewDepartments();
    }

    public void viewDepartments() {
        ArrayList<Department> departments = new ArrayList<>();
        model.setRowCount(0);
        departments = departmentManager.getDepartments();

        if (departments != null) {
            departments.forEach(department -> {
                Object added[] = {
                    department.getId(),
                    department.getName(),
                    department.getTeacherCount(),
                    department.getGroupCount(),
                    department.getStudentCount(),
                    department.getStudentCount()
                };
                model.addRow(added);
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        container = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        departmentsTable = new javax.swing.JTable();
        deleteDepartment = new javax.swing.JButton();
        editDepartment = new javax.swing.JButton();
        addDepartment = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(702, 462));

        container.setBackground(new java.awt.Color(255, 255, 255));
        container.setPreferredSize(new java.awt.Dimension(702, 462));

        departmentsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Ad", "Müəllim Sayı", "Qrup Sayı", "Tələbə Sayı", "Fənn Sayı"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(departmentsTable);
        if (departmentsTable.getColumnModel().getColumnCount() > 0) {
            departmentsTable.getColumnModel().getColumn(0).setResizable(false);
            departmentsTable.getColumnModel().getColumn(1).setPreferredWidth(210);
            departmentsTable.getColumnModel().getColumn(2).setResizable(false);
            departmentsTable.getColumnModel().getColumn(3).setResizable(false);
            departmentsTable.getColumnModel().getColumn(4).setResizable(false);
            departmentsTable.getColumnModel().getColumn(5).setResizable(false);
        }

        deleteDepartment.setText("Sil");
        deleteDepartment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteDepartmentActionPerformed(evt);
            }
        });

        editDepartment.setText("Redaktə et");
        editDepartment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editDepartmentActionPerformed(evt);
            }
        });

        addDepartment.setText("Əlavə et");
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
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(containerLayout.createSequentialGroup()
                        .addComponent(addDepartment)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editDepartment)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteDepartment))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 936, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        containerLayout.setVerticalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, containerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteDepartment)
                    .addComponent(editDepartment)
                    .addComponent(addDepartment))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, 982, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deleteDepartmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteDepartmentActionPerformed
        int selectedRow = departmentsTable.getSelectedRow();

        if (selectedRow == -1) {
            if (model.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Siyahı boşdur.", "Xəta", HEIGHT);
            } else {
                JOptionPane.showMessageDialog(this, "Silinəcək kafedranı seçin.", "Kafedra seçin", HEIGHT);
            }
        } else {
            String departmentName = model.getValueAt(selectedRow, 1).toString();
            int checkSelected = JOptionPane.showConfirmDialog(this, departmentName + " kafedrası silinsin ?", "Sorğu", HEIGHT);

            if (checkSelected == 0) {
                if (departmentManager.deleteDepartment((int) model.getValueAt(selectedRow, 0))) {
                    anyRefreshTime = true;
                    departmentTableUpdateTimer();
                    JOptionPane.showMessageDialog(this, departmentName + " kafedrası silindi.", "Əməliyyat uğurla icra olundu", WIDTH);
                }
            }
        }
    }//GEN-LAST:event_deleteDepartmentActionPerformed

    private void editDepartmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editDepartmentActionPerformed
        int selectedRow = departmentsTable.getSelectedRow();

        if (selectedRow == -1) {
            if (model.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Siyahı boşdur.", "Xəta", HEIGHT);
            } else {
                JOptionPane.showMessageDialog(this, "Məlumatları yenilənəcək kafedranı seçin.", "Kafedra seçin", HEIGHT);
            }
        } else {
            String departmentName = model.getValueAt(selectedRow, 1).toString();
            int checkSelected = JOptionPane.showConfirmDialog(this, departmentName + " kafedrası yenilənsin ?", "Sorğu", HEIGHT);

            if (checkSelected == 0) {
                departmentAddCons = new DepartmentAdd(departmentName, (int) model.getValueAt(selectedRow, 0));
                departmentAddCons.setVisible(true);
                departmentTableUpdateTimer();
            }
        }
    }//GEN-LAST:event_editDepartmentActionPerformed

    private void addDepartmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDepartmentActionPerformed
        departmentAdd.setVisible(true);
        departmentTableUpdateTimer();
    }//GEN-LAST:event_addDepartmentActionPerformed

    public void departmentTableUpdateTimer() {
        Timer timer = new Timer(1000, null);
        timer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewDepartments();
                if ((departmentAdd != null && departmentAdd.isShowing()) 
                        || (departmentAddCons != null && departmentAddCons.isShowing())) {
                    return;
                } else if (anyRefreshTime) {
                    anyRefreshTime = false;
                } else {
                    timer.stop();
                }
            }
        });
        timer.start();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addDepartment;
    private javax.swing.JPanel container;
    private javax.swing.JButton deleteDepartment;
    private javax.swing.JTable departmentsTable;
    private javax.swing.JButton editDepartment;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
