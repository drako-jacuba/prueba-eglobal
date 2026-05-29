package com.transaction.api.service;

import com.transaction.api.dto.request.LoginRequest;
import com.transaction.api.dto.response.LoginResponse;

public interface AuthService {
    LoginResponse login(LoginRequest request);
}
