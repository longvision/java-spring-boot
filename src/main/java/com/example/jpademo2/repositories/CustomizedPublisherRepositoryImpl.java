package com.example.jpademo2.repositories;

import java.util.*;

import com.example.jpademo2.dto.PublisherName;

import org.springframework.jdbc.core.JdbcTemplate;

public class CustomizedPublisherRepositoryImpl implements CustomizedPublisherRepository {
    private final JdbcTemplate jdbc;

    public CustomizedPublisherRepositoryImpl(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<PublisherName> findPublisherList() {
        String sql = "SELECT publisher_id, publisher_name FROM publisher";

        List<Map<String, Object>> rows = jdbc.queryForList(sql);
        
        List<PublisherName> names = new ArrayList<>();
        for (Map<String, Object> row : rows) {
            PublisherName pub = new PublisherName();
            pub.setPublisherId((Integer) (row.get("publisher_id")));
            pub.setPublisherName((String) (row.get("publisher_name")));
            names.add(pub);
        }

        return names;
    }

}
