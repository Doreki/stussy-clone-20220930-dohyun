package com.stussy.stussyclone20220930dohyun.repository.admin;

import com.stussy.stussyclone20220930dohyun.domain.*;
import com.stussy.stussyclone20220930dohyun.dto.admin.ProductRegisterDtlReqDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Locale;

@Mapper
public interface ProductManagementRepository {
    public List<ProductCategory> getCategoryList() throws Exception;
    public int saveProductMst(Product product) throws Exception;

    public List<OptionProductMst> getProductMstList() throws Exception;

    public List<OptionProductSize> getSizeList(int productId) throws Exception;

    public int findProductColor(ProductDetail productDetail) throws Exception;

    public int saveProductDtl(ProductDetail productDetail) throws Exception;

    public int saveProductImg(List<ProductImg> productImgs) throws Exception;
}
