/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * NewJFrame.java
 *
 * Created on Jun 9, 2011, 8:44:05 PM
 */
package reportingModule;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.AttributedString;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.JComboBox;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.text.Utilities;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JRViewer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import ui.FileOperator;

/**
 *
 * @author user
 */
public class ReportingModule extends javax.swing.JFrame {

    JRViewer jrv;
    HashMap hm = new HashMap();
    String[][] resultArray;
    String selectedDocumentPath;
    int numberOfFiles;
    Highlighter hilit = new DefaultHighlighter();
    Highlighter hilit2 = new DefaultHighlighter();
    Highlighter hilit3 = new DefaultHighlighter();
    final static Color HILIT_COLOR = new Color(255, 160, 122);
    Highlighter.HighlightPainter painter;
    ArrayList peerDocs = new ArrayList();
    ArrayList urlListTemp = new ArrayList();
    HashMap<String, String> matchingToPreprocessed = new HashMap<String, String>();
    ArrayList<String> urlArray = new ArrayList<String>();
    HashMap<String, ArrayList<Integer>> indexHighligherMap = new HashMap<String, ArrayList<Integer>>();
    ArrayList peers = new ArrayList();
    HashMap<String, String> fileToUrlMap = new HashMap<String, String>();

    /** Creates new form NewJFrame */
    public ReportingModule() {


        this.setSize(500, 500);
        initComponents();
        PreviousButton.setEnabled(false);
        jTabbedPane1.setEnabledAt(1, false);
        jTabbedPane1.setEnabledAt(2, false);
        jTabbedPane1.setEnabledAt(3, false);
        browserPanel.setVisible(false);
        jTextField1.setVisible(false);
    }

    public DefaultPieDataset createPieDataset() {


        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Original", new Double(43.2));
        dataset.setValue("Plagarizm Suspected", new Double(10.0));
        dataset.setValue("Refereenced", new Double(27.5));
        return dataset;

    }

    private JFreeChart createChart(PieDataset dataset) {

        JFreeChart chart = ChartFactory.createPieChart3D(
                "Plagiarism Statistics", // chart title
                dataset, // data
                true, // include legend
                true,
                false);

        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setLabelFont(new Font("SansSerif", Font.PLAIN, 12));
        plot.setNoDataMessage("No data available");
        plot.setCircular(false);
        plot.setLabelGap(0.02);
        return chart;

    }

    public BufferedImage createChart() {

        DefaultPieDataset pie = this.createPieDataset();
        JFreeChart jf = this.createChart(pie);
        return jf.createBufferedImage(500, 500);



    }

    public void generateResults() {

        File file = new File(selectedDocumentPath);
        textSetter m = new textSetter();
        String content = m.textSetter(file.getAbsolutePath());
        String fileName = file.getAbsolutePath();
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("h:mm a");
        String time = sdf.format(cal.getTime());
        BufferedImage bf = this.createChart();


        for (int i = 0; i < resultArray.length; i++) {

            if (resultArray[i][1] != null) {
                peers.add(resultArray[i][1]);
            }

        }

        while (peers.size() != 10) {

            peers.add(" ");

        }




        for (int i = 0; i < urlListTemp.size(); i++) {

            peerDocs.add(urlListTemp.get(i));
        }

        while (peerDocs.size() != 10) {

            peerDocs.add(" ");

        }



        hm.put("image", bf);
        hm.put("field", content);
        hm.put("time", time);
        hm.put("docName", fileName);
        hm.put("peerDocs", peerDocs);
        hm.put("peers", peers);


        JasperReport jasperReport;
        JasperPrint jasperPrint;

        try {

            //jasperReport = JasperCompileManager.compileReport(
             //       "jasper/report2.jrxml");

            jasperPrint = JasperFillManager.fillReport(
                    "jasper/report2.jasper", hm, new JREmptyDataSource());
            jrv = new JRViewer(jasperPrint);


            jrv.addHyperlinkListener(new ReportHyperlinkListner());

            jasperReportScrollPane.getViewport().add(jrv);


        } catch (JRException e) {
            e.printStackTrace();
        }
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
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        browserPanel = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        browser = new javax.swing.JEditorPane();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        showFileContentTextPane = new javax.swing.JTextPane();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        selectedFileEditorPane = new javax.swing.JEditorPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        suspectedFileEditorPane = new javax.swing.JEditorPane();
        jButton4 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        fileListComboBox = new javax.swing.JComboBox();
        jTextField1 = new javax.swing.JTextField();
        selectedFileTextField = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jasperReportScrollPane = new javax.swing.JScrollPane(jrv);
        jPanel1 = new javax.swing.JPanel();
        nextButton = new javax.swing.JButton();
        PreviousButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jScrollPane3.setBorder(null);

        jTextArea1.setColumns(20);
        jTextArea1.setEditable(false);
        jTextArea1.setFont(new java.awt.Font("DejaVu Sans", 1, 11));
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("\n\n\nThis Wizard will guide you to view the Plagiarism check results of the selected single Document. \nFeatues include\n\n1. On Screen View\nIn the Report OnScreen View of the plagiarism Check results, you can view the document along with the possible plagirized phrases highlighted in red colour. You can view the source of the plagiarized by clicking on the phrase. The content of the file will be displayed in the browser section.\n\n2. Dynamic Cross Check\nYou can select the file you want to compare from the list and the contents along with the similarity phrases will be highlighted in a relevant colours.\n\n3. Final Report\nAll the Details of the plagiarism Check will be displayed in a single report, Including the possible plagiarized sources and the possible internet Sources. Document Statictics will be displayed in a graphical chart.");
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setBorder(javax.swing.BorderFactory.createTitledBorder("Welcome"));
        jScrollPane3.setViewportView(jTextArea1);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 18));
        jLabel1.setText("Welcome to the Plagiarism Results Viewer");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/welcome-icon.png"))); // NOI18N

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/welcome-icon.png"))); // NOI18N

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1.jpg"))); // NOI18N

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/3.jpg"))); // NOI18N

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/4.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jLabel4)
                        .addGap(141, 141, 141)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76)
                        .addComponent(jLabel8))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(600, 600, 600))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(143, 143, 143)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(750, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Introduction", jPanel2);

        browserPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Browser", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        browser.setContentType("text/html");
        browser.setEditable(false);
        jScrollPane7.setViewportView(browser);

        javax.swing.GroupLayout browserPanelLayout = new javax.swing.GroupLayout(browserPanel);
        browserPanel.setLayout(browserPanelLayout);
        browserPanelLayout.setHorizontalGroup(
            browserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, browserPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        browserPanelLayout.setVerticalGroup(
            browserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(browserPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("selected File"));

        jScrollPane6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane6MouseClicked(evt);
            }
        });

        showFileContentTextPane.setEditable(false);
        showFileContentTextPane.setForeground(java.awt.Color.gray);
        showFileContentTextPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showFileContentTextPaneMouseClicked(evt);
            }
        });
        showFileContentTextPane.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                showFileContentTextPaneMouseMoved(evt);
            }
        });
        jScrollPane5.setViewportView(showFileContentTextPane);

        jScrollPane6.setViewportView(jScrollPane5);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel3.setFont(new java.awt.Font("DejaVu Sans", 2, 11)); // NOI18N
        jLabel3.setText("Click on the phrases highlighted in Red to see the suspeced Source");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(browserPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(browserPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("On Screen View", jPanel6);

        selectedFileEditorPane.setEditable(false);
        jScrollPane1.setViewportView(selectedFileEditorPane);

        suspectedFileEditorPane.setEditable(false);
        jScrollPane2.setViewportView(suspectedFileEditorPane);

        jButton4.setText("Next Step");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel5.setText("Selected File: ");

        jLabel6.setText("Suspected File");

        jLabel7.setText("Select the file to see the comparison");

        fileListComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { }));
        fileListComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                fileListComboBoxItemStateChanged(evt);
            }
        });
        fileListComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileListComboBoxActionPerformed(evt);
            }
        });

        jTextField1.setText("jTextField1");

        selectedFileTextField.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        selectedFileTextField.setEditable(false);
        selectedFileTextField.setFont(new java.awt.Font("Tahoma", 1, 11));
        selectedFileTextField.setToolTipText("");
        selectedFileTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectedFileTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(502, 502, 502)
                                .addComponent(jLabel2)
                                .addGap(738, 738, 738)
                                .addComponent(jButton4))
                            .addComponent(jLabel6)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 698, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(243, 243, 243))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(fileListComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(selectedFileTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 2303, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fileListComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(selectedFileTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addComponent(jButton4)
                        .addGap(234, 234, 234))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)))))
        );

        jTabbedPane1.addTab("Dynamic Cross Check", jPanel3);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1176, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 517, Short.MAX_VALUE)
        );

        jPanel5.add(jasperReportScrollPane);
        jasperReportScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel4.setLayout(null);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jasperReportScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 1155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jasperReportScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        jTabbedPane1.addTab("Final Report", jPanel4);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 503, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        nextButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/next-icon.png"))); // NOI18N
        nextButton.setText("Next");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        PreviousButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/previous-icon.png"))); // NOI18N
        PreviousButton.setText("Previous");
        PreviousButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PreviousButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1175, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(684, 684, 684)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(680, 680, 680)
                        .addComponent(PreviousButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PreviousButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed

        //nextButton.setEnabled(true);
        int index = jTabbedPane1.getSelectedIndex();
        int nextIndex=index+1;
        if(nextIndex!=4){
        jTabbedPane1.setSelectedIndex(nextIndex);
        PreviousButton.setEnabled(true);
        jTabbedPane1.setEnabledAt(index, true);
        jTabbedPane1.setEnabledAt(index+1, true);
        }
        if(nextIndex==3){
            nextButton.setEnabled(false);
        }
        


    }//GEN-LAST:event_nextButtonActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        jTabbedPane1.setSelectedIndex(2);

    }//GEN-LAST:event_jButton4ActionPerformed

    private void PreviousButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PreviousButtonActionPerformed
        nextButton.setEnabled(true);
        int index = jTabbedPane1.getSelectedIndex();
        int prevIndex=index - 1;
        if (index != 0) {
            jTabbedPane1.setSelectedIndex(prevIndex);
        }
        if(prevIndex==0){
            PreviousButton.setEnabled(false);
        }
        

    }//GEN-LAST:event_PreviousButtonActionPerformed

    private void fileListComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_fileListComboBoxItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_fileListComboBoxItemStateChanged

    private void fileListComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileListComboBoxActionPerformed

        JComboBox cb = (JComboBox) evt.getSource();
        String fileName = (String) cb.getSelectedItem();
        try {

            updateTextBoxes(fileName);

        } catch (Exception ex) {
            Logger.getLogger(ReportingModule.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_fileListComboBoxActionPerformed

    private void selectedFileTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectedFileTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selectedFileTextFieldActionPerformed

    private void jScrollPane6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane6MouseClicked

    private void showFileContentTextPaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showFileContentTextPaneMouseClicked


        ArrayList<Integer> phraseIndexes = new ArrayList<Integer>();
        Iterator it = indexHighligherMap.entrySet().iterator();
        String matchedFile = "";
        String content = "";
        String internetMatch="";

        while (it.hasNext()) {

            Map.Entry pair = (Map.Entry) it.next();
            String match = (String) pair.getKey();
            phraseIndexes = indexHighligherMap.get(match);



            int startIndex = phraseIndexes.get(0);
            int endIndex = phraseIndexes.get(1);

            int offset = showFileContentTextPane.viewToModel(evt.getPoint());
            try {
                int start = Utilities.getWordStart(showFileContentTextPane, offset);
                if ((start > startIndex) && start < endIndex) {
                    String word = showFileContentTextPane.getDocument().getText(startIndex, endIndex - startIndex);

                    String preprocessedText = matchingToPreprocessed.get(word.trim());

                    //System.out.println("preprocessed text is " + preprocessedText);

                    for (int j = 0; j < resultArray.length; j++) {
                        if (resultArray[j][2] != null) {
                            //System.out.println(resultArray[j][2]);
                            String[] matchings = resultArray[j][2].split(":");
                            for (int k = 0; k < matchings.length; k++) {
                                //System.out.println(matchings[k]);
                                if (preprocessedText.equalsIgnoreCase(matchings[k])) {

                                    //System.out.println("matching String found");
                                    internetMatch=resultArray[j][1];
                                    matchedFile = matchedFile + "\n" +resultArray[j][1];

                                }


                            }
                        }

                    }
                    content = "<p><b>The suspected File </b>  <font color='red'>" + matchedFile + "</font></p> ";


                    Iterator mapIterator = fileToUrlMap.entrySet().iterator();

                    while (mapIterator.hasNext()) {

                        Map.Entry fileUrlPair = (Map.Entry) mapIterator.next();
                        String downloadedFileName = (String) fileUrlPair.getKey();
                        System.err.println("key value is " + downloadedFileName);
                        System.err.println(" value is " + internetMatch);
                        if (internetMatch.equalsIgnoreCase(downloadedFileName)) {

                            internetMatch = (String) fileUrlPair.getValue();
                            content = "<p><b>The suspected Online Source </b><b><a href='" + internetMatch + "'>" + internetMatch + "</a></b></p> ";

                        }
                    }
                    //jTextPane1.setToolTipText(matchedFile);
                    String heading = "View Source";
                    new ExpandableToolTip(heading, content, showFileContentTextPane, browser,browserPanel);

                }
            } catch (Exception ex) {

                Logger.getLogger(ReportingModule.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_showFileContentTextPaneMouseClicked

    private void showFileContentTextPaneMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showFileContentTextPaneMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_showFileContentTextPaneMouseMoved

    public void setTemp(String[][] tempa) {
        resultArray = tempa;
    }

    public void setDocument(String doc) {
        selectedDocumentPath = doc;


    }

    public void highlighter(String queryTemp) {


        ArrayList<Color> colourArray = new ArrayList<Color>();
        colourArray.add(Color.cyan);
        colourArray.add(Color.yellow);
        colourArray.add(Color.gray);
        colourArray.add(Color.LIGHT_GRAY);
        colourArray.add(Color.MAGENTA);
        colourArray.add(Color.pink);
        colourArray.add(Color.ORANGE);

        selectedFileEditorPane.setHighlighter(hilit);
        suspectedFileEditorPane.setHighlighter(hilit2);
        hilit.removeAllHighlights();
        hilit2.removeAllHighlights();
        //entryBg = jTextField2.getBackground();
        String content = selectedFileEditorPane.getText();
        String content2 = suspectedFileEditorPane.getText();
        String queryString = queryTemp;
        String[] query = null;
        if (queryString.length() <= 0) {
            return;
        }
        if (queryString.contains(":")) {

            query = queryString.split(":");

        } else {
            query = new String[1];
            query[0] = queryString;
        }

        for (int i = 0; i < query.length; i++) {
            String searchQuery = query[i];
            TextHighlighter highlighterFirstFile = new TextHighlighter();
            TextHighlighter highlighterSecondFile = new TextHighlighter();
            String[] highlightindexedInfoFirstFile = highlighterFirstFile.highlightTexts(content, searchQuery);
            String[] highlightindexedInfoSecondFile = highlighterSecondFile.highlightTexts(content2, searchQuery);
            int startIndexFirst = Integer.valueOf(highlightindexedInfoFirstFile[0]);
            int endIndexFirst = Integer.valueOf(highlightindexedInfoFirstFile[1]);
            int startIndexSecond = Integer.valueOf(highlightindexedInfoSecondFile[0]);
            int endIndexSecond = Integer.valueOf(highlightindexedInfoSecondFile[1]);


            try {

                Color HILIT_COLOR = colourArray.get(i);

                if (startIndexFirst != -1) {
                    painter = new DefaultHighlighter.DefaultHighlightPainter(HILIT_COLOR);
                    hilit.addHighlight(startIndexFirst, endIndexFirst, painter);
                    selectedFileEditorPane.setCaretPosition(endIndexFirst);

                }
                if (startIndexSecond != -1) {

                    painter = new DefaultHighlighter.DefaultHighlightPainter(HILIT_COLOR);

                    hilit2.addHighlight(startIndexSecond, endIndexSecond, painter);

                    suspectedFileEditorPane.setCaretPosition(endIndexSecond);

                }

            } catch (BadLocationException ex) {
                Logger.getLogger(ReportingModule.class.getName()).log(Level.SEVERE, null, ex);
            }
        }



    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ReportingModule().setVisible(true);

            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton PreviousButton;
    private javax.swing.JEditorPane browser;
    private javax.swing.JPanel browserPanel;
    private javax.swing.JComboBox fileListComboBox;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JScrollPane jasperReportScrollPane;
    private javax.swing.JButton nextButton;
    private javax.swing.JEditorPane selectedFileEditorPane;
    private javax.swing.JTextField selectedFileTextField;
    private javax.swing.JTextPane showFileContentTextPane;
    private javax.swing.JEditorPane suspectedFileEditorPane;
    // End of variables declaration//GEN-END:variables

    public void setData() {



        for (int i = 0; i < resultArray.length; i++) {

            if (resultArray[i][1] != null) {
                fileListComboBox.addItem(resultArray[i][1]);
                this.setIndexDetails(resultArray[i][1]);
            }
        }

        selectedFileTextField.setText(selectedDocumentPath);
        selectedFileTextField.setToolTipText(selectedDocumentPath);


        ArrayList<Integer> phraseIndexes = new ArrayList<Integer>();
        FileOperator setTextToTextAreas = new FileOperator();
        String appendedText = "";
        String texts = setTextToTextAreas.textSetter(selectedDocumentPath);
        AttributedString attributedString = new AttributedString(texts);
        showFileContentTextPane.setText(texts);

        showFileContentTextPane.setHighlighter(hilit3);

        StyledDocument doc = showFileContentTextPane.getStyledDocument();

        Iterator it = indexHighligherMap.entrySet().iterator();
        while (it.hasNext()) {

            Map.Entry pair = (Map.Entry) it.next();
            String match = (String) pair.getKey();
            phraseIndexes = indexHighligherMap.get(match);

            for (int i = 0; i < phraseIndexes.size(); i++) {

                int startIndex = phraseIndexes.get(0);
                int endIndex = phraseIndexes.get(1);

                try {
                    doc.remove(startIndex, endIndex - startIndex);
                    Style style = showFileContentTextPane.addStyle("I'm a Style", null);
                    StyleConstants.setForeground(style, Color.red);
                    StyleConstants.setBold(style, true);
                    StyleConstants.setItalic(style, true);


                    doc.insertString(startIndex, match, style);
                } catch (BadLocationException e) {
                }




            }




        }

        

        this.generateResults();


    }

    public void setUrl(ArrayList<String> urlList) {
        for (int i = 0; i < urlList.size(); i++) {
            urlListTemp.add(urlList.get(i));
        }
    }

    private void updateTextBoxes(String fileName) {

        String fileName1 = selectedDocumentPath;
        String fileName2 = fileName;
        FileOperator setTextToTextAreas = new FileOperator();
        String[] texts = setTextToTextAreas.textSetter(fileName1, fileName2);
        String field1 = texts[0];
        String field2 = texts[1];
        selectedFileEditorPane.setText(field1.toLowerCase());
        suspectedFileEditorPane.setText(field2.toLowerCase());

        for (int i = 0; i < resultArray.length; i++) {
            if (resultArray[i][1] != null) {
                if (resultArray[i][1].equalsIgnoreCase(fileName2)) {
                    jTextField1.setText(resultArray[i][2]);
                    this.highlighter(resultArray[i][2]);
                }
            }
        }

    }

    public void setIndexDetails(String fileName) {


        String fileName2 = fileName;
        for (int i = 0; i < resultArray.length; i++) {
            if (resultArray[i][1] != null) {
                if (resultArray[i][1].equalsIgnoreCase(fileName2)) {
                    jTextField1.setText(resultArray[i][2]);
                    this.highlighterDetails(resultArray[i][2], fileName);
                }
            }
        }


    }

    public void highlighterDetails(String queryTemp, String filename) {

        FileOperator setTextToTextAreas = new FileOperator();
        String[] texts = setTextToTextAreas.textSetter(selectedDocumentPath, filename);
        String content = texts[0].toLowerCase();
        String queryString = queryTemp;
        String[] query = null;
        if (queryString.length() <= 0) {
            return;
        }
        if (queryString.contains(":")) {

            query = queryString.split(":");

        } else {
            query = new String[1];
            query[0] = queryString;
        }

        for (int i = 0; i < query.length; i++) {
            String searchQuery = query[i];
            TextHighlighter highlighterFirstFile = new TextHighlighter();
            String[] highlightindexedInfoFirstFile = highlighterFirstFile.highlightTexts(content, searchQuery);
            int startIndexFirst = Integer.valueOf(highlightindexedInfoFirstFile[0]);
            int endIndexFirst = Integer.valueOf(highlightindexedInfoFirstFile[1]);
            String match = highlightindexedInfoFirstFile[2];
            ArrayList<Integer> arr = new ArrayList<Integer>();
            arr.add(startIndexFirst);
            arr.add(endIndexFirst);
            indexHighligherMap.put(match, arr);
            matchingToPreprocessed.put(highlightindexedInfoFirstFile[2], highlightindexedInfoFirstFile[3]);

        }

    }

    public void setMap(HashMap<String, String> fileUrlMap) {

        this.fileToUrlMap = fileUrlMap;
        if (fileUrlMap == null) {
            System.err.println("Fileurl map is null");
        }

    }
}
