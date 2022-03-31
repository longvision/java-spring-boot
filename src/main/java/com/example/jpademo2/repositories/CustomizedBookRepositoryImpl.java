package com.example.jpademo2.repositories;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.example.jpademo2.dto.BookInfo;

public class CustomizedBookRepositoryImpl implements CustomizedBookRepository {
    private final JdbcTemplate jdbc;

    public CustomizedBookRepositoryImpl(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<BookInfo> findBookInfoList() {
        String sql = "SELECT * FROM book";

        RowMapper<BookInfo> rowMapper = (r, i) -> {
            BookInfo book = new BookInfo();
            book.setId(r.getInt("id"));
            book.setPublisherId(r.getInt("publisher_id"));
            book.setIsbn(r.getString("isbn"));
            book.setTitle(r.getString("title"));
            book.setPrice(r.getBigDecimal("price"));
            book.setAvailable(r.getBoolean("available"));
            return book;
        };

        return jdbc.query(sql, rowMapper);
    }
    
    public BookInfo findBookInfoById(Integer id) {
        String sql = "SELECT * FROM book where id = ?";

        RowMapper<BookInfo> rowMapper = (r, i) -> {
            BookInfo book = new BookInfo();
            book.setId(r.getInt("id"));
            book.setPublisherId(r.getInt("publisher_id"));
            book.setIsbn(r.getString("isbn"));
            book.setTitle(r.getString("title"));
            book.setPrice(r.getBigDecimal("price"));
            book.setAvailable(r.getBoolean("available"));
            return book;
        };

        return jdbc.query(sql, rowMapper, id.intValue()).get(0);
    }
}
