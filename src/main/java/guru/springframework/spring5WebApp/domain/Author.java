package guru.springframework.spring5WebApp.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
//import org.hibernate.mapping.Set;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long authId;

    private String firstName;
    private String lastName;

    @ManyToMany (mappedBy = "authors")
    private Set<Book> books = new HashSet<>();

    public Author() {
    }

    public Author(String firstName, String lastName/*, Set<Book> books*/) {
        this.firstName = firstName;
        this.lastName = lastName;
//        this.books = books;
    }

    public Long getAuthId() {
        return authId;
    }

    public void setAuthId(Long authId) {
        this.authId = authId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Author{" +
                "authId=" + authId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", books=" + books +
                '}';
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Author author = (Author) object;
        return java.util.Objects.equals(authId, author.authId);
    }

    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), authId);
    }
}
