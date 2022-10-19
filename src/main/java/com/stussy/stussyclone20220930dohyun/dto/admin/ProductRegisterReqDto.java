package com.stussy.stussyclone20220930dohyun.dto.admin;

import com.stussy.stussyclone20220930dohyun.domain.Product;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Data
public class ProductRegisterReqDto {
    private String category;
    private String name;
//    @Pattern(regexp = "^[0-9]*$")
//    @Min(value = 100, message = "최소 가격은 100원입니다.")
    private Integer price;
    private String simpleInfo;
    private String detailInfo;
    private String optionInfo;
    private String managementInfo;
    private String shippingInfo;

}
