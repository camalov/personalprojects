
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class EmployeesScreen extends javax.swing.JDialog {

    DefaultTableModel model;
    EmployeesOperations operations = new EmployeesOperations();

    public EmployeesScreen(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        InputSecurity.checkSession();
        setLocationRelativeTo(null);
        model = (DefaultTableModel) employeesTable.getModel();
        viewEmployees();
    }

    public void viewEmployees() {
        model.setRowCount(0);
        ArrayList<Employee> employees = new ArrayList<>();
        employees = operations.getEmployees();

        if (employees != null) {
            employees.forEach(employee -> {
                Object added[] = {employee.getId(), employee.getName(), employee.getSurname(), employee.getDepartment(), employee.getSalary()};
                model.addRow(added);
            });
        }
    }

    public void dynamicSearch(String searchingContent) {
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
        employeesTable.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(searchingContent));
        viewEmployees();
        //trs.setRowFilter(RowFilter.regexFilter(searchingContent, 4));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        container = new javax.swing.JPanel();
        employeeScrollPane = new javax.swing.JScrollPane();
        employeesTable = new javax.swing.JTable();
        searchingBox = new javax.swing.JTextField();
        searchLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        nameLabel = new javax.swing.JLabel();
        salaryLabel = new javax.swing.JLabel();
        surnameLabel = new javax.swing.JLabel();
        departmentLabel = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        surnameField = new javax.swing.JTextField();
        departmentField = new javax.swing.JTextField();
        salaryField = new javax.swing.JTextField();
        messageText = new javax.swing.JLabel();
        addEmployee = new javax.swing.JButton();
        updateInformation = new javax.swing.JButton();
        deleteEmployee = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("İşçilər");

        employeesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Ad", "Soyad", "Şöbə", "Maaş"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        employeesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                employeesTableMouseClicked(evt);
            }
        });
        employeeScrollPane.setViewportView(employeesTable);
        if (employeesTable.getColumnModel().getColumnCount() > 0) {
            employeesTable.getColumnModel().getColumn(0).setResizable(false);
            employeesTable.getColumnModel().getColumn(1).setResizable(false);
            employeesTable.getColumnModel().getColumn(2).setResizable(false);
            employeesTable.getColumnModel().getColumn(3).setResizable(false);
            employeesTable.getColumnModel().getColumn(4).setResizable(false);
        }

        searchingBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchingBoxKeyReleased(evt);
            }
        });

        searchLabel.setFont(new java.awt.Font("Meiryo UI", 1, 12)); // NOI18N
        searchLabel.setText("Axtarış");

        nameLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        nameLabel.setText("Ad");

        salaryLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        salaryLabel.setText("Maaş");

        surnameLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        surnameLabel.setText("Soyad");

        departmentLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        departmentLabel.setText("Şöbə");

        departmentField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                departmentFieldActionPerformed(evt);
            }
        });

        messageText.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        messageText.setForeground(new java.awt.Color(0, 102, 102));

        addEmployee.setText("İşçi Əlavə Et");
        addEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEmployeeActionPerformed(evt);
            }
        });

        updateInformation.setText("Məlumatı Yenilə");
        updateInformation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateInformationActionPerformed(evt);
            }
        });

        deleteEmployee.setText("Sil");
        deleteEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteEmployeeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout containerLayout = new javax.swing.GroupLayout(container);
        container.setLayout(containerLayout);
        containerLayout.setHorizontalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(employeeScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 844, Short.MAX_VALUE)
                    .addGroup(containerLayout.createSequentialGroup()
                        .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(salaryLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(departmentLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(surnameLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nameLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nameField)
                            .addComponent(surnameField)
                            .addComponent(departmentField)
                            .addComponent(salaryField, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, containerLayout.createSequentialGroup()
                                .addComponent(searchLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(searchingBox, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(messageText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, containerLayout.createSequentialGroup()
                                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(deleteEmployee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(updateInformation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(addEmployee, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE))
                                .addGap(35, 35, 35)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        containerLayout.setVerticalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, containerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchingBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nameField)
                        .addComponent(addEmployee)))
                .addGap(18, 18, 18)
                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(surnameField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(surnameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateInformation))
                .addGap(18, 18, 18)
                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(departmentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(departmentField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteEmployee))
                .addGap(18, 18, 18)
                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(salaryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(salaryField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(messageText, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addComponent(employeeScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void searchingBoxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchingBoxKeyReleased
        String searchingContent = searchingBox.getText();
        dynamicSearch(searchingContent);
    }//GEN-LAST:event_searchingBoxKeyReleased

    private void departmentFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_departmentFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_departmentFieldActionPerformed

    private void addEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEmployeeActionPerformed
        try {
            String name = nameField.getText();
            String surname = surnameField.getText();
            String department = departmentField.getText();
            float salary = Float.valueOf(salaryField.getText());

            if (!name.equals("") && !department.equals("") && !String.valueOf(salary).equals("")) {
                operations.addEmployee(name, surname, department, salary);
                messageText.setText(name + " adlı yeni işçi əlavə edildi.");
                viewEmployees();
            }
        } catch (NumberFormatException ex) {
            messageText.setText("Əməliyyatın icrası zamanı xəta baş verdi.");
        }
    }//GEN-LAST:event_addEmployeeActionPerformed

    private void employeesTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_employeesTableMouseClicked
        int selectedRow = employeesTable.getSelectedRow();

        nameField.setText(employeesTable.getValueAt(selectedRow, 1).toString());
        surnameField.setText(employeesTable.getValueAt(selectedRow, 2).toString());
        departmentField.setText(employeesTable.getValueAt(selectedRow, 3).toString());
        salaryField.setText(employeesTable.getValueAt(selectedRow, 4).toString());
    }//GEN-LAST:event_employeesTableMouseClicked

    private void updateInformationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateInformationActionPerformed
        try {
            int selectedRow = employeesTable.getSelectedRow();

            if (selectedRow == -1) {
                messageText.setForeground(Color.red);
                if (model.getRowCount() == 0) {
                    messageText.setText("İşçi siyahısı boşdur.");
                } else {
                    messageText.setText("Haqqında məlumatları yeniləcək işçini seçin.");
                }
            } else {
                String name = nameField.getText();
                String surname = surnameField.getText();
                String department = departmentField.getText();
                float salary = Float.valueOf(salaryField.getText());
                int id = (int) employeesTable.getValueAt(selectedRow, 0);

                if (!name.equals("") && !department.equals("") && !String.valueOf(salary).equals("")) {
                    operations.updateEmployee(id, name, surname, department, salary);
                    messageText.setText("İşçi haqqında məlumatlar yeniləndi.");
                    viewEmployees();
                }
            }
        } catch (NumberFormatException ex) {
            messageText.setText("Əməliyyatın icrası zamanı xəta baş verdi.");
        }
    }//GEN-LAST:event_updateInformationActionPerformed

    private void deleteEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteEmployeeActionPerformed
        try {
            int selectedRow = employeesTable.getSelectedRow();

            if (selectedRow == -1) {
                messageText.setForeground(Color.red);
                if (model.getRowCount() == 0) {
                    messageText.setText("İşçi siyahısı boşdur.");
                } else {
                    messageText.setText("Silinəcək işçini seçin.");
                }
            } else {
                String name = nameField.getText();
                int id = (int) employeesTable.getValueAt(selectedRow, 0);
                operations.deleteEmployee(id);
                messageText.setText(name + " adlı işçi silindi.");
                viewEmployees();
            }
        } catch (NumberFormatException ex) {
            messageText.setText("Əməliyyatın icrası zamanı xəta baş verdi.");
        }
    }//GEN-LAST:event_deleteEmployeeActionPerformed

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
            java.util.logging.Logger.getLogger(EmployeesScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeesScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeesScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeesScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EmployeesScreen dialog = new EmployeesScreen(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addEmployee;
    private javax.swing.JPanel container;
    private javax.swing.JButton deleteEmployee;
    private javax.swing.JTextField departmentField;
    private javax.swing.JLabel departmentLabel;
    private javax.swing.JScrollPane employeeScrollPane;
    private javax.swing.JTable employeesTable;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel messageText;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField salaryField;
    private javax.swing.JLabel salaryLabel;
    private javax.swing.JLabel searchLabel;
    private javax.swing.JTextField searchingBox;
    private javax.swing.JTextField surnameField;
    private javax.swing.JLabel surnameLabel;
    private javax.swing.JButton updateInformation;
    // End of variables declaration//GEN-END:variables
}
