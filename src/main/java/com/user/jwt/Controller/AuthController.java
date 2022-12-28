package com.user.jwt.Controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.jwt.Entity.User;
import com.user.jwt.Payload.UserDio;
import com.user.jwt.Security.JwtAuthRequest;
import com.user.jwt.Security.JwtAuthResponse;
import com.user.jwt.Security.JwtTokenHelper;
import com.user.jwt.Services.UserServices;

@RestController
@RequestMapping("/api/v1/auth/")
public class AuthController {

    @Autowired
    private JwtTokenHelper jwtTokenHelper;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private UserServices userService;

    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponse> createToken(@RequestBody JwtAuthRequest request) throws Exception
    // throws Exception
    {
        this.authenticate(request.getEmail(), request.getPassword());
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(request.getEmail());
        String token = this.jwtTokenHelper.generateToken(userDetails);

        JwtAuthResponse response = new JwtAuthResponse();
        response.setToken(token);
        response.setUser(this.mapper.map((User) userDetails, UserDio.class));
        return new ResponseEntity<JwtAuthResponse>(response, HttpStatus.OK);
    }

    private void authenticate(String username, String password) throws Exception {

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username,
                password);
        try {

            this.authenticationManager.authenticate(authenticationToken);
        } catch (BadCredentialsException e) {
            System.out.println("Invalid Detal!!");
            throw new Exception(" password does not matched!!");
        }
    }

    // register new user api

    @PostMapping("/register")
    public ResponseEntity<UserDio> registerUser(@RequestBody UserDio userDto) {
        UserDio registeredUser = this.userService.registerUser(userDto);
        return new ResponseEntity<UserDio>(registeredUser, HttpStatus.CREATED);
    }

    // get loggedin user data
    // @Autowired
    // private UserRepo userRepo;
    // @Autowired
    // private ModelMapper mapper;

    // @GetMapping("/current-user/")
    // public ResponseEntity<UserDto> getUser(Principal principal) {
    // User user = this.userRepo.findByEmail(principal.getEmail()).get();
    // return new ResponseEntity<UserDto>(this.mapper.map(user, UserDto.class),
    // HttpStatus.OK);
    // }

}