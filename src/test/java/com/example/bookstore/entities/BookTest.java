package com.example.bookstore.entities;

import com.example.bookstore.dto.BookUpdateVO;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class BookTest {

    @Test
    public void updateImageAndDescription_shouldUpdateImageAndDescription_givenAnImageAndADescription() {
        // Given
        final String image = "New Image Url";
        final String description = "New Description";
        Book book = new Book("C123456789012", "title", "authors", "publisher", "Image", "Book description");
        BookUpdateVO bookUpdateVO = new BookUpdateVO(image,description);

        // When
        book.updateImageAndDescription(bookUpdateVO);

        // Then
        assertThat(book).extracting("isbn", "title", "authors", "publisher", "image", "description")
                .contains("C123456789012", "title", "authors", "publisher", image, description);
    }
}
