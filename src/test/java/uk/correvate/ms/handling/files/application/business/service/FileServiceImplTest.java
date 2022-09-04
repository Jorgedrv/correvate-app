package uk.correvate.ms.handling.files.application.business.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import uk.correvate.ms.handling.files.application.business.service.impl.FileServiceImpl;
import uk.correvate.ms.handling.files.infrastructure.exceptions.ZipFilesException;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileServiceImplTest {

    @Mock
    ByteArrayOutputStream byteArrayOutputStream;
    @InjectMocks
    private FileServiceImpl service;

    @BeforeEach
    void before() {
        service = new FileServiceImpl();
    }

    @Test
    void testGetZipFileShouldBetrue() {
        MockMultipartFile file
                = new MockMultipartFile(
                "file",
                "hello.txt",
                MediaType.TEXT_PLAIN_VALUE,
                "A File".getBytes()
        );
        MockMultipartFile file2
                = new MockMultipartFile(
                "file",
                "hello2.txt",
                MediaType.TEXT_PLAIN_VALUE,
                "Another File".getBytes()
        );
        byte[] response = service.getZipFile(List.of(file, file2));
        assertTrue(response.length > 0);
    }

    @Test
    void testGetZipFileShouldThrowException() {
        assertThrows(ZipFilesException.class, () -> service.getZipFile(null));
    }
}
