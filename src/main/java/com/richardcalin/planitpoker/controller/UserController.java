package com.richardcalin.planitpoker.controller;

import com.richardcalin.planitpoker.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    @GetMapping("/")
    public void saveUserToDatabase(@AuthenticationPrincipal OAuth2User oauth2User) {
        if (oauth2User != null) {
            String email = oauth2User.getAttribute("email");
            if (!userService.existsByEmail(email)) {
                userService.saveUser(email);
            }
        }
    }
}
