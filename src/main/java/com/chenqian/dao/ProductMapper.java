package com.chenqian.dao;

import com.chenqian.pojo.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: 陈谦
 * @Date: 2018/5/16 9:47
 * <p>
 * 商品
 */
public interface ProductMapper {
    /**
     * 删除商品
     *
     * @param id 商品Id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 添加商品
     *
     * @param record 商品
     * @return
     */
    int insert(Product record);

    /**
     * 选择性更新
     *
     * @param record 商品
     * @return
     */
    int insertSelective(Product record);

    /**
     * 查询商品
     *
     * @param id 商品Id
     * @return
     */
    Product selectByPrimaryKey(Integer id);

    /**
     * 选择性查询产品
     *
     * @param record 商品
     * @return
     */
    int updateByPrimaryKeySelective(Product record);

    /**
     * 更新商品
     *
     * @param record 商品
     * @return
     */
    int updateByPrimaryKey(Product record);

    /**
     * 后台查询产品List
     *
     * @return
     */
    List<Product> selectList();

    /**
     * 后台商品搜索, 带分页
     *
     * @param productName
     * @param productId
     * @return
     */
    List<Product> selectByNameAndProductId(@Param("productName") String productName, @Param("productId") Integer productId);

    /**
     * 关键字搜索
     *
     * @param productName    商品名字
     * @param categoryIdList 分类集合
     * @return
     */
    List<Product> selectByNameAndCategoryIds(@Param("productName") String productName, @Param("categoryIdList") List<Integer> categoryIdList);

    /**
     * 悲观锁
     *
     * @param id
     * @return
     */
    Integer selectStockByProductId(Integer id);


}