package com.aiinsight.postservice.model.enums;



public enum ScrapeStatus {
    AVAILABLE("available"),
    FETCHING("fetching"),
    UNAVAILABLE("unavailable");

    private final String dbValue;

    ScrapeStatus(String dbValue) {
        this.dbValue = dbValue;
    }

    public String getDbValue() {
        return dbValue;
    }

    public static ScrapeStatus fromDbValue(String dbValue) {
        for (ScrapeStatus status : values()) {
            if (status.dbValue.equalsIgnoreCase(dbValue)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Unknown db value: " + dbValue);
    }
}
