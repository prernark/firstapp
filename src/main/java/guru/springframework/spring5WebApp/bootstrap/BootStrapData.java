package guru.springframework.spring5WebApp.bootstrap;

import guru.springframework.spring5WebApp.domain.Author;
import guru.springframework.spring5WebApp.domain.Book;
import guru.springframework.spring5WebApp.domain.Publisher;
import guru.springframework.spring5WebApp.repositories.AuthorRepository;
import guru.springframework.spring5WebApp.repositories.BookRepository;
import guru.springframework.spring5WebApp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @java.lang.Override
    public void run(java.lang.String... args) throws Exception {
        Publisher pub1 = new Publisher("pub1", "Address line 1", "city1", "state1", 1234);
        publisherRepository.save(pub1);

        Publisher pub2 = new Publisher("pub2", "Address line 2", "city2", "state2", 1111);
        publisherRepository.save(pub2);

        Publisher pub3 = new Publisher("pub3", "Address line 3", "city3", "state3", 1111);
        publisherRepository.save(pub3);

        System.out.println("Number of publishers "+publisherRepository.count());
        for (Publisher pub : publisherRepository.findAll())
        {
            System.out.println("Publisher name - " + pub.getName());
        }

        Author andy = new Author("Andy", "Harris");
        Book b1 = new Book("Development Manager", "1234");
        andy.getBooks().add(b1);
        b1.getAuthors().add(andy);

        b1.setPublisher(pub1);
        pub1.getBooks().add(b1);

        authorRepository.save(andy);
        bookRepository.save(b1);
        publisherRepository.save(pub1);

        andy = new Author("Colin", "Mills");
        b1 = new Book("Product Manager", "5678");
        andy.getBooks().add(b1);
        b1.getAuthors().add(andy);

        b1.setPublisher(pub1);
        pub1.getBooks().add(b1);

        authorRepository.save(andy);
        bookRepository.save(b1);
        publisherRepository.save(pub1);

        System.out.println("Starting bootstrap");
        System.out.println("Number of books "+bookRepository.count());
        System.out.println("Number of books for publisher 1 = "+ pub1.getBooks().size());
        System.out.println("Number of books for publisher 2 = "+ pub2.getBooks().size());
        System.out.println("Number of books for publisher 3 = "+ pub3.getBooks().size());


    }
}
