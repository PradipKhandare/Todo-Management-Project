package com.learn.springboot.todo_managemnt.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncoderIMPL {

    public static void main(String[] args) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        System.out.println("password "+passwordEncoder.encode("pradip"));
        System.out.println(passwordEncoder.encode("admin"));
    }
}
