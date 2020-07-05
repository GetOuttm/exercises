package dao;

import domian.Items;

import java.util.List;

public interface ItemsDao {

    List<Items> findAll() throws Exception;
}
