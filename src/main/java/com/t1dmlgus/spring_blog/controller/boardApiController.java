package com.t1dmlgus.spring_blog.controller;


import com.t1dmlgus.spring_blog.domain.Role;
import com.t1dmlgus.spring_blog.domain.User;
import com.t1dmlgus.spring_blog.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Supplier;

@RestController
public class boardApiController {

    @Autowired  //DI
    private UserRepository userRepository;



    @PostMapping("/api/user")
    public String saveUser(User user) {

        System.out.println("user.getUsername() = " + user.getUsername());
        System.out.println("user.getPassword() = " + user.getPassword());
        System.out.println("user.getEmail() = " + user.getEmail());

        user.setRole(Role.ROLE_USER);
        userRepository.save(user);

        return "회원가입완료";

    }


//    // null 값인 user를 생성해서 가져옴
//
//    @GetMapping("/api/user/{id}")
//    public User selectUserAll01(@PathVariable Long id) {
//
//        User user = userRepository.findById(id).orElseGet(new Supplier<User>() {
//            @Override
//            public User get() {
//                return new User();
//            }
//
//        });
//        return user;
//    }
//
//
//    /**
//     * 현재 테이블 id가 3까지 있는 경우
//     * /api/user/4 를 찾으면 DB에서 못찾아오게 되면  -> user가 null이 됨
//     * 그러면 return 값이 null로 반환 -> 런타임 에러
//     * <p>
//     * = > Optional로 User 객체를 감싸서 가져온 후 null인지 아닌지 판단해서 return 함
//     */
//

//    // 예외를 던져서 표시
//    @GetMapping("/api/user/{id}")
//    public User selectUserAll02(@PathVariable Long id) {
//
//        User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
//            @Override
//            public IllegalArgumentException get() {
//                return new IllegalArgumentException(" 해당 유저는 없습니다: id" + id);
//            }
//
//        });
//        return user;
//
//        /**
//         *
//         * user 객체 = 자바 오브젝트
//         * 요청: 웹브라우저
//         * 변환 -> 웹브라우저가 이해할 수 있는 데이터 -> json으로 변환해 줘야 한다
//         * 스프링부트 -> MessageConverter라는 애가 응답 시 자동 작동
//         *
//         * -> 자바 오브젝트를 리턴하게 되면, MessageConverter가 Jackson 라이브러리를 호출해서
//         *    user 오브젝트를 Json으로 변환해서 브라우저에게 던져준다.
//         *
//         */
//
//
//    }

    // 람다식 -> 예외 표시
    @GetMapping("/api/user/{id}")
    public User selectUserAll03(@PathVariable Long id) {

        User user = userRepository.findById(id).orElseThrow(() -> {
            return new IllegalArgumentException("해당 유저는 없습니02다. id" + id);

        });
        return user;
    }


    // 전체 리스트
    @GetMapping("/api/user")
    public List<User> list(){
        return userRepository.findAll();
    }


//    // json 데이터를 요청 -> java Object(MessageConverter의 Jackson 라이브러리가 변환해서 받아준다.)
//    @PutMapping("/api/user/{id}")
//    public User updateUser(@PathVariable Long id, @RequestBody User requestUser) {
//
//
//        System.out.println("id = " + id);
//        System.out.println("password = " + requestUser.getPassword());
//        System.out.println("email = " + requestUser.getEmail());
//
//
//        requestUser.setId(id);
//        userRepository.save(requestUser);
//
//        return null;
//    }




    // json 데이터를 요청 -> java Object(MessageConverter의 Jackson 라이브러리가 변환해서 받아준다.)

    @Transactional  // 함수 종료 시 자동 commit    -> 이게 왜 update 되는지?
    @PutMapping("/api/user/{id}")
    public User updateUser02(@PathVariable Long id, @RequestBody User requestUser) {


        System.out.println("id = " + id);
        System.out.println("password = " + requestUser.getPassword());
        System.out.println("email = " + requestUser.getEmail());


        User user = userRepository.findById(id).orElseThrow(() -> {
            return new IllegalArgumentException("UPDATE에 실패하였슈");

        });

        user.setPassword(requestUser.getPassword());
        user.setEmail(requestUser.getEmail());

       // userRepository.save(user);

        return user;
    }



    // 삭제
    @DeleteMapping("/api/user/{id}")
    public String deleteUser(@PathVariable Long id){
        try{
            userRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            return "삭제 실패하였02수, 해당 id db가 없지유~";
        }

        return "삭제되었02수";
    }

}
