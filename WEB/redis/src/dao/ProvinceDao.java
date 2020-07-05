package dao;

import domian.Province;

import java.util.List;

public interface ProvinceDao {

    /**
     * 查询所有
     * @return
     */
    public List<Province> findAll();
}
