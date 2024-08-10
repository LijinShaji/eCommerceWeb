package com.example.eCommerceWebsite.services.userservices.authenticationService;

import com.example.eCommerceWebsite.dtos.usersDTO.AuthenticationResponse;
import com.example.eCommerceWebsite.dtos.usersDTO.UsersDTO;
import com.example.eCommerceWebsite.models.userModel.User;
import com.example.eCommerceWebsite.repository.usersRepo.UserRepository;
import com.example.eCommerceWebsite.services.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Qualifier("userDetailsServiceBean")
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthenticationResponse register(UsersDTO usersDTO) {
    var user=User.builder()
            .userName(usersDTO.getUserName())
            .name(usersDTO.getName())
            .password(passwordEncoder.encode(usersDTO.getPassword()))
            .role(usersDTO.getRole())
            .build();
    userRepository.save(user);
    var jwt=jwtService.generateToken(user);
    return AuthenticationResponse.builder()
            .token(jwt)
            .build();
    }

    @Override
    public AuthenticationResponse authenticate(String username,String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
        var user=userRepository.findByUserName(username);
        if(user==null){
            throw new UsernameNotFoundException("Invalid username or password");
        }
        var jwt=jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwt)
                .build();
    }
}
