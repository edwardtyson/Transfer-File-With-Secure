package ftp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.security.spec.KeySpec;
import java.util.Base64;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author bisicetea
 */
public class Client extends javax.swing.JFrame {

    /**
     * Creates new form Client
     */
    public Client() throws Exception {
        initComponents();
        this.setTitle("FTP Client");
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        frmMenu = new javax.swing.JFrame();
        jPanel4 = new javax.swing.JPanel();
        txt_Path = new javax.swing.JTextField();
        btn_List = new javax.swing.JButton();
        btn_Back = new javax.swing.JButton();
        btn_Send = new javax.swing.JButton();
        btn_Receive = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        lb2 = new javax.swing.JLabel();
        lb_User = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lst_Server = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        lst_Client = new javax.swing.JList<>();
        btn_Browser = new javax.swing.JButton();
        btn_Logout = new javax.swing.JButton();
        btn_Receive1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jsepa = new javax.swing.JSeparator();
        fcPath = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        separator = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_Username = new javax.swing.JTextField();
        txt_Password = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        btn_Login = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jPanel4.setBackground(new java.awt.Color(255, 204, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(1120, 550));

        btn_List.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btn_List.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ftp/listed.png"))); // NOI18N
        btn_List.setText("List");
        btn_List.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ListActionPerformed(evt);
            }
        });

        btn_Back.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btn_Back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ftp/back.png"))); // NOI18N
        btn_Back.setText("Back");
        btn_Back.setPreferredSize(new java.awt.Dimension(85, 33));
        btn_Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BackActionPerformed(evt);
            }
        });

        btn_Send.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btn_Send.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ftp/icons8_upload_30px_6.png"))); // NOI18N
        btn_Send.setText("Upload");
        btn_Send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SendActionPerformed(evt);
            }
        });

        btn_Receive.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btn_Receive.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ftp/download.png"))); // NOI18N
        btn_Receive.setText("Download");
        btn_Receive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ReceiveActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ftp/server.png"))); // NOI18N
        jLabel6.setText("Server Browser:");

        lb2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lb2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ftp/userFTP.png"))); // NOI18N
        lb2.setText("User: ");

        lb_User.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        lst_Server.setSelectionBackground(new java.awt.Color(192, 56, 226));
        jScrollPane1.setViewportView(lst_Server);

        lst_Client.setSelectionBackground(new java.awt.Color(192, 56, 226));
        jScrollPane2.setViewportView(lst_Client);

        btn_Browser.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btn_Browser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ftp/icons8_server_30px.png"))); // NOI18N
        btn_Browser.setText("BROWSER");
        btn_Browser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BrowserActionPerformed(evt);
            }
        });

        btn_Logout.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_Logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ftp/logout.png"))); // NOI18N
        btn_Logout.setText("Logout");
        btn_Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LogoutActionPerformed(evt);
            }
        });

        btn_Receive1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btn_Receive1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ftp/delete.png"))); // NOI18N
        btn_Receive1.setText("Delete");
        btn_Receive1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Receive1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ftp/Copyright.png"))); // NOI18N
        jLabel2.setText("Cody by bisiceteaSec");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ftp/ftp.png"))); // NOI18N

        jsepa.setBackground(new java.awt.Color(0, 0, 0));
        jsepa.setForeground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(btn_Send, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(199, 199, 199))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(83, 83, 83)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(50, 50, 50)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_Browser)
                        .addGap(193, 193, 193)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(lb2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lb_User)
                            .addGap(94, 94, 94)
                            .addComponent(btn_Logout))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txt_Path, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(btn_Receive)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_Receive1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btn_Back, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btn_List, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(43, 43, 43))))
                .addGap(0, 9, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jsepa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(36, 36, 36))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb2)
                            .addComponent(lb_User)
                            .addComponent(btn_Logout))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_Path, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btn_Browser, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel7)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(btn_List, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_Back, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Send, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Receive, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Receive1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jsepa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout frmMenuLayout = new javax.swing.GroupLayout(frmMenu.getContentPane());
        frmMenu.getContentPane().setLayout(frmMenuLayout);
        frmMenuLayout.setHorizontalGroup(
            frmMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frmMenuLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 1138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 45, Short.MAX_VALUE))
        );
        frmMenuLayout.setVerticalGroup(
            frmMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 102, 0));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ftp/ftp-upload.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(61, 61, 61))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel5)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        separator.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 0));
        jLabel1.setText("LOGIN");

        txt_Username.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txt_Username.setText("Username");
        txt_Username.setBorder(null);
        txt_Username.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_UsernameFocusGained(evt);
            }
        });

        txt_Password.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txt_Password.setText("Password");
        txt_Password.setBorder(null);
        txt_Password.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_PasswordFocusGained(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        btn_Login.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_Login.setForeground(new java.awt.Color(255, 102, 0));
        btn_Login.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_Login.setText("LOGIN");
        btn_Login.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn_Login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_LoginMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_Login, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_Login, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
        );

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ftp/icons8_contacts_30px.png"))); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ftp/icons8_lock_30px.png"))); // NOI18N

        javax.swing.GroupLayout separatorLayout = new javax.swing.GroupLayout(separator);
        separator.setLayout(separatorLayout);
        separatorLayout.setHorizontalGroup(
            separatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(separatorLayout.createSequentialGroup()
                .addContainerGap(71, Short.MAX_VALUE)
                .addGroup(separatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, separatorLayout.createSequentialGroup()
                        .addGroup(separatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(separatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator2)
                            .addComponent(jSeparator1)
                            .addComponent(txt_Username)
                            .addComponent(txt_Password, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE))
                        .addGap(78, 78, 78))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, separatorLayout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(150, 150, 150))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, separatorLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(177, 177, 177))))
        );
        separatorLayout.setVerticalGroup(
            separatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(separatorLayout.createSequentialGroup()
                .addGroup(separatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(separatorLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel1)
                        .addGap(34, 34, 34)
                        .addComponent(txt_Username, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(separatorLayout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(jLabel3)))
                .addGroup(separatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(separatorLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel4))
                    .addGroup(separatorLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_Password, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(separator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(separator, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    class ftp
    {
        Socket ClientSoc;
        DataInputStream din;
        Scanner sc;
        PrintWriter pw;
        DataOutputStream dout;
        BufferedReader br;
        String dir, clientDir = "";
        private static final String SECRET_KEY = "sup3r_s3cr3t_k3y_by_b1s1c3t3aS3c";
        private static final String SALT = "sup3r_s4lt_h1h1_b1s1c3t3a";
        ftp(Socket soc)
        {

            try
            {
                ClientSoc = soc;
                din = new DataInputStream(ClientSoc.getInputStream());
                sc = new Scanner(ClientSoc.getInputStream());
                pw = new PrintWriter(ClientSoc.getOutputStream(), true);
                dout = new DataOutputStream(ClientSoc.getOutputStream());
                br = new BufferedReader(new InputStreamReader(System.in));
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null, ex.toString());
            }        
        }
        void SendFile() throws Exception
        {
            dout.writeUTF("SEND");
            
            String fileName = clientDir + lst_Client.getSelectedValue();
            File f = new File(fileName);
            dout.writeUTF(fileName);

            String msgFromServer = din.readUTF();
            if (msgFromServer.compareTo("File Already Exists") == 0)
            {
                int a = JOptionPane.showConfirmDialog(null, "File already exists. Want to overwrite it ?", "Notification", JOptionPane.OK_CANCEL_OPTION);
                if(a == 0)    
                {
                    dout.writeUTF("Y");
                }
                else
                {
                    dout.writeUTF("N");
                    return;
                }
            }
            System.out.println("Sending File ...");
            FileInputStream fin = new FileInputStream(f);
            int ch;
            do
            {
                ch = fin.read();
                dout.writeUTF(String.valueOf(ch));
            }
            while(ch != -1);
            fin.close();
            System.out.println(din.readUTF());
            JOptionPane.showConfirmDialog(null, "File Send Successfully!!!", "Notification", JOptionPane.DEFAULT_OPTION);
            t.BrowseDirectory();
        }

        void ReceiveFile() throws Exception
        {
            dout.writeUTF("RECEIVE");
            String fileName = dir + lst_Server.getSelectedValue();
            
            dout.writeUTF(fileName);
            
            String msgFromServer = din.readUTF();
            if(msgFromServer.compareTo("File Not Found") == 0)
            {
                JOptionPane.showConfirmDialog(null, "Bruh!! File not found on server!!!", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }
            else if(msgFromServer.compareTo("READY") == 0)
            {
                File f = new File(clientDir + lst_Server.getSelectedValue());
                if(f.exists())
                {
                    String Option;
                    int a = JOptionPane.showConfirmDialog(null, "File already exists. Want to overwrite it ?", "Notification", JOptionPane.OK_CANCEL_OPTION);          
                    if(a == 2)    
                    {
                        dout.flush();
                        return;    
                    }                
                }
                FileOutputStream fout = new FileOutputStream(f);
                int ch;
                String temp;
                do
                {
                    temp = din.readUTF();
                    ch = Integer.parseInt(temp);
                    if(ch != -1)
                    {
                        fout.write(ch);                    
                    }
                }
                while(ch != -1);
                fout.close();
                System.out.println(din.readUTF());
            }
            JOptionPane.showConfirmDialog(null, "File Receive Successfully!!!", "Notification", JOptionPane.DEFAULT_OPTION);
        }
        void BrowseDirectory() throws Exception
        {
            try
            {
                String path = txt_Path.getText();
                if(path.charAt(path.length() - 1) != '/')
                    txt_Path.setText(path + '/');
                dout.writeUTF("LIST");
                String fileName = txt_Path.getText();
                dout.writeUTF(fileName);
                String msgFromServer = din.readUTF();
                System.out.print(msgFromServer);
                DefaultListModel dlm = new DefaultListModel();
                if (msgFromServer.compareTo("Dinvalid") == 0)
                {
                    JOptionPane.showMessageDialog(null, "Wrong path. Can not access!!!", "ERROR", JOptionPane.ERROR_MESSAGE);
                    btn_Send.setEnabled(false);
                    btn_Receive.setEnabled(false);
                    btn_Back.setEnabled(false);
                    return;
                }
                else
                {
                    if (msgFromServer.compareTo("PM") == 0)
                    {
                        JOptionPane.showMessageDialog(null, "Permission denied!!!", "ERROR", JOptionPane.ERROR_MESSAGE);
                        String[] part = dir.split("/");
                        dir = "";
                        for (int i = 0; i < part.length - 1; i++)
                            dir += part[i] + "/";
                        txt_Path.setText(dir);
                        t.BrowseDirectory();
                        btn_Receive.setEnabled(false);
                        return;
                    }
                    else
                    {
                        if(msgFromServer.compareTo("IsFile") == 0)
                        {
                            JOptionPane.showMessageDialog(null, "This is File not Folder bro :v.", "ERROR", JOptionPane.ERROR_MESSAGE);
                            String[] part = dir.split("/");
                            dir = "";
                            for (int i = 0; i < part.length - 1; i++)
                                dir += part[i] + "/";
                            txt_Path.setText(dir);
                            t.BrowseDirectory();
                            return;
                        }

                        else
                        {
                            dir = fileName;

                            int mountD = din.read();
                            for (int i = 0; i < mountD; i++)
                                dlm.addElement(din.readUTF());

                            int mountF = din.read();
                            for (int i = 0; i < mountF; i++)
                                dlm.addElement(din.readUTF());
                        }
                        lst_Server.setModel(dlm);
                        btn_Back.setEnabled(true);
                        btn_Receive.setEnabled(true);
                    }
                }
            }
            catch (Exception ex)
            {
                JOptionPane.showMessageDialog(null, ex.toString());
            }
        }

        void BackDirectory() throws Exception
        {
            dout.writeUTF("LIST");
            DefaultListModel dlm = new DefaultListModel();
            if(dir.equals("/"))
            {
                t.BrowseDirectory();
                return;
            }
            else
            {
                int countSlash = 0;
                String path = txt_Path.getText();
                for (int i = 0; i < path.length(); i++)
                    if (path.charAt(i) == '/')
                        countSlash++;
                if (countSlash == 2)
                    dir = "/";
                else
                {
                    int k = dir.lastIndexOf('/');
                    char dst[] = new char[1000];
                    dir.getChars(0, dir.length(), dst, 0);
                    dst[k] = '?';
                    String str = new String(dst, 0, k);
                    k = str.lastIndexOf('/');
                    str.getChars(0, k - 1, dst, 0);
                    dir = new String(dst, 0, k + 1);
                }
                dout.writeUTF(dir);
                //lb_Pwd.setText("PWD: " + dir);
                txt_Path.setText(dir);
            }
            String msgFromServer = din.readUTF();
            System.out.print(msgFromServer);
            if(msgFromServer.compareTo("Dinvalid") == 0)
            {
                JOptionPane.showMessageDialog(null, "Wrong path or action invalid!");
                btn_Receive.setEnabled(false);
                return;
            }
            else
            {
                int mountD = din.read();
                for (int i = 0; i < mountD; i++)
                    dlm.addElement(din.readUTF());
                int mountF = din.read();
                for (int i = 0; i < mountF; i++)
                    dlm.addElement(din.readUTF());
            }
            lst_Server.setModel(dlm);
            btn_Back.setEnabled(true);
            btn_Receive.setEnabled(true);
        }

        public void Login() throws Exception
        {
            String usr = txt_Username.getText();
            dout.writeUTF(encrypt(usr, "akuma"));
            String pass = txt_Password.getText();
            dout.writeUTF(encrypt(pass, "bisicetea"));

            
            String reply = din.readUTF();
            System.out.println(reply);
            if(reply.equalsIgnoreCase("login successful"))
            {
                JOptionPane.showMessageDialog(null, "Login successful!", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                setVisible(false);
                
                frmMenu.setDefaultCloseOperation(frmMenu.EXIT_ON_CLOSE);
                frmMenu.setPreferredSize(new Dimension(1150, 605));
                frmMenu.pack();
                frmMenu.setVisible(true);
                lb_User.setText(usr);
                frmMenu.setTitle("FTP - code by Bisicetea ft Akuma");
                btn_Back.setEnabled(false);
                btn_Send.setEnabled(false);
                btn_Receive.setEnabled(false);
                jsepa.setBackground(Color.BLACK);
                
                lst_Server.addMouseListener(new MouseAdapter()
                {
                    public void mouseClicked(MouseEvent e)
                    {
                        if(e.getClickCount()==2)
                        {
                            String path = txt_Path.getText();
                            String fileName = lst_Server.getSelectedValue();
                            txt_Path.setText(path + fileName + "/");
                            dir = txt_Path.getText();
                            try {
                                t.BrowseDirectory();
                            } catch (Exception ex) {
                                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                });
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Login failed!");
            }
        }
        
        public static String encrypt(String strToEncrypt) throws Exception
        {

            byte[] iv = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            IvParameterSpec ivspec = new IvParameterSpec(iv);

            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            KeySpec spec = new PBEKeySpec(SECRET_KEY.toCharArray(), SALT.getBytes(), 65536, 256);
            SecretKey tmp = factory.generateSecret(spec);
            SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivspec);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes(StandardCharsets.UTF_8)));
        }
        
        public void clientBrowser()
        {
            fcPath.setVisible(true);
            fcPath.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            if(fcPath.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            try
            {
                String path = fcPath.getSelectedFile().getCanonicalPath();
                File dir = new File(path);
                File dsFile[] = dir.listFiles();
                if (dsFile == null)
                {
                    JOptionPane.showMessageDialog(null, "Folder empty!!!", "Notification", JOptionPane.INFORMATION_MESSAGE);
                    btn_Send.setEnabled(false);
                }
                else
                {
                    clientDir = path + "\\";
                    DefaultListModel dlm = new DefaultListModel();
                    for (int i = 0; i < dsFile.length; i++)
                    {
                        if(dsFile[i].isFile())
                            dlm.addElement(dsFile[i].getName());
                    }
                    lst_Client.setModel(dlm);
                    btn_Send.setEnabled(true);
                }
            }
            catch (Exception ex)
            {
                System.out.print(ex.toString());
            }
        }
        public void Logout() throws IOException
        {
            frmMenu.setVisible(false);
            dout.writeUTF("LOGOUT");
        }
    }
    
    Socket socfd = new Socket("192.168.174.132", 21113);
    ftp t = new ftp(socfd);
    
    private void txt_UsernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_UsernameFocusGained
        txt_Username.setText("");
    }//GEN-LAST:event_txt_UsernameFocusGained

    private void txt_PasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_PasswordFocusGained
        txt_Password.setText("");
    }//GEN-LAST:event_txt_PasswordFocusGained

    private void btn_LoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_LoginMouseClicked
        try
        {
            t.Login();
        }
        catch (Exception ex)
        {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_LoginMouseClicked

    private void btn_ListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ListActionPerformed
        if (txt_Path.getText().compareTo("") == 0)
            JOptionPane.showMessageDialog(null, "Let's enter directory!");
        else
        {
            try
            {
                t.BrowseDirectory();
            }
            catch (Exception ex)
            {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btn_ListActionPerformed

    private void btn_BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BackActionPerformed
        try
        {
            t.BackDirectory();
        }
        catch (Exception ex)
        {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_BackActionPerformed

    private void btn_SendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SendActionPerformed
        if (txt_Path.getText().compareTo("") == 0)
        {
            JOptionPane.showMessageDialog(null, "Bruh, enter path of server first bro!!!", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            try
            {
                t.SendFile();
            }
            catch (Exception ex)
            {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btn_SendActionPerformed

    private void btn_BrowserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BrowserActionPerformed
        t.clientBrowser();
    }//GEN-LAST:event_btn_BrowserActionPerformed

    private void btn_ReceiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ReceiveActionPerformed
        if(lst_Client.getModel().getSize() == 0)
        {
            JOptionPane.showMessageDialog(null, "Bruh, enter path of client first bro!!!", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            try
            {
                t.ReceiveFile();
            }
            catch (Exception ex)
            {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btn_ReceiveActionPerformed

    private void btn_LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LogoutActionPerformed
        try {
            t.Logout();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setVisible(true);
    }//GEN-LAST:event_btn_LogoutActionPerformed

    private void btn_Receive1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Receive1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_Receive1ActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try
                {
                    new Client().setVisible(true);
                }
                catch (Exception ex)
                {
                    JOptionPane.showConfirmDialog(null, "TURN ON SERVER FIRST BROOOOO!!!", "Notification", JOptionPane.DEFAULT_OPTION);
                    Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Back;
    private javax.swing.JButton btn_Browser;
    private javax.swing.JButton btn_List;
    private javax.swing.JLabel btn_Login;
    private javax.swing.JButton btn_Logout;
    private javax.swing.JButton btn_Receive;
    private javax.swing.JButton btn_Receive1;
    private javax.swing.JButton btn_Send;
    private javax.swing.JFileChooser fcPath;
    private javax.swing.JFrame frmMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jsepa;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lb_User;
    private javax.swing.JList<String> lst_Client;
    private javax.swing.JList<String> lst_Server;
    private javax.swing.JPanel separator;
    private javax.swing.JPasswordField txt_Password;
    private javax.swing.JTextField txt_Path;
    private javax.swing.JTextField txt_Username;
    // End of variables declaration//GEN-END:variables
}
