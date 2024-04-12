package ee.ivkhk.jktv22springlibrary.repository;

import ee.ivkhk.jktv22springlibrary.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

}
