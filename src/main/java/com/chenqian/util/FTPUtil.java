package com.chenqian.util;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.net.ftp.FTPClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

/**
 * @Author: 陈谦
 * @Date: 2018/5/17 17:01
 * <p>
 * FTP文件上传工具类
 */

@Getter
@Setter
public class FTPUtil {

    private static final Logger logger = LoggerFactory.getLogger(FTPUtil.class);

    /**
     * ftpIP.
     */
    private String ip;
    /**
     * ftp端口.
     */
    private int port;
    /**
     * ftp用户.
     */
    private String user;
    /**
     * ftp密码.
     */
    private String pwd;
    private FTPClient ftpClient;

    private static String ftpIp = PropertiesUtil.getProperty("ftp.server.ip");
    private static String ftpUser = PropertiesUtil.getProperty("ftp.user");
    private static String ftpPass = PropertiesUtil.getProperty("ftp.pass");

    public FTPUtil(String ip, int port, String user, String pwd) {
        this.ip = ip;
        this.port = port;
        this.user = user;
        this.pwd = pwd;
    }

    /**
     * 对外开放的FTP文件上传方法
     *
     * @param fileList 文件
     * @return
     * @throws IOException
     */
    public static boolean uploadFile(List<File> fileList) throws IOException {
        FTPUtil ftpUtil = new FTPUtil(ftpIp, 21, ftpUser, ftpPass);
        logger.info("开始连接ftp服务器");
        boolean result = ftpUtil.uploadFile("img", fileList);
        logger.info("开始连接ftp服务器,结束上传,上传结果:{}");
        return result;
    }

    /**
     * FTP 上传
     *
     * @param remotePath 远程路径
     * @param fileList   文件
     * @return
     * @throws IOException
     */
    private boolean uploadFile(String remotePath, List<File> fileList) throws IOException {
        // 是否上传
        boolean uploaded = true;
        FileInputStream fis = null;
        //连接FTP服务器
        if (connectServer(this.ip, this.port, this.user, this.pwd)) {
            try {
                // 切换文件夹
                ftpClient.changeWorkingDirectory(remotePath);
                // 设置缓冲区
                ftpClient.setBufferSize(1024);
                ftpClient.setControlEncoding("UTF-8");
                // 设置二进制
                ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
                // 打开本地被动模式
                ftpClient.enterLocalPassiveMode();
                for (File fileItem : fileList) {
                    fis = new FileInputStream(fileItem);
                    ftpClient.storeFile(fileItem.getName(), fis);
                }
                logger.info("通过FTP上传成功");

            } catch (IOException e) {
                logger.error("上传文件异常", e);
                uploaded = false;
                e.printStackTrace();
            } finally {
                fis.close();
                ftpClient.disconnect();
                logger.info("关闭FTP连接");
            }
        }
        return uploaded;
    }


    /**
     * 连接FTP服务器
     *
     * @param ip   FTP IP
     * @param port FTP端口
     * @param user FTP用户
     * @param pwd  FTP密码
     * @return
     */
    private boolean connectServer(String ip, int port, String user, String pwd) {

        boolean isSuccess = false;
        ftpClient = new FTPClient();
        try {
            ftpClient.connect(ip);
            isSuccess = ftpClient.login(user, pwd);
            logger.info("成功登陆FTP");
        } catch (IOException e) {
            logger.error("连接FTP服务器异常", e);
        }
        return isSuccess;
    }

}
