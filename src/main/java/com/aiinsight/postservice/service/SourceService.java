package com.aiinsight.postservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aiinsight.postservice.model.Source;
import com.aiinsight.postservice.repository.SourceRepository;

@Service
public class SourceService {
    private final SourceRepository sourceRepository;

    public SourceService(SourceRepository sourceRepository) {
        this.sourceRepository = sourceRepository;
    }

    public List<Source> getSources() {
        return sourceRepository.findAll();
    }

    public boolean sourceExists(String url) {
        return sourceRepository.findByUrl(url) != null;
    }

    public Source updateSourceUrl(Long id, String newUrl) {
        Source source = sourceRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Source not found"));
        source.setUrl(newUrl);
        return sourceRepository.save(source);
    }

    public void deleteSource(Long id) {
        sourceRepository.deleteById(id);
    }
}
