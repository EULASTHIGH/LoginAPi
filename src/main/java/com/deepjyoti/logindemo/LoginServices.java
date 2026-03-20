package com.deepjyoti.logindemo;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LoginServices {
    private final LoginRepo loginRepo;

    public LoginServices(LoginRepo loginRepo) {
        this.loginRepo = loginRepo;
    }

    public List<Login> GetAllUsers(){
        return loginRepo.findAll();
    }

    public void AddUser(Login login){
        loginRepo.save(login);
    }

    public Login UpdatePassword(Integer id, String password){
        Login login = loginRepo.findById(id).orElseThrow(()->new RuntimeException("Book Not Found."));
        login.setPassword(password);
        loginRepo.save(login);
        return login;
    }

    public Login UpdateUsername(Integer id, String username){
        Login login = loginRepo.findById(id).orElseThrow(()->new RuntimeException("Book Not Found."));
        login.setUsername(username);
        loginRepo.save(login);
        return login;
    }
}
