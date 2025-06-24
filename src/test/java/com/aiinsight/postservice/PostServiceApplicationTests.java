package com.aiinsight.postservice;

import com.aiinsight.postservice.controller.NewsController;
import com.aiinsight.postservice.dto.NewsRequestDto;
import com.aiinsight.postservice.dto.NewsResponseDto;
import com.aiinsight.postservice.service.NewsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class NewsServiceApplicationTests {

    @Mock
    private NewsService newsService;

    @InjectMocks
    private NewsController newsController;

    @Test
    void testGetAllNews() {
        // Arrange
        NewsResponseDto responseDto = new NewsResponseDto();
        when(newsService.findAll()).thenReturn(Collections.singletonList(responseDto));

        // Act
        ResponseEntity<List<NewsResponseDto>> response = newsController.getAllNews();

        // Assert
        assertEquals(1, response.getBody().size());
        verify(newsService, times(1)).findAll();
    }


}
