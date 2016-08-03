package id.ac.itb.informatika.tugasawesome;

import id.ac.itb.informatika.tugasawesome.model.GfPolynomial;
import id.ac.itb.informatika.tugasawesome.process.Extraction;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import org.openide.util.NbBundle;
import org.sleuthkit.autopsy.casemodule.Case;
import org.sleuthkit.autopsy.casemodule.services.Blackboard;
import org.sleuthkit.autopsy.coreutils.Logger;
import org.sleuthkit.autopsy.ingest.FileIngestModule;
import org.sleuthkit.autopsy.ingest.IngestJobContext;
import org.sleuthkit.autopsy.ingest.IngestMessage;
import org.sleuthkit.autopsy.ingest.IngestModuleReferenceCounter;
import org.sleuthkit.autopsy.ingest.IngestServices;
import org.sleuthkit.datamodel.AbstractFile;

/**
 *
 * @author Khoirunnisa Afifah <khoirunnisa.afik@gmail.com>
 */
public class PrivacySearchIngestModule implements FileIngestModule{

    private static final Logger logger = Logger.getLogger(PrivacySearchIngestModule.class.getName());
    private final IngestServices services = IngestServices.getInstance();
    private final PrivacySearchIngestJobSettings settings;
    private long jobId;
    private static final IngestModuleReferenceCounter refCounter = new IngestModuleReferenceCounter();
    private int fileseq;
    private List<String> foundFile = new ArrayList<>();
    //private Path result = Paths.get("/home/tolep/Documents/TugasAwesome/TugasAwesome/result");
    private Blackboard blackboard;
    
    PrivacySearchIngestModule(PrivacySearchIngestJobSettings settings) {
        this.settings = settings;
    }
    
    @Override
    public ProcessResult process(AbstractFile file) {
        blackboard = Case.getCurrentCase().getServices().getBlackboard();
        
        if (file.isDir() || file.getName().equals("meta.ser") || file.getName().equals("md5.txt")) {
            return ProcessResult.OK;
        }
        
        logger.log(Level.INFO, "Processing... {0}", file.getLocalAbsPath());
        System.out.println("Processing : " + file.getLocalAbsPath());
            
        try {
            Path currFile = Paths.get(file.getLocalAbsPath());
            List<GfPolynomial> thisPoly = settings.getPolynomials(file.getName());
            Path savePath = Paths.get(settings.getOutputPath());
            boolean success = Extraction.extract(currFile, savePath, thisPoly, 
                    settings.getKeywords(), settings.getThreshold());

            if (success) {
                logger.log(Level.INFO, "Found in {0}", file.getName());
                System.out.println("Found in " + file.getName());
                foundFile.add(file.getName());
            }
            
            fileseq = fileseq + 1;
            return ProcessResult.OK;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error read file");
            return ProcessResult.ERROR;
        }
    }

    @Override
    public void shutDown() {
        String msg;
        if (foundFile.isEmpty())  {
            msg = "Not Found";
        } else {
            StringBuilder detailsSb = new StringBuilder();
            //details
            detailsSb.append("<table border='0' cellpadding='4' width='280'>"); //NON-NLS
            //title
            detailsSb.append("<tr>"); //NON-NLS
            detailsSb.append("<th>") //NON-NLS
                    .append("File Name")
                    .append("</th>"); //NON-NLS
            detailsSb.append("<td>") //NON-NLS
                    .append("File Location")
                    .append("</td>"); //NON-NLS
            detailsSb.append("</tr>"); //NON-NLS
            
            for (String file : foundFile) {
                detailsSb.append("<tr>"); //NON-NLS
                detailsSb.append("<th>") //NON-NLS
                        .append(file)
                        .append("</th>"); //NON-NLS
                detailsSb.append("<td>") //NON-NLS
                        .append(settings.getOutputPath())
                        .append("/")
                        .append(file)
                        .append("</td>"); //NON-NLS
                detailsSb.append("</tr>"); //NON-NLS

            }
            msg = detailsSb.toString();
        }
        services.postMessage(IngestMessage.createMessage(IngestMessage.MessageType.INFO, PrivacySearchFactory.getModuleName(), "Privacy Search Result", msg));
    }

    @Override
    public void startUp(IngestJobContext context) throws IngestModuleException {
        jobId = context.getJobId();
        refCounter.incrementAndGet(jobId);
        fileseq = 0;
        
        logger.log(Level.INFO, "Searching started with keyword {0}", settings.getKeywords());
        System.out.println("Searching started with keyword " + settings.getKeywords());
    }
    
}
