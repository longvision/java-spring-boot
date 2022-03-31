package com.example.jpademo2.repositories;
import java.util.*;

import com.example.jpademo2.dto.BookInfo;

interface CustomizedBookRepository {
    List<BookInfo> findBookInfoList();

    BookInfo findBookInfoById(Integer id);
}
