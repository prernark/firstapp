package guru.springframework.spring5WebApp.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Publisher {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long publisherId;

    private String name;
    private String addrLine1;
    private String city;
    private String state;
    private int zip;

    @OneToMany
//    @JoinColumn (name = "publisher_Id")
    @JoinColumn (name = "publisher_publisherId")
    private Set<Book> books = new HashSet<>();

    public Publisher() {
    }

    public Publisher(String name, String addrLine1, String city, String state, int zip) {
        this.name = name;
        this.addrLine1 = addrLine1;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddrLine1() {
        return addrLine1;
    }

    public void setAddrLine1(String addrLine1) {
        this.addrLine1 = addrLine1;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public Long getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Long publisherId) {
        this.publisherId = publisherId;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Publisher{" +
                "name='" + name + '\'' +
                ", addrLine1='" + addrLine1 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip=" + zip +
                '}';
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Publisher publisher = (Publisher) object;
        return java.util.Objects.equals(publisherId, publisher.publisherId);
    }

    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), publisherId);
    }
}
