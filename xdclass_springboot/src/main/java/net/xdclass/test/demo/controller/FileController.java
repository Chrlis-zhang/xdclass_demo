package net.xdclass.test.demo.controller;

import net.xdclass.test.demo.domain.JsonData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 功能描述 文件测试
 */
@Controller
@PropertySource({"classpath:application.properties"})
public class FileController {

    @RequestMapping(value = "/api/v1/page")
    public Object index() {
        return "index";
    }


    @Value("${web.file.path}")
    private String filePath;

    @RequestMapping(value = "upload")
    @ResponseBody
    public JsonData upload(@RequestParam("head_img") MultipartFile file, HttpServletRequest request) {

        // file.isEmpty() 判断图片是否为空
        // file.getSize() 图片大小进行判断
        System.out.println("配置文件注入打印:" + filePath);
        String name = request.getParameter("name");
        System.out.println("用户名" + name);

        // 获取文件名
        String fileName = file.getOriginalFilename();
        System.out.println("上传文件名" + fileName);

        // 获取文件后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        System.out.println("文件后缀名" + suffixName);

        // 文件上传路径
        fileName = UUID.randomUUID() + suffixName;
        System.out.println("转换后的名称" + fileName);

        File dest = new File(filePath + fileName);

        try {
            file.transferTo(dest);
            return new JsonData(0, fileName);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new JsonData(-1, "fail to save file", null);
    }
}
