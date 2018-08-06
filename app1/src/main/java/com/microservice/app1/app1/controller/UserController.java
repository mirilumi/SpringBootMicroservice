package com.microservice.app1.app1.controller;

import com.microservice.app1.app1.dtos.UserPostDto;
import com.microservice.app1.app1.entities.User;
import com.microservice.app1.app1.repositories.UserRepositories;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;


@Api(
        tags = {"User"},
        description = "User Resource"
)
@RestController
@RequestMapping( value = "/api", produces = MediaType.APPLICATION_JSON_VALUE )
public class UserController {

    @Autowired
    UserRepositories userRepositories;
    @ApiOperation("Get all Users")
    @RequestMapping( method = GET, value= "/user/all")
    public ResponseEntity<List<User>> findAll(){
        return ResponseEntity.ok(userRepositories.findAll());
    }
    @ApiOperation("Create new user")
    @PostMapping(value = "user")
    public ResponseEntity<User> save(
            @RequestBody @Valid UserPostDto userPostDto,
            final BindingResult bindingResult) {
        User user = new User();
        user.setName(userPostDto.getName());
        return ResponseEntity.ok(userRepositories.save(user));
    }
}

