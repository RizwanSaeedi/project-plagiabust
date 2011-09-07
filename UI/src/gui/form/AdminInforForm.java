/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AdminInforForm.java
 *
 * Created on Aug 30, 2011, 7:26:06 PM
 */
package gui.form;

import internetsearch.BingSearch;
import internetsearch.GoogleSearch;
import internetsearch.InternetSearchAPI;

/**
 *
 * @author Kasun
 */
public class AdminInforForm extends javax.swing.JFrame {

    private static InternetSearchAPI searchAPI;
    private final String bingAppId = "F138552F897E2CA7C264FDAC64F8EF2021ABD3AF";
    private final String googleAppId = "AIzaSyBPM9e5SyUgJBEbz5l8J6LoKsbWxGFo-B0";

    /** Creates new form AdminInforForm */
    public AdminInforForm() {
        initComponents();
        this.setDefaults();
        this.setIconImage(Main.getPlagiabustImage());
    }

    public static InternetSearchAPI getInternetSearchAPI() {
        return searchAPI;
    }

    public void setDefaults() {
        bingSearchRadioButton.setSelected(true);
        bingIdTextField.setText(bingAppId);
        googleIdTextField.setText(googleAppId);
        searchAPI = new BingSearch(bingAppId);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        DeleteDocumentPanel = new javax.swing.JPanel();
        enterGoogleIdLabel = new javax.swing.JLabel();
        googleIdTextField = new javax.swing.JTextField();
        googleImageLabel = new javax.swing.JLabel();
        googleKeyTextField = new javax.swing.JPanel();
        enterBingIdLabel = new javax.swing.JLabel();
        bingIdTextField = new javax.swing.JTextField();
        bingImageLabel = new javax.swing.JLabel();
        DeleteDocumentPanel2 = new javax.swing.JPanel();
        bingSearchRadioButton = new javax.swing.JRadioButton();
        selectSearchAPILable = new javax.swing.JLabel();
        googleSearchRadioButton = new javax.swing.JRadioButton();
        setDefaultButton = new javax.swing.JButton();
        DoneButton = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Internet Search Configuration Manager");

        DeleteDocumentPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Google", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        DeleteDocumentPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        DeleteDocumentPanel.setName("Google"); // NOI18N

        enterGoogleIdLabel.setFont(new java.awt.Font("Tahoma", 0, 12));
        enterGoogleIdLabel.setText("Search Application Key");

        googleImageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Google.png"))); // NOI18N

        javax.swing.GroupLayout DeleteDocumentPanelLayout = new javax.swing.GroupLayout(DeleteDocumentPanel);
        DeleteDocumentPanel.setLayout(DeleteDocumentPanelLayout);
        DeleteDocumentPanelLayout.setHorizontalGroup(
            DeleteDocumentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DeleteDocumentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DeleteDocumentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DeleteDocumentPanelLayout.createSequentialGroup()
                        .addComponent(enterGoogleIdLabel)
                        .addGap(18, 18, 18)
                        .addComponent(googleIdTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE))
                    .addComponent(googleImageLabel))
                .addContainerGap())
        );
        DeleteDocumentPanelLayout.setVerticalGroup(
            DeleteDocumentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DeleteDocumentPanelLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(googleImageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(DeleteDocumentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(enterGoogleIdLabel)
                    .addComponent(googleIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        googleKeyTextField.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bing", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        googleKeyTextField.setName("Bing"); // NOI18N

        enterBingIdLabel.setFont(new java.awt.Font("Tahoma", 0, 12));
        enterBingIdLabel.setText("Search Application Key");

        bingImageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bing.png"))); // NOI18N

        javax.swing.GroupLayout googleKeyTextFieldLayout = new javax.swing.GroupLayout(googleKeyTextField);
        googleKeyTextField.setLayout(googleKeyTextFieldLayout);
        googleKeyTextFieldLayout.setHorizontalGroup(
            googleKeyTextFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(googleKeyTextFieldLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(googleKeyTextFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(googleKeyTextFieldLayout.createSequentialGroup()
                        .addComponent(bingImageLabel)
                        .addContainerGap(542, Short.MAX_VALUE))
                    .addGroup(googleKeyTextFieldLayout.createSequentialGroup()
                        .addComponent(enterBingIdLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bingIdTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
                        .addGap(18, 18, 18))))
        );
        googleKeyTextFieldLayout.setVerticalGroup(
            googleKeyTextFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, googleKeyTextFieldLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bingImageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(googleKeyTextFieldLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(enterBingIdLabel)
                    .addComponent(bingIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        DeleteDocumentPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Select Option", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        DeleteDocumentPanel2.setName("Bing"); // NOI18N

        buttonGroup1.add(bingSearchRadioButton);
        bingSearchRadioButton.setFont(new java.awt.Font("Tahoma", 0, 12));
        bingSearchRadioButton.setSelected(true);
        bingSearchRadioButton.setText("Bing");
        bingSearchRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bingSearchRadioButtonActionPerformed(evt);
            }
        });

        selectSearchAPILable.setFont(new java.awt.Font("Tahoma", 0, 12));
        selectSearchAPILable.setText("Search Choice");
        selectSearchAPILable.setRequestFocusEnabled(false);
        selectSearchAPILable.setVerifyInputWhenFocusTarget(false);

        buttonGroup1.add(googleSearchRadioButton);
        googleSearchRadioButton.setFont(new java.awt.Font("Tahoma", 0, 12));
        googleSearchRadioButton.setText("Google");

        setDefaultButton.setFont(new java.awt.Font("Tahoma", 0, 12));
        setDefaultButton.setText("Set Default");
        setDefaultButton.setPreferredSize(new java.awt.Dimension(180, 40));
        setDefaultButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setDefaultButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout DeleteDocumentPanel2Layout = new javax.swing.GroupLayout(DeleteDocumentPanel2);
        DeleteDocumentPanel2.setLayout(DeleteDocumentPanel2Layout);
        DeleteDocumentPanel2Layout.setHorizontalGroup(
            DeleteDocumentPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DeleteDocumentPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(selectSearchAPILable)
                .addGap(33, 33, 33)
                .addComponent(bingSearchRadioButton)
                .addGap(18, 18, 18)
                .addComponent(googleSearchRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 298, Short.MAX_VALUE)
                .addComponent(setDefaultButton, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        DeleteDocumentPanel2Layout.setVerticalGroup(
            DeleteDocumentPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DeleteDocumentPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DeleteDocumentPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectSearchAPILable)
                    .addComponent(bingSearchRadioButton)
                    .addComponent(googleSearchRadioButton)
                    .addComponent(setDefaultButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        DoneButton.setFont(new java.awt.Font("Tahoma", 0, 12));
        DoneButton.setText("Done");
        DoneButton.setPreferredSize(new java.awt.Dimension(180, 40));
        DoneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DoneButtonActionPerformed(evt);
            }
        });

        CancelButton.setFont(new java.awt.Font("Tahoma", 0, 12));
        CancelButton.setText("Cancel");
        CancelButton.setPreferredSize(new java.awt.Dimension(180, 40));
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DeleteDocumentPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DeleteDocumentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(googleKeyTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(DoneButton, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(CancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DeleteDocumentPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(googleKeyTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(DeleteDocumentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DoneButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        DeleteDocumentPanel.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bingSearchRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bingSearchRadioButtonActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_bingSearchRadioButtonActionPerformed

    private void DoneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DoneButtonActionPerformed
        if (bingSearchRadioButton.isSelected()) {
            searchAPI = new BingSearch(bingIdTextField.getText());
        } else {
            searchAPI = new GoogleSearch(googleIdTextField.getText());
        }
        this.setVisible(false);
}//GEN-LAST:event_DoneButtonActionPerformed

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        this.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_CancelButtonActionPerformed

    private void setDefaultButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setDefaultButtonActionPerformed
        this.setDefaults();
        // TODO add your handling code here:
    }//GEN-LAST:event_setDefaultButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelButton;
    private javax.swing.JPanel DeleteDocumentPanel;
    private javax.swing.JPanel DeleteDocumentPanel2;
    private javax.swing.JButton DoneButton;
    private javax.swing.JTextField bingIdTextField;
    private javax.swing.JLabel bingImageLabel;
    private javax.swing.JRadioButton bingSearchRadioButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel enterBingIdLabel;
    private javax.swing.JLabel enterGoogleIdLabel;
    private javax.swing.JTextField googleIdTextField;
    private javax.swing.JLabel googleImageLabel;
    private javax.swing.JPanel googleKeyTextField;
    private javax.swing.JRadioButton googleSearchRadioButton;
    private javax.swing.JLabel selectSearchAPILable;
    private javax.swing.JButton setDefaultButton;
    // End of variables declaration//GEN-END:variables
}