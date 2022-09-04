package uk.correvate.ms.handling.files.application.business.service;

import org.springframework.web.multipart.MultipartFile;
import uk.correvate.ms.handling.files.application.business.service.impl.FileServiceImpl;

import java.util.List;

public interface FileService {

    /**
     * Implementation
     * {@link FileServiceImpl#getZipFile(List)}.
     */
    byte[] getZipFile(final List<MultipartFile> files);
}
