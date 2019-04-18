package com.feng.jpa.persistence;

import com.feng.entities.entity.Author;
import com.feng.entities.representation.Authors;
import com.feng.entities.representation.BookDetails;
import org.jooq.DSLContext;
import org.simpleflatmapper.jdbc.JdbcMapper;
import org.simpleflatmapper.jdbc.JdbcMapperFactory;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.feng.jpa.jooq.Tables.AUTHOR;
import static com.feng.jpa.jooq.Tables.BOOK;
import static com.feng.jpa.jooq.Tables.BOOK_CHAPTER;

@Component
public class JooqPersistence {

    private final DSLContext jooq;
    private final AuthorPersistenceJpa authorPersistenceJpa;

    public JooqPersistence(AuthorPersistenceJpa authorPersistenceJpa, DSLContext context) {
        this.jooq = context;
        this.authorPersistenceJpa = authorPersistenceJpa;
    }

    public List<Authors> findAllAuthor() {
        List<Author> all = authorPersistenceJpa.findAll();
//        List<Author> authors = jooq.select(AUTHOR.AUTHOR_ID.as("id"), AUTHOR.NAME, AUTHOR.SEX, AUTHOR.AGE).from(AUTHOR).fetchInto(Author.class);
        List<Authors> authors = jooq.selectFrom(AUTHOR).fetchInto(Authors.class);
        return authors;

    }

    private final JdbcMapper<BookDetails> bookMapper = JdbcMapperFactory.newInstance().addKeys("book_id").newMapper(BookDetails.class);

    public List<BookDetails> getBooks() {

        try (ResultSet resultSet = jooq.select(
                BOOK.BOOK_ID,
                BOOK.NAME,
                BOOK.PUBLISH_DAY,
                BOOK.CREATE_AT,
                BOOK_CHAPTER.INDEX.as("chapters.index"),
                BOOK_CHAPTER.NAME.as("chapters.name"),
                BOOK_CHAPTER.SUMMARY.as("chapters.summary")
        ).from(BOOK)
                .leftOuterJoin(BOOK_CHAPTER)
                .on(BOOK.BOOK_ID.eq(BOOK_CHAPTER.BOOK_ID))
                .orderBy(BOOK.BOOK_ID)
                .fetchResultSet()) {

            Stream<BookDetails> stream = bookMapper.stream(resultSet);
            List<BookDetails> collect = stream.collect(Collectors.toList());
            return collect;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
