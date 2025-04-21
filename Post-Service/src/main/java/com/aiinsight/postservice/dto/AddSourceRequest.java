package com.aiinsight.postservice.dto;

// A simple DTO to represent the request body for adding a source
public class AddSourceRequest {
    private String url;
    private boolean containsAiContent;
    private boolean containsAfricaContent;

    // Getters and setters are needed for Spring to map the JSON body
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isContainsAiContent() {
        return containsAiContent;
    }

    public void setContainsAiContent(boolean containsAiContent) {
        this.containsAiContent = containsAiContent;
    }

    public boolean isContainsAfricaContent() {
        return containsAfricaContent;
    }

    public void setContainsAfricaContent(boolean containsAfricaContent) {
        this.containsAfricaContent = containsAfricaContent;
    }
}