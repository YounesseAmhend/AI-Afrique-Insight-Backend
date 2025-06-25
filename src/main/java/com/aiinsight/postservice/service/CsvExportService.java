package com.aiinsight.postservice.service;

import com.aiinsight.postservice.model.News;
import com.aiinsight.postservice.repository.NewsRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Service
public class CsvExportService {
  @Autowired
  private NewsRepository newsRepository;

  public byte[] getCsvFile() {
    List<News> newsList = newsRepository.findAll();

    try (
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintWriter writer = new PrintWriter(out);
        CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
            .withHeader("ID", "Title", "Body", "URL", "Image URL", "Source ID", "Author Name", "Created At", "Post Date"));
    ) {
      for (News news : newsList) {
        String authorName = (news.getAuthor() != null) ? news.getAuthor().getName() : "N/A";

        csvPrinter.printRecord(
            news.getId(),
            news.getTitle(),
            news.getBody(),
            news.getUrl(),
            news.getImageUrl(),
            news.getSourceId(),
            authorName,
            news.getCreatedAt(), // .toString()  automatically
            news.getPostDate()
        );
      }

      csvPrinter.flush();
      return out.toByteArray();

    } catch (IOException e) {
      throw new RuntimeException("Failed to generate CSV data: " + e.getMessage());
    }
  }
}
