package net.murwan.securityjwt.controller;

import net.murwan.securityjwt.dto.LoginRequestDTO;
import net.murwan.securityjwt.dto.AuthenticationResponseDTO;
import net.murwan.securityjwt.dto.RegisterRequestDTO;
import net.murwan.securityjwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user/auth")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponseDTO> register(@RequestBody RegisterRequestDTO request) {
        System.out.println(request.toString());
        return ResponseEntity.ok(userService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponseDTO> login(@RequestBody LoginRequestDTO request) {
        System.out.println("Request is here --->" + request.toString());
        AuthenticationResponseDTO responseDTO = userService.login(request);
        System.out.println("Response is here --->" + responseDTO.toString());
        return ResponseEntity.ok(responseDTO);
    }
}
