package common.restapis.api.files;

import common.restapis.api.messages.SuccessMessage;
import common.restapis.domain.files.FileStore;
import common.restapis.domain.files.domain.File;
import common.restapis.domain.files.repository.MemoryFileRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@RestController
@RequiredArgsConstructor
public class FileController {

    private final MemoryFileRepository memoryFileRepository;
    private final FileStore fileStore;

    @PostMapping("/upload")
    public SuccessMessage saveFile(@RequestParam MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            throw new RuntimeException("파일을 첨부해주세요");
        }
        String originalFilename = file.getOriginalFilename();
        String storeFilename = fileStore.storeFile(file);
        memoryFileRepository.upLoad(new File(originalFilename, storeFilename));
        return new SuccessMessage(HttpStatus.OK, "파일 저장 성공!");
    }

    @GetMapping("/upload/{id}")
    public File findFileById(@PathVariable Long id) {
        return memoryFileRepository.findById(id);
    }
}
