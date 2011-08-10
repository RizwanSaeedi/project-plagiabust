/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Help.java
 *
 * Created on Aug 10, 2011, 6:54:27 PM
 */
package gui.form;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JList;

/**
 *
 * @author Compaq
 */
public class Help extends javax.swing.JFrame {
    
    
    File afile = new File("Resources"+File.separatorChar+"helpfiles");

    /** Creates new form Help */
    public Help() throws IOException {
        initComponents();
        loadFiles(afile);
        
    }
    
    public void loadFiles(File f)
    {
        String[] files = f.list();
        javax.swing.DefaultListModel dm = new javax.swing.DefaultListModel();
        for(int i=0;i<files.length;i++)
        {
            dm.addElement(files[i].replace(".txt", ""));
        }
        list.setModel(dm);
    }

    public void showSelectedFile(String selectedValue) throws IOException{
        editorPane.setPage("file:///"+System.getProperty("user.dir")+File.separatorChar+"Resources"+File.separatorChar+"helpfiles"+File.separatorChar+selectedValue+".txt");
    }
    
    
    
    
    
    
    

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        list = new javax.swing.JList();
        spane = new javax.swing.JScrollPane();
        editorPane = new javax.swing.JEditorPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Help & Support");

        jSplitPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jSplitPane1.setDividerLocation(100);

        list.setBorder(javax.swing.BorderFactory.createTitledBorder("Content"));
        list.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        list.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(list);

        jSplitPane1.setLeftComponent(jScrollPane1);

        editorPane.setBorder(javax.swing.BorderFactory.createTitledBorder("Description"));
        spane.setViewportView(editorPane);

        jSplitPane1.setRightComponent(spane);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listValueChanged
       String selectedval = null;
        
         if (!evt.getValueIsAdjusting()) {
            JList list = (JList) evt.getSource();            
            selectedval = (String) list.getSelectedValue();
        }
        if (selectedval != null) {
            try {
                showSelectedFile(selectedval);
            } catch (IOException ex) {
                Logger.getLogger(Help.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        // TODO add your handling code here:
    }//GEN-LAST:event_listValueChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    new Help().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Help.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JEditorPane editorPane;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JList list;
    private javax.swing.JScrollPane spane;
    // End of variables declaration//GEN-END:variables
}
