package com.chenqian.dao;

import com.chenqian.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: 陈谦
 * @Date: 2018/5/16 9:47
 * <p>
 * 用户
 */
public interface UserMapper {

    /**
     * 选择性删除
     *
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 新增
     *
     * @param record
     * @return
     */
    int insert(User record);

    /**
     * 选择性新增
     *
     * @param record
     * @return
     */
    int insertSelective(User record);

    /**
     * 根据主见选择性查询
     *
     * @param id
     * @return
     */
    User selectByPrimaryKey(Integer id);

    /**
     * 根据主见选择性更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * 更新方法
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(User record);

    /**
     * 查询用户名是否存在
     *
     * @param username 用户名
     * @return
     */
    int checkUsername(String username);

    /**
     * 查询 email 是否存在
     *
     * @param email email
     * @return
     */
    int checkEmail(String email);

    /**
     * 检查用户名, 密码是否正确
     *
     * @param username 用户名
     * @param password 密码
     * @return
     */
    User selectLogin(@Param("username") String username, @Param("password") String password);

    /**
     * 找回密码问题
     *
     * @param username 用户名
     * @return
     */
    String selectQuestionByUsername(String username);

    /**
     * 找回密码答案
     *
     * @param username 用户名
     * @param question 密码问题
     * @param answer   密码答案
     * @return
     */
    int checkAnswer(@Param("username") String username, @Param("question") String question, @Param("answer") String answer);

    /**
     * 根据用户名重置密码
     *
     * @param username    用户名
     * @param passwordNew 新密码
     * @return
     */
    int updatePasswordByUsername(@Param("username") String username, @Param("passwordNew") String passwordNew);

    /**
     * 登录状态下修改密码
     *
     * @param password 密码
     * @param userId   用户ID
     * @return
     */
    int checkPassword(@Param("password") String password, @Param("userId") Integer userId);

    /**
     * 根据用户名修改email
     *
     * @param email  邮箱
     * @param userId 用户ID
     * @return
     */
    int checkEmailByUsername(@Param("email") String email, @Param("userId") Integer userId);
}