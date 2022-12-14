package com.gui.frame;

import com.dao.objects.Department;
import com.dao.operations.DepartmentManager;
import com.dao.operations.TeachersManager;
import com.gui.elements.ImageParameters;
import java.awt.image.BufferedImage;
import static java.awt.image.ImageObserver.HEIGHT;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class TeacherAddPanel extends javax.swing.JFrame {

    BufferedImage img;
    String filePath;
    String getFileFormat;
    DefaultComboBoxModel<Object> departmentBoxModel;
    TeachersManager teachersManager = new TeachersManager();
    DepartmentManager departmentManager = new DepartmentManager();
    ArrayList<Department> departments = new ArrayList<>();
    ArrayList<String> selectedLanguages = new ArrayList<>();
    int setSizeNum = 20, selectedGender = 1;

    public TeacherAddPanel() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);

        //listModel = (DefaultListModel) departmetList.getModel();
        departmentBoxModel = (DefaultComboBoxModel) deparmtentListBox.getModel();
        deleteImg.setEnabled(false);
        getReadyInfo();

    }

    /*
    public TeacherAddPanel(
            String teacherPhotoUrl,
            String teacherName,
            String teacherSurname,
            String birthDate,
            String teacherGraduate,
            String specialty,
            String academicDegree,
            String department,
            String lessonTime,
            String salary,
            String numberOfSub,
            String numberOfGroups
    ) {

        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        //listModel = (DefaultListModel) departmetList.getModel();
        departmentBoxModel = (DefaultComboBoxModel) deparmtentListBox.getModel();
        deleteImg.setEnabled(false);

        ImageParameters imageParameters;
        BufferedImage img;
        if (teacherPhotoUrl != null && teacherPhotoUrl != "") {
            System.out.println(teacherName);
            try {
                img = ImageIO.read(new FileImageInputStream(new File(teacherPhotoUrl)));
                imageParameters = new ImageParameters(teacherPhotoUrl);
                teacherPhotoLabel.setIcon(new javax.swing.ImageIcon(imageParameters.resize(img, 121, 113)));
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "T??svirin oxunmas?? zaman?? x??ta ba?? verdi. \nIOException", teacherPhotoUrl, HEIGHT);
            }
        }
        nameField.setText(teacherName);
        surnameField.setText(teacherSurname);
        birthDateField.setText(birthDate);
        teacherSchoolGraduateField.setText(teacherGraduate);
        specialtyField.setText(specialty);
        academicDegreeField.setText(academicDegree);
        lessontTimeField.setText(lessonTime);
        salaryField.setText(salary);
        numberOfSubjectsField.setText(numberOfSub);
        numberOfGorupsField.setText(numberOfGroups);
    }
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        genderButtonGroup = new javax.swing.ButtonGroup();
        languagesButtonGroup = new javax.swing.ButtonGroup();
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
        addTeacher = new javax.swing.JButton();
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
        loacalArticleTexteArea = new javax.swing.JTextArea();
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
        setFocusable(false);
        setMaximumSize(new java.awt.Dimension(1100, 692));
        setPreferredSize(new java.awt.Dimension(1100, 629));

        teacherPhotoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        teacherPhotoLabel.setMaximumSize(new java.awt.Dimension(110, 110));
        teacherPhotoLabel.setMinimumSize(new java.awt.Dimension(110, 110));

        nameLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        nameLabel.setText("Ad");

        surnameLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        surnameLabel.setText("Soyad");

        birthDateLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        birthDateLabel.setText("T??v??ll??d");

        academicDegreeLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        academicDegreeLabel.setText("Elmi D??r??c??");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        departmentLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        departmentLabel.setText("Kafedra");

        addTeacher.setText("??lav?? et");
        addTeacher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTeacherActionPerformed(evt);
            }
        });

        chooseImg.setText("????kil se??");
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
        teacherGraduateLabel1.setText("T??hsil");

        genderButtonGroup.add(manRadioButton);
        manRadioButton.setText("Ki??i");
        manRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manRadioButtonActionPerformed(evt);
            }
        });

        genderButtonGroup.add(womanRadioButton);
        womanRadioButton.setText("Qad??n");
        womanRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                womanRadioButtonActionPerformed(evt);
            }
        });

        genderRadioLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        genderRadioLabel.setText("Cins");

        teacherGraduateLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        teacherGraduateLabel3.setText("Bildiyi dill??r");

        englishRadioButton.setText("??ngilis");
        englishRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                englishRadioButtonActionPerformed(evt);
            }
        });

        rusRadioButton.setText("Rus");
        rusRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rusRadioButtonActionPerformed(evt);
            }
        });

        frenchRadioButton.setText("Frans??z");
        frenchRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                frenchRadioButtonActionPerformed(evt);
            }
        });

        germanRadioButton.setText("Alman");
        germanRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                germanRadioButtonActionPerformed(evt);
            }
        });

        articlesLocalLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        articlesLocalLabel.setText("M??qal??l??r (yerli)");

        loacalArticleTexteArea.setColumns(20);
        loacalArticleTexteArea.setRows(5);
        jScrollPane1.setViewportView(loacalArticleTexteArea);

        articlesLocalOverseas.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        articlesLocalOverseas.setText("M??qal??l??r (xarici)");

        overseasArticleTexteArea.setColumns(20);
        overseasArticleTexteArea.setRows(5);
        jScrollPane3.setViewportView(overseasArticleTexteArea);

        tezisTextArea.setColumns(20);
        tezisTextArea.setRows(5);
        jScrollPane4.setViewportView(tezisTextArea);

        tezisLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        tezisLabel.setText("Tezis");

        foreignCountriesLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        foreignCountriesLabel.setText("Xaricd?? oldu??u ??lk??l??r");

        foreignCountriesTeaxtArea.setColumns(20);
        foreignCountriesTeaxtArea.setRows(5);
        jScrollPane5.setViewportView(foreignCountriesTeaxtArea);

        academicDegreeLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        academicDegreeLabel1.setText("Elmi Ad");

        academicDegreeBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Texniki Elml??r Namiz??di", "Fizika Elml??r Namiz??di" }));
        academicDegreeBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                academicDegreeBoxActionPerformed(evt);
            }
        });

        scientificNameBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dosent", "Professor", "Akademik", "Milli Elml??r Akademiyas??n??n M??xbir ??zvi" }));

        javax.swing.GroupLayout containerLayout = new javax.swing.GroupLayout(container);
        container.setLayout(containerLayout);
        containerLayout.setHorizontalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(addTeacher)
                    .addGroup(containerLayout.createSequentialGroup()
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tezisLabel)
                            .addComponent(articlesLocalOverseas)
                            .addComponent(jScrollPane3)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                            .addComponent(foreignCountriesLabel)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE))))
                .addGap(12, 12, 12))
        );
        containerLayout.setVerticalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
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
                                            .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(deparmtentListBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(containerLayout.createSequentialGroup()
                                                    .addComponent(departmentLabel)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(articlesLocalLabel))))
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
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane5))))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(addTeacher))
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

    public void setValues(
            String teacherPhotoUrl,
            String teacherName,
            String teacherSurname,
            String birthDate,
            String teacherGraduate,
            String specialty,
            String academicDegree,
            String department,
            String lessonTime,
            String salary,
            String numberOfSub,
            String numberOfGroups
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
                JOptionPane.showMessageDialog(this, "T??svirin oxunmas?? zaman?? x??ta ba?? verdi. \nIOException", teacherPhotoUrl, HEIGHT);
            }
        }
        /*
        nameField.setText(teacherName);
        surnameField.setText(teacherSurname);
        birthDateField.setText(birthDate);
        teacherGraduateField.setText(teacherGraduate);
        academicDegreeField.setText(academicDegreeBox.getSelectedItem().toString());
        lessontTimeField.setText(lessonTime);
        salaryField.setText(salary);
        numberOfSubjectsField.setText(numberOfSub);
        numberOfGorupsField.setText(numberOfGroups);
         */
    }

    public void getReadyInfo() {
        departments = departmentManager.getDepartments();

        departments.forEach(department -> {
            if (department.getName().length() > setSizeNum) {
                //departmentBoxModel.addElement(department.getName().substring(30));
                setResizable(true);
                setSize(
                        getWidth() + department.getName().length() * 3, getHeight());
                setResizable(false);
                setSizeNum += department.getName().length();
            }
            departmentBoxModel.addElement(department.getName());
        });
    }

    public void checkAllFields() {
        if (nameField.getText().isEmpty()
                || surnameField.getText().isEmpty()
                || birthDateField.getText().isEmpty()
                || deparmtentListBox.getSelectedIndex() == -1
                || teacherGraduateField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "B??t??n m??lumatlar??n daxil edildiyini v?? d??zg??nl??y??n?? yoxlay??n.", "X??ta", HEIGHT);
        } else {
            postData();
        }
    }

    public void postData() {
        String getSelectedDepartment = departmentBoxModel.getSelectedItem().toString();
        String getAcademicDegree = academicDegreeBox.getSelectedItem().toString();
        String getScientificName = scientificNameBox.getSelectedItem().toString();
        saveImage();
        boolean addTeacher = teachersManager.addTeacher(filePath,
                nameField.getText(),
                surnameField.getText(),
                birthDateField.getText(),
                teacherGraduateField.getText(),
                selectedGender,
                selectedLanguages,
                getAcademicDegree,
                getScientificName,
                getSelectedDepartment,
                loacalArticleTexteArea.getText(),
                overseasArticleTexteArea.getText(),
                tezisTextArea.getText(),
                foreignCountriesTeaxtArea.getText()
        );
        if (addTeacher) {
            JOptionPane.showMessageDialog(this,
                    surnameField.getText() + " " + nameField.getText() + " m????lliml??r siyah??s??na ??lav?? edildi.", "??m??liyyat u??urla icra olundu", WIDTH);
        } else {
            JOptionPane.showMessageDialog(this, "??m??liyyat icra olunark??n x??ta ba?? verdi.", "X??ta", HEIGHT);
        }
    }

    public void saveImage() {
        if (filePath != null) {
            try {
                FileInputStream imgInputStream = new FileInputStream(new File(filePath));
                int imgCurrByte;
                Random randNum = new Random();
                int randomNameNum = randNum.nextInt(3000);
                String fileName = filePath.replaceAll("." + getFileFormat, "");
                fileName = fileName.substring(fileName.lastIndexOf("\\") + 1) + randomNameNum + "." + getFileFormat;
                String saveLocation = "C:\\Users\\PC\\Projects\\Desktop\\Java\\Faculty System\\Images\\" + fileName;
                FileOutputStream imgOutputStream = new FileOutputStream(new File(saveLocation));
                byte buffer[] = new byte[1024];
                filePath = saveLocation;
                while ((imgCurrByte = imgInputStream.read(buffer)) > 0) {
                    imgOutputStream.write(buffer, 0, imgCurrByte);
                }

            } catch (FileNotFoundException ex) {
                System.out.println("Fayl tap??lmad??.");
            } catch (IOException ex) {
                System.out.println("Fayl saxlan??lark??n x??ta ba?? verdi. IOException");
            }
        }
    }

    private void chooseImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseImgActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        int selectedFile = fileChooser.showOpenDialog(this);

        if (selectedFile == JFileChooser.APPROVE_OPTION) {
            filePath = fileChooser.getSelectedFile().getPath();
            getFileFormat = filePath.substring(filePath.length() - 3, filePath.length());

            if (!getFileFormat.toLowerCase().equals("jpg") && !getFileFormat.toLowerCase().equals("jpeg")) {
                JOptionPane.showMessageDialog(this, "JPG v?? ya JPEG uzant??l?? fayl daxil edin.", "X??ta", HEIGHT);
            } else {
                try {
                    img = ImageIO.read(new FileImageInputStream(new File(filePath)));
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "T??svirin oxunmas?? zaman?? x??ta ba?? verdi. \nIOException", filePath, HEIGHT);
                }
                ImageParameters imgParameters = new ImageParameters(filePath);
                //teacherPhotoLabel.setIcon(new javax.swing.ImageIcon(filePath));
                teacherPhotoLabel.setIcon(new ImageIcon(imgParameters.resize(img, 121, 113)));
                deleteImg.setEnabled(true);
            }

        }
    }//GEN-LAST:event_chooseImgActionPerformed

    private void deleteImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteImgActionPerformed
        // Delete image
        if (teacherPhotoLabel.getIcon() != null) {
            teacherPhotoLabel.setIcon(new javax.swing.ImageIcon());
            img = null;
            deleteImg.setEnabled(false);
            filePath = null;
        }
    }//GEN-LAST:event_deleteImgActionPerformed

    private void addTeacherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTeacherActionPerformed
        // ??lav?? et
        checkAllFields();
    }//GEN-LAST:event_addTeacherActionPerformed

    private void manRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manRadioButtonActionPerformed
        selectedGender = 1;
    }//GEN-LAST:event_manRadioButtonActionPerformed

    private void englishRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_englishRadioButtonActionPerformed
        if (englishRadioButton.isSelected()) {
            selectedLanguages.add("??ngilis");
        } else {
            selectedLanguages.remove("??ngilis");
        }
    }//GEN-LAST:event_englishRadioButtonActionPerformed

    private void rusRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rusRadioButtonActionPerformed
        if (rusRadioButton.isSelected()) {
            selectedLanguages.add("Rus");
        } else {
            selectedLanguages.remove("Rus");
        }
    }//GEN-LAST:event_rusRadioButtonActionPerformed

    private void frenchRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_frenchRadioButtonActionPerformed
        if (frenchRadioButton.isSelected()) {
            selectedLanguages.add("Frans??z");
        } else {
            selectedLanguages.remove("Frans??z");
        }
    }//GEN-LAST:event_frenchRadioButtonActionPerformed

    private void germanRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_germanRadioButtonActionPerformed
        if (germanRadioButton.isSelected()) {
            selectedLanguages.add("Alman");
        } else {
            selectedLanguages.remove("Alman");
        }
    }//GEN-LAST:event_germanRadioButtonActionPerformed

    private void womanRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_womanRadioButtonActionPerformed
        selectedGender = 0;
    }//GEN-LAST:event_womanRadioButtonActionPerformed

    private void academicDegreeBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_academicDegreeBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_academicDegreeBoxActionPerformed

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
            java.util.logging.Logger.getLogger(TeacherAddPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TeacherAddPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TeacherAddPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TeacherAddPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TeacherAddPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> academicDegreeBox;
    private javax.swing.JLabel academicDegreeLabel;
    private javax.swing.JLabel academicDegreeLabel1;
    private javax.swing.JButton addTeacher;
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
    private javax.swing.ButtonGroup genderButtonGroup;
    private javax.swing.JLabel genderRadioLabel;
    private javax.swing.JRadioButton germanRadioButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.ButtonGroup languagesButtonGroup;
    private javax.swing.JTextArea loacalArticleTexteArea;
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
