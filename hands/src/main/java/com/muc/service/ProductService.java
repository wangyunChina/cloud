package com.muc.service;

import com.muc.bean.Product;
import com.muc.bean.ProductView;

import java.util.ArrayList;

public interface ProductService {
    public ArrayList<ProductView> getAllProduct();
    public ArrayList<ProductView> getByType(String type);
    public ArrayList<ProductView> getByName(String productname);
    public ArrayList<ProductView> getByUsername(String username);
    public int addProduct(Product product);
    public int deletProduct(Product product);
    public int updateProduct(Product product);

}
