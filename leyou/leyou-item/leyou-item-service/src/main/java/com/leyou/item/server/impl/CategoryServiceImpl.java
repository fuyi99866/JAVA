package com.leyou.item.server.impl;

import com.leyou.item.pojo.Category;
import com.leyou.item.server.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Override
    public List<Category> queryCategoriesByPid(Long pid) {
        return null;
    }
}
