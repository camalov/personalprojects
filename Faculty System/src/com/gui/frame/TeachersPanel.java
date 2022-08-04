package com.gui.frame;

import com.dao.objects.Teacher;
import com.dao.operations.TeachersManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.regex.PatternSyntaxException;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.Timer;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class TeachersPanel extends javax.swing.JInternalFrame {

    DefaultTableModel model;
    TeachersManager teachersManager = new TeachersManager();
    TeacherDetailPanel teacherDetailPanel;
    TeacherAddPanel teacherAddPanel;
    TeacherUpdatePanel teacherUpdatePanel;
    ArrayList<String> imgPath = new ArrayList<String>();
    ArrayList<String> articleLocal = new ArrayList<>();
    ArrayList<String> articleOverseas = new ArrayList<>();
    ArrayList<String> tezis = new ArrayList<>();
    ArrayList<String> foreignCountries = new ArrayList<>();
    ArrayList<Integer> gender = new ArrayList<>();
    ArrayList<String> languages = new ArrayList<>();
    boolean anyRefreshTime;

    public TeachersPanel() {
        initComponents();
        // Border, kənar əlavələrin ləğvi
        setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI) this.getUI();
        bi.setNorthPane(null);

        model = (DefaultTableModel) teachersTable.getModel();
        viewTeachers();
    }

    public void viewTeachers() {
        // if (isShowing()) {
        model.setRowCount(0);
        ArrayList<Teacher> teachers = new ArrayList<>();
        teachers = teachersManager.getTeachers();
        if (!teachers.isEmpty()) {
            imgPath.removeAll(imgPath);
            ArrayList<String> availableDeparments = new ArrayList<>();

            teachers.forEach(teacher -> {
                imgPath.add(teacher.getTeacherPhotoUrl());
                Object added[] = {
                    teacher.getId(),
                    "           *",
                    teacher.getTeacherName(),
                    teacher.getTeacherSurname(),
                    teacher.getBirthDate(),
                    teacher.getTeacherGraduateWT(),
                    teacher.getScientificName(),
                    teacher.getAcademicDegree(),
                    teacher.getDepartment()
                };
                articleLocal.add(teacher.getArticleLocal());
                articleOverseas.add(teacher.getArticleOverseas());
                tezis.add(teacher.getTezis());
                foreignCountries.add(teacher.getForeignCountries());
                gender.add(teacher.getGender());
                languages.add(teacher.getLanguages());
                model.addRow(added);

            });
        }
        //}
    }

    public void teacherTableUpdateTimer() {
        Timer timer = new Timer(1000, null);
        timer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                teachersManager = new TeachersManager();
                articleLocal = new ArrayList<>();
                articleOverseas = new ArrayList<>();
                tezis = new ArrayList<>();
                foreignCountries = new ArrayList<>();
                gender = new ArrayList<>();
                languages = new ArrayList<>();
                viewTeachers();
                if ((teacherAddPanel != null && teacherAddPanel.isShowing()) || (teacherUpdatePanel != null && teacherUpdatePanel.isShowing())) {
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        container = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        teachersTable = new javax.swing.JTable();
        deleteTeacher = new javax.swing.JButton();
        editTeacher = new javax.swing.JButton();
        addTeacher = new javax.swing.JButton();
        detail = new javax.swing.JButton();
        searchingBox = new javax.swing.JTextField();

        container.setBackground(new java.awt.Color(255, 255, 255));
        container.setPreferredSize(new java.awt.Dimension(702, 462));

        teachersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Şəkil", "Ad", "Soyad", "Təvəllüd", "Təhsil", "Elmi Dərəcə", "Elmi Ad", "Kafedra"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(teachersTable);

        deleteTeacher.setText("Sil");
        deleteTeacher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteTeacherActionPerformed(evt);
            }
        });

        editTeacher.setText("Redaktə et");
        editTeacher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editTeacherActionPerformed(evt);
            }
        });

        addTeacher.setText("Əlavə et");
        addTeacher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTeacherActionPerformed(evt);
            }
        });

        detail.setText("Daha Ətraflı");
        detail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailActionPerformed(evt);
            }
        });

        searchingBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchingBoxKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchingBoxKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout containerLayout = new javax.swing.GroupLayout(container);
        container.setLayout(containerLayout);
        containerLayout.setHorizontalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(containerLayout.createSequentialGroup()
                        .addComponent(detail)
                        .addGap(114, 114, 114)
                        .addComponent(searchingBox, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addTeacher)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editTeacher)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteTeacher))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 936, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        containerLayout.setVerticalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, containerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(deleteTeacher)
                        .addComponent(editTeacher)
                        .addComponent(addTeacher)
                        .addComponent(detail))
                    .addComponent(searchingBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, 948, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Daha ətraflı pəncərəsi
    private void detailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailActionPerformed
        int selectedRow = teachersTable.getSelectedRow();

        if (selectedRow == -1) {
            if (model.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Müəllim siyahısı boşdur.", "Boş siyahı", HEIGHT);
            } else {
                JOptionPane.showMessageDialog(this, "Haqqında daha ətraflı məlumat üçün müəllim seçin.", "Müəllim seçin", HEIGHT);
            }
        } else {
            String imgPath = this.imgPath.get(selectedRow);
            String teacherName = model.getValueAt(selectedRow, 2).toString();
            String teacherSurname = model.getValueAt(selectedRow, 3).toString();
            String birthDate = model.getValueAt(selectedRow, 4).toString();
            String teacherGraduateWT = model.getValueAt(selectedRow, 5).toString();
            String scientificName = model.getValueAt(selectedRow, 6).toString();
            String academicDegree = model.getValueAt(selectedRow, 7).toString();
            String department = model.getValueAt(selectedRow, 8).toString();
            String articleLocal = this.articleLocal.get(selectedRow);
            String articleOverseas = this.articleOverseas.get(selectedRow);
            String tezis = this.tezis.get(selectedRow);
            String foreignCountries = this.foreignCountries.get(selectedRow);
            int gender = this.gender.get(selectedRow);
            String languages = this.languages.get(selectedRow);

            if (teacherDetailPanel == null) {
                teacherDetailPanel = new TeacherDetailPanel();
            } else {
                teacherDetailPanel = null;
                teacherDetailPanel = new TeacherDetailPanel();
            }

            teacherDetailPanel.setValues(
                    imgPath,
                    teacherName,
                    teacherSurname,
                    birthDate,
                    teacherGraduateWT,
                    gender,
                    languages,
                    academicDegree,
                    scientificName,
                    department,
                    articleLocal,
                    articleOverseas,
                    tezis,
                    foreignCountries
            );
            teacherDetailPanel.setVisible(true);
        }
    }//GEN-LAST:event_detailActionPerformed

    private void addTeacherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTeacherActionPerformed
        if (teacherAddPanel != null) {
            teacherAddPanel = null;
        }
        teacherAddPanel = new TeacherAddPanel();
        teacherAddPanel.setVisible(true);
        teacherTableUpdateTimer();
    }//GEN-LAST:event_addTeacherActionPerformed

    private void deleteTeacherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteTeacherActionPerformed
        // Seçilmiş müəllimin silinməsi.
        int selectedRowIndex = teachersTable.getSelectedRow();

        if (selectedRowIndex == -1) {
            if (model.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Siyahı boşdur.", "Xəta", HEIGHT);
            } else {
                JOptionPane.showMessageDialog(this, "Silinəcək müəllimi  seçin.", "Müəllimi seçin", HEIGHT);
            }
        } else {
            String teacherName = model.getValueAt(teachersTable.getSelectedRow(), 2).toString();
            int checkSelected = JOptionPane.showConfirmDialog(this, "Silmək istədiyinizə əminsiniz ?", "Sorğu", HEIGHT);
            int selectedRows[] = teachersTable.getSelectedRows();
            ArrayList<Integer> selectedRowsIndex = new ArrayList<>();
            ArrayList<String> deletedPhotos = new ArrayList<>();

            if (checkSelected == 0) {
                for (int selectedRow : selectedRows) {
                    int id = Integer.valueOf(model.getValueAt(selectedRow, 0).toString());
                    selectedRowsIndex.add(id);
                    if (imgPath.contains(imgPath.get(selectedRow))) {
                        deletedPhotos.add(imgPath.get(selectedRow));
                        System.out.println("Added\n" + imgPath.get(selectedRow));
                    }
                }
                int i = 0;
                if (teachersManager.deleteTeacher(selectedRowsIndex)) {
                    if (!deletedPhotos.isEmpty()) {
                        for (String imgPath : deletedPhotos) {
                            File file = new File(imgPath);
                            file.delete();
                        }/*
                        deletedPhotos.forEach(img -> {
                            if (img != null) {
                                File file = new File(img);
                                file.delete();
                                System.out.println("deleted");
                            }
                        });
                         */
                    }

                    anyRefreshTime = true;
                    teacherTableUpdateTimer();
                    if (selectedRows.length > 1) {
                        JOptionPane.showMessageDialog(this, "Seçilmiş müəllimlər silindi.", "Əməliyyat uğurla icra olundu", WIDTH);
                    } else {
                        JOptionPane.showMessageDialog(this, teacherName + " müəllimlər siyahısından silindi.", "Əməliyyat uğurla icra olundu", WIDTH);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Silinmə zamanı xəta baş verdi.", "Xəta", WIDTH);
                }
            }
        }
    }//GEN-LAST:event_deleteTeacherActionPerformed

    private void editTeacherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editTeacherActionPerformed
        int selectedRow = teachersTable.getSelectedRow();

        if (selectedRow == -1) {
            if (model.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Müəllim siyahısı boşdur.", "Boş siyahı", HEIGHT);
            } else {
                JOptionPane.showMessageDialog(this, "Haqqında məlumatı yenilənəcək müəllimi seçin.", "Müəllim seçin", HEIGHT);
            }
        } else {
            int id = (int) model.getValueAt(selectedRow, 0);
            String imgPath = this.imgPath.get(selectedRow);
            String teacherName = model.getValueAt(selectedRow, 2).toString();
            String teacherSurname = model.getValueAt(selectedRow, 3).toString();
            String birthDate = model.getValueAt(selectedRow, 4).toString();
            String teacherGraduateWT = model.getValueAt(selectedRow, 5).toString();
            String scientificName = model.getValueAt(selectedRow, 6).toString();
            String academicDegree = model.getValueAt(selectedRow, 7).toString();
            String department = model.getValueAt(selectedRow, 8).toString();
            String articleLocal = this.articleLocal.get(selectedRow);
            String articleOverseas = this.articleOverseas.get(selectedRow);
            String tezis = this.tezis.get(selectedRow);
            String foreignCountries = this.foreignCountries.get(selectedRow);
            int gender = this.gender.get(selectedRow);
            String languages = this.languages.get(selectedRow);

            if (teacherAddPanel != null) {
                teacherAddPanel = null;
            }
            teacherUpdatePanel = new TeacherUpdatePanel(
                    id,
                    imgPath,
                    teacherName,
                    teacherSurname,
                    birthDate,
                    teacherGraduateWT,
                    gender,
                    languages,
                    academicDegree,
                    scientificName,
                    department,
                    articleLocal,
                    articleOverseas,
                    tezis,
                    foreignCountries);
            teacherUpdatePanel.setVisible(true);
            teacherTableUpdateTimer();
        }
    }//GEN-LAST:event_editTeacherActionPerformed

    private void searchingBoxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchingBoxKeyTyped
        String searchingContent = searchingBox.getText();
        dynamicSearch(searchingContent);
    }//GEN-LAST:event_searchingBoxKeyTyped

    private void searchingBoxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchingBoxKeyReleased
        String searchingContent = searchingBox.getText();
        dynamicSearch(searchingContent);
    }//GEN-LAST:event_searchingBoxKeyReleased

    public void dynamicSearch(String searchingContent) {
        try {
            TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
            teachersTable.setRowSorter(trs);
            trs.setRowFilter(RowFilter.regexFilter(searchingContent));
            viewTeachers();
        } catch (PatternSyntaxException ex) {

        }
        //trs.setRowFilter(RowFilter.regexFilter(searchingContent, 4));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addTeacher;
    private javax.swing.JPanel container;
    private javax.swing.JButton deleteTeacher;
    private javax.swing.JButton detail;
    private javax.swing.JButton editTeacher;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField searchingBox;
    private javax.swing.JTable teachersTable;
    // End of variables declaration//GEN-END:variables
}
