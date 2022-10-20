package com.stussy.stussyclone20220930dohyun.repository.admin;

import com.stussy.stussyclone20220930dohyun.domain.Product;
import com.stussy.stussyclone20220930dohyun.domain.ProductCategory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Locale;

@Mapper
public interface ProductManagementRepository {
    public List<ProductCategory> getCategoryList() throws Exception;
    public int saveProductMst(Product product) throws Exception;
}
