package com.aiinsight.postservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aiinsight.postservice.dto.AddSourceRequest;
import com.aiinsight.postservice.model.Source;
import com.aiinsight.postservice.repository.SourceRepository;

import jakarta.transaction.Transactional;

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
    @Transactional
    public Source updateSourceUrl(Long id, AddSourceRequest request) {
        sourceRepository.updateSource(id, request.getUrl(), !request.isContainsAiContent(),
                !request.isContainsAfricaContent());
        return sourceRepository.findById(id).get();
    }

    public void deleteSource(Long id) {
        sourceRepository.deleteById(id);
    }
}
