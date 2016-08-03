package id.ac.itb.informatika.tugasawesome;

import org.openide.util.NbBundle;
import org.openide.util.lookup.ServiceProvider;
import org.sleuthkit.autopsy.ingest.FileIngestModule;
import org.sleuthkit.autopsy.ingest.IngestModuleFactory;
import org.sleuthkit.autopsy.ingest.IngestModuleFactoryAdapter;
import org.sleuthkit.autopsy.ingest.IngestModuleIngestJobSettings;
import org.sleuthkit.autopsy.ingest.IngestModuleIngestJobSettingsPanel;

/**
 *
 * @author Khoirunnisa Afifah <khoirunnisa.afik@gmail.com>
 */
@ServiceProvider(service = IngestModuleFactory.class) // Sample is discarded at runtime 
public class PrivacySearchFactory extends IngestModuleFactoryAdapter {
    
    private static final String VERSION_NUMBER = "1.0.0";
    
    static String getModuleName() {
        return NbBundle.getMessage(PrivacySearchFactory.class, "PrivacySearchFactory.moduleName");
    }

    @Override
    public String getModuleDisplayName() {
        return getModuleName();
    }

    @Override
    public String getModuleDescription() {
        return NbBundle.getMessage(PrivacySearchFactory.class, "PrivacySearchFactory.moduleDescription");
    }

    @Override
    public String getModuleVersionNumber() {
        return VERSION_NUMBER;
    }

    @Override
    public boolean hasGlobalSettingsPanel() {
        return false;
    }

    @Override
    public IngestModuleIngestJobSettings getDefaultIngestJobSettings() {
        return new PrivacySearchIngestJobSettings();
    }

    @Override
    public boolean hasIngestJobSettingsPanel() {
        return true;
    }

    @Override
    public IngestModuleIngestJobSettingsPanel getIngestJobSettingsPanel(IngestModuleIngestJobSettings settings) {
        assert settings instanceof PrivacySearchIngestJobSettings;
        if (!(settings instanceof PrivacySearchIngestJobSettings)) {
            throw new IllegalArgumentException(NbBundle.getMessage(this.getClass(),
                    "PrivacySearchFactory.getIngestJobSettingsPanel.exception.msg"));
        }
        PrivacySearchModuleSettingsPanel settingPanel = new PrivacySearchModuleSettingsPanel((PrivacySearchIngestJobSettings) settings);
        return settingPanel;
    }

    @Override
    public boolean isFileIngestModuleFactory() {
        return true;
    }

    @Override
    public FileIngestModule createFileIngestModule(IngestModuleIngestJobSettings settings) {
        return new PrivacySearchIngestModule((PrivacySearchIngestJobSettings) settings);
    }

    @Override
    public boolean isDataSourceIngestModuleFactory() {
        return false;
    }

    
}
