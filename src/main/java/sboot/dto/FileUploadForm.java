package sboot.dto;



import java.util.List;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author mujify
 */
public class FileUploadForm {
    
    private List<MultipartFile> files;

    public List<MultipartFile> getFiles() {
        return files;
    }

    public void setFiles(List<MultipartFile> files) {
        this.files = files;
    }
    
    
    
}

