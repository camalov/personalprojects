package com.gui.frame;

import com.gui.elements.FontChanger;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class MainPage extends javax.swing.JFrame {

    private static FontChanger fontManager;
    DropdownSidebar dropSidebar;
    private DepartmentsPanel departmentsPanel = new DepartmentsPanel();

    public MainPage() {
        initComponents();
        setLocationRelativeTo(null);
        //InputSecurity.checkSession();
        departmentMenulLabelBG.setVisible(false);
        studentsMenuLabelBG.setVisible(false);
        exUnfulStdntsMenuLabelBG.setVisible(false);
        scholarShipMenuLabelBG.setVisible(false);

        //mainPageLabelSeperator.setVisible(false);
        departmentsMenuSeperator.setVisible(false);
        studentsMenuSeperator.setVisible(false);
        exUnfulStudentsMenuSeperator.setVisible(false);
        scholarShipMenuSeperator.setVisible(false);

        String robotoBlackURL
                = "C:\\Users\\PC\\Projects\\Desktop\\Java\\Faculty System\\Fonts\\Roboto\\Roboto-Medium.ttf";
        fontManager = new FontChanger();
        fontManager.setJLabelFont(robotoBlackURL, mainPageMenuLabel, 18f);
        fontManager.setJLabelFont(robotoBlackURL, departmentsMenuLabel, 18f);
        fontManager.setJLabelFont(robotoBlackURL, studentsMenuLabel, 18f);
        fontManager.setJLabelFont(robotoBlackURL, exUnfulStdntsMenuLabel, 18f);
        fontManager.setJLabelFont(robotoBlackURL, scholarShipMenuLabel, 18f);
        jComboBox1.setVisible(true);
    }

    private void sidebarClosedControl() {
        Timer timer = new Timer(150, null);
        timer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!dropSidebar.isShowing()) {
                    setVisible(true);
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
        dashboardPanel = new javax.swing.JPanel();
        dashboardDepartmentCount = new javax.swing.JLabel();
        dashboardDepartmentLabel = new javax.swing.JLabel();
        dashboardSpecialtyCount = new javax.swing.JLabel();
        dashboardSpecialtyLabel = new javax.swing.JLabel();
        dashboardGroupCount = new javax.swing.JLabel();
        dashboardGroupLabel = new javax.swing.JLabel();
        dashboardDepartmentCount1 = new javax.swing.JLabel();
        dashboardDepartmentLabel1 = new javax.swing.JLabel();
        dashboardDepartmentCount2 = new javax.swing.JLabel();
        dashboardDepartmentLabel2 = new javax.swing.JLabel();
        dashboardDepartmentCount3 = new javax.swing.JLabel();
        dashboardDepartmentLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        sideBar = new javax.swing.JPanel();
        IKTIconLabel = new javax.swing.JLabel();
        mainPageMenuLabel = new javax.swing.JLabel();
        mainPageMenuLabelBG = new javax.swing.JLabel();
        mainPageLabelSeperator = new javax.swing.JSeparator();
        departmentsMenuLabel = new javax.swing.JLabel();
        departmentDropdownMenuLabel = new javax.swing.JLabel();
        departmentMenulLabelBG = new javax.swing.JLabel();
        departmentsMenuSeperator = new javax.swing.JSeparator();
        studentsMenuLabel = new javax.swing.JLabel();
        studentsMenuLabelBG = new javax.swing.JLabel();
        studentsMenuSeperator = new javax.swing.JSeparator();
        exUnfulStdntsMenuLabel = new javax.swing.JLabel();
        exUnfulStdntsMenuLabelBG = new javax.swing.JLabel();
        scholarShipMenuSeperator = new javax.swing.JSeparator();
        scholarShipMenuLabel = new javax.swing.JLabel();
        scholarShipMenuLabelBG = new javax.swing.JLabel();
        exUnfulStudentsMenuSeperator = new javax.swing.JSeparator();
        sidebarBottom = new javax.swing.JPanel();
        bottomMenuSeperator = new javax.swing.JSeparator();
        userProfileMenuIcon = new javax.swing.JLabel();
        exitMenuIcon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("IKT");
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(800, 500));

        dashboardPanel.setBackground(new java.awt.Color(179, 202, 255));

        dashboardDepartmentCount.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        dashboardDepartmentCount.setForeground(new java.awt.Color(0, 0, 0));
        dashboardDepartmentCount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dashboardDepartmentCount.setText("0");

        dashboardDepartmentLabel.setBackground(new java.awt.Color(0, 0, 0));
        dashboardDepartmentLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        dashboardDepartmentLabel.setText("Kafedra");

        dashboardSpecialtyCount.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        dashboardSpecialtyCount.setForeground(new java.awt.Color(0, 0, 0));
        dashboardSpecialtyCount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dashboardSpecialtyCount.setText("0");

        dashboardSpecialtyLabel.setBackground(new java.awt.Color(0, 0, 0));
        dashboardSpecialtyLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        dashboardSpecialtyLabel.setText("İxtisas");

        dashboardGroupCount.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        dashboardGroupCount.setForeground(new java.awt.Color(0, 0, 0));
        dashboardGroupCount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dashboardGroupCount.setText("0");

        dashboardGroupLabel.setBackground(new java.awt.Color(0, 0, 0));
        dashboardGroupLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        dashboardGroupLabel.setText("Qrup");

        dashboardDepartmentCount1.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        dashboardDepartmentCount1.setForeground(new java.awt.Color(0, 0, 0));
        dashboardDepartmentCount1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dashboardDepartmentCount1.setText("0");

        dashboardDepartmentLabel1.setBackground(new java.awt.Color(0, 0, 0));
        dashboardDepartmentLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        dashboardDepartmentLabel1.setText("Müəllim");

        dashboardDepartmentCount2.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        dashboardDepartmentCount2.setForeground(new java.awt.Color(0, 0, 0));
        dashboardDepartmentCount2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dashboardDepartmentCount2.setText("0");

        dashboardDepartmentLabel2.setBackground(new java.awt.Color(0, 0, 0));
        dashboardDepartmentLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        dashboardDepartmentLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dashboardDepartmentLabel2.setText("Fənn");

        dashboardDepartmentCount3.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        dashboardDepartmentCount3.setForeground(new java.awt.Color(0, 0, 0));
        dashboardDepartmentCount3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dashboardDepartmentCount3.setText("0");

        dashboardDepartmentLabel3.setBackground(new java.awt.Color(0, 0, 0));
        dashboardDepartmentLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        dashboardDepartmentLabel3.setText("Tələbə");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout dashboardPanelLayout = new javax.swing.GroupLayout(dashboardPanel);
        dashboardPanel.setLayout(dashboardPanelLayout);
        dashboardPanelLayout.setHorizontalGroup(
            dashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashboardPanelLayout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addGroup(dashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dashboardPanelLayout.createSequentialGroup()
                        .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(112, 112, 112))
                    .addGroup(dashboardPanelLayout.createSequentialGroup()
                        .addGroup(dashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(dashboardPanelLayout.createSequentialGroup()
                                .addGroup(dashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(dashboardPanelLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(dashboardDepartmentLabel))
                                    .addComponent(dashboardDepartmentCount, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
                                .addGroup(dashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dashboardSpecialtyCount, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(dashboardPanelLayout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addComponent(dashboardSpecialtyLabel))))
                            .addGroup(dashboardPanelLayout.createSequentialGroup()
                                .addGroup(dashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dashboardDepartmentCount1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(dashboardPanelLayout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addComponent(dashboardDepartmentLabel1)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(dashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(dashboardPanelLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(dashboardDepartmentLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(dashboardDepartmentCount2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
                        .addGroup(dashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dashboardPanelLayout.createSequentialGroup()
                                .addComponent(dashboardGroupLabel)
                                .addGap(136, 136, 136))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dashboardPanelLayout.createSequentialGroup()
                                .addGroup(dashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(dashboardDepartmentCount3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dashboardGroupCount, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(112, 112, 112))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dashboardPanelLayout.createSequentialGroup()
                                .addComponent(dashboardDepartmentLabel3)
                                .addGap(126, 126, 126))))))
        );
        dashboardPanelLayout.setVerticalGroup(
            dashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashboardPanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(dashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dashboardGroupCount)
                    .addGroup(dashboardPanelLayout.createSequentialGroup()
                        .addGroup(dashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dashboardDepartmentCount)
                            .addComponent(dashboardSpecialtyCount))
                        .addGap(0, 0, 0)
                        .addGroup(dashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dashboardDepartmentLabel)
                            .addComponent(dashboardSpecialtyLabel)
                            .addComponent(dashboardGroupLabel))))
                .addGap(36, 36, 36)
                .addGroup(dashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dashboardPanelLayout.createSequentialGroup()
                        .addComponent(dashboardDepartmentCount3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dashboardDepartmentLabel3))
                    .addGroup(dashboardPanelLayout.createSequentialGroup()
                        .addGroup(dashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dashboardDepartmentCount1)
                            .addComponent(dashboardDepartmentCount2))
                        .addGroup(dashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dashboardDepartmentLabel2)
                            .addComponent(dashboardDepartmentLabel1))))
                .addGap(69, 69, 69)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        sideBar.setBackground(new java.awt.Color(35, 42, 60));

        IKTIconLabel.setFont(new java.awt.Font("Dialog", 1, 34)); // NOI18N
        IKTIconLabel.setForeground(new java.awt.Color(255, 255, 255));
        IKTIconLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IKTIconLabel.setIcon(new javax.swing.ImageIcon("C:\\Users\\PC\\Projects\\Desktop\\Java\\Faculty System\\Icons\\icons8_university_48.png")); // NOI18N
        IKTIconLabel.setText(" IKT");

        mainPageMenuLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        mainPageMenuLabel.setForeground(new java.awt.Color(255, 255, 255));
        mainPageMenuLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mainPageMenuLabel.setIcon(new javax.swing.ImageIcon("C:\\Users\\PC\\Projects\\Desktop\\Java\\Faculty System\\Icons\\dashboard_32px.png")); // NOI18N
        mainPageMenuLabel.setText("Əsas səhifə");
        mainPageMenuLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mainPageMenuLabel.setPreferredSize(new java.awt.Dimension(100, 100));

        mainPageMenuLabelBG.setBackground(new java.awt.Color(78, 133, 227));
        mainPageMenuLabelBG.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        mainPageMenuLabelBG.setOpaque(true);

        mainPageLabelSeperator.setBackground(new java.awt.Color(204, 204, 204));

        departmentsMenuLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        departmentsMenuLabel.setForeground(new java.awt.Color(255, 255, 255));
        departmentsMenuLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        departmentsMenuLabel.setIcon(new javax.swing.ImageIcon("C:\\Users\\PC\\Projects\\Desktop\\Java\\Faculty System\\Icons\\department_24px.png")); // NOI18N
        departmentsMenuLabel.setText(" Kafedralar");
        departmentsMenuLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        departmentsMenuLabel.setPreferredSize(new java.awt.Dimension(100, 100));
        departmentsMenuLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                departmentsMenuLabelMouseClicked(evt);
            }
        });

        departmentDropdownMenuLabel.setBackground(new java.awt.Color(79, 85, 99));
        departmentDropdownMenuLabel.setForeground(new java.awt.Color(78, 85, 99));
        departmentDropdownMenuLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        departmentDropdownMenuLabel.setIcon(new javax.swing.ImageIcon("C:\\Users\\PC\\Projects\\Desktop\\Java\\Faculty System\\Icons\\forward_16px.png")); // NOI18N
        departmentDropdownMenuLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        departmentDropdownMenuLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                departmentDropdownMenuLabelMouseClicked(evt);
            }
        });

        departmentMenulLabelBG.setBackground(new java.awt.Color(78, 133, 227));
        departmentMenulLabelBG.setOpaque(true);

        departmentsMenuSeperator.setBackground(new java.awt.Color(204, 204, 204));

        studentsMenuLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        studentsMenuLabel.setForeground(new java.awt.Color(255, 255, 255));
        studentsMenuLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        studentsMenuLabel.setIcon(new javax.swing.ImageIcon("C:\\Users\\PC\\Projects\\Desktop\\Java\\Faculty System\\Icons\\student_male_24px.png")); // NOI18N
        studentsMenuLabel.setText(" Tələbələr");
        studentsMenuLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        studentsMenuLabel.setPreferredSize(new java.awt.Dimension(100, 100));

        studentsMenuLabelBG.setBackground(new java.awt.Color(78, 133, 227));
        studentsMenuLabelBG.setOpaque(true);

        studentsMenuSeperator.setBackground(new java.awt.Color(204, 204, 204));

        exUnfulStdntsMenuLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        exUnfulStdntsMenuLabel.setForeground(new java.awt.Color(255, 255, 255));
        exUnfulStdntsMenuLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exUnfulStdntsMenuLabel.setIcon(new javax.swing.ImageIcon("C:\\Users\\PC\\Projects\\Desktop\\Java\\Faculty System\\Icons\\scorecard_32px.png")); // NOI18N
        exUnfulStdntsMenuLabel.setText("Kəsrlər");
        exUnfulStdntsMenuLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exUnfulStdntsMenuLabel.setPreferredSize(new java.awt.Dimension(100, 100));

        exUnfulStdntsMenuLabelBG.setBackground(new java.awt.Color(78, 133, 227));
        exUnfulStdntsMenuLabelBG.setOpaque(true);

        scholarShipMenuSeperator.setBackground(new java.awt.Color(204, 204, 204));

        scholarShipMenuLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        scholarShipMenuLabel.setForeground(new java.awt.Color(255, 255, 255));
        scholarShipMenuLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        scholarShipMenuLabel.setIcon(new javax.swing.ImageIcon("C:\\Users\\PC\\Projects\\Desktop\\Java\\Faculty System\\Icons\\scholarship_24px.png")); // NOI18N
        scholarShipMenuLabel.setText(" Təqaüd");
        scholarShipMenuLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        scholarShipMenuLabel.setPreferredSize(new java.awt.Dimension(100, 100));

        scholarShipMenuLabelBG.setBackground(new java.awt.Color(78, 133, 227));
        scholarShipMenuLabelBG.setOpaque(true);

        exUnfulStudentsMenuSeperator.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout sideBarLayout = new javax.swing.GroupLayout(sideBar);
        sideBar.setLayout(sideBarLayout);
        sideBarLayout.setHorizontalGroup(
            sideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideBarLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(IKTIconLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(sideBarLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(sideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mainPageMenuLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(sideBarLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(mainPageMenuLabelBG, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(sideBarLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(mainPageLabelSeperator, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(sideBarLayout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(departmentDropdownMenuLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(departmentsMenuLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(sideBarLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(departmentMenulLabelBG, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(sideBarLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(departmentsMenuSeperator, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(sideBarLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(sideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(studentsMenuLabelBG, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(studentsMenuLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(sideBarLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(studentsMenuSeperator, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(sideBarLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(exUnfulStdntsMenuLabelBG, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(exUnfulStdntsMenuLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(sideBarLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(exUnfulStudentsMenuSeperator, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(sideBarLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(sideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scholarShipMenuLabelBG, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scholarShipMenuLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(sideBarLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(scholarShipMenuSeperator, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        sideBarLayout.setVerticalGroup(
            sideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideBarLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(IKTIconLabel)
                .addGap(26, 26, 26)
                .addGroup(sideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sideBarLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(mainPageMenuLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(mainPageMenuLabelBG, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(mainPageLabelSeperator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(sideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(departmentDropdownMenuLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(departmentsMenuLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(departmentMenulLabelBG, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(departmentsMenuSeperator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(sideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(studentsMenuLabelBG, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(studentsMenuLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(studentsMenuSeperator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(sideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(exUnfulStdntsMenuLabelBG, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exUnfulStdntsMenuLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(exUnfulStudentsMenuSeperator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(sideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scholarShipMenuLabelBG, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scholarShipMenuLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(scholarShipMenuSeperator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        sidebarBottom.setBackground(new java.awt.Color(35, 42, 60));

        bottomMenuSeperator.setBackground(new java.awt.Color(26, 33, 46));
        bottomMenuSeperator.setForeground(new java.awt.Color(26, 33, 46));
        bottomMenuSeperator.setDoubleBuffered(true);

        userProfileMenuIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        userProfileMenuIcon.setIcon(new javax.swing.ImageIcon("C:\\Users\\PC\\Projects\\Desktop\\Java\\Faculty System\\Icons\\SidebarBottomIcons\\male_user_40px.png")); // NOI18N

        exitMenuIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exitMenuIcon.setIcon(new javax.swing.ImageIcon("C:\\Users\\PC\\Projects\\Desktop\\Java\\Faculty System\\Icons\\SidebarBottomIcons\\exit_32px.png")); // NOI18N

        javax.swing.GroupLayout sidebarBottomLayout = new javax.swing.GroupLayout(sidebarBottom);
        sidebarBottom.setLayout(sidebarBottomLayout);
        sidebarBottomLayout.setHorizontalGroup(
            sidebarBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bottomMenuSeperator)
            .addGroup(sidebarBottomLayout.createSequentialGroup()
                .addComponent(userProfileMenuIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(exitMenuIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        sidebarBottomLayout.setVerticalGroup(
            sidebarBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sidebarBottomLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(bottomMenuSeperator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sidebarBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(userProfileMenuIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(exitMenuIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout containerLayout = new javax.swing.GroupLayout(container);
        container.setLayout(containerLayout);
        containerLayout.setHorizontalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(sideBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sidebarBottom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addComponent(dashboardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        containerLayout.setVerticalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dashboardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(containerLayout.createSequentialGroup()
                .addComponent(sideBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(sidebarBottom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void departmentsMenuLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_departmentsMenuLabelMouseClicked
        int pressedKey = evt.getButton();
        if (pressedKey == 1) {
            if (dropSidebar == null) {
                dropSidebar = new DropdownSidebar();
            }
            departmentMenulLabelBG.setVisible(true);
            mainPageMenuLabelBG.setVisible(false);
            setVisible(false);
            dropSidebar.setVisible(true);
            sidebarClosedControl();
        }
    }//GEN-LAST:event_departmentsMenuLabelMouseClicked

    private void departmentDropdownMenuLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_departmentDropdownMenuLabelMouseClicked
        int pressedKey = evt.getButton();
        if (pressedKey == 1) {
            /*
            departmentMenulLabelBG.setVisible(true);
            mainPageMenuLabelBG.setVisible(false);
            dropSidebar = new DropdownSidebar();
            setVisible(false);
            dropSidebar.setVisible(true);
            sidebarClosedControl();
             */
            departmentsMenuLabelMouseClicked(evt);
        }
    }//GEN-LAST:event_departmentDropdownMenuLabelMouseClicked

    public static void main(String args[]) {
        /*
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
         */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IKTIconLabel;
    private javax.swing.JSeparator bottomMenuSeperator;
    private javax.swing.JPanel container;
    private javax.swing.JLabel dashboardDepartmentCount;
    private javax.swing.JLabel dashboardDepartmentCount1;
    private javax.swing.JLabel dashboardDepartmentCount2;
    private javax.swing.JLabel dashboardDepartmentCount3;
    private javax.swing.JLabel dashboardDepartmentLabel;
    private javax.swing.JLabel dashboardDepartmentLabel1;
    private javax.swing.JLabel dashboardDepartmentLabel2;
    private javax.swing.JLabel dashboardDepartmentLabel3;
    private javax.swing.JLabel dashboardGroupCount;
    private javax.swing.JLabel dashboardGroupLabel;
    private javax.swing.JPanel dashboardPanel;
    private javax.swing.JLabel dashboardSpecialtyCount;
    private javax.swing.JLabel dashboardSpecialtyLabel;
    private javax.swing.JLabel departmentDropdownMenuLabel;
    private javax.swing.JLabel departmentMenulLabelBG;
    private javax.swing.JLabel departmentsMenuLabel;
    private javax.swing.JSeparator departmentsMenuSeperator;
    private javax.swing.JLabel exUnfulStdntsMenuLabel;
    private javax.swing.JLabel exUnfulStdntsMenuLabelBG;
    private javax.swing.JSeparator exUnfulStudentsMenuSeperator;
    private javax.swing.JLabel exitMenuIcon;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JSeparator mainPageLabelSeperator;
    private javax.swing.JLabel mainPageMenuLabel;
    private javax.swing.JLabel mainPageMenuLabelBG;
    private javax.swing.JLabel scholarShipMenuLabel;
    private javax.swing.JLabel scholarShipMenuLabelBG;
    private javax.swing.JSeparator scholarShipMenuSeperator;
    private javax.swing.JPanel sideBar;
    private javax.swing.JPanel sidebarBottom;
    private javax.swing.JLabel studentsMenuLabel;
    private javax.swing.JLabel studentsMenuLabelBG;
    private javax.swing.JSeparator studentsMenuSeperator;
    private javax.swing.JLabel userProfileMenuIcon;
    // End of variables declaration//GEN-END:variables
}
