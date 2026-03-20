package com.deepjyoti.logindemo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/Login")
public class LoginController {
    private final LoginServices services;

    public LoginController(LoginServices services) {
        this.services = services;
    }

    @GetMapping
    public List<Login> getAllUsers(){
        return services.GetAllUsers();
    }

    @PostMapping
    public ResponseEntity<Login> addUser(@RequestBody Login login){
        services.AddUser(login);
        return ResponseEntity.status(201).body(login);
    }

    @PutMapping("{id}/password")
    public void updatePassword(@PathVariable Integer id,
                               @RequestParam String password){
        services.UpdatePassword(id, password);
    }

    @PutMapping("{id}/username")
    public void updateUsername(@PathVariable Integer id,
                               @RequestParam String username){
        services.UpdateUsername(id, username);
    }
}
