package com.example.api.models.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "books")
public class GetBooksByAuthorResponse {

    private List<Book> books;

    @XmlElement(name = "book")
    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @XmlRootElement
    public static class Book {
        private long id;
        private String bookTitle;
        private Author author;

        @XmlElement
        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        @XmlElement
        public String getBookTitle() {
            return bookTitle;
        }

        public void setBookTitle(String bookTitle) {
            this.bookTitle = bookTitle;
        }

        @XmlElement
        public Author getAuthor() {
            return author;
        }

        public void setAuthor(Author author) {
            this.author = author;
        }

        @XmlRootElement
        public static class Author {
            private long id;
            private String firstName;
            private String secondName;
            private String familyName;

            @XmlElement
            public long getId() {
                return id;
            }

            public void setId(long id) {
                this.id = id;
            }

            @XmlElement
            public String getFirstName() {
                return firstName;
            }

            public void setFirstName(String firstName) {
                this.firstName = firstName;
            }

            @XmlElement
            public String getSecondName() {
                return secondName;
            }

            public void setSecondName(String secondName) {
                this.secondName = secondName;
            }

            @XmlElement
            public String getFamilyName() {
                return familyName;
            }

            public void setFamilyName(String familyName) {
                this.familyName = familyName;
            }
        }
    }
}