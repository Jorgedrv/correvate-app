package uk.correvate.ms.handling.files.interfaces.rest;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import uk.correvate.ms.handling.files.application.business.service.FileService;
import uk.correvate.ms.handling.files.shared.constant.FileConstants;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class.getSimpleName());
    private final FileService service;

    /**
     * Allows to add files inside a zip and return it.
     *
     * @param files to be added to zip.
     * @return zip with the files.
     */
    @GetMapping(value = "/files", produces = FileConstants.APPLICATION_ZIP)
    public ResponseEntity<byte[]> getZipFile(@RequestPart("files") List<MultipartFile> files) {
        logger.info("Entering file controller");
        if (files.get(0).getOriginalFilename().equals("")) {
            return ResponseEntity.badRequest().body(new byte[0]);
        }
        return ResponseEntity
                .accepted()
                .header(FileConstants.CONTENT_DISPOSITION, FileConstants.ATTACHMENT)
                .body(service.getZipFile(files));
    }
}
