package com.example.jpademo2.repositories;
import java.util.*;

import com.example.jpademo2.dto.PublisherName;

interface CustomizedPublisherRepository {
    List<PublisherName> findPublisherList();
}

