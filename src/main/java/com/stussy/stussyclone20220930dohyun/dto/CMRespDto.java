package com.stussy.stussyclone20220930dohyun.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@Data
public class CMRespDto<T> {

    private int code;
    private String message;
    private T data;
}
