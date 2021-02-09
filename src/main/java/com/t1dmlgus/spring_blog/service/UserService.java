package com.t1dmlgus.spring_blog.service;

import com.t1dmlgus.spring_blog.domain.User;
import com.t1dmlgus.spring_blog.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service            // 스프링이 컴포넌트 스캔을 통해서 Bean에 등록을 해줌 -> IoC
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void userJoin(User user) {

        userRepository.save(user);
    }
}

    /**
     *      Service가 필요한 이유
     *
     *
     *      1. 트랜젝션을 관리하기 위해서
     *
     *      2. 서비스의 의미 때문
     *
     *          트랜잭션
     *
     *
      */


