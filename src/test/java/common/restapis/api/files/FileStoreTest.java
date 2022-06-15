package common.restapis.api.files;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;


class FileStoreTest {

    FileStore fileStore = new FileStore();

    @Value("${file.dir}")
    public String filePath;

    @Test
    void getFullPath() {
        //given
        String fileName = "image.png";
        //when
        String fullPath = fileStore.getFullPath(fileName);
        //then
        assertThat(fullPath).isEqualTo(filePath + "image.png");
    }

    @Test
    void storeFile() throws IOException {
        //given
        MockMultipartFile mockMultipartFile = new MockMultipartFile("file", "image.png", MediaType.MULTIPART_FORM_DATA_VALUE, new FileInputStream("/Users/dnd/Desktop/image.png"));
        //when
        String storeFileName = fileStore.storeFile(mockMultipartFile);
        //then
        assertThat(storeFileName).isNotEqualTo("image.png");
    }
}