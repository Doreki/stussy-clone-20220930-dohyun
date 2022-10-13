package com.stussy.stussyclone20220930dohyun.service;

import com.stussy.stussyclone20220930dohyun.dto.RegisterReqDto;
import com.stussy.stussyclone20220930dohyun.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


public interface AccountService {

    public void duplicate(RegisterReqDto registerReqDto) throws Exception;
    public void register(RegisterReqDto registerReqDto) throws Exception;


}
