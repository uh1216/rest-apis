package common.restapis.domain.files.repository;

import common.restapis.domain.files.domain.File;

import java.util.List;

public interface FileRepository {

    String upLoad(File file);

    File findById(Long id);

    List<File> findAll();
}
