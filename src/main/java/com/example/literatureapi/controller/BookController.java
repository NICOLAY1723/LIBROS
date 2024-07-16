
package com.example.literatureapi.controller;

import com.example.literatureapi.model.Book;
import com.example.literatureapi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/search")
    public String searchBooks(@RequestParam String query) {
        List<Book> books = bookService.searchBooks(query);
        List<BookDTO> bookDTOs = books.stream().map(this::convertToDto).collect(Collectors.toList());
        printBooksInSpanish(bookDTOs);
        return "Consulta realizada. Revisa la terminal para los resultados.";
    }

    private BookDTO convertToDto(Book book) {
        BookDTO dto = new BookDTO();
        dto.setTitle(book.getTitle());
        dto.setAuthors(book.getAuthor_name() != null ? String.join(", ", book.getAuthor_name()) : "Desconocido");
        dto.setLanguages(book.getLanguages() != null ? String.join(", ", book.getLanguages()) : "Desconocido");
        dto.setDownloadCount(book.getDownload_count());
        return dto;
    }

    private void printBooksInSpanish(List<BookDTO> bookDTOs) {
        for (BookDTO book : bookDTOs) {
            System.out.println("Título: " + book.getTitle());
            System.out.println("Autores: " + book.getAuthors());
            System.out.println("Idiomas: " + book.getLanguages());
            System.out.println("Número de Descargas: " + book.getDownloadCount());
            System.out.println("------------------------------");
        }
    }

    public static class BookDTO {
        private String title;
        private String authors;
        private String languages;
        private int downloadCount;

        // Getters y Setters

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthors() {
            return authors;
        }

        public void setAuthors(String authors) {
            this.authors = authors;
        }

        public String getLanguages() {
            return languages;
        }

        public void setLanguages(String languages) {
            this.languages = languages;
        }

        public int getDownloadCount() {
            return downloadCount;
        }

        public void setDownloadCount(int downloadCount) {
            this.downloadCount = downloadCount;
        }
    }
}
