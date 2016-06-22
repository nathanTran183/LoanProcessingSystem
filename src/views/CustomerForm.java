/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.Frame;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.DateChooser;
import model.Validator;

/**
 *
 * @author Administrator
 */
public class CustomerForm extends javax.swing.JFrame {

//    CustomerForm cusForm = new CustomerForm();
    /**
     * Creates new form MainForm
     */
    String User, Role, id;
    int count;
    ResultSet rs, rt;
    Connection con;
    Statement sta;
    DefaultTableModel model;
    String oldID, oldName, oldIden, oldAdd, oldDOB, oldGen, oldTel, oldSal, oldJob, oldComName, oldEmail;
    Validator valid = new Validator();
    Date birthday = null;

    public void saveOld() {
        oldID = txtCusID.getText();
        oldName = txtFullName.getText();
        oldAdd = txtCusAdd.getText();
        oldDOB = txtDOB.getText();
        oldIden = txtIdentity.getText();
        oldGen = buttonGroup1.getSelection().toString();
        oldTel = txtTelephone.getText();
        oldSal = txtSalary.getText();
        oldJob = txtJob.getText();
        oldComName = txtComName.getText();
        oldEmail = txtEmail.getText();
    }

    public boolean checkMail() {
        if (!valid.validateEmail(txtEmail.getText())) {
            JOptionPane.showMessageDialog(null, "Email Not validate");
            return false;
        } else {
            return true;
        }
    }

    public boolean checkIdentity() {
        if (!valid.validatePhoneNumber(txtIdentity.getText().trim())) {
            JOptionPane.showMessageDialog(null, "Identity not validate");
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

    public void removeRow() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
    }

    public CustomerForm(String user, String role) throws ClassNotFoundException, SQLException {
        initComponents();
        User = user;
        Role = role;

        lblUsertext.setText(User);
        lblDesignationText.setText(Role);
        if (Role == "Administrator") {
            btnLoan.setEnabled(false);
        } else {
            btnLoan.setEnabled(true);
        }
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection cn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=LoanProcessingSystem", "sa", "123456");
        Statement s = cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        rs = s.executeQuery("SELECT * FROM tblCustomer");
        btnPrevious.setEnabled(false);
        rs.next();
        txtCusID.setText(rs.getString("CustomerID"));
        txtFullName.setText(rs.getString("CustomerName"));
        txtIdentity.setText(rs.getString("IdentityID"));
        txtCusAdd.setText(rs.getString("CustomerAddress"));
        txtDOB.setText(rs.getString("DateOfBirth"));
        if (rs.getString("Gender").equals("Male")) {
            chkMale.setSelected(true);
        } else {
            chkFemale.setSelected(true);
        }
        txtTelephone.setText(rs.getString("Telephone"));
        txtJob.setText(rs.getString("Job"));
        txtSalary.setText(rs.getString("Salary"));
        txtComName.setText(rs.getString("CompanyName"));
        txtEmail.setText(rs.getString("Email"));
        if (Role.equals("User")) {
            btnEdit.setEnabled(true);
            btnEditTable.setEnabled(true);
        } else {
            btnEdit.setEnabled(false);
            btnEditTable.setEnabled(false);
        }
        con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=LoanProcessingSystem", "sa", "123456");
        sta = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        rt = sta.executeQuery("SELECT [LoanID],[LoanTypeID],[Amount],[DateStart],[Duration]"
                + ",[IsActive] FROM tblLoanProcessing where CustomerID = '" + txtCusID.getText() + "'");
        model = (DefaultTableModel) jTable1.getModel();
        while (rt.next()) {
            model.addRow(new Object[]{rt.getString("LoanID"), rt.getString("LoanTypeID"),
                rt.getString("Amount"), rt.getString("DateStart"), rt.getString("Duration"),
                rt.getBoolean("IsActive")});
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
        pnlStatus = new javax.swing.JPanel();
        lblUserName = new javax.swing.JLabel();
        lblUsertext = new javax.swing.JLabel();
        lblDesignation = new javax.swing.JLabel();
        lblDesignationText = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        pnlContent = new javax.swing.JPanel();
        lblSymbol = new javax.swing.JLabel();
        pnlRight = new javax.swing.JPanel();
        lblHeader = new javax.swing.JLabel();
        lblCusID = new javax.swing.JLabel();
        lblFullName = new javax.swing.JLabel();
        lblCusAdd = new javax.swing.JLabel();
        lblDOB = new javax.swing.JLabel();
        lblCusIdentity = new javax.swing.JLabel();
        lblTelephone = new javax.swing.JLabel();
        lblGender = new javax.swing.JLabel();
        lblComName = new javax.swing.JLabel();
        lblJob = new javax.swing.JLabel();
        lblSalary = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        txtFullName = new javax.swing.JTextField();
        txtIdentity = new javax.swing.JTextField();
        txtCusID = new javax.swing.JTextField();
        txtCusAdd = new javax.swing.JTextField();
        txtDOB = new javax.swing.JTextField();
        btnDOB = new javax.swing.JButton();
        chkMale = new javax.swing.JRadioButton();
        chkFemale = new javax.swing.JRadioButton();
        txtTelephone = new javax.swing.JTextField();
        txtJob = new javax.swing.JTextField();
        txtSalary = new javax.swing.JTextField();
        txtComName = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        btnList = new javax.swing.JButton();
        btnPrevious = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnEdit = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnEditTable = new javax.swing.JButton();
        pnlMenu = new javax.swing.JPanel();
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
        pnlImg = new javax.swing.JPanel();
        lblImg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Loan Processing System");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        pnlStatus.setBackground(new java.awt.Color(255, 255, 255));
        pnlStatus.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlStatus.setCursor(new java.awt.Cursor(java.awt.Cursor.N_RESIZE_CURSOR));

        lblUserName.setBackground(new java.awt.Color(204, 255, 255));
        lblUserName.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lblUserName.setText("User Name: ");
        lblUserName.setPreferredSize(new java.awt.Dimension(80, 20));

        lblUsertext.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lblUsertext.setText("jLabel2");
        lblUsertext.setPreferredSize(new java.awt.Dimension(130, 20));

        lblDesignation.setBackground(new java.awt.Color(204, 255, 255));
        lblDesignation.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lblDesignation.setText("Designation:");
        lblDesignation.setPreferredSize(new java.awt.Dimension(80, 20));

        lblDesignationText.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lblDesignationText.setText("jLabel4");
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
                .addGap(68, 68, 68))
            .addGroup(pnlStatusLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(pnlStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlStatusLayout.createSequentialGroup()
                        .addComponent(lblUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(lblUsertext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlStatusLayout.createSequentialGroup()
                        .addComponent(lblDesignation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(lblDesignationText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        pnlStatusLayout.setVerticalGroup(
            pnlStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStatusLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(pnlStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUsertext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(pnlStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDesignation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDesignationText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLogout)
                .addContainerGap())
        );

        pnlContent.setBackground(new java.awt.Color(255, 255, 255));
        pnlContent.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Customer Form", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("VNI-Coronet", 0, 36), new java.awt.Color(0, 204, 255))); // NOI18N

        lblSymbol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/img/bgcontent.jpg"))); // NOI18N

        pnlRight.setBackground(new java.awt.Color(204, 255, 204));

        lblHeader.setFont(new java.awt.Font("UVN Lac Long Quan", 2, 22)); // NOI18N
        lblHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeader.setText("Customer Information");
        lblHeader.setPreferredSize(new java.awt.Dimension(700, 50));

        lblCusID.setFont(new java.awt.Font("Vijaya", 0, 20)); // NOI18N
        lblCusID.setText("Customer ID");
        lblCusID.setPreferredSize(new java.awt.Dimension(200, 25));

        lblFullName.setFont(new java.awt.Font("Vijaya", 0, 20)); // NOI18N
        lblFullName.setText("Full Name");
        lblFullName.setPreferredSize(new java.awt.Dimension(200, 25));

        lblCusAdd.setFont(new java.awt.Font("Vijaya", 0, 20)); // NOI18N
        lblCusAdd.setText("Customer Address");
        lblCusAdd.setPreferredSize(new java.awt.Dimension(200, 25));

        lblDOB.setFont(new java.awt.Font("Vijaya", 0, 20)); // NOI18N
        lblDOB.setText("Date Of Birth");
        lblDOB.setPreferredSize(new java.awt.Dimension(200, 25));

        lblCusIdentity.setFont(new java.awt.Font("Vijaya", 0, 20)); // NOI18N
        lblCusIdentity.setText("Identity ID");
        lblCusIdentity.setPreferredSize(new java.awt.Dimension(200, 25));

        lblTelephone.setFont(new java.awt.Font("Vijaya", 0, 20)); // NOI18N
        lblTelephone.setText("Telephone");
        lblTelephone.setPreferredSize(new java.awt.Dimension(200, 25));

        lblGender.setFont(new java.awt.Font("Vijaya", 0, 20)); // NOI18N
        lblGender.setText("Gender");
        lblGender.setPreferredSize(new java.awt.Dimension(200, 25));

        lblComName.setFont(new java.awt.Font("Vijaya", 0, 20)); // NOI18N
        lblComName.setText("Company Name");
        lblComName.setPreferredSize(new java.awt.Dimension(200, 25));

        lblJob.setFont(new java.awt.Font("Vijaya", 0, 20)); // NOI18N
        lblJob.setText("Job");
        lblJob.setPreferredSize(new java.awt.Dimension(200, 25));

        lblSalary.setFont(new java.awt.Font("Vijaya", 0, 20)); // NOI18N
        lblSalary.setText("Salary");
        lblSalary.setPreferredSize(new java.awt.Dimension(200, 25));

        lblEmail.setFont(new java.awt.Font("Vijaya", 0, 20)); // NOI18N
        lblEmail.setText("Email");
        lblEmail.setPreferredSize(new java.awt.Dimension(200, 25));

        txtFullName.setEditable(false);
        txtFullName.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtFullName.setPreferredSize(new java.awt.Dimension(450, 25));

        txtIdentity.setEditable(false);
        txtIdentity.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtIdentity.setPreferredSize(new java.awt.Dimension(450, 25));

        txtCusID.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtCusID.setEnabled(false);
        txtCusID.setPreferredSize(new java.awt.Dimension(450, 25));

        txtCusAdd.setEditable(false);
        txtCusAdd.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtCusAdd.setPreferredSize(new java.awt.Dimension(450, 25));

        txtDOB.setEditable(false);
        txtDOB.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtDOB.setPreferredSize(new java.awt.Dimension(450, 25));

        btnDOB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/img/btnCalendar.png"))); // NOI18N
        btnDOB.setText("Set Date");
        btnDOB.setEnabled(false);
        btnDOB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDOBActionPerformed(evt);
            }
        });

        buttonGroup1.add(chkMale);
        chkMale.setSelected(true);
        chkMale.setText("Male");
        chkMale.setEnabled(false);
        chkMale.setPreferredSize(new java.awt.Dimension(70, 25));

        buttonGroup1.add(chkFemale);
        chkFemale.setText("Female");
        chkFemale.setEnabled(false);
        chkFemale.setPreferredSize(new java.awt.Dimension(70, 25));

        txtTelephone.setEditable(false);
        txtTelephone.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtTelephone.setPreferredSize(new java.awt.Dimension(450, 25));

        txtJob.setEditable(false);
        txtJob.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtJob.setPreferredSize(new java.awt.Dimension(450, 25));

        txtSalary.setEditable(false);
        txtSalary.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtSalary.setPreferredSize(new java.awt.Dimension(450, 25));
        txtSalary.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSalaryKeyTyped(evt);
            }
        });

        txtComName.setEditable(false);
        txtComName.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtComName.setPreferredSize(new java.awt.Dimension(450, 25));

        txtEmail.setEditable(false);
        txtEmail.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtEmail.setPreferredSize(new java.awt.Dimension(450, 25));

        btnList.setText("Customer List");
        btnList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListActionPerformed(evt);
            }
        });

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

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Loan ID", "Loan Type", "Amount", "Date Start", "Duration", "Is Active"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setEnabled(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/img/btnedit.png"))); // NOI18N
        btnEdit.setText("Edit");
        btnEdit.setEnabled(false);
        btnEdit.setPreferredSize(new java.awt.Dimension(100, 25));
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/img/btnSave.png"))); // NOI18N
        btnSave.setText("Save");
        btnSave.setEnabled(false);
        btnSave.setPreferredSize(new java.awt.Dimension(100, 25));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/img/btnCancel.png"))); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.setEnabled(false);
        btnCancel.setPreferredSize(new java.awt.Dimension(100, 25));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnEditTable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/img/btnEditTable.gif"))); // NOI18N
        btnEditTable.setText("Edit Table");
        btnEditTable.setEnabled(false);
        btnEditTable.setPreferredSize(new java.awt.Dimension(100, 25));
        btnEditTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditTableActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlRightLayout = new javax.swing.GroupLayout(pnlRight);
        pnlRight.setLayout(pnlRightLayout);
        pnlRightLayout.setHorizontalGroup(
            pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRightLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRightLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblComName, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(lblGender, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                                .addComponent(lblDOB, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                .addComponent(lblCusAdd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                .addComponent(lblFullName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                .addComponent(lblCusID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                .addComponent(lblJob, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                .addComponent(lblEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)))
                        .addGap(27, 27, 27)
                        .addGroup(pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlRightLayout.createSequentialGroup()
                                .addComponent(txtCusID, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnList)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(pnlRightLayout.createSequentialGroup()
                                .addGroup(pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCusAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pnlRightLayout.createSequentialGroup()
                                        .addComponent(txtFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(32, 32, 32)
                                        .addComponent(lblCusIdentity, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(29, 29, 29)
                                        .addComponent(txtIdentity, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnlRightLayout.createSequentialGroup()
                                        .addGroup(pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtComName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                            .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                            .addGroup(pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(pnlRightLayout.createSequentialGroup()
                                                    .addComponent(txtDOB, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(btnDOB))
                                                .addGroup(pnlRightLayout.createSequentialGroup()
                                                    .addGroup(pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(chkMale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(pnlRightLayout.createSequentialGroup()
                                                            .addGap(99, 99, 99)
                                                            .addComponent(chkFemale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(txtJob, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGap(18, 18, 18)
                                                    .addGroup(pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(lblTelephone, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lblSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                        .addGap(16, 16, 16)
                                        .addGroup(pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtTelephone, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(pnlRightLayout.createSequentialGroup()
                        .addComponent(lblHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(23, Short.MAX_VALUE))))
            .addGroup(pnlRightLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRightLayout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRightLayout.createSequentialGroup()
                        .addComponent(btnPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 183, Short.MAX_VALUE)
                        .addGroup(pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlRightLayout.createSequentialGroup()
                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlRightLayout.createSequentialGroup()
                                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnEditTable, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(63, 63, 63))))
        );
        pnlRightLayout.setVerticalGroup(
            pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRightLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCusID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCusID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnList))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFullName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFullName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCusIdentity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdentity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCusAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCusAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDOB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkMale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkFemale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTelephone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelephone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblJob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtJob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblComName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtComName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlContentLayout = new javax.swing.GroupLayout(pnlContent);
        pnlContent.setLayout(pnlContentLayout);
        pnlContentLayout.setHorizontalGroup(
            pnlContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSymbol)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlRight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlContentLayout.setVerticalGroup(
            pnlContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContentLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(lblSymbol)
                .addContainerGap(47, Short.MAX_VALUE))
            .addGroup(pnlContentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlRight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlMenu.setBackground(new java.awt.Color(255, 255, 255));

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

        javax.swing.GroupLayout pnlMenuLayout = new javax.swing.GroupLayout(pnlMenu);
        pnlMenu.setLayout(pnlMenuLayout);
        pnlMenuLayout.setHorizontalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tbrMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 897, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlMenuLayout.setVerticalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tbrMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlImg.setBackground(new java.awt.Color(255, 255, 255));
        pnlImg.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblImg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/img/Userlogo.png"))); // NOI18N

        javax.swing.GroupLayout pnlImgLayout = new javax.swing.GroupLayout(pnlImg);
        pnlImg.setLayout(pnlImgLayout);
        pnlImgLayout.setHorizontalGroup(
            pnlImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImg, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        pnlImgLayout.setVerticalGroup(
            pnlImgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(pnlContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlImg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlImg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(1296, 802));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        // TODO add your handling code here:
        new HomeForm(User, Role).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnHomeActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:


    }//GEN-LAST:event_jTable1MouseClicked

    private void btnUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserActionPerformed
        // TODO add your handling code here:
        if (Role == "User") {
            try {
                new UserForm(User, Role).setVisible(true);
                this.dispose();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (Role == "Administrator") {
            try {
                new ManageUserForm(User, Role).setVisible(true);
                this.dispose();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(HomeForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnUserActionPerformed

    private void btnChangePassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangePassActionPerformed
        // TODO add your handling code here:
        new ChangePassForm(User, Role);
    }//GEN-LAST:event_btnChangePassActionPerformed

    private void btnCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustomerActionPerformed
        try {
            // TODO add your handling code here:
            new CustomerForm(User, Role).setVisible(true);
            this.dispose();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomerForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            Logger.getLogger(UserForm.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_btnCustomerActionPerformed

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

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListActionPerformed
        // TODO add your handling code here:
        try {
            new CusList().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(UserForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnListActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        try {
            removeRow();
            rs.next();
            btnPrevious.setEnabled(true);
            if (rs.isAfterLast()) {
                btnNext.setEnabled(false);
                JOptionPane.showMessageDialog(null, "Out of DATA!!!");
                btnEdit.setEnabled(false);
                btnEditTable.setEnabled(false);
            } else {
                while (rt.next()) {
                    model.removeRow(0);
                }
                txtCusID.setText(rs.getString("CustomerID"));
                txtFullName.setText(rs.getString("CustomerName"));
                txtIdentity.setText(rs.getString("IdentityID"));
                txtCusAdd.setText(rs.getString("CustomerAddress"));
                txtDOB.setText(rs.getString("DateOfBirth"));
                if (rs.getString("Gender").equals("Male")) {
                    chkMale.setSelected(true);
                } 
                if(rs.getString("Gender").equals("Female")){
                    chkFemale.setSelected(true);
                }
                txtTelephone.setText(rs.getString("Telephone"));
                txtJob.setText(rs.getString("Job"));
                txtSalary.setText(rs.getString("Salary"));
                txtComName.setText(rs.getString("CompanyName"));
                txtEmail.setText(rs.getString("Email"));
                if (Role.equals("User")) {
                    btnEdit.setEnabled(true);
                    btnEditTable.setEnabled(true);
                } else {
                    btnEdit.setEnabled(false);
                    btnEditTable.setEnabled(false);
                }
                rt = sta.executeQuery("SELECT [LoanID],[LoanTypeID],[Amount],[DateStart],[Duration]"
                        + ",[IsActive] FROM tblLoanProcessing where CustomerID = '" + txtCusID.getText() + "'");
                model = (DefaultTableModel) jTable1.getModel();
                while (rt.next()) {
                    model.addRow(new Object[]{rt.getString("LoanID"), rt.getString("LoanTypeID"),
                        rt.getString("Amount"), rt.getString("DateStart"), rt.getString("Duration"),
                        rt.getBoolean("IsActive")});

                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserForm.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
        // TODO add your handling code here:
        try {
            removeRow();
            rs.previous();
            btnNext.setEnabled(true);
            if (rs.isBeforeFirst()) {
                btnPrevious.setEnabled(false);
                JOptionPane.showMessageDialog(null, "Out of DATA!!!");
                btnEdit.setEnabled(false);
                btnEditTable.setEnabled(false);
            } else {
                while (rt.next()) {
                    model.removeRow(1);
                }
                txtCusID.setText(rs.getString("CustomerID"));
                txtFullName.setText(rs.getString("CustomerName"));
                txtIdentity.setText(rs.getString("IdentityID"));
                txtCusAdd.setText(rs.getString("CustomerAddress"));
                txtDOB.setText(rs.getString("DateOfBirth"));
                if (rs.getString("Gender").equals("Male")) {
                    chkMale.setSelected(true);
                } else {
                    chkFemale.setSelected(true);
                }
                txtTelephone.setText(rs.getString("Telephone"));
                txtJob.setText(rs.getString("Job"));
                txtSalary.setText(rs.getString("Salary"));
                txtComName.setText(rs.getString("CompanyName"));
                txtEmail.setText(rs.getString("Email"));
                if (Role.equals("User")) {
                    btnEdit.setEnabled(true);
                    btnEditTable.setEnabled(true);
                } else {
                    btnEdit.setEnabled(false);
                    btnEditTable.setEnabled(false);
                }
                rt = sta.executeQuery("SELECT [LoanID],[LoanTypeID],[Amount],[DateStart],[Duration]"
                        + ",[IsActive] FROM tblLoanProcessing where CustomerID = '" + txtCusID.getText() + "'");
                model = (DefaultTableModel) jTable1.getModel();
                while (rt.next()) {
                    model.addRow(new Object[]{rt.getString("LoanID"), rt.getString("LoanTypeID"),
                        rt.getString("Amount"), rt.getString("DateStart"), rt.getString("Duration"),
                        rt.getBoolean("IsActive")});

                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserForm.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPreviousActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        int dialog = JOptionPane.showConfirmDialog(null, "Do you want to log out?", "WARNING", JOptionPane.YES_NO_OPTION);
        if (dialog == JOptionPane.YES_OPTION) {
            new LoginForm().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        //set button
        btnEdit.setEnabled(false);
        txtIdentity.setEditable(true);
        btnEditTable.setEnabled(false);
        btnList.setEnabled(false);
        btnSave.setEnabled(true);
        btnCancel.setEnabled(true);
        btnPrevious.setEnabled(false);
        btnNext.setEnabled(false);
        btnDOB.setEnabled(true);
        chkFemale.setEnabled(true);
        chkMale.setEnabled(true);
        //set field
        txtFullName.setEditable(true);
        txtCusAdd.setEditable(true);
        txtTelephone.setEditable(true);
        txtJob.setEditable(true);
        txtSalary.setEditable(true);
        txtComName.setEditable(true);
        txtEmail.setEditable(true);
        saveOld();
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        if (checkIdentity() == true && checkMail() == true && checkPhone() == true) {
            try {
                
                rs.updateString("CustomerName", txtFullName.getText());
                rs.updateString("IdentityID", txtIdentity.getText());
                rs.updateString("CustomerAddress", txtCusAdd.getText());
                rs.updateString("DateOfBirth", txtDOB.getText());
                if (chkMale.isSelected()) {
                    rs.updateString("Gender", "Male");
                } else {
                    rs.updateString("Gender", "Female");
                }
                rs.updateString("Telephone", txtTelephone.getText());
                rs.updateString("Job", txtJob.getText());
                rs.updateString("Salary", txtSalary.getText());
                rs.updateString("CompanyName", txtComName.getText());
                rs.updateString("Email", txtEmail.getText());
                rs.updateRow();
                JOptionPane.showMessageDialog(null, "Save Success");
                //set button
                jTable1.setEnabled(false);
                if (rs.isBeforeFirst() == false) {
                    btnPrevious.setEnabled(true);
                }
                if (rs.isAfterLast() == false) {
                    btnNext.setEnabled(true);
                }
                btnSave.setEnabled(false);
                btnCancel.setEnabled(false);
                if (Role.equals("User")) {
                    btnEdit.setEnabled(true);
                    btnEditTable.setEnabled(true);
                } else {
                    btnEdit.setEnabled(false);
                    btnEditTable.setEnabled(false);
                }
                //set field
                txtFullName.setEditable(false);
                txtCusAdd.setEditable(false);
                txtTelephone.setEditable(false);
                txtJob.setEditable(false);
                txtSalary.setEditable(false);
                txtComName.setEditable(false);
                txtEmail.setEditable(false);
                btnDOB.setEnabled(false);
                btnList.setEnabled(true);

            } catch (SQLException ex) {
                Logger.getLogger(CustomerForm.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        txtCusID.setText(oldID);
        txtFullName.setText(oldName);
        txtIdentity.setText(oldIden);
        txtCusAdd.setText(oldAdd);
        txtDOB.setText(oldDOB);
        if (oldGen.equals("Male")) {
            chkMale.setSelected(true);
        } else {
            chkFemale.setSelected(true);
        }
        txtTelephone.setText(oldTel);
        txtJob.setText(oldJob);
        txtSalary.setText(oldSal);
        txtComName.setText(oldComName);
        txtEmail.setText(oldEmail);
        if (Role.equals("User")) {
            btnEdit.setEnabled(true);
        } else {
            btnEdit.setEnabled(false);
        }
        try {
            //set button
            jTable1.setEnabled(false);
            if (rs.isBeforeFirst() == false) {
                btnPrevious.setEnabled(true);
            }
            if (rs.isAfterLast() == false) {
                btnNext.setEnabled(true);
            }
            btnSave.setEnabled(false);
            btnCancel.setEnabled(false);
            if (Role.equals("User")) {
                btnEdit.setEnabled(true);
                btnEditTable.setEnabled(true);
            } else {
                btnEdit.setEnabled(false);
                btnEditTable.setEnabled(false);
            }
            //set field
            txtFullName.setEditable(false);
            txtCusAdd.setEditable(false);
            txtTelephone.setEditable(false);
            txtJob.setEditable(false);
            txtSalary.setEditable(false);
            txtComName.setEditable(false);
            txtEmail.setEditable(false);
            btnDOB.setEnabled(false);
            btnList.setEnabled(true);

        } catch (SQLException ex) {
            Logger.getLogger(CustomerForm.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

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
        txtDOB.setText(formatDate.format(birthday));
    }//GEN-LAST:event_btnDOBActionPerformed

    private void btnEditTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditTableActionPerformed
        try {
            // TODO add your handling code here:
            new editTableCus(txtCusID.getText(), txtSalary.getText()).setVisible(true);

        } catch (SQLException ex) {
            Logger.getLogger(CustomerForm.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEditTableActionPerformed

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

    private void txtSalaryKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSalaryKeyTyped
        // TODO add your handling code here:
        String filterStr = "0123456789.";
        char c = (char) evt.getKeyChar();
        if (filterStr.indexOf(c) < 0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtSalaryKeyTyped

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
    //            java.util.logging.Logger.getLogger(CustomerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //        } catch (InstantiationException ex) {
    //            java.util.logging.Logger.getLogger(CustomerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //        } catch (IllegalAccessException ex) {
    //            java.util.logging.Logger.getLogger(CustomerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
    //            java.util.logging.Logger.getLogger(CustomerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //        }
    //        //</editor-fold>
    //
    //        /* Create and display the form */
    //        java.awt.EventQueue.invokeLater(new Runnable() {
    //            public void run() {
    //                new CustomerForm().setVisible(true);
    //            }
    //        });
    //    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnChangePass;
    private javax.swing.JButton btnCustomer;
    private javax.swing.JButton btnDOB;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnEditTable;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnHelp;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnList;
    private javax.swing.JButton btnLoan;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JButton btnReport;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUser;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton chkFemale;
    private javax.swing.JRadioButton chkMale;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JToolBar.Separator jSeparator8;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblComName;
    private javax.swing.JLabel lblCusAdd;
    private javax.swing.JLabel lblCusID;
    private javax.swing.JLabel lblCusIdentity;
    private javax.swing.JLabel lblDOB;
    private javax.swing.JLabel lblDesignation;
    private javax.swing.JLabel lblDesignationText;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFullName;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JLabel lblImg;
    private javax.swing.JLabel lblJob;
    private javax.swing.JLabel lblSalary;
    private javax.swing.JLabel lblSymbol;
    private javax.swing.JLabel lblTelephone;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JLabel lblUsertext;
    private javax.swing.JPanel pnlContent;
    private javax.swing.JPanel pnlImg;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JPanel pnlRight;
    private javax.swing.JPanel pnlStatus;
    private javax.swing.JToolBar tbrMenu;
    private javax.swing.JTextField txtComName;
    private javax.swing.JTextField txtCusAdd;
    private javax.swing.JTextField txtCusID;
    private javax.swing.JTextField txtDOB;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFullName;
    private javax.swing.JTextField txtIdentity;
    private javax.swing.JTextField txtJob;
    private javax.swing.JTextField txtSalary;
    private javax.swing.JTextField txtTelephone;
    // End of variables declaration//GEN-END:variables
}
