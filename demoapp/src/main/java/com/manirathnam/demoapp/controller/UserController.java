package com.manirathnam.demoapp.controller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/user")
    public String getUser(){
        return "USERS FETCHED";
    }

    @GetMapping("/{userId}")
    public String getUsers(@PathVariable String userId){
        return "HELLO USERS  " + userId ;
    }

    @GetMapping
    public String getSetOfUsers(@RequestParam(value="page") String pageNo,@RequestParam(value="limit") String pageSize){
        return "HELLO USERS from  " + pageNo + " of page size " + pageSize ;
    }

    @PostMapping("/save")
    public String saveUser(){
        return "USERS SAVED";
    }

    @PutMapping("/update")
    public String updatetUser(){
        return "USERS UPDATED";
    }

    @DeleteMapping("/delete")
    public String deleteUser(){
        return "USERS DELETED";
    }


}
