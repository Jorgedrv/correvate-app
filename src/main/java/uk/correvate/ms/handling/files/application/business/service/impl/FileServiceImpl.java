package uk.correvate.ms.handling.files.application.business.service.impl;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import uk.correvate.ms.handling.files.application.business.service.FileService;
import uk.correvate.ms.handling.files.infrastructure.exceptions.ZipFilesException;
import uk.correvate.ms.handling.files.interfaces.rest.FileController;

import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Service
public class FileServiceImpl implements FileService {

    private static final Logger logger = LoggerFactory.getLogger(FileServiceImpl.class.getSimpleName());

    /**
     * Service implementation for add files to zip and return it.
     * @param files to be added to zip.
     * @return zip with files.
     */
    @Override
    public byte[] getZipFile(final List<MultipartFile> files) {
        logger.info("Start - Adding files to zip");
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
            ZipOutputStream zipOutputStream = new ZipOutputStream(byteArrayOutputStream);
            for (MultipartFile file : files) {
                try (InputStream fis = new BufferedInputStream(file.getInputStream())) {
                    logger.info("Adding file " + file.getOriginalFilename());
                    ZipEntry zipEntry = new ZipEntry(file.getOriginalFilename());
                    zipOutputStream.putNextEntry(zipEntry);
                    IOUtils.copy(fis, zipOutputStream);
                }
            }
            zipOutputStream.close();
            logger.info("End - Adding files to zip");
            return byteArrayOutputStream.toByteArray();
        } catch (Exception ex) {
            throw new ZipFilesException(ex.getMessage());
        }
    }
}
