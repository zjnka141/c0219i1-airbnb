package codegym.airbnb.web.controller;


import codegym.airbnb.dao.entity.Account;
import codegym.airbnb.web.security.JwtResponse;
import codegym.airbnb.web.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin
public class AppController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @GetMapping("/test")
    public ResponseEntity<?> sayHello() {
        return new ResponseEntity<>("Welcome to my website", HttpStatus.OK);
    }
    @GetMapping("/admin/test")
    public ResponseEntity<?> sayAdmin() {
        return new ResponseEntity<>("Welcome admin to my website", HttpStatus.OK);
    }
    @GetMapping("/operator/test")
    public ResponseEntity<?> sayOperator() {
        return new ResponseEntity<>("Welcome operator to my website", HttpStatus.OK);
    }
    @GetMapping("/user")
    public ResponseEntity<?> sayUser(Principal principal) {
        Principal a= principal;
        return new ResponseEntity<>("Welcome user to my website", HttpStatus.OK);
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Account user) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwtToken=jwtTokenProvider.generateToken(authentication);
        UserDetails userDetails =(UserDetails) authentication.getPrincipal();
        return new ResponseEntity<>( new JwtResponse(jwtToken,userDetails.getUsername(),userDetails.getAuthorities()),HttpStatus.OK);
    }
}
