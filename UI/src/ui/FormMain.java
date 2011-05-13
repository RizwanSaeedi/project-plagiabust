/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FormMain.java
 *
 * Created on Apr 25, 2011, 1:10:07 PM
 */

package ui;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import net.didion.jwnl.JWNLException;
import reportingModule.TextFieldDemo;

/**
 *
 * @author Brave Heart
 */
public class FormMain extends javax.swing.JFrame {
    private File file1;
    private File selectFile1;
    private File selectFile2;
    final static Color  HILIT_COLOR = Color.LIGHT_GRAY;
    final static Color  ERROR_COLOR = Color.PINK;
    Color entryBg;
    int numberOfFiles;
    Highlighter hilit = new DefaultHighlighter();
    Highlighter hilit2 = new DefaultHighlighter();;
    String[][] temp = null;   /////////// declared as a global variable

    Highlighter.HighlightPainter painter;

    private String fileName;
    /** Creates new form FormMain */
    public FormMain() {
        try{
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        }
        catch(Exception ex)
        {

        }

        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel14 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 24));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1240, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 476, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Overview", jPanel1);

        jTabbedPane2.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane2.setFont(new java.awt.Font("Tahoma", 0, 18));

        jLabel4.setText("Select the Document Folder");

        jButton1.setText("Browse");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancel");

        jButton3.setText("Check");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(67, 67, 67))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)))
                .addGap(100, 100, 100)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3)
                    .addComponent(jButton1))
                .addContainerGap(271, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton3)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(95, 95, 95))
        );

        jTabbedPane2.addTab("Plagiarism Check", jPanel5);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1067, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 449, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Critical info", jPanel7);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1067, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 449, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Logs", jPanel8);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1067, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 449, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Custom Settings", jPanel9);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1067, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 449, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Feedback", jPanel13);

        jTextArea2.setColumns(20);
        jTextArea2.setLineWrap(true);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jTextArea3.setColumns(20);
        jTextArea3.setLineWrap(true);
        jTextArea3.setRows(5);
        jScrollPane3.setViewportView(jTextArea3);

        jLabel5.setText("Search");

        jLabel6.setText("file 1");

        jButton4.setText("Select");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel7.setText("File 2");

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jButton5.setText("Select");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Show");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Search");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Next");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("Previous");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                .addGap(313, 313, 313))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGap(54, 54, 54)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField4)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))
                                .addGap(36, 36, 36)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton5)
                                    .addComponent(jButton4)
                                    .addComponent(jButton6)))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jButton7))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jButton8)
                                .addGap(18, 18, 18)
                                .addComponent(jButton9))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(jLabel8)))
                .addContainerGap(463, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4)
                    .addComponent(jButton8)
                    .addComponent(jButton9))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton5)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton7)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane2.addTab("Latest Results", jPanel6);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1220, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Plagiarism Check", jPanel2);

        jTabbedPane3.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane3.setFont(new java.awt.Font("Tahoma", 0, 18));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1072, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 449, Short.MAX_VALUE)
        );

        jTabbedPane3.addTab("Search Students", jPanel10);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1072, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 449, Short.MAX_VALUE)
        );

        jTabbedPane3.addTab("Black List", jPanel11);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1072, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 449, Short.MAX_VALUE)
        );

        jTabbedPane3.addTab("Enroll Students", jPanel12);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1220, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Student Profiles", jPanel3);

        jTabbedPane4.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane4.setFont(new java.awt.Font("Tahoma", 0, 18));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/spinning_globe.gif"))); // NOI18N

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(959, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(338, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("Internet Search", jPanel14);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/0017.gif"))); // NOI18N

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(968, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(341, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("Peer Search", jPanel15);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/0048.gif"))); // NOI18N

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap(947, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(342, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("Database Search", jPanel16);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1220, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Settings", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1245, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        final JFileChooser fc = new JFileChooser();
        fc.setApproveButtonText("Select");
	fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnVal = fc.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            file1 = fc.getSelectedFile();
            this.jTextField1.setText(file1.toString());
	        System.out.println(fc.getSelectedFile().getAbsolutePath());
	        fileName= fc.getSelectedFile().getAbsolutePath();
	        fc.setVisible(false);
	              //  jTextArea1.setText(match);
        }
                // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed



        Manager manager = new Manager();
            
        try {
            temp = manager.manage(fileName);
        } catch (IOException ex) {
            Logger.getLogger(FormMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JWNLException ex) {
            Logger.getLogger(FormMain.class.getName()).log(Level.SEVERE, null, ex);
        }
            jTextArea1.setText(temp[0][1]+"\n"+temp[0][1]+"\n"+temp[0][2]);// TODO add your handling code here
            jTextField3.setText(temp[0][0]);
            jTextField4.setText(temp[0][1]);
            jTextField2.setText(temp[0][2]);

            String fileName1=jTextField3.getText();
            String fileName2=jTextField4.getText();


            jTabbedPane2.setSelectedIndex(5);
            setTextToTextFields(fileName1, fileName2);
            


    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       final JFileChooser fc = new JFileChooser();
        int returnVal = fc.showOpenDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            selectFile2 = fc.getSelectedFile();           
            this.jTextField4.setText(selectFile2.toString());
        }

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        final JFileChooser fc = new JFileChooser();
        int returnVal = fc.showOpenDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            selectFile1 = fc.getSelectedFile();            
            this.jTextField3.setText(selectFile1.toString());
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        String fileName1=jTextField3.getText();
        String fileName2=jTextField4.getText();


        File testFile1=new File(fileName1);
        File testFile2=new File(fileName2);
        String field1="";
        String field2="";
        try {
            FileReader fr = new FileReader(testFile1);
            FileReader fr2 = new FileReader(testFile2);

            BufferedReader br=new BufferedReader(fr);
            BufferedReader br2=new BufferedReader(fr2);
            System.out.println("testing phase");
            try {
                while (br.readLine()!= null) {
                    field1=field1+br.readLine();
                }
                while (br2.readLine()!= null) {
                    field2=field2+br2.readLine();
                }
                
            } catch (IOException ex) {
                Logger.getLogger(FormMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FormMain.class.getName()).log(Level.SEVERE, null, ex);
        }
System.out.println(field1);
System.out.println(field2);
jTextArea2.setText(field1);
jTextArea3.setText(field2);




    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

            
        painter = new DefaultHighlighter.DefaultHighlightPainter(HILIT_COLOR);
        jTextArea2.setHighlighter(hilit);
        jTextArea3.setHighlighter(hilit2);
        hilit.removeAllHighlights();
        hilit2.removeAllHighlights();
        entryBg = jTextField2.getBackground();
        //jTextField4.getDocument().addDocumentListener();

        //InputMap im = jTextField2.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        //ActionMap am = jTextField2.getActionMap();
        //TextFieldDemo textDemo=new TextFieldDemo()
        //im.put(KeyStroke.getKeyStroke("ESCAPE"), CANCEL_ACTION);
        //am.put(CANCEL_ACTION, new CancelAction());
        // hilit.removeAllHighlights();

        String string = jTextField2.getText().toLowerCase();
        String[] query=null;
        if (string.length() <= 0) {
            //message("Nothing to search");
            return;
        }

        if(string.contains(":")){

           query = string.split(":");

        }
 else{
            query=new String[1];
            query[0]=string;
 }



        String content = jTextArea2.getText();
        String content2 = jTextArea3.getText();

        for(int i=0;i<query.length;i++){

         String s=query[i];
         int index = content.indexOf(s);
         int index2 = content2.indexOf(s);
        while (index != -1) {   // match found
            try {

               
                if(index!=-1){
                int end = index + s.length();
                hilit.addHighlight(index, end, painter);
                jTextArea2.setCaretPosition(end);
                jTextField2.setBackground(entryBg);
                }
                System.out.println("first file index= "+index);
                index = content.indexOf(s,index+s.length());

                //message("'" + s + "' found. Press ESC to end search");
            } catch (BadLocationException e) {
                e.printStackTrace();
            }
        }

            while (index2 != -1) {  // match found
            try {
               
                 if(index2!=-1){
                int end2 = index2 + s.length();
                hilit2.addHighlight(index2, end2, painter);
                jTextArea3.setCaretPosition(end2);
                jTextField2.setBackground(entryBg);
                }
                   System.out.println("second file index= "+index2);
                  index2 = content2.indexOf(s,index2+s.length());
               // message("'" + s + "' found. Press ESC to end search");
            } catch (BadLocationException e) {
                e.printStackTrace();
            }
        }
        }

    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed

      
        numberOfFiles++;
        System.out.println(numberOfFiles);
        jTextField3.setText(temp[numberOfFiles][0]);
        jTextField4.setText(temp[numberOfFiles][1]);
        jTextField2.setText(temp[numberOfFiles][2]);
        setTextToTextFields(temp[numberOfFiles][0], temp[numberOfFiles][1]);
        
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed

        numberOfFiles--;
        System.out.println(numberOfFiles);
        jTextField3.setText(temp[numberOfFiles][0]);
        jTextField4.setText(temp[numberOfFiles][1]);
        jTextField2.setText(temp[numberOfFiles][2]);
        setTextToTextFields(temp[numberOfFiles][0], temp[numberOfFiles][1]);


    }//GEN-LAST:event_jButton9ActionPerformed


    void message(String msg) {
        jLabel8.setText(msg);
    }

     public void setTextToTextFields(String fileName1,String fileName2){

         if(fileName1==null|| fileName2==null){
             jTextArea2.setText("");
            jTextArea3.setText("");
         }
 else{

         File testFile1=new File(fileName1);
        File testFile2=new File(fileName2);
        String field1="";
        String field2="";
        try {
            FileReader fr = new FileReader(testFile1);
            FileReader fr2 = new FileReader(testFile2);

            BufferedReader br=new BufferedReader(fr);
            BufferedReader br2=new BufferedReader(fr2);
            System.out.println("testing phase");
            try {
                while (br.readLine()!= null) {
                    field1=field1+br.readLine();
                }
                while (br2.readLine()!= null) {
                    field2=field2+br2.readLine();
                }

            } catch (IOException ex) {
                Logger.getLogger(FormMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FormMain.class.getName()).log(Level.SEVERE, null, ex);
        }
jTextArea2.setText(field1.toLowerCase());
jTextArea3.setText(field2.toLowerCase());
         }
    }
    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables

}
