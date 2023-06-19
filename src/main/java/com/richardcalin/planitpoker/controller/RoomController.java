package com.richardcalin.planitpoker.controller;

import com.richardcalin.planitpoker.model.entity.User;
import com.richardcalin.planitpoker.service.RoomService;
import com.richardcalin.planitpoker.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;
    private final UserService userService;

    @PostMapping("/create-room")
    public Long createRoom(@AuthenticationPrincipal OAuth2User oauth2User, @RequestParam String name, @RequestParam String description) {
        String email;
        if (oauth2User != null) {
            email = oauth2User.getAttribute("email");
        } else {
            email = null;
        }
        Optional<User> optionalUser = userService.findUserByEmail(email);
        User user = optionalUser.orElseThrow(() -> new IllegalArgumentException("User not found with email: " + email));
        return roomService.createRoom(name, description, user);
    }
}
