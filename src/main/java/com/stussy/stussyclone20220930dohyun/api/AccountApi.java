package com.stussy.stussyclone20220930dohyun.api;

import com.stussy.stussyclone20220930dohyun.aop.annotation.LogAspect;
import com.stussy.stussyclone20220930dohyun.dto.CMRespDto;
import com.stussy.stussyclone20220930dohyun.dto.RegisterReqDto;
import com.stussy.stussyclone20220930dohyun.dto.validation.ValidationSequence;
import com.stussy.stussyclone20220930dohyun.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RequestMapping("/api/account")
@RestController
@RequiredArgsConstructor
public class AccountApi {

    private final AccountService accountService;

    @LogAspect
    @PostMapping("/register")
    public ResponseEntity<?> register(@Validated(ValidationSequence.class) @RequestBody RegisterReqDto registerReqDto, BindingResult bindingResult) throws Exception {

        accountService.duplicate(registerReqDto);
        accountService.register(registerReqDto);

        return ResponseEntity.created(URI.create("/account/login")).body(new CMRespDto<>(1,"회원가입 성공", registerReqDto.getEmail()));
    }
}
