package com.chenqian.service;

import com.chenqian.common.ServerResponse;
import com.chenqian.pojo.Product;
import com.chenqian.vo.ProductDetailVo;
import com.github.pagehelper.PageInfo;

/**
 * @Author: 陈谦
 * @Date: 2018/5/17 15:13
 */

public interface IProductService {

    /**
     * 新增和更新
     *
     * @param product
     * @return
     */
    ServerResponse saveOrUpdateProduct(Product product);

    /**
     * 更新上架商品的状态
     *
     * @param productId 商品Id
     * @param status    商品状态
     * @return
     */
    ServerResponse<String> setSaleStatus(Integer productId, Integer status);

    /**
     * 获取商品详情
     *
     * @param productId
     * @return
     */
    ServerResponse<ProductDetailVo> manageProductDetail(Integer productId);

    /**
     * 后台查询产品List,带分页
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    ServerResponse<PageInfo> getProductList(int pageNum, int pageSize);


    /**
     * 后台商品搜索, 带分页
     *
     * @param productName 商品名字
     * @param productId   商品Id
     * @param pageNum
     * @param pageSize
     * @return
     */
    ServerResponse<PageInfo> searchProduct(String productName, Integer productId, int pageNum, int pageSize);

    /**
     * 商品详情
     *
     * @param productId
     * @return
     */
    ServerResponse<ProductDetailVo> getProductDetail(Integer productId);

    /**
     * 商品搜索
     *
     * @param keyword    关键字
     * @param categoryId 分类Id
     * @param pageNum
     * @param pageSize
     * @param orderBy
     * @return
     */
    ServerResponse<PageInfo> getProductByKeywordCategory(String keyword, Integer categoryId, int pageNum, int pageSize, String orderBy);


}
