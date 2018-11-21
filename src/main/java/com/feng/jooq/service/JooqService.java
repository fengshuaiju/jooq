package com.feng.jooq.service;

import com.feng.jooq.representation.Author;
import com.feng.jooq.representation.BookDetails;
import lombok.RequiredArgsConstructor;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.impl.UpdatableRecordImpl;
import org.simpleflatmapper.jdbc.JdbcMapper;
import org.simpleflatmapper.jdbc.JdbcMapperFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static sprout.jooq.generate.Tables.AUTHOR;
import static sprout.jooq.generate.Tables.BOOK_DETAIL;

@Service
@RequiredArgsConstructor
public class JooqService {

    private final DSLContext jooq;

    private static final JdbcMapper<BookDetails> mapper = JdbcMapperFactory.newInstance().addKeys("id").newMapper(BookDetails.class);

    public List<Author> getAuthors() {
        return jooq.selectFrom(AUTHOR).fetchInto(Author.class);
    }


    public Page<BookDetails> bookDetails(Pageable pageable) {
        Condition condition = BOOK_DETAIL.IS_SALE.eq(true);

        try (ResultSet rs = jooq.select(
                BOOK_DETAIL.ID,
                BOOK_DETAIL.FIRST_NAME,
                BOOK_DETAIL.LAST_NAME,
                BOOK_DETAIL.DATE_OF_BIRTH_DAY,
                BOOK_DETAIL.ADDRESS,
                BOOK_DETAIL.AUTHOR_ID.as("details_author_id"),
                BOOK_DETAIL.TITLE.as("details_title"),
                BOOK_DETAIL.CONTENT_TEXT.as("details_content_text"),
                BOOK_DETAIL.IS_SALE.as("details_is_sale"),
                BOOK_DETAIL.PUBLICATION_AT.as("details_publication_at")
        ).from(BOOK_DETAIL)
                .where(condition)
                .offset((int) pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchResultSet()) {
            List<BookDetails> list = mapper.stream(rs).collect(Collectors.toList());
            int count = jooq.fetchCount(BOOK_DETAIL, condition);
            return new PageImpl<>(list, pageable, count);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Transactional
    public Integer addAuthor(String firstName, String lastName, String address, LocalDate dateOfBirthDay) {
        return jooq.insertInto(AUTHOR)
                .set(AUTHOR.FIRST_NAME, firstName)
                .set(AUTHOR.LAST_NAME, lastName)
                .set(AUTHOR.ADDRESS, address)
                .set(AUTHOR.DATE_OF_BIRTH_DAY, dateOfBirthDay)
                .execute();
    }

    @Transactional
    public void updateAuthor(Integer id, String firstName, String lastName, String address, LocalDate dateOfBirthDay) {
        jooq.selectFrom(AUTHOR).where(AUTHOR.ID.eq(id)).fetchOptional().ifPresent(author -> {
            author.setFirstName(firstName);
            author.setLastName(lastName);
            author.setAddress(address);
            author.setDateOfBirthDay(dateOfBirthDay);
            author.update();
        });
    }

    @Transactional
    public void deleteAuthor(Integer id) {
        jooq.selectFrom(AUTHOR).where(AUTHOR.ID.eq(id)).fetchOptional().ifPresent(UpdatableRecordImpl::delete);
    }
}
