package com.muc.action;

import com.muc.bean.Product;
import com.muc.service.ProductService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/server")
public class ServerAction {
    @Resource
    ProductService productService;
    @CrossOrigin
    @RequestMapping("getproducts")
    HashMap<String,Object> initProduct(){
        HashMap<String,Object> map=new HashMap<>();
        try {
            ArrayList temp = productService.getAllProduct();
            if(temp!=null)
            {
                map.put("result","success");
                map.put("data",temp);
            }
            else
            {
                map.put("result","fail");
                map.put("errorMessage","服务器异常，请稍后重新打开页面");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            map.put("result","fail");
            map.put("errorMessage","服务器异常，请稍后重新打开页面");
        }
        return map;
    }
    @RequestMapping(value = "/uploadPhoto", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public Map<String, String> uploadPhoto(MultipartFile photo, HttpServletRequest request) {
        Map<String, String> ret = new HashMap<String, String>();
        if (photo == null) {
            ret.put("type", "error");
            ret.put("msg", "选择要上传的文件！");
            return ret;
        }
        if (photo.getSize() > 1024 * 1024 * 10) {
            ret.put("type", "error");
            ret.put("msg", "文件大小不能超过10M！");
            return ret;
        }
        //获取文件后缀
        String suffix = photo.getOriginalFilename().substring(photo.getOriginalFilename().lastIndexOf(".") + 1, photo.getOriginalFilename().length());
        if (!"jpg,jpeg,gif,png,pdf".toUpperCase().contains(suffix.toUpperCase())) {
            ret.put("type", "error");
            ret.put("msg", "请选择jpg,jpeg,gif,png格式的图片！");
            return ret;
        }
        //获取项目根目录加上图片目录 webapp/static/imgages/upload/
        String savePath = "C:/Users/王云/IdeaProjects/cloud/hands/src/main/resources/static/img/";
        System.out.println(savePath);
        File savePathFile = new File(savePath);
        if (!savePathFile.exists()) {
            //若不存在该目录，则创建目录
            savePathFile.mkdir();
        }
        String filename = new Date().getTime() + "." + suffix;
        try {
            //将文件保存指定目录
            photo.transferTo(new File(savePath + filename));
        } catch (Exception e) {
            ret.put("type", "error");
            ret.put("msg", "保存文件异常！");
            e.printStackTrace();
            return ret;
        }
        ret.put("type", "success");
        ret.put("msg", "上传图片成功！");
        ret.put("filepath", "C:/Users/王云/IdeaProjects/cloud/hands/src/main/resources/static/img/");
        ret.put("filename", filename);
        return ret;
    }


}
