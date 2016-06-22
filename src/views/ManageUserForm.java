/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.DateChooser;
import model.Validator;

/**
 *
 * @author Administrator
 */
public class ManageUserForm extends javax.swing.JFrame {

    /**
     * Creates new form MainForm
     */
    String User, Role;
    ResultSet rs;
    String oldUserName, oldFullName, oldAdd, oldTel, oldDOB, oldDep, oldDesign, oldGender, oldEmail;
    Date birthday = null;
    boolean edit = false;
    Validator valid = new Validator();
    boolean check = true;

    public void cancel() {
        oldFullName = txtFullName.getText();
        oldAdd = txtUserAddress.getText();
        oldTel = txtTelephone.getText();
        oldDOB = txtdob.getText();
        oldDep = cbxDepartment.getSelectedItem().toString();
        oldDesign = cbxDesignation.getSelectedItem().toString();
        oldGender = buttonGroup1.getSelection().toString();
        oldEmail = txtEmail.getText();
    }

    public boolean checkSave() {
        if (txtUserName.getText().equals("")
                || txtFullName.getText().equals("")
                || txtUserAddress.getText().equals("")
                || txtTelephone.getText().equals("")
                || txtdob.getText().equals("")
                || txtEmail.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Must fill in all the field");
            return false;
        } else {
            return true;
        }
    }

    public boolean checkMail() {
        if (!valid.validateEmail(txtEmail.getText())) {
            JOptionPane.showMessageDialog(null, "Email Not validate");
            return false;
        } else {
            return true;
        }
    }

    public boolean checkPhone() {
        if (!valid.validatePhoneNumber(txtTelephone.getText().trim())) {
            JOptionPane.showMessageDialog(null, "Phone not validate");
            return false;
        } else {
            return true;
        }
    }

    public boolean checkUserName() throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection cn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=LoanProcessingSystem", "sa", "123456");
        Statement st = cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rt = st.executeQuery("SELECT [UserName] FROM tblUser");

        while (rt.next()) {
            if (txtUserName.getText().equals(rt.getString("UserName"))) {
                JOptionPane.showMessageDialog(null, "The new UserName was exits, must new a different UserName");
                txtUserName.setText("");
                check = false;
                break;
            }
        }
        if (check == false) {
            return false;
        } else {
            return true;
        }

    }

    public ManageUserForm(String user, String role) throws ClassNotFoundException {
        initComponents();
        this.Role = role;
        this.User = user;
        lblDesignationText.setText(Role);
        lblUsertext.setText(User);
        if (Role == "Administrator") {
            btnLoan.setEnabled(false);
        } else {
            btnLoan.setEnabled(true);
        }
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection cn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=LoanProcessingSystem", "sa", "123456");
            Statement s = cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = s.executeQuery("SELECT * FROM tblUser");
            btnPrevious.setEnabled(false);
            rs.next();
            txtUserID.setText(rs.getString("UserID"));
            txtUserName.setText(rs.getString("UserName"));
            txtFullName.setText(rs.getString("FullName"));
            pwdPass.setText(rs.getString("Password"));
            txtUserAddress.setText(rs.getString("UserAddress"));
            txtTelephone.setText(rs.getString("Telephone"));
            txtdob.setText(rs.getString("DateOfBirth"));
            cbxDepartment.setSelectedItem(rs.getString("Department"));
            cbxDesignation.setSelectedItem(rs.getString("Designation"));
            if (rs.getString("Gender").equals("Male")) {
                chkMale.setSelected(true);
            } else {
                chkFemale.setSelected(true);
            }
            txtEmail.setText(rs.getString("Email"));

        } catch (SQLException e) {
            Logger.getLogger(UserForm.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        pnlContent = new javax.swing.JPanel();
        pnlLeft = new javax.swing.JPanel();
        lblSymbol = new javax.swing.JLabel();
        pnlRight = new javax.swing.JPanel();
        lblHeader = new javax.swing.JLabel();
        lblUserID = new javax.swing.JLabel();
        txtUserID = new javax.swing.JTextField();
        lblFullName = new javax.swing.JLabel();
        txtFullName = new javax.swing.JTextField();
        lblUserAddress = new javax.swing.JLabel();
        txtUserAddress = new javax.swing.JTextField();
        lblTelephone = new javax.swing.JLabel();
        txtTelephone = new javax.swing.JTextField();
        lblDob = new javax.swing.JLabel();
        txtdob = new javax.swing.JTextField();
        lblDepartment = new javax.swing.JLabel();
        lblDesignation = new javax.swing.JLabel();
        cbxDesignation = new javax.swing.JComboBox();
        lblGender = new javax.swing.JLabel();
        chkMale = new javax.swing.JRadioButton();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblPass = new javax.swing.JLabel();
        chkFemale = new javax.swing.JRadioButton();
        pwdPass = new javax.swing.JPasswordField();
        pnlButtonLeft = new javax.swing.JPanel();
        btnPrevious = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        pnlButtonRight = new javax.swing.JPanel();
        btnEdit = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        lblUserName = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        cbxDepartment = new javax.swing.JComboBox();
        btnDOB = new javax.swing.JButton();
        pnlMenu = new javax.swing.JPanel();
        pnlStatus = new javax.swing.JPanel();
        lblUserName1 = new javax.swing.JLabel();
        lblUsertext = new javax.swing.JLabel();
        lblDesignation1 = new javax.swing.JLabel();
        lblDesignationText = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        tbrMenu = new javax.swing.JToolBar();
        btnHome = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnUser = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnChangePass = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        btnCustomer = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        btnLoan = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        btnSearch = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        btnReport = new javax.swing.JButton();
        jSeparator8 = new javax.swing.JToolBar.Separator();
        btnHelp = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        btnExit = new javax.swing.JButton();
        lblImg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Loan Processing System");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        pnlContent.setBackground(new java.awt.Color(255, 255, 255));
        pnlContent.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Manage User Form", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("VNI-Coronet", 0, 36), new java.awt.Color(51, 204, 255))); // NOI18N

        pnlLeft.setBackground(new java.awt.Color(255, 255, 255));
        pnlLeft.setLayout(new javax.swing.BoxLayout(pnlLeft, javax.swing.BoxLayout.LINE_AXIS));

        lblSymbol.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSymbol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/img/bgcontent.jpg"))); // NOI18N
        lblSymbol.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pnlLeft.add(lblSymbol);

        pnlRight.setBackground(new java.awt.Color(102, 255, 255));
        pnlRight.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblHeader.setFont(new java.awt.Font("UVN Lac Long Quan", 2, 22)); // NOI18N
        lblHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeader.setText("User Information");
        lblHeader.setPreferredSize(new java.awt.Dimension(700, 50));

        lblUserID.setFont(new java.awt.Font("Vijaya", 0, 20)); // NOI18N
        lblUserID.setText("User ID");
        lblUserID.setPreferredSize(new java.awt.Dimension(200, 25));

        txtUserID.setEditable(false);
        txtUserID.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtUserID.setEnabled(false);
        txtUserID.setPreferredSize(new java.awt.Dimension(450, 25));

        lblFullName.setFont(new java.awt.Font("Vijaya", 0, 20)); // NOI18N
        lblFullName.setText("Full Name");
        lblFullName.setPreferredSize(new java.awt.Dimension(200, 25));

        txtFullName.setEditable(false);
        txtFullName.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtFullName.setPreferredSize(new java.awt.Dimension(450, 25));

        lblUserAddress.setFont(new java.awt.Font("Vijaya", 0, 20)); // NOI18N
        lblUserAddress.setText("User Address");
        lblUserAddress.setPreferredSize(new java.awt.Dimension(200, 25));

        txtUserAddress.setEditable(false);
        txtUserAddress.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtUserAddress.setPreferredSize(new java.awt.Dimension(450, 25));

        lblTelephone.setFont(new java.awt.Font("Vijaya", 0, 20)); // NOI18N
        lblTelephone.setText("Telephone");
        lblTelephone.setPreferredSize(new java.awt.Dimension(200, 25));

        txtTelephone.setEditable(false);
        txtTelephone.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtTelephone.setPreferredSize(new java.awt.Dimension(450, 25));

        lblDob.setFont(new java.awt.Font("Vijaya", 0, 20)); // NOI18N
        lblDob.setText("Date Of Birth");
        lblDob.setPreferredSize(new java.awt.Dimension(200, 25));

        txtdob.setEditable(false);
        txtdob.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtdob.setPreferredSize(new java.awt.Dimension(370, 25));

        lblDepartment.setFont(new java.awt.Font("Vijaya", 0, 20)); // NOI18N
        lblDepartment.setText("Department");
        lblDepartment.setPreferredSize(new java.awt.Dimension(200, 25));

        lblDesignation.setFont(new java.awt.Font("Vijaya", 0, 20)); // NOI18N
        lblDesignation.setText("Designation");
        lblDesignation.setPreferredSize(new java.awt.Dimension(200, 25));

        cbxDesignation.setFont(new java.awt.Font("Microsoft New Tai Lue", 0, 14)); // NOI18N
        cbxDesignation.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Administrator", "User" }));
        cbxDesignation.setEnabled(false);
        cbxDesignation.setPreferredSize(new java.awt.Dimension(100, 25));

        lblGender.setFont(new java.awt.Font("Vijaya", 0, 20)); // NOI18N
        lblGender.setText("Gender");
        lblGender.setPreferredSize(new java.awt.Dimension(200, 25));

        buttonGroup1.add(chkMale);
        chkMale.setFont(new java.awt.Font("Microsoft New Tai Lue", 0, 14)); // NOI18N
        chkMale.setSelected(true);
        chkMale.setText("Male");
        chkMale.setEnabled(false);
        chkMale.setPreferredSize(new java.awt.Dimension(80, 25));

        lblEmail.setFont(new java.awt.Font("Vijaya", 0, 20)); // NOI18N
        lblEmail.setText("Email");
        lblEmail.setPreferredSize(new java.awt.Dimension(200, 25));

        txtEmail.setEditable(false);
        txtEmail.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtEmail.setPreferredSize(new java.awt.Dimension(450, 25));

        lblPass.setFont(new java.awt.Font("Vijaya", 0, 20)); // NOI18N
        lblPass.setText("Password");
        lblPass.setPreferredSize(new java.awt.Dimension(200, 25));

        buttonGroup1.add(chkFemale);
        chkFemale.setFont(new java.awt.Font("Microsoft New Tai Lue", 0, 14)); // NOI18N
        chkFemale.setText("Female");
        chkFemale.setEnabled(false);
        chkFemale.setPreferredSize(new java.awt.Dimension(80, 25));

        pwdPass.setEditable(false);
        pwdPass.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        pwdPass.setText("11111111");
        pwdPass.setPreferredSize(new java.awt.Dimension(450, 25));

        pnlButtonLeft.setBackground(new java.awt.Color(153, 255, 255));
        pnlButtonLeft.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        btnPrevious.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/img/btnPrevious.png"))); // NOI18N
        btnPrevious.setText("Previous");
        btnPrevious.setPreferredSize(new java.awt.Dimension(100, 25));
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });

        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/img/btnNext.png"))); // NOI18N
        btnNext.setText("Next");
        btnNext.setPreferredSize(new java.awt.Dimension(100, 25));
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlButtonLeftLayout = new javax.swing.GroupLayout(pnlButtonLeft);
        pnlButtonLeft.setLayout(pnlButtonLeftLayout);
        pnlButtonLeftLayout.setHorizontalGroup(
            pnlButtonLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlButtonLeftLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlButtonLeftLayout.setVerticalGroup(
            pnlButtonLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlButtonLeftLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(pnlButtonLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlButtonRight.setBackground(new java.awt.Color(153, 255, 255));
        pnlButtonRight.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/img/btnedit.png"))); // NOI18N
        btnEdit.setText("Edit");
        btnEdit.setPreferredSize(new java.awt.Dimension(75, 25));
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/img/btnCancel.png"))); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.setEnabled(false);
        btnCancel.setPreferredSize(new java.awt.Dimension(75, 25));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/img/btnSave.png"))); // NOI18N
        btnSave.setText("Save");
        btnSave.setEnabled(false);
        btnSave.setPreferredSize(new java.awt.Dimension(75, 25));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/img/btnNew.png"))); // NOI18N
        btnNew.setText("New");
        btnNew.setPreferredSize(new java.awt.Dimension(75, 25));
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/img/btnDelete.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.setPreferredSize(new java.awt.Dimension(75, 25));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlButtonRightLayout = new javax.swing.GroupLayout(pnlButtonRight);
        pnlButtonRight.setLayout(pnlButtonRightLayout);
        pnlButtonRightLayout.setHorizontalGroup(
            pnlButtonRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlButtonRightLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlButtonRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(pnlButtonRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlButtonRightLayout.setVerticalGroup(
            pnlButtonRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlButtonRightLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlButtonRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(pnlButtonRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        lblUserName.setFont(new java.awt.Font("Vijaya", 0, 20)); // NOI18N
        lblUserName.setText("User Name");
        lblUserName.setPreferredSize(new java.awt.Dimension(200, 25));

        txtUserName.setEditable(false);
        txtUserName.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtUserName.setPreferredSize(new java.awt.Dimension(450, 25));

        cbxDepartment.setFont(new java.awt.Font("Microsoft New Tai Lue", 0, 14)); // NOI18N
        cbxDepartment.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Vehicle Finance", "Home Finance", "Personal Finance", "Educational Finance", "Manager" }));
        cbxDepartment.setEnabled(false);
        cbxDepartment.setPreferredSize(new java.awt.Dimension(100, 25));

        btnDOB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/img/btnCalendar.png"))); // NOI18N
        btnDOB.setText("Set Date");
        btnDOB.setEnabled(false);
        btnDOB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDOBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlRightLayout = new javax.swing.GroupLayout(pnlRight);
        pnlRight.setLayout(pnlRightLayout);
        pnlRightLayout.setHorizontalGroup(
            pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRightLayout.createSequentialGroup()
                .addGroup(pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRightLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlRightLayout.createSequentialGroup()
                                .addComponent(lblDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(pnlRightLayout.createSequentialGroup()
                                    .addComponent(lblUserID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtUserID, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(41, 41, 41)
                                    .addComponent(lblUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlRightLayout.createSequentialGroup()
                                    .addComponent(lblPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(pwdPass, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlRightLayout.createSequentialGroup()
                                    .addComponent(lblFullName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtFullName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnlRightLayout.createSequentialGroup()
                                .addComponent(lblDob, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtdob, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(btnDOB))
                            .addGroup(pnlRightLayout.createSequentialGroup()
                                .addComponent(pnlButtonLeft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(105, 105, 105)
                                .addComponent(pnlButtonRight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlRightLayout.createSequentialGroup()
                                .addComponent(lblDesignation, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxDesignation, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlRightLayout.createSequentialGroup()
                                .addComponent(lblUserAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtUserAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(pnlRightLayout.createSequentialGroup()
                                    .addGroup(pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlRightLayout.createSequentialGroup()
                                            .addGap(2, 2, 2)
                                            .addComponent(lblGender, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(pnlRightLayout.createSequentialGroup()
                                            .addComponent(chkMale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(47, 47, 47)
                                            .addComponent(chkFemale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(243, 243, 243))
                                        .addGroup(pnlRightLayout.createSequentialGroup()
                                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                            .addGap(82, 82, 82))))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlRightLayout.createSequentialGroup()
                                    .addComponent(lblTelephone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtTelephone, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(pnlRightLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        pnlRightLayout.setVerticalGroup(
            pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRightLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUserID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUserID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFullName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFullName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pwdPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUserAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUserAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelephone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelephone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDOB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDesignation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxDesignation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkMale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkFemale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlButtonLeft, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlButtonRight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(90, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlContentLayout = new javax.swing.GroupLayout(pnlContent);
        pnlContent.setLayout(pnlContentLayout);
        pnlContentLayout.setHorizontalGroup(
            pnlContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlContentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlLeft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlRight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlContentLayout.setVerticalGroup(
            pnlContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlContentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlLeft, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlRight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pnlMenu.setBackground(new java.awt.Color(255, 255, 255));

        pnlStatus.setBackground(new java.awt.Color(255, 255, 255));
        pnlStatus.setCursor(new java.awt.Cursor(java.awt.Cursor.N_RESIZE_CURSOR));

        lblUserName1.setBackground(new java.awt.Color(204, 255, 255));
        lblUserName1.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lblUserName1.setText("User Name: ");
        lblUserName1.setPreferredSize(new java.awt.Dimension(80, 20));

        lblUsertext.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lblUsertext.setText("jLabel2");
        lblUsertext.setPreferredSize(new java.awt.Dimension(130, 20));

        lblDesignation1.setBackground(new java.awt.Color(204, 255, 255));
        lblDesignation1.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lblDesignation1.setText("Designation:");
        lblDesignation1.setPreferredSize(new java.awt.Dimension(80, 20));

        lblDesignationText.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lblDesignationText.setText("Admin");
        lblDesignationText.setPreferredSize(new java.awt.Dimension(130, 20));

        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/img/btnLogOut.png"))); // NOI18N
        btnLogout.setText("Log Out");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlStatusLayout = new javax.swing.GroupLayout(pnlStatus);
        pnlStatus.setLayout(pnlStatusLayout);
        pnlStatusLayout.setHorizontalGroup(
            pnlStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlStatusLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnLogout)
                .addGap(63, 63, 63))
            .addGroup(pnlStatusLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(pnlStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlStatusLayout.createSequentialGroup()
                        .addComponent(lblUserName1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(lblUsertext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlStatusLayout.createSequentialGroup()
                        .addComponent(lblDesignation1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(lblDesignationText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        pnlStatusLayout.setVerticalGroup(
            pnlStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStatusLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(pnlStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUserName1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUsertext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(pnlStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDesignation1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDesignationText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLogout)
                .addContainerGap())
        );

        tbrMenu.setBackground(new java.awt.Color(255, 255, 255));
        tbrMenu.setFloatable(false);
        tbrMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tbrMenu.setPreferredSize(new java.awt.Dimension(1280, 30));

        btnHome.setBackground(new java.awt.Color(255, 255, 255));
        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/img/btnHome.png"))); // NOI18N
        btnHome.setToolTipText("Home");
        btnHome.setFocusable(false);
        btnHome.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHome.setPreferredSize(new java.awt.Dimension(70, 70));
        btnHome.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });
        tbrMenu.add(btnHome);
        tbrMenu.add(jSeparator1);

        btnUser.setBackground(new java.awt.Color(255, 255, 255));
        btnUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/img/btnUser.png"))); // NOI18N
        btnUser.setToolTipText("User");
        btnUser.setFocusable(false);
        btnUser.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnUser.setPreferredSize(new java.awt.Dimension(70, 70));
        btnUser.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserActionPerformed(evt);
            }
        });
        tbrMenu.add(btnUser);
        tbrMenu.add(jSeparator2);

        btnChangePass.setBackground(new java.awt.Color(255, 255, 255));
        btnChangePass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/img/btnPassword.png"))); // NOI18N
        btnChangePass.setToolTipText("Change Password");
        btnChangePass.setFocusable(false);
        btnChangePass.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnChangePass.setPreferredSize(new java.awt.Dimension(70, 70));
        btnChangePass.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnChangePass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangePassActionPerformed(evt);
            }
        });
        tbrMenu.add(btnChangePass);
        tbrMenu.add(jSeparator3);

        btnCustomer.setBackground(new java.awt.Color(255, 255, 255));
        btnCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/img/btnCustomer.png"))); // NOI18N
        btnCustomer.setToolTipText("Customer");
        btnCustomer.setFocusable(false);
        btnCustomer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCustomer.setPreferredSize(new java.awt.Dimension(70, 70));
        btnCustomer.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCustomerActionPerformed(evt);
            }
        });
        tbrMenu.add(btnCustomer);
        tbrMenu.add(jSeparator4);

        btnLoan.setBackground(new java.awt.Color(255, 255, 255));
        btnLoan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/img/btnLoan.png"))); // NOI18N
        btnLoan.setToolTipText("Loan Process");
        btnLoan.setFocusable(false);
        btnLoan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLoan.setPreferredSize(new java.awt.Dimension(70, 70));
        btnLoan.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoanActionPerformed(evt);
            }
        });
        tbrMenu.add(btnLoan);
        tbrMenu.add(jSeparator5);

        btnSearch.setBackground(new java.awt.Color(255, 255, 255));
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/img/btnSearch.png"))); // NOI18N
        btnSearch.setToolTipText("Search");
        btnSearch.setFocusable(false);
        btnSearch.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSearch.setPreferredSize(new java.awt.Dimension(70, 70));
        btnSearch.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        tbrMenu.add(btnSearch);
        tbrMenu.add(jSeparator7);

        btnReport.setBackground(new java.awt.Color(255, 255, 255));
        btnReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/img/btnReport.png"))); // NOI18N
        btnReport.setToolTipText("Report");
        btnReport.setFocusable(false);
        btnReport.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnReport.setPreferredSize(new java.awt.Dimension(70, 70));
        btnReport.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportActionPerformed(evt);
            }
        });
        tbrMenu.add(btnReport);
        tbrMenu.add(jSeparator8);

        btnHelp.setBackground(new java.awt.Color(255, 255, 255));
        btnHelp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/img/btnHelp.png"))); // NOI18N
        btnHelp.setToolTipText("Help");
        btnHelp.setFocusable(false);
        btnHelp.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHelp.setPreferredSize(new java.awt.Dimension(70, 70));
        btnHelp.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHelpActionPerformed(evt);
            }
        });
        tbrMenu.add(btnHelp);
        tbrMenu.add(jSeparator6);

        btnExit.setBackground(new java.awt.Color(255, 255, 255));
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/img/btnExit1.png"))); // NOI18N
        btnExit.setToolTipText("Exit");
        btnExit.setFocusable(false);
        btnExit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExit.setPreferredSize(new java.awt.Dimension(70, 70));
        btnExit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        tbrMenu.add(btnExit);

        lblImg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/img/Userlogo.png"))); // NOI18N

        javax.swing.GroupLayout pnlMenuLayout = new javax.swing.GroupLayout(pnlMenu);
        pnlMenu.setLayout(pnlMenuLayout);
        pnlMenuLayout.setHorizontalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addContainerGap(940, Short.MAX_VALUE)
                .addComponent(lblImg, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlMenuLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(tbrMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 921, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(349, Short.MAX_VALUE)))
        );
        pnlMenuLayout.setVerticalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblImg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(tbrMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1296, 838));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserActionPerformed
        // TODO add your handling code here: 
        if (Role == "User") {
            try {
                new UserForm(User, Role).setVisible(true);
                this.dispose();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ManageUserForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (Role == "Administrator") {
            try {
                new ManageUserForm(User, Role).setVisible(true);
                this.dispose();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ManageUserForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnUserActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        // TODO add your handling code here:
        new HomeForm(User, Role).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
        // TODO add your handling code here:
        try {
            btnNext.setEnabled(true);
            rs.previous();
            if (rs.isBeforeFirst() == false) {
                txtUserID.setText(rs.getString("UserID"));
                txtUserName.setText(rs.getString("UserName"));
                txtFullName.setText(rs.getString("FullName"));
                pwdPass.setText(rs.getString("Password"));
                txtUserAddress.setText(rs.getString("UserAddress"));
                txtTelephone.setText(rs.getString("Telephone"));
                txtdob.setText(rs.getString("DateOfBirth"));
                cbxDepartment.setSelectedItem(rs.getString("Department"));
                cbxDesignation.setSelectedItem(rs.getString("Designation"));
                if (rs.getString("Gender").equals("Male")) {
                    chkMale.setSelected(true);
                } else {
                    chkFemale.setSelected(true);
                }
                txtEmail.setText(rs.getString("Email"));
                btnPrevious.setEnabled(true);
                btnEdit.setEnabled(true);
                btnDelete.setEnabled(true);
                btnNew.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(null, "Out of Data");
                btnPrevious.setEnabled(false);
                btnEdit.setEnabled(false);
                btnDelete.setEnabled(false);
                btnNew.setEnabled(false);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPreviousActionPerformed

    private void btnChangePassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangePassActionPerformed
        // TODO add your handling code here:
        new ChangePassForm(User, Role).setVisible(true);
    }//GEN-LAST:event_btnChangePassActionPerformed

    private void btnCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustomerActionPerformed
        // TODO add your handling code here:
        try {
            new CustomerForm(User, Role).setVisible(true);
            this.dispose();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomerForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            Logger.getLogger(UserForm.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_btnCustomerActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        try {
            rs.next();
            btnPrevious.setEnabled(true);
            if (rs.isAfterLast()) {
                btnNext.setEnabled(false);
                JOptionPane.showMessageDialog(null, "Out of DATA!!!");
                btnEdit.setEnabled(false);
                btnDelete.setEnabled(false);
                btnNew.setEnabled(false);
            } else {
                txtUserID.setText(rs.getString("UserID"));
                txtUserName.setText(rs.getString("UserName"));
                txtFullName.setText(rs.getString("FullName"));
                pwdPass.setText(rs.getString("Password"));
                txtUserAddress.setText(rs.getString("UserAddress"));
                txtTelephone.setText(rs.getString("Telephone"));
                txtdob.setText(rs.getString("DateOfBirth"));
                cbxDepartment.setSelectedItem(rs.getString("Department"));
                cbxDesignation.setSelectedItem(rs.getString("Designation"));
                if (rs.getString("Gender").equals("Male")/*==("Male")*/) {
                    chkMale.setSelected(true);

                } else {
                    chkFemale.setSelected(true);
                }
                txtEmail.setText(rs.getString("Email"));
                btnNext.setEnabled(true);
                btnEdit.setEnabled(true);
                btnDelete.setEnabled(true);
                btnNew.setEnabled(true);
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            // TODO add your handling code here:
            rs.moveToCurrentRow();
            rs.deleteRow();
            JOptionPane.showMessageDialog(null, "Delete Success");
            Connection cn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=LoanProcessingSystem", "sa", "123456");
            Statement s = cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = s.executeQuery("SELECT * FROM tblUser");
            btnPrevious.setEnabled(false);
            rs.next();
            txtUserID.setText(rs.getString("UserID"));
            txtUserName.setText(rs.getString("UserName"));
            txtFullName.setText(rs.getString("FullName"));
            pwdPass.setText(rs.getString("Password"));
            txtUserAddress.setText(rs.getString("UserAddress"));
            txtTelephone.setText(rs.getString("Telephone"));
            txtdob.setText(rs.getString("DateOfBirth"));
            cbxDepartment.setSelectedItem(rs.getString("Department"));
            cbxDesignation.setSelectedItem(rs.getString("Designation"));
            if (rs.getString("Gender").equals("Male")) {
                chkMale.setSelected(true);
            } else {
                chkFemale.setSelected(true);
            }
            txtEmail.setText(rs.getString("Email"));
        } catch (SQLException ex) {
            Logger.getLogger(ManageUserForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:  
        edit = true;
        txtFullName.setEditable(true);
        txtUserAddress.setEditable(true);
        txtTelephone.setEditable(true);
        btnDOB.setEnabled(true);
        cbxDepartment.setEnabled(true);
        cbxDesignation.setEnabled(true);
        chkFemale.setEnabled(true);
        chkMale.setEnabled(true);
        txtEmail.setEditable(true);
        //set button
        btnNew.setEnabled(false);
        btnDelete.setEnabled(false);
        btnSave.setEnabled(true);
        btnCancel.setEnabled(true);
        btnNext.setEnabled(false);
        btnPrevious.setEnabled(false);
        btnEdit.setEnabled(false);
        this.cancel();
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnLoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoanActionPerformed
        // TODO add your handling code here:
        new LoanProcessForm(User, Role).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLoanActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        new SearchForm(User, Role).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        if (edit == true) {
            if (checkSave() == true && checkMail() == true && checkPhone() == true) {
                try {
                    rs.updateString("UserName", txtUserName.getText());
                    rs.updateString("FullName", txtFullName.getText());
                    rs.updateString("UserAddress", txtUserAddress.getText());
                    rs.updateString("Telephone", txtTelephone.getText());
                    rs.updateString("DateOfBirth", txtdob.getText());
                    rs.updateString("Department", cbxDepartment.getSelectedItem().toString());
                    rs.updateString("Designation", cbxDesignation.getSelectedItem().toString());
                    rs.updateString("Email", txtEmail.getText());
                    if (chkMale.isSelected()) {
                        rs.updateString("Gender", "Male");
                    } else {
                        rs.updateString("Gender", "Female");
                    }
                    if (rs.isBeforeFirst() == false) {
                        btnPrevious.setEnabled(true);
                    }
                    if (rs.isAfterLast() == false) {
                        btnNext.setEnabled(true);
                    }
                    rs.updateRow();
                    JOptionPane.showMessageDialog(null, "Save Success");
                } catch (SQLException ex) {
                    Logger.getLogger(UserForm.class.getName()).log(Level.SEVERE, null, ex);
                }
                //set disable
                txtFullName.setEditable(false);
                txtUserAddress.setEditable(false);
                txtTelephone.setEditable(false);
                btnDOB.setEnabled(false);
                cbxDepartment.setEnabled(false);
                cbxDesignation.setEnabled(false);
                chkFemale.setEnabled(false);
                chkMale.setEnabled(false);
                txtEmail.setEditable(false);
                btnNext.setEnabled(true);
                //set button
                btnEdit.setEnabled(true);
                btnNew.setEnabled(true);
                btnDelete.setEnabled(true);
                btnSave.setEnabled(false);
                btnCancel.setEnabled(false);
                btnNext.setEnabled(true);
                btnPrevious.setEnabled(true);
            } else {
                txtFullName.setText(oldFullName);
                txtUserAddress.setText(oldAdd);
                txtTelephone.setText(oldTel);
                txtdob.setText(oldDOB);
                cbxDepartment.setSelectedItem(oldDep);
                cbxDesignation.setSelectedItem(oldDesign);
                txtEmail.setText(oldEmail);
            }
        } else {
            try {
                if (checkSave() == true && checkUserName() == true && checkMail() == true && checkPhone() == true) {
                    try {
                        char[] oldPass = pwdPass.getPassword();
                        String password = new String(oldPass);
                        rs.moveToInsertRow();
                        rs.updateString("UserName", txtUserName.getText());
                        rs.updateString("FullName", txtFullName.getText());
                        rs.updateString("Password", password);
                        rs.updateString("UserAddress", txtUserAddress.getText());
                        rs.updateString("Telephone", txtTelephone.getText());
                        rs.updateString("DateOfBirth", txtdob.getText());
                        rs.updateString("Department", cbxDepartment.getSelectedItem().toString());
                        rs.updateString("Designation", cbxDesignation.getSelectedItem().toString());
                        rs.updateString("Email", txtEmail.getText());
                        if (chkMale.isSelected()) {
                            rs.updateString("Gender", "Male");
                        } else {
                            rs.updateString("Gender", "Female");
                        }
                        if (rs.isBeforeFirst() == false) {
                            btnPrevious.setEnabled(true);
                        }
                        if (rs.isAfterLast() == false) {
                            btnNext.setEnabled(true);
                        }
                        rs.insertRow();
                        JOptionPane.showMessageDialog(null, "Save Success");
                    } catch (SQLException ex) {
                        Logger.getLogger(ManageUserForm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    //set disable
                    txtFullName.setEditable(false);
                    txtUserAddress.setEditable(false);
                    txtTelephone.setEditable(false);
                    btnDOB.setEnabled(false);
                    cbxDepartment.setEnabled(false);
                    cbxDesignation.setEnabled(false);
                    chkFemale.setEnabled(false);
                    chkMale.setEnabled(false);
                    txtEmail.setEditable(false);
                    btnNext.setEnabled(true);
                    //set button
                    btnEdit.setEnabled(true);
                    btnNew.setEnabled(true);
                    btnDelete.setEnabled(true);
                    btnSave.setEnabled(false);
                    btnCancel.setEnabled(false);
                    btnNext.setEnabled(true);
                    btnPrevious.setEnabled(true);
                } else {
                    txtUserName.setText("");
                    txtFullName.setText("");
                    txtUserAddress.setText("");
                    txtTelephone.setText("");
                    txtEmail.setText("");
                    pwdPass.setText("11111111");
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ManageUserForm.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ManageUserForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        edit = false;
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        if (edit == true) {
            txtFullName.setText(oldFullName);
            txtUserAddress.setText(oldAdd);
            txtTelephone.setText(oldTel);
            txtdob.setText(oldDOB);
            cbxDepartment.setSelectedItem(oldDep);
            cbxDesignation.setSelectedItem(oldDesign);
            txtEmail.setText(oldEmail);
        } else {
            try {
                Connection cn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=LoanProcessingSystem", "sa", "123456");
                Statement s = cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                rs = s.executeQuery("SELECT * FROM tblUser");
                btnPrevious.setEnabled(false);
                rs.next();
                txtUserID.setText(rs.getString("UserID"));
                txtUserName.setText(rs.getString("UserName"));
                txtFullName.setText(rs.getString("FullName"));
                pwdPass.setText(rs.getString("Password"));
                txtUserAddress.setText(rs.getString("UserAddress"));
                txtTelephone.setText(rs.getString("Telephone"));
                txtdob.setText(rs.getString("DateOfBirth"));
                cbxDepartment.setSelectedItem(rs.getString("Department"));
                cbxDesignation.setSelectedItem(rs.getString("Designation"));
                if (rs.getString("Gender").equals("Male")) {
                    chkMale.setSelected(true);
                } else {
                    chkFemale.setSelected(true);
                }
                txtEmail.setText(rs.getString("Email"));
            } catch (SQLException sql) {
                sql.printStackTrace();
            }
        }
        edit = false;
        //set disable
        txtFullName.setEditable(false);
        txtUserAddress.setEditable(false);
        txtTelephone.setEditable(false);
        btnDOB.setEnabled(false);
        cbxDepartment.setEnabled(false);
        cbxDesignation.setEnabled(false);
        chkFemale.setEnabled(false);
        chkMale.setEnabled(false);
        txtEmail.setEditable(false);
        //set button
        btnEdit.setEnabled(true);
        btnNew.setEnabled(true);
        btnDelete.setEnabled(true);
        btnSave.setEnabled(false);
        btnCancel.setEnabled(false);
        btnNext.setEnabled(true);
        btnPrevious.setEnabled(true);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnDOBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDOBActionPerformed
        // TODO add your handling code here:
        DateChooser dateChooser = new DateChooser((Frame) null, "Select your birthday");
        Date getDate = new Date();
        getDate = dateChooser.select(getDate);
        if (getDate == null) {
            birthday = new Date();
            return;
        }
        birthday = getDate;
        SimpleDateFormat formatDate = new SimpleDateFormat("MM/dd/yyyy");
        txtdob.setText(formatDate.format(birthday));
    }//GEN-LAST:event_btnDOBActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        int dialog = JOptionPane.showConfirmDialog(null, "Do you want to log out?", "WARNING", JOptionPane.YES_NO_OPTION);
        if (dialog == JOptionPane.YES_OPTION) {
            new LoginForm().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        // TODO add your handling code here:
        txtUserName.setEditable(true);
        txtFullName.setEditable(true);
        txtUserAddress.setEditable(true);
        txtTelephone.setEditable(true);
        btnDOB.setEnabled(true);
        cbxDepartment.setEnabled(true);
        cbxDesignation.setEnabled(true);
        chkFemale.setEnabled(true);
        chkMale.setEnabled(true);
        txtEmail.setEditable(true);
        //set text
        txtUserName.setText("");
        txtFullName.setText("");
        txtUserAddress.setText("");
        txtTelephone.setText("");
        txtEmail.setText("");
        pwdPass.setText("11111111");
        //set button
        btnNew.setEnabled(false);
        btnDelete.setEnabled(false);
        btnPrevious.setEnabled(false);
        btnNext.setEnabled(false);
        btnEdit.setEnabled(false);
        btnSave.setEnabled(true);
        btnCancel.setEnabled(true);
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportActionPerformed
        // TODO add your handling code here:
        new ReportForm(User, Role).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnReportActionPerformed

    private void btnHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHelpActionPerformed
        // TODO add your handling code here:
        new Help(User, Role).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnHelpActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(ManageUserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ManageUserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ManageUserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ManageUserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ManageUserForm().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnChangePass;
    private javax.swing.JButton btnCustomer;
    private javax.swing.JButton btnDOB;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnHelp;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnLoan;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JButton btnReport;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUser;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cbxDepartment;
    private javax.swing.JComboBox cbxDesignation;
    private javax.swing.JRadioButton chkFemale;
    private javax.swing.JRadioButton chkMale;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JToolBar.Separator jSeparator8;
    private javax.swing.JLabel lblDepartment;
    private javax.swing.JLabel lblDesignation;
    private javax.swing.JLabel lblDesignation1;
    private javax.swing.JLabel lblDesignationText;
    private javax.swing.JLabel lblDob;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFullName;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JLabel lblImg;
    private javax.swing.JLabel lblPass;
    private javax.swing.JLabel lblSymbol;
    private javax.swing.JLabel lblTelephone;
    private javax.swing.JLabel lblUserAddress;
    private javax.swing.JLabel lblUserID;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JLabel lblUserName1;
    private javax.swing.JLabel lblUsertext;
    private javax.swing.JPanel pnlButtonLeft;
    private javax.swing.JPanel pnlButtonRight;
    private javax.swing.JPanel pnlContent;
    private javax.swing.JPanel pnlLeft;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JPanel pnlRight;
    private javax.swing.JPanel pnlStatus;
    private javax.swing.JPasswordField pwdPass;
    private javax.swing.JToolBar tbrMenu;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFullName;
    private javax.swing.JTextField txtTelephone;
    private javax.swing.JTextField txtUserAddress;
    private javax.swing.JTextField txtUserID;
    private javax.swing.JTextField txtUserName;
    private javax.swing.JTextField txtdob;
    // End of variables declaration//GEN-END:variables
}
