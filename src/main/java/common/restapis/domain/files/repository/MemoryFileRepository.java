package common.restapis.domain.files.repository;

import common.restapis.domain.files.domain.File;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemoryFileRepository implements FileRepository {

    private static Long sequence = 0L;
    private static final Map<Long, File> store = new HashMap<>();


    @Override
    public String upLoad(File file) {
        file.setId(++sequence);
        store.put(file.getId(), file);
        return file.getStoreFilename();
    }

    @Override
    public File findById(Long id) {
        return store.get(id);
    }

    @Override
    public List<File> findAll() {
        return new ArrayList<>(store.values());
    }
}
