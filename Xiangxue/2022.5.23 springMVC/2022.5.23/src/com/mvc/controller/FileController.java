package com.mvc.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

@Controller
public class FileController {
    /**
     * 上传
     */
    @RequestMapping(value = "/upload", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String upLoad(MultipartFile files) throws IOException { //  files参数名与表单提交名一致
        /*  获取上传的文件名称   */
        String originalFilename = files.getOriginalFilename();
        System.out.println(originalFilename);
        /**
         *  上传处理
         *  上传的文件储存在服务器的文件夹中
         *  文件名与文件所在服务器中目录路径储存到数据库中
         */
        /*  处理文件路径  */
        File filePath = new File("c:/data/");
        if (!filePath.exists()) {    //  目录不存在时创建目录
            filePath.mkdir();
        }
        /*  避免上传时同名文件被覆盖    */
        String fileName = System.currentTimeMillis() + originalFilename;
        File file = new File(filePath, fileName);
        files.transferTo(file); //  实现上传功能
        return "上传";
    }

    /**
     * 下载
     */
    @RequestMapping("/download")
    @ResponseBody
    public ResponseEntity<byte[]> download() throws IOException {
        /*  指定下载的服务器的中文路径   */
        File file = new File("c:/data/01.jpeg");
        FileInputStream in = new FileInputStream(file);
        /*  创建一个大数组装文件  */
        byte[] b = new byte[in.available()];
        /*  要下载的文件装入数组  */
        in.read(b);
        /*  以附件的形式相应到浏览器，设置响应头信息    */
        HttpHeaders headers = new HttpHeaders();
        String encodeName = URLEncoder.encode(file.getName(), "utf-8"); //  设置响应的文件名编码
        headers.add("Content-Disposition", "attachment;filename=" + encodeName);
        HttpStatus status = HttpStatus.OK;  //  状态码，ok表示200
        ResponseEntity<byte[]> entity = new ResponseEntity<>(b, headers, status);
        return entity;
    }
}
