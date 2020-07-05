package com.ljf.service;


import com.ljf.domain.Items;
import org.springframework.stereotype.Service;

@Service
public interface ItemsService {

    public Items findById(Integer id);
}
