package net.murwan.securityjwt.service;

import net.murwan.securityjwt.auth.AuthenticationService;
import net.murwan.securityjwt.dto.AuthenticationResponseDTO;
import net.murwan.securityjwt.dto.LoginRequestDTO;
import net.murwan.securityjwt.dto.RegisterRequestDTO;
import net.murwan.securityjwt.kafka.Producer;
import net.murwan.securityjwt.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    AuthenticationService authenticationService;
    @Autowired
    UserRepository repository;

    @Autowired
    Producer producer;

    public AuthenticationResponseDTO register(RegisterRequestDTO request) {
        AuthenticationResponseDTO responseDTO = authenticationService.register(request);
        int id = repository.findByEmail(request.getEmail()).get().getId();
        request.setId(id);
        producer.sendMessage(request);
        return responseDTO;
    }

    public AuthenticationResponseDTO login(LoginRequestDTO request) {
        AuthenticationResponseDTO responseDTO = authenticationService.authenticate(request);
        return responseDTO;
    }
}
