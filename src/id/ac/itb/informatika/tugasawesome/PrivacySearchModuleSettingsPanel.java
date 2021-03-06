/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.itb.informatika.tugasawesome;

import id.ac.itb.informatika.tugasawesome.model.GfPolynomial;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.sleuthkit.autopsy.coreutils.Logger;
import org.sleuthkit.autopsy.ingest.IngestModuleIngestJobSettings;
import org.sleuthkit.autopsy.ingest.IngestModuleIngestJobSettingsPanel;

/**
 *
 * @author tolep
 */
public class PrivacySearchModuleSettingsPanel extends IngestModuleIngestJobSettingsPanel {
    
    private static final Logger logger = Logger.getLogger(PrivacySearchModuleSettingsPanel.class.getName());
    private PrivacySearchIngestJobSettings settings;
    //TODO : save path and option to save
    
    /**
     * Creates new customizer PrivacySearchModuleSettingsPanel
     */
    public PrivacySearchModuleSettingsPanel(PrivacySearchIngestJobSettings setting) {
        this.settings = setting;
        initComponents();
    }
    
    @Override
    public IngestModuleIngestJobSettings getSettings() {
        return settings;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the FormEditor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jFileChooser2 = new javax.swing.JFileChooser();
        metaPath = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        browseMeta = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        keywordTextArea = new javax.swing.JTextArea();
        outputPathText = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        browseOutput = new javax.swing.JButton();

        jLabel1.setText("Browse meta.ser file");

        browseMeta.setText("Browse");
        browseMeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseMetaActionPerformed(evt);
            }
        });

        jLabel2.setText("Enter keyword to search (space separated)");

        keywordTextArea.setColumns(20);
        keywordTextArea.setRows(5);
        keywordTextArea.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                keywordTextAreaFocusLost(evt);
            }
        });
        keywordTextArea.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                keywordTextAreaPropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(keywordTextArea);

        outputPathText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                browseOutputPath(evt);
            }
        });

        jLabel4.setText("Set output path");

        browseOutput.setText("Browse");
        browseOutput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseOutputActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 23, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(outputPathText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                                    .addComponent(metaPath, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(browseMeta, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(browseOutput, javax.swing.GroupLayout.Alignment.LEADING)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(112, 112, 112)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(metaPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(browseMeta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(outputPathText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(browseOutput))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void browseMetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseMetaActionPerformed
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Serializeable file", "ser");
        jFileChooser1.setFileFilter(filter);
        jFileChooser1.setDialogTitle("Select meta.ser file");
        int returnVal = jFileChooser1.showOpenDialog(PrivacySearchModuleSettingsPanel.this);
        
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = jFileChooser1.getSelectedFile();
            metaPath.setText(file.getAbsolutePath());
            try {
                FileInputStream fis = new FileInputStream(file.getAbsolutePath());
                ObjectInputStream in = new ObjectInputStream(fis);
                HashMap<String, List<GfPolynomial>> poly = (HashMap) in.readObject();
                settings.setTreshold(poly.get("threshold").get(0).getDegree());
                settings.setAllPolynomials(poly);
                logger.log(Level.INFO, "meta.ser file found in {0}", file.getAbsolutePath());
                System.out.println("meta.ser file found in " + file.getAbsolutePath());
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
                logger.log(Level.WARNING, "fail to serialize polynomial");
            }
        } else {
            logger.log(Level.INFO, "meta.ser search cancelled");
            System.out.println("meta.ser search cancelled");
        }
        
    }//GEN-LAST:event_browseMetaActionPerformed

    private void keywordTextAreaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_keywordTextAreaPropertyChange
        
    }//GEN-LAST:event_keywordTextAreaPropertyChange

    private void keywordTextAreaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_keywordTextAreaFocusLost
        String text = keywordTextArea.getText();
        String[] splitted = text.split(" ");
        settings.clearKeyword();
        for (String word : splitted) {
            settings.addKeyWord(word);
        }
    }//GEN-LAST:event_keywordTextAreaFocusLost

    private void browseOutputPath(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_browseOutputPath
        
    }//GEN-LAST:event_browseOutputPath

    private void browseOutputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseOutputActionPerformed
        jFileChooser2.setDialogTitle("Choose output directory");
        jFileChooser2.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnVal = jFileChooser2.showOpenDialog(PrivacySearchModuleSettingsPanel.this);
        
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = jFileChooser2.getSelectedFile();
            outputPathText.setText(file.getAbsolutePath());
            //settings.setOutputPath("/"+file.getAbsolutePath()); //for UNIX
            settings.setOutputPath(file.getAbsolutePath());
        } else {
            logger.log(Level.INFO, "meta.ser search cancelled");
            System.out.println("meta.ser search cancelled");
        }
    }//GEN-LAST:event_browseOutputActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton browseMeta;
    private javax.swing.JButton browseOutput;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JFileChooser jFileChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea keywordTextArea;
    private javax.swing.JTextField metaPath;
    private javax.swing.JTextField outputPathText;
    // End of variables declaration//GEN-END:variables

    
}
