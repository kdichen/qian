package com.chenqian.dao;

import com.chenqian.pojo.Cart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: 陈谦
 * @Date: 2018/5/16 9:47
 * <p>
 * 购物车
 */
public interface CartMapper {
    /**
     * 删除
     *
     * @param id 购物车ID
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 添加
     *
     * @param record 购物车
     * @return
     */
    int insert(Cart record);

    /**
     * 选择性新增
     *
     * @param record 购物车
     * @return
     */
    int insertSelective(Cart record);

    /**
     * 查询单个
     *
     * @param id 购物车ID
     * @return
     */
    Cart selectByPrimaryKey(Integer id);

    /**
     * 选择性更新购物车
     *
     * @param record 购物车对象
     * @return
     */
    int updateByPrimaryKeySelective(Cart record);

    /**
     * 更新购物车
     *
     * @param record 购物车对象
     * @return
     */
    int updateByPrimaryKey(Cart record);

    /**
     * 根据用户Id和产品Id, 查询购物车
     *
     * @param userId    用户Id
     * @param productId 产品Id
     * @return
     */
    Cart selectCartByUserIdProductId(@Param("userId") Integer userId, @Param("productId") Integer productId);

    /**
     * 根据用户名Id查询购物车
     *
     * @param userId
     * @return
     */
    List<Cart> selectCartByUserId(Integer userId);

    /**
     * 查询是否全选
     *
     * @param userId
     * @return
     */
    int selectCartProductCheckedStatusByUserId(Integer userId);

    /**
     * 删除购物车的商品
     *
     * @param userId        用户Id
     * @param productIdList 商品Id集合
     * @return
     */
    int deleteByUserIdProductIds(@Param("userId") Integer userId, @Param("productIdList") List<String> productIdList);

    /**
     * 全选/反选/单独选/单独反选
     *
     * @param userId    用户ID
     * @param productId 商品Id
     * @param checked
     * @return
     */
    int checkedOrUncheckedProduct(@Param("userId") Integer userId, @Param("productId") Integer productId, @Param("checked") Integer checked);

    /**
     * 查询购物车的总数量
     *
     * @param userId 用户Id
     * @return
     */
    int selectCartProductCount(@Param("userId") Integer userId);

}