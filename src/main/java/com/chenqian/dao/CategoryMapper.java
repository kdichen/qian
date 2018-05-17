package com.chenqian.dao;

import com.chenqian.pojo.Category;

import java.util.List;

/**
 * @Author: 陈谦
 * @Date: 2018/5/16 9:47
 * <p>
 * 类别
 */
public interface CategoryMapper {
    /**
     * 选择性删除分类
     *
     * @param id 分类ID
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 新增分类
     *
     * @param record 分类对象
     * @return
     */
    int insert(Category record);

    /**
     * 选择性新增分类
     *
     * @param record 分类对象
     * @return
     */
    int insertSelective(Category record);

    /**
     * 选择性查询分类
     *
     * @param id 分类ID
     * @return
     */
    Category selectByPrimaryKey(Integer id);

    /**
     * 选择性更新分类
     *
     * @param record 分类对象
     * @return
     */
    int updateByPrimaryKeySelective(Category record);

    /**
     * 更新分类
     *
     * @param record 分类对象
     * @return
     */
    int updateByPrimaryKey(Category record);

    /**
     *
     * 根据分类 Id 找到孩子节点
     * @param categoryId 分类Id
     * @return
     */
    List<Category> selectCategoryChildrenByParentId(Integer categoryId);
}