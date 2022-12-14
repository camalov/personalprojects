package com.gui.frame;

import com.gui.elements.ImageParameters;
import java.awt.Color;
import java.awt.image.BufferedImage;
import static java.awt.image.ImageObserver.HEIGHT;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class TeacherDetailPanel extends javax.swing.JFrame {

    BufferedImage img;
    String filePath;
    String getFileFormat;

    public TeacherDetailPanel() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        deleteImg.setVisible(false);
        chooseImg.setVisible(false);
    }

    public void setValues(
            String teacherPhotoUrl,
            String teacherName,
            String teacherSurname,
            String birthDate,
            String teacherGraduate,
            int gender,
            String languages,
            String scientificName,
            String academicDegree,
            String department,
            String articleLocal,
            String articleOverseas,
            String tezis,
            String foreignCountries
    ) {
        //ImageIcon imageIcon = new ImageIcon();
        ImageParameters imageParameters;
        BufferedImage img;
        if (teacherPhotoUrl != null && teacherPhotoUrl != "") {
            try {
                img = ImageIO.read(new FileImageInputStream(new File(teacherPhotoUrl)));
                imageParameters = new ImageParameters(teacherPhotoUrl);
                teacherPhotoLabel.setIcon(new javax.swing.ImageIcon(imageParameters.resize(img, 121, 113)));
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Təsvirin oxunması zamanı xəta baş verdi. \nIOException", teacherPhotoUrl, HEIGHT);
            }
        }
        nameField.setText(teacherName);
        surnameField.setText(teacherSurname);
        birthDateField.setText(birthDate);
        teacherGraduateField.setText(teacherGraduate);

        if (gender == 1) {
            manRadioButton.setSelected(true);
        } else {
            womanRadioButton.setSelected(true);
        }

        if (!languages.isEmpty()) {
            if (languages.contains("İngilis")) {
                englishRadioButton.setSelected(true);
            }
            if (languages.contains("Rus")) {
                rusRadioButton.setSelected(true);
            }
            if (languages.contains("Alman")) {
                germanRadioButton.setSelected(true);
            }
            if (languages.contains("Fransız")) {
                frenchRadioButton.setSelected(true);
            }
        }
        academicDegreeBox.addItem(academicDegree);
        academicDegreeBox.setSelectedItem(academicDegree);
        scientificNameBox.addItem(scientificName);
        scientificNameBox.setSelectedItem(scientificName);
        deparmtentListBox.addItem(department);
        deparmtentListBox.setSelectedItem(department);
        localArticleTexteArea.setText(articleLocal);
        overseasArticleTexteArea.setText(articleOverseas);
        tezisTextArea.setText(tezis);
        foreignCountriesTeaxtArea.setText(foreignCountries);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        container = new javax.swing.JPanel();
        teacherPhotoLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        surnameLabel = new javax.swing.JLabel();
        surnameField = new javax.swing.JTextField();
        birthDateLabel = new javax.swing.JLabel();
        birthDateField = new javax.swing.JTextField();
        academicDegreeLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        departmentLabel = new javax.swing.JLabel();
        chooseImg = new javax.swing.JButton();
        deleteImg = new javax.swing.JButton();
        deparmtentListBox = new javax.swing.JComboBox<>();
        teacherGraduateLabel1 = new javax.swing.JLabel();
        teacherGraduateField = new javax.swing.JTextField();
        manRadioButton = new javax.swing.JRadioButton();
        womanRadioButton = new javax.swing.JRadioButton();
        genderRadioLabel = new javax.swing.JLabel();
        teacherGraduateLabel3 = new javax.swing.JLabel();
        englishRadioButton = new javax.swing.JRadioButton();
        rusRadioButton = new javax.swing.JRadioButton();
        frenchRadioButton = new javax.swing.JRadioButton();
        germanRadioButton = new javax.swing.JRadioButton();
        articlesLocalLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        localArticleTexteArea = new javax.swing.JTextArea();
        articlesLocalOverseas = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        overseasArticleTexteArea = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        tezisTextArea = new javax.swing.JTextArea();
        tezisLabel = new javax.swing.JLabel();
        foreignCountriesLabel = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        foreignCountriesTeaxtArea = new javax.swing.JTextArea();
        academicDegreeLabel1 = new javax.swing.JLabel();
        academicDegreeBox = new javax.swing.JComboBox<>();
        scientificNameBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        teacherPhotoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        teacherPhotoLabel.setMaximumSize(new java.awt.Dimension(110, 110));
        teacherPhotoLabel.setMinimumSize(new java.awt.Dimension(110, 110));

        nameLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        nameLabel.setText("Ad");

        nameField.setEditable(false);

        surnameLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        surnameLabel.setText("Soyad");

        surnameField.setEditable(false);

        birthDateLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        birthDateLabel.setText("Təvəllüd");

        birthDateField.setEditable(false);

        academicDegreeLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        academicDegreeLabel.setText("Elmi Dərəcə");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        departmentLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        departmentLabel.setText("Kafedra");

        chooseImg.setText("Şəkil seç");
        chooseImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseImgActionPerformed(evt);
            }
        });

        deleteImg.setText("Sil");
        deleteImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteImgActionPerformed(evt);
            }
        });

        teacherGraduateLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        teacherGraduateLabel1.setText("Təhsil");

        teacherGraduateField.setEditable(false);

        manRadioButton.setText("Kişi");
        manRadioButton.setEnabled(false);

        womanRadioButton.setText("Qadın");
        womanRadioButton.setEnabled(false);

        genderRadioLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        genderRadioLabel.setText("Cins");

        teacherGraduateLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        teacherGraduateLabel3.setText("Bildiyi dillər");

        englishRadioButton.setText("İngilis");
        englishRadioButton.setEnabled(false);

        rusRadioButton.setText("Rus");
        rusRadioButton.setEnabled(false);

        frenchRadioButton.setText("Fransız");
        frenchRadioButton.setEnabled(false);

        germanRadioButton.setText("Alman");
        germanRadioButton.setEnabled(false);

        articlesLocalLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        articlesLocalLabel.setText("Məqalələr (yerli)");

        localArticleTexteArea.setEditable(false);
        localArticleTexteArea.setColumns(20);
        localArticleTexteArea.setRows(5);
        jScrollPane1.setViewportView(localArticleTexteArea);

        articlesLocalOverseas.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        articlesLocalOverseas.setText("Məqalələr (xarici)");

        overseasArticleTexteArea.setEditable(false);
        overseasArticleTexteArea.setColumns(20);
        overseasArticleTexteArea.setRows(5);
        overseasArticleTexteArea.setToolTipText("");
        jScrollPane3.setViewportView(overseasArticleTexteArea);

        tezisTextArea.setEditable(false);
        tezisTextArea.setColumns(20);
        tezisTextArea.setRows(5);
        jScrollPane4.setViewportView(tezisTextArea);

        tezisLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        tezisLabel.setText("Tezis");

        foreignCountriesLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        foreignCountriesLabel.setText("Xaricdə olduğu ölkələr");

        foreignCountriesTeaxtArea.setEditable(false);
        foreignCountriesTeaxtArea.setColumns(20);
        foreignCountriesTeaxtArea.setRows(5);
        jScrollPane5.setViewportView(foreignCountriesTeaxtArea);

        academicDegreeLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        academicDegreeLabel1.setText("Elmi Ad");

        academicDegreeBox.setActionCommand("");
        academicDegreeBox.setEditor(null);
        academicDegreeBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                academicDegreeBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout containerLayout = new javax.swing.GroupLayout(container);
        container.setLayout(containerLayout);
        containerLayout.setHorizontalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(teacherPhotoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chooseImg, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteImg, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(containerLayout.createSequentialGroup()
                        .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameLabel)
                            .addComponent(surnameLabel)
                            .addComponent(birthDateLabel)
                            .addComponent(teacherGraduateLabel1)
                            .addComponent(teacherGraduateLabel3)
                            .addComponent(genderRadioLabel))
                        .addGap(37, 37, 37)
                        .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(birthDateField, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(surnameField, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(teacherGraduateField, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(containerLayout.createSequentialGroup()
                                .addComponent(manRadioButton)
                                .addGap(18, 18, 18)
                                .addComponent(womanRadioButton))
                            .addGroup(containerLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(englishRadioButton))
                            .addGroup(containerLayout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(rusRadioButton))
                            .addGroup(containerLayout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(frenchRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(germanRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(articlesLocalLabel)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(containerLayout.createSequentialGroup()
                        .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(academicDegreeLabel)
                            .addComponent(departmentLabel)
                            .addComponent(academicDegreeLabel1))
                        .addGap(36, 36, 36)
                        .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(deparmtentListBox, 0, 324, Short.MAX_VALUE)
                            .addComponent(academicDegreeBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(scientificNameBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tezisLabel)
                    .addComponent(articlesLocalOverseas)
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                    .addComponent(foreignCountriesLabel)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE))
                .addGap(12, 12, 12))
        );
        containerLayout.setVerticalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(containerLayout.createSequentialGroup()
                            .addComponent(teacherPhotoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(12, 12, 12)
                            .addComponent(chooseImg)
                            .addGap(12, 12, 12)
                            .addComponent(deleteImg))
                        .addGroup(containerLayout.createSequentialGroup()
                            .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(containerLayout.createSequentialGroup()
                                    .addComponent(nameLabel)
                                    .addGap(8, 8, 8)
                                    .addComponent(surnameLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(birthDateLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(teacherGraduateLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(genderRadioLabel)
                                    .addGap(18, 18, 18)
                                    .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(containerLayout.createSequentialGroup()
                                            .addComponent(teacherGraduateLabel3)
                                            .addGap(34, 34, 34)
                                            .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(academicDegreeLabel)
                                                .addComponent(academicDegreeBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(scientificNameBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(academicDegreeLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(containerLayout.createSequentialGroup()
                                                    .addComponent(deparmtentListBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGroup(containerLayout.createSequentialGroup()
                                                    .addComponent(departmentLabel)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(articlesLocalLabel)
                                                    .addGap(0, 0, Short.MAX_VALUE))))
                                        .addGroup(containerLayout.createSequentialGroup()
                                            .addComponent(tezisLabel)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(foreignCountriesLabel))))
                                .addGroup(containerLayout.createSequentialGroup()
                                    .addGap(4, 4, 4)
                                    .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(containerLayout.createSequentialGroup()
                                            .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(surnameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(birthDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(teacherGraduateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, 0)
                                            .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(manRadioButton)
                                                .addComponent(womanRadioButton)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, containerLayout.createSequentialGroup()
                                            .addComponent(articlesLocalOverseas)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(englishRadioButton)
                                        .addGroup(containerLayout.createSequentialGroup()
                                            .addGap(4, 4, 4)
                                            .addComponent(rusRadioButton))
                                        .addGroup(containerLayout.createSequentialGroup()
                                            .addGap(24, 24, 24)
                                            .addComponent(frenchRadioButton))
                                        .addGroup(containerLayout.createSequentialGroup()
                                            .addGap(24, 24, 24)
                                            .addComponent(germanRadioButton)))))
                            .addGap(9, 9, 9)
                            .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                                .addComponent(jScrollPane5)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(container, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void academicDegreeBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_academicDegreeBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_academicDegreeBoxActionPerformed

    private void deleteImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteImgActionPerformed
        // Delete image
        if (teacherPhotoLabel.getIcon() != null) {
            teacherPhotoLabel.setIcon(new javax.swing.ImageIcon());
            img = null;
            deleteImg.setEnabled(false);
        }
    }//GEN-LAST:event_deleteImgActionPerformed

    private void chooseImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseImgActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        int selectedFile = fileChooser.showOpenDialog(this);

        if (selectedFile == JFileChooser.APPROVE_OPTION) {
            filePath = fileChooser.getSelectedFile().getPath();
            getFileFormat = filePath.substring(filePath.length() - 3, filePath.length());

            if (!getFileFormat.toLowerCase().equals("jpg") && !getFileFormat.toLowerCase().equals("jpeg")) {
                JOptionPane.showMessageDialog(this, "JPG və ya JPEG uzantılı fayl daxil edin.", "Xəta", HEIGHT);
            } else {
                try {
                    img = ImageIO.read(new FileImageInputStream(new File(filePath)));
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Təsvirin oxunması zamanı xəta baş verdi. \nIOException", filePath, HEIGHT);
                }
                ImageParameters imgParameters = new ImageParameters(filePath);
                //teacherPhotoLabel.setIcon(new javax.swing.ImageIcon(filePath));
                teacherPhotoLabel.setIcon(new ImageIcon(imgParameters.resize(img, 121, 113)));
                deleteImg.setEnabled(true);
            }

        }
    }//GEN-LAST:event_chooseImgActionPerformed

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
            java.util.logging.Logger.getLogger(TeacherDetailPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TeacherDetailPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TeacherDetailPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TeacherDetailPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TeacherDetailPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> academicDegreeBox;
    private javax.swing.JLabel academicDegreeLabel;
    private javax.swing.JLabel academicDegreeLabel1;
    private javax.swing.JLabel articlesLocalLabel;
    private javax.swing.JLabel articlesLocalOverseas;
    private javax.swing.JTextField birthDateField;
    private javax.swing.JLabel birthDateLabel;
    private javax.swing.JButton chooseImg;
    private javax.swing.JPanel container;
    private javax.swing.JButton deleteImg;
    private javax.swing.JComboBox<String> deparmtentListBox;
    private javax.swing.JLabel departmentLabel;
    private javax.swing.JRadioButton englishRadioButton;
    private javax.swing.JLabel foreignCountriesLabel;
    private javax.swing.JTextArea foreignCountriesTeaxtArea;
    private javax.swing.JRadioButton frenchRadioButton;
    private javax.swing.JLabel genderRadioLabel;
    private javax.swing.JRadioButton germanRadioButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea localArticleTexteArea;
    private javax.swing.JRadioButton manRadioButton;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextArea overseasArticleTexteArea;
    private javax.swing.JRadioButton rusRadioButton;
    private javax.swing.JComboBox<String> scientificNameBox;
    private javax.swing.JTextField surnameField;
    private javax.swing.JLabel surnameLabel;
    private javax.swing.JTextField teacherGraduateField;
    private javax.swing.JLabel teacherGraduateLabel1;
    private javax.swing.JLabel teacherGraduateLabel3;
    private javax.swing.JLabel teacherPhotoLabel;
    private javax.swing.JLabel tezisLabel;
    private javax.swing.JTextArea tezisTextArea;
    private javax.swing.JRadioButton womanRadioButton;
    // End of variables declaration//GEN-END:variables
}
