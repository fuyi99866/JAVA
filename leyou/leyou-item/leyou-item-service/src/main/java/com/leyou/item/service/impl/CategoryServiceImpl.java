package com.leyou.item.service.impl;

import com.leyou.item.pojo.Category;
import com.leyou.item.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Override
    public List<Category> queryLast() {
        return null;
    }

    @Override
    public List<Category> queryCategoryByPid(Long pid) {
        return null;
    }

    @Override
    public List<Category> queryByBrandId(Long bid) {
        return null;
    }

    @Override
    public void saveCategory(Category category) {

    }

    @Override
    public List<Category> queryAllCategoryLevelByCid3(Long id) {
        return null;
    }

    @Override
    public List<Category> queryCategoryByIds(List<Long> ids) {
        return null;
    }

    @Override
    public List<String> queryNameByIds(List<Long> ids) {
        return null;
    }

    @Override
    public void deleteCategory(Long id) {

    }

    @Override
    public void updateCategory(Category category) {

    }
}
