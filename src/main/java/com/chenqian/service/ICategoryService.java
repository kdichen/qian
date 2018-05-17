package com.chenqian.service;

import com.chenqian.common.ServerResponse;
import com.chenqian.pojo.Category;

import java.util.List;

/**
 * @Author: 陈谦
 * @Date: 2018/5/17 11:28
 */

public interface ICategoryService {

    /**
     * 添加分配
     *
     * @param categoryName 分类名字
     * @param parentId     商品ID
     * @return
     */
    ServerResponse addCategory(String categoryName, Integer parentId);

    /**
     * 更新分类
     *
     * @param categoryId
     * @param categoryName
     * @return
     */
    ServerResponse updateCategoryName(Integer categoryId, String categoryName);

    /**
     * 获取子节点, 并且是平级的信息
     *
     * @param categoryId 分类ID
     * @return
     */
    ServerResponse<List<Category>> getChildrenParallelCategory (Integer categoryId);

    /**
     * 递归查询本节点的id及孩子节点的id
     *
     * @param categoryId
     * @return
     */
    ServerResponse<List<Integer>> selectCategoryAndChildrenById(Integer categoryId);




}
