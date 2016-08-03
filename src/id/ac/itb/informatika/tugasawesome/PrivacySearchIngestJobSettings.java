/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.itb.informatika.tugasawesome;

import id.ac.itb.informatika.tugasawesome.model.GfPolynomial;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.sleuthkit.autopsy.ingest.IngestModuleIngestJobSettings;

/**
 *
 * @author Khoirunnisa Afifah <khoirunnisa.afik@gmail.com>
 */
public class PrivacySearchIngestJobSettings implements IngestModuleIngestJobSettings {
    private static final long serialVersionUID = 1L;
    private List<String> keywords = new ArrayList<>();
    private HashMap<String, List<GfPolynomial>> allpolynomials = new HashMap<>();
    private int threshold;
    private boolean isOutputPath = false;
    private String outputPath;
    
    //TODO : save path and option to save
    
    @Override
    public long getVersionNumber() {
        return serialVersionUID;
    }
    
    public void addKeyWord(String word) {
        keywords.add(word);
    }
    
    public List<String> getKeywords() {
        return keywords;
    }
    
    public void clearKeyword() {
        keywords.clear();
    }
    
    public List<GfPolynomial> getPolynomials(String filename) {
        return allpolynomials.get(filename);
    }
    
    public HashMap<String, List<GfPolynomial>> getAllPolynomials() {
        return allpolynomials;
    }
    
    public void setAllPolynomials(HashMap<String, List<GfPolynomial>> poly) {
        allpolynomials.putAll(poly);
    }
    
    public int getThreshold() {
        return threshold;
    }
    
    public void setTreshold(int th) {
        threshold = th;
    }
    
    public void setOutputPath(String path) {
        isOutputPath = true;
        outputPath = path;
    }
    
    public String getOutputPath() {
        if (isOutputPath) {
            return outputPath;
        } else {
//            return "/home/tolep/Documents/TugasAwesome/TugasAwesome/result";
            return "D:\\AFIK\\Project\\T(ugas) A(wesome)\\demo\\test\\result";
        }
    }
    
    public boolean isOutputPath() {
        return isOutputPath;
    }
    
    public void setDefaultPath() {
        isOutputPath = false;
    }
}
