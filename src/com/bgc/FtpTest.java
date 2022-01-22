package com.bgc;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FtpTest {

    static String url = "16.5.20.62";
    static int port = 21;
    static String username = "zmcxxt";
    static String password = "zmcxxt";

    public static void main(String[] args) {
        boolean flag = false;
        FTPClient ftpClient = new FTPClient();
        try {
            int reply;
            ftpClient.connect(url, port);
            ftpClient.login(username, password);
            reply = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftpClient.disconnect();
                System.out.println("连接失败！");
            }
//			if (passiveMode) {
            ftpClient.enterLocalPassiveMode();
            ftpClient.setBufferSize(1024*1024);
            ftpClient.setControlEncoding("GBK");
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);

//            ftpClient.changeWorkingDirectory(path);
            while (true){
                ftpClient.sendCommand("ls");
                Thread.sleep(5*60*1000);
                System.out.println(new SimpleDateFormat("yyyyMMdd HH:mm:ss").format(new Date()));
                if(Integer.valueOf( new SimpleDateFormat("yyyyMMdd HH:mm:ss").format(new Date()).substring(9,11) )>=20){
                    break;
                }
            }

//            ftpClient.storeFile(filename, input);
//            input.close();
            ftpClient.logout();
        } catch (IOException ioe) {
            ioe.printStackTrace();
//            logger.error("FTP客户端出错！" + Constants.CLIENT_INFO, ioe);
        } catch (Exception e){
            e.printStackTrace();;
        }finally {
            if (ftpClient.isConnected()) {
                try {
                    ftpClient.disconnect();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
//                    logger.error("关闭FTP连接发生异常！" + Constants.CLIENT_INFO, ioe);
                }
            }
        }

    }
}
