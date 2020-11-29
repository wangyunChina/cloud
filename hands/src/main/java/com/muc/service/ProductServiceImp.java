package com.muc.service;

import com.muc.bean.Product;
import com.muc.bean.ProductImages;
import com.muc.bean.ProductView;
import com.muc.mapper.ProductImagesMapper;
import com.muc.mapper.ProductMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
@Service
public class ProductServiceImp implements ProductService {
    @Resource
    ProductMapper productMapper;
    @Resource
    ProductImagesMapper productImagesMapper;

    @Override
    public ArrayList<ProductView> getAllProduct() {
        ArrayList<ProductView> list=new ArrayList<>();
        try {
            ArrayList<Product> products = new ArrayList<>();
            products = this.productMapper.selectAll();
            for (Product i : products
            ) {
                ProductView temp = new ProductView();
                temp.setId(i.getId());
                temp.setUid(i.getUid());
                temp.setAuthor(i.getAuthor());
                temp.setPname(i.getPname());
                temp.setPpricein(i.getPpricein());
                temp.setPstack(i.getPstack());
                temp.setImageArray(productImagesMapper.selectByPid(i.getId()));
                list.add(temp);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public ArrayList<ProductView> getByType(String type) {
        return null;
    }

    @Override
    public ArrayList<ProductView> getByName(String productname) {
        return null;
    }

    @Override
    public ArrayList<ProductView> getByUsername(String username) {
        return null;
    }

    @Override
    public int addProduct(Product product) {
        return 0;
    }

    @Override
    public int deletProduct(Product product) {
        return 0;
    }

    @Override
    public int updateProduct(Product product) {
        return 0;
    }
}
