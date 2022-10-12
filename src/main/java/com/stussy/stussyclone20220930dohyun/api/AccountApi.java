package com.stussy.stussyclone20220930dohyun.api;

import com.stussy.stussyclone20220930dohyun.aop.annotation.LogAspect;
import com.stussy.stussyclone20220930dohyun.dto.CMRespDto;
import com.stussy.stussyclone20220930dohyun.dto.RegisterReqDto;
import com.stussy.stussyclone20220930dohyun.dto.validation.ValidationSequence;
import com.stussy.stussyclone20220930dohyun.exception.CustomValidationException;
import com.stussy.stussyclone20220930dohyun.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api/account")
@RestController
@RequiredArgsConstructor
public class AccountApi {

    private final AccountService accountService;

    @LogAspect
    @PostMapping("/register")
    public ResponseEntity<?> register(@Validated(ValidationSequence.class) @RequestBody RegisterReqDto registerReqDto, BindingResult bindingResult) throws Exception {
        accountService.register(registerReqDto);
        return ResponseEntity.created(null).body(new CMRespDto<>(1,"회원가입 성공", registerReqDto));
    }
}
