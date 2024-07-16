
package com.example.literatureapi.service;

import com.example.literatureapi.model.Book;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class BookService {

    private final RestTemplate restTemplate = new RestTemplate();

    public List<Book> searchBooks(String query) {
        String url = UriComponentsBuilder.fromHttpUrl("https://gutendex.com/books")
                .queryParam("search", query)
                .toUriString();

        BookSearchResult result = restTemplate.getForObject(url, BookSearchResult.class);
        return result.getResults();
    }

    private static class BookSearchResult {
        private List<Book> results;

        public List<Book> getResults() {
            return results;
        }

        public void setResults(List<Book> results) {
            this.results = results;
        }
    }
}
