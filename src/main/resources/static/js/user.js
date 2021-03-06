let index={     // 오브젝트

    init:function(){


               /*
               function(){} -> ()=>{} 쓴 이유는 this를 바인딩 하기 위해서!


               */

        $('#btn_save').on('click',()=>{
            this.save();
        });
     },

        save: function(){
            alert('user의 save함수 호출됨!');

            let data = {
                username: $('#username').val(),
                password: $('#password').val(),
                email: $('#email').val()
            };

            console.log(data);                      // 자바스크립트 오브젝트
            console.log(JSON.stringify(data));          // json 문자열


            // ajax 호출시 default가 비동기 호출이다.
            // ajax 통신을 이용해서 3개의 데이터를 json으로 변경하여 insert요청!
           $.ajax({
                type:"POST",
                url:"/api/user",
                data: JSON.stringify(data), // http body 데이터는   -> MIME 타입이 필요하다.
                contentType:"application/json; charset=utf-8",  // body데이터가 어떤 타입인지(MIME)
                dataType:"json"            // 요청을 서버로 해서 응답이 왔을 때 기본적으로 모는 것이 String(문자열)인데 생긴게  json 이라면 javascript오브젝트로 변환해준다.

           }).done(function(resp){
                alert("회원가입이 완료되었습니다.");
                alert(resp+"resp 값~");
                location.href="/";
           }).fail(function(error){
                alert(JSON.stringify(error));

           });



            /*

                아래
                1
                2
                3
                4
                5
                ajax 가 100초 가량 로직이 걸린다고 할 때
                밑에 함수가 있으면 1~ 5 실행을 하고 중간에 100초가 지나면
                다시 콜백해서 성공하면 done함수를 실행




            */


        }

}

index.init();