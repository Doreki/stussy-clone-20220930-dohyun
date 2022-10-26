package com.stussy.stussyclone20220930dohyun.service.admin;

import com.stussy.stussyclone20220930dohyun.dto.admin.*;
import com.stussy.stussyclone20220930dohyun.exception.CustomInternalServerErrorException;
import com.stussy.stussyclone20220930dohyun.exception.CustomValidationException;
import com.stussy.stussyclone20220930dohyun.repository.admin.ProductManagementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ProductManagementServiceImpl implements  ProductManagementService {

    private final ProductManagementRepository productManagementRepository;

    @Override
    public List<CategoryResponseDto> getCategoryList() throws Exception {
        List<CategoryResponseDto> categoryResponseDtos = new ArrayList<>();
        productManagementRepository.getCategoryList().forEach(category -> {
            categoryResponseDtos.add(category.toDto());
        });

        return categoryResponseDtos;
    }

    @Override
    public void registerMst(ProductRegisterReqDto productRegisterReqDto) throws Exception {
        if(productManagementRepository.saveProductMst(productRegisterReqDto.toEntity())==0) {
            throw new CustomInternalServerErrorException("상품 등록 실패");
        }
    }

    @Override
    public List<ProductMstOptionRespDto> getProductMstList() throws Exception {
        List<ProductMstOptionRespDto> list = new ArrayList<>();

        productManagementRepository.getProductMstList().forEach(pdtMst -> {
            list.add(pdtMst.toDto());
        });
        return list;
    }

    @Override
    public List<?> getSizeList(int productId) throws Exception {
        List<ProductSizeOptionRespDto> list = new ArrayList<ProductSizeOptionRespDto>();

        productManagementRepository.getSizeList(productId).forEach(size -> {
            list.add(size.toDto());
        });

        return list;
    }

    @Override
    public void checkDuplicatedColor(ProductRegisterDtlReqDto productRegisterDtlReqDto) throws Exception {
        if(productManagementRepository.findProductColor(productRegisterDtlReqDto.toEntity() ) > 0) {
            Map<String, String> errorMap = new HashMap<String, String>();
            errorMap.put("error", "이미 등록된 상품입니다.");
            throw new CustomValidationException("Duplicated Error",errorMap);
        }
    }

    @Override
    public void registerDtl(ProductRegisterDtlReqDto productRegisterDtlReqDto) throws Exception {
        if(productManagementRepository.saveProductDtl(productRegisterDtlReqDto.toEntity()) == 0) {
            throw new CustomInternalServerErrorException("상품 등록 오류");
        }
    }
}
