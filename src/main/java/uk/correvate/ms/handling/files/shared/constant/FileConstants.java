package uk.correvate.ms.handling.files.shared.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FileConstants {

    public static final String CONTENT_DISPOSITION = "Content-Disposition";
    public static final String ATTACHMENT = "attachment;filename=export.zip";
    public static final String APPLICATION_ZIP = "application/zip";
}
