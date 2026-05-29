package com.transaction.api.controller;

import com.transaction.api.util.AESUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aes")
public class AESController {

    @GetMapping("/encrypt")
    public String encrypt(
            @RequestParam String value)
            throws Exception {

        return AESUtil.encrypt(value);
    }
}
