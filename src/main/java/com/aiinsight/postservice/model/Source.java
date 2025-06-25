package com.aiinsight.postservice.model;

import com.aiinsight.postservice.model.enums.ScrapeStatus;

import jakarta.persistence.*;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
class ScrapeStatusConverter implements AttributeConverter<ScrapeStatus, String> {

    @Override
    public String convertToDatabaseColumn(ScrapeStatus attribute) {
        return attribute != null ? attribute.getDbValue() : null;
    }

    @Override
    public ScrapeStatus convertToEntityAttribute(String dbData) {
        return dbData != null ? ScrapeStatus.fromDbValue(dbData) : null;
    }
}

@Entity
@Table(name = "sources")
public class Source {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String url;

    @Column(columnDefinition = "jsonb")
    private String selector;

    @Column(nullable = false)
    private boolean triggerAfrica;

    @Column(nullable = false)
    private boolean triggerAi;

    @Convert(converter = ScrapeStatusConverter.class)
    @Column(nullable = false, columnDefinition = "scrape_status DEFAULT 'available'")
    private ScrapeStatus status = ScrapeStatus.AVAILABLE;

    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP")
    private java.time.OffsetDateTime createdAt;

    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private java.time.OffsetDateTime updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSelector() {
        return selector;
    }

    public void setSelector(String selector) {
        this.selector = selector;
    }

    public boolean isTriggerAfrica() {
        return triggerAfrica;
    }

    public void setTriggerAfrica(boolean triggerAfrica) {
        this.triggerAfrica = triggerAfrica;
    }

    public boolean isTriggerAi() {
        return triggerAi;
    }

    public void setTriggerAi(boolean triggerAi) {
        this.triggerAi = triggerAi;
    }

    public ScrapeStatus getStatus() {
        return status;
    }

    public void setStatus(ScrapeStatus status) {
        this.status = status;
    }

    public java.time.OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(java.time.OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public java.time.OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(java.time.OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

}
