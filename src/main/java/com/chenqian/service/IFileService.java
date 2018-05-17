package com.chenqian.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: 陈谦
 * @Date: 2018/5/17 16:59
 * <p>
 * 文件处理
 */

public interface IFileService {

    /**
     * 文件处理
     *
     * @param file 文件
     * @param path 上传路径
     * @return
     */
    String upload(MultipartFile file, String path);
}
