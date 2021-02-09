package com.t1dmlgus.spring_blog.controller;

import com.t1dmlgus.spring_blog.domain.Role;
import com.t1dmlgus.spring_blog.domain.User;
import com.t1dmlgus.spring_blog.dto.ResponseDto;
import com.t1dmlgus.spring_blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class userApiController {

    @Autowired
    private UserService userService;

    @PostMapping("/api/user")
    public ResponseDto<Integer> saveUser(@RequestBody User user){  //I

        System.out.println("userApiController.save 호출 ");
        user.setRole(Role.ROLE_USER);
        userService.userJoin(user);

        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);   //responseText      //@RestCotroller의 모든 리턴 값은 @ResponseBody가 붙어있어
    }
}
