/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DocumentManagerForm.java
 *
 * Created on Jun 5, 2011, 11:41:05 AM
 */
package gui.form;

import dataExtraction.DocumentFilter;
import java.io.File;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Brave Heart
 */
enum TableColumns{
    FileName,
    Destination,
}

public class PlagiabustServerDocumentManagerForm extends javax.swing.JFrame {

    DefaultTableModel tableModel;
    public static String fileName;
    public static String folderpath;
    private  ArrayList<String> documentList = new ArrayList<String>();

    public ArrayList<String> getDocumentList() {
        return documentList;
    }

    /** Creates new form DocumentManagerForm */
    public PlagiabustServerDocumentManagerForm() {
        initComponents();
        setFormStyle();
        tableModel = getDefaultTableModel();
        DocumentTable.setModel(tableModel);
        DocumentTable.setDefaultRenderer(Object.class, new TableRenderer());
    }

    private DefaultTableModel getDefaultTableModel() {
        String[] columns = {"File Name", "Destination"};
        DefaultTableModel defaultTableModel = new DefaultTableModel(columns, 0);

        return defaultTableModel;
    }

    private void setFormStyle() {
        this.RemoveFilesButton.setEnabled(false);
        this.DoneButton.setEnabled(false);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        DocumentManagerMainPanel = new javax.swing.JPanel();
        CommandPanel = new javax.swing.JPanel();
        AddFilesButton = new javax.swing.JButton();
        RemoveFilesButton = new javax.swing.JButton();
        DoneButton = new javax.swing.JButton();
        DocumentManagerImageLabel = new javax.swing.JLabel();
        DocumentTableScrollPane = new javax.swing.JScrollPane();
        DocumentTable = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;   //Disallow the editing of any cell
            }};
            DocumentTableSeparator = new javax.swing.JSeparator();
            NumOfDocumentsLabel = new javax.swing.JLabel();

            jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null}
                },
                new String [] {
                    "Title 1", "Title 2", "Title 3", "Title 4"
                }
            ));
            jScrollPane1.setViewportView(jTable1);

            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            setTitle("Document Manager");
            setIconImages(null);
            setResizable(false);

            DocumentManagerMainPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Select Files :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
            DocumentManagerMainPanel.setFont(new java.awt.Font("Tahoma", 0, 12));
            DocumentManagerMainPanel.setPreferredSize(new java.awt.Dimension(600, 360));

            CommandPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Commands :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

            AddFilesButton.setFont(new java.awt.Font("Tahoma", 0, 12));
            AddFilesButton.setText("Add Files");
            AddFilesButton.setPreferredSize(new java.awt.Dimension(180, 40));
            AddFilesButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    AddFilesButtonActionPerformed(evt);
                }
            });

            RemoveFilesButton.setFont(new java.awt.Font("Tahoma", 0, 12));
            RemoveFilesButton.setText("Remove Files");
            RemoveFilesButton.setPreferredSize(new java.awt.Dimension(180, 40));
            RemoveFilesButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    RemoveFilesButtonActionPerformed(evt);
                }
            });

            DoneButton.setFont(new java.awt.Font("Tahoma", 0, 12));
            DoneButton.setText("Done");
            DoneButton.setPreferredSize(new java.awt.Dimension(180, 40));
            DoneButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    DoneButtonActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout CommandPanelLayout = new javax.swing.GroupLayout(CommandPanel);
            CommandPanel.setLayout(CommandPanelLayout);
            CommandPanelLayout.setHorizontalGroup(
                CommandPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(CommandPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(CommandPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(DoneButton, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE)
                        .addComponent(RemoveFilesButton, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE)
                        .addComponent(AddFilesButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            CommandPanelLayout.setVerticalGroup(
                CommandPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(CommandPanelLayout.createSequentialGroup()
                    .addComponent(AddFilesButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(RemoveFilesButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(DoneButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
            );

            DocumentManagerImageLabel.setBackground(new java.awt.Color(255, 255, 255));
            DocumentManagerImageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/resource/image/background/DocumentManager.png"))); // NOI18N

            DocumentTable.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
            DocumentTable.setFont(new java.awt.Font("Tahoma", 0, 12));
            DocumentTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {

                }
            ));
            DocumentTable.getTableHeader().setResizingAllowed(false);
            DocumentTable.getTableHeader().setReorderingAllowed(false);
            DocumentTableScrollPane.setViewportView(DocumentTable);
            DocumentTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

            DocumentTableSeparator.setOrientation(javax.swing.SwingConstants.VERTICAL);

            javax.swing.GroupLayout DocumentManagerMainPanelLayout = new javax.swing.GroupLayout(DocumentManagerMainPanel);
            DocumentManagerMainPanel.setLayout(DocumentManagerMainPanelLayout);
            DocumentManagerMainPanelLayout.setHorizontalGroup(
                DocumentManagerMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DocumentManagerMainPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(DocumentManagerMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(DocumentManagerImageLabel, 0, 0, Short.MAX_VALUE)
                        .addComponent(CommandPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(DocumentTableSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(DocumentTableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
                    .addContainerGap())
            );
            DocumentManagerMainPanelLayout.setVerticalGroup(
                DocumentManagerMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DocumentManagerMainPanelLayout.createSequentialGroup()
                    .addGroup(DocumentManagerMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(DocumentTableScrollPane, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                        .addComponent(DocumentTableSeparator, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                        .addGroup(DocumentManagerMainPanelLayout.createSequentialGroup()
                            .addComponent(DocumentManagerImageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(CommandPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap())
            );

            NumOfDocumentsLabel.setFont(new java.awt.Font("Tahoma", 0, 12));
            NumOfDocumentsLabel.setText("Documents added. - ");

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(NumOfDocumentsLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 714, Short.MAX_VALUE)
                        .addComponent(DocumentManagerMainPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 714, Short.MAX_VALUE))
                    .addContainerGap())
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(DocumentManagerMainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(NumOfDocumentsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)
                    .addContainerGap())
            );

            pack();
        }// </editor-fold>//GEN-END:initComponents

    private void bindDatatoTable(File selectedFolder) {
        File[] selectedFileArray = selectedFolder.listFiles(new DocumentFilter());
        ArrayList<SelectedFile> selectedFileList = new ArrayList<SelectedFile>();

        for (int i = 0; i < selectedFileArray.length; i++) {
            File file = selectedFileArray[i];

            if (file.isFile()) {
                SelectedFile selectedFile = new SelectedFile();
                selectedFile.fileName = file.getName();
                selectedFile.location = file.getPath();
                selectedFileList.add(selectedFile);
            }
        }

        for (int i = 0; i < selectedFileList.size(); i++) {
            Vector row = new Vector();
            row.add(selectedFileList.get(i).fileName);
            row.add(selectedFileList.get(i).location);
            tableModel.addRow(row);
        }

        DocumentTable.setModel(tableModel);
        this.RemoveFilesButton.setEnabled(true);
        this.DoneButton.setEnabled(true);
    }

    private void AddFilesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddFilesButtonActionPerformed

        final JFileChooser fc = new JFileChooser(Main.getDesktop());
        fc.setApproveButtonText("Select");
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnVal = fc.showOpenDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File selectedFolder = fc.getSelectedFile();
            folderpath = selectedFolder.getAbsolutePath();
            this.bindDatatoTable(selectedFolder);
            fc.setVisible(false);
        }
    }//GEN-LAST:event_AddFilesButtonActionPerformed

    private void RemoveFilesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveFilesButtonActionPerformed
        int selectedRowCount = DocumentTable.getSelectedRowCount();
        int firstSelectedRow = DocumentTable.getSelectedRow();

        for (int i = 0; i < selectedRowCount; i++) {
            tableModel.removeRow(firstSelectedRow);
        }

        DocumentTable.setModel(tableModel);
    }//GEN-LAST:event_RemoveFilesButtonActionPerformed

    private void DoneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DoneButtonActionPerformed
       
        int rowCount = DocumentTable.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            documentList.add((String) tableModel.getValueAt(i, TableColumns.Destination.ordinal()));
        }
        this.dispose();
    }//GEN-LAST:event_DoneButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddFilesButton;
    private javax.swing.JPanel CommandPanel;
    private javax.swing.JLabel DocumentManagerImageLabel;
    private javax.swing.JPanel DocumentManagerMainPanel;
    private javax.swing.JTable DocumentTable;
    private javax.swing.JScrollPane DocumentTableScrollPane;
    private javax.swing.JSeparator DocumentTableSeparator;
    private javax.swing.JButton DoneButton;
    private javax.swing.JLabel NumOfDocumentsLabel;
    private javax.swing.JButton RemoveFilesButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
