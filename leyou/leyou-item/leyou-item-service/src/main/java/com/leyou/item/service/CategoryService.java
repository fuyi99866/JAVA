package com.leyou.item.service;

import com.leyou.item.pojo.Category;

import java.util.List;

public interface CategoryService {
    public List<Category> queryLast();

    public List<Category> queryCategoryByPid(Long pid);

    List<Category> queryByBrandId(Long bid);

    void saveCategory(Category category);

    List<Category> queryAllCategoryLevelByCid3(Long id);

    List<Category> queryCategoryByIds(List<Long> ids);

    List<String> queryNameByIds(List<Long> ids);

    void deleteCategory(Long id);

    void updateCategory(Category category);
}
