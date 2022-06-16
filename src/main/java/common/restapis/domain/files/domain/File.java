package common.restapis.domain.files.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class File {

    private Long id;
    private String originalFilename;
    private String storeFilename;

    public File() {
    }

    public File(String originalFilename, String storeFilename) {
        this.originalFilename = originalFilename;
        this.storeFilename = storeFilename;
    }
}
