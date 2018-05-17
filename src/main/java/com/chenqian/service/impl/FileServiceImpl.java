package com.chenqian.service.impl;

import com.chenqian.service.IFileService;
import com.chenqian.util.FTPUtil;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @Author: 陈谦
 * @Date: 2018/5/17 17:00
 */
@Service("iFileService")
public class FileServiceImpl implements IFileService {

    private Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);

    /**
     * 创建上传文件夹
     *
     * @param file 文件
     * @param path 上传路径
     * @return
     */
    @Override
    public String upload(MultipartFile file, String path) {
        // 获取上传文件的原始文件名
        String fileName = file.getOriginalFilename();
        // 获取扩展名 例如: abc.jpg -> jpg
        String fileExtensionName = fileName.substring(fileName.lastIndexOf(".") + 1);
        // 上传文件的名字
        String uploadFileName = UUID.randomUUID().toString() + "." + fileExtensionName;
        logger.info("开始上传文件,上传文件的文件名:{},上传的路径:{},新文件名:{}", fileName, path, uploadFileName);

        File fileDir = new File(path);
        // 判断文件夹是否存在
        if (!fileDir.exists()) {
            // 赋予可写权限
            fileDir.setWritable(true);
            // 创建文件夹
            fileDir.mkdirs();
        }
        // 创建文件
        File targetFile = new File(path, uploadFileName);

        try {
            file.transferTo(targetFile);
            logger.info("文件上传成功: path:{}, uploadFileName:{}", path, uploadFileName);
            FTPUtil.uploadFile(Lists.newArrayList(targetFile));
            logger.info("文件上传至服务器成功: path:{}, uploadFileName:{}", path, uploadFileName);
            targetFile.delete();
            logger.info("SFTP删除文件成功: path:{}, uploadFileName:{}", path, uploadFileName);
        } catch (IOException e) {
            logger.error("上传文件异常", e);
            return null;
        }
        return targetFile.getName();
    }
}
