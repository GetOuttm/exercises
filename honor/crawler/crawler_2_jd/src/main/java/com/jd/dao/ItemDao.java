package com.jd.dao;

import com.jd.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemDao extends JpaRepository<Item,Long> {
}
