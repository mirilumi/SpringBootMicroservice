package com.microservice.app2.app2.controllers;

import com.microservice.app2.app2.dto.UserGetDto;
import com.microservice.app2.app2.dto.UserPostDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Api(
        tags = {"User"},
        description = "User Resource"
)
@RestController
@RequestMapping( value = "/api", produces = MediaType.APPLICATION_JSON_VALUE )
public class UserController {


    @ApiOperation("Get all Users")
    @RequestMapping( method = GET, value= "/user/all")
    public ResponseEntity<UserGetDto[]> findAll(){
        ResponseEntity<UserGetDto[]> responseEntity = new RestTemplate().getForEntity(
                "http://localhost:8000/api/user/all", UserGetDto[].class);

        UserGetDto[] response = responseEntity.getBody();

        assert response != null;
        return ResponseEntity.ok(response);
    }
//    @ApiOperation("Create new user")
//    @PostMapping(value = "user")
//    public void save(
//            @RequestBody @Valid UserPostDto userPostDto,
//            final BindingResult bindingResult) {
//        MultiValueMap<String, Object> parts = new LinkedMultiValueMap<String, Object>();
//        parts.add("user", userPostDto);
//
//        ResponseEntity<Object> responseEntity = new RestTemplate().postForEntity(
//                "http://localhost:8000/api/user",  parts,Object.class);
//        String test = "";
//        return new ResponseEntity<UserGetDto>();
//    }
}
