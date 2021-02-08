package com.t1dmlgus.spring_blog.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.sql.Timestamp;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@DynamicInsert        // insert 시 null인 필드를 제외시켜준다.
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)      //프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
    private Long id;

    @Column(nullable = false, length = 20,unique = true)
    private String username;    // 아이디

    @Column(nullable = false, length = 100)     // 비밀번호 => 해쉬(암호화)
    private String password;    // 비밀번호

    @Column(nullable = false, length = 50)
    private String email;



    @Enumerated(EnumType.STRING)    // DB는 RoleType이 없다. -> string
    private Role role;             // Enum을 쓰는게 좋음 -> ROLE_ADMIN, ROLE_USER, ROLE_MANAGER




    @CreationTimestamp              // 시간이 자동 입력(비워놔도 자동입력됨)
    private Timestamp createDate;


}


/**
 * Domain   -> 프로그래밍에서는 범위를 뜻함
 *
 *              ex) 성별이라는 도메인은 -> 남, 녀
 *                  초등학생의 학년이라는 도메인은 -> 1 ~ 6
 *
 *
 */


