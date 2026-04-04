package com.thefoods.backend.service;

import com.thefoods.backend.dto.*;
import com.thefoods.backend.entity.*;
import java.util.*;

public interface AuthService {
    AuthResponse login(LoginRequest request);
    User register(User user);
}
