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
            //alert('user의 save함수 호출됨!');

            let data = {
                username: $('#username').val(),
                password: $('#password').vla(),
                email: $('#email').val()
            }

            //console.log(data);


            // ajax 호출시 default가 비동기 호출이다.
            // ajax 통신을 이용해서 3개의 데이터를 json으로 변경하여 insert요청!
           $.ajax({
           }).done(function(){

           }).fail(function(){

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