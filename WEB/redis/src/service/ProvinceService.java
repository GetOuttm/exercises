package service;

import domian.Province;

import java.util.List;

public interface ProvinceService {

    /**
     * 查询所有
     * @return
     */
    public List<Province> findAll();


    public String findAllJson();
}
