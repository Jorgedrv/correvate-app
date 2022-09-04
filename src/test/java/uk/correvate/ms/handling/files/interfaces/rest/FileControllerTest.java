package uk.correvate.ms.handling.files.interfaces.rest;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;
import uk.correvate.ms.handling.files.application.business.service.FileService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class FileControllerTest {

    @Mock private FileService fileService;

    @Captor
    ArgumentCaptor<List<MultipartFile>> captor;

    @InjectMocks private FileController fileController;

    @Test
    void testGetZipFileShouldReturnOk() {
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
        List<MultipartFile> files = List.of(file, file2);
        when(fileService.getZipFile(files)).thenReturn(new byte[1048]);
        ResponseEntity<byte[]> response = fileController.getZipFile(files);
        assertNotNull(response);
        assertEquals(1048, response.getBody().length);

        verify(fileService).getZipFile(captor.capture());
        assertEquals(List.of(file, file2), captor.getValue());

        verifyNoMoreInteractions(fileService);
    }
}
