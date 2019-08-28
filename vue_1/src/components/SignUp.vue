<template>
    <div>
        <Navigate></Navigate>
        <div class="signupform">
            <form action="" v-show="flag">
                <h1>SignUp</h1>
                <input type="text" class="txtb" placeholder="username" v-model="signupform.username" name="signup">
                <input type="password" class="txtb" placeholder="password" v-model="signupform.password" name="signup">
                <input type="password" class="txtb" placeholder="password again" v-model="signupform.repassword" name="signup">
                <input type="submit" class="signupbottom" value="注册账户" @click.prevent="signup">
                <a href="" @click.prevent="change">已经有账户了?</a>
            </form>
            <form action="" v-show="!flag">
                <h1>Login</h1>
                <input type="text" class="txtb" placeholder="username" v-model="loginform.username" name="login">
                <input type="password" class="txtb" placeholder="password" v-model="loginform.password" name="login">
                <input type="submit" class="loginbottom" value="登录" @click.prevent="login">
                <a href="" @click.prevent="change">还没有账户?</a>
            </form>
        </div>
    </div>
</template>

<script>

import Navigate from './Navigate'
export default {
  name: 'App',
  data(){
      return{
          flag:true,
          loginform:{
              username:"",
              password:""
          },
          signupform:{
              username:"",
              password:"",
              repassword:""
          }
      }
  },
  components:{
      'Navigate':Navigate
  },
  methods:{
      change(){
          this.flag=!this.flag
      },
      login(){
        this.$axios
        .post('/login', {
            username: this.loginform.username,
            password: this.loginform.password
        })
        .then(successResponse => {
            if (successResponse.data.code === 200) {
                this.$store.commit('changeuser',this.loginform.username);
                this.$router.replace({path: '/'})
            }
            else{
                console.log("密码错误");
            }
        })
        .catch(failResponse => {
            alert("err");
        })
    },
      signup(){
          this.$axios
          .post('/signup',{
              username: this.signupform.username,
              password: this.signupform.password,
              repassword: this.signupform.repassword
          })
          .then(successResponse=>{
              if(successResponse.data.code===200){
                  alert("注册成功");
                  this.$store.commit('changeuser',this.signupform.username);
                  this.$router.replace({path: '/'})
              }
              else if(successResponse.data.code===300){
                  alert("用户已存在");
              }
              else{
                  alert("请输入前后一致的密码");
              }
          })
          .catch(failResponse=>{
              alert("err");
          })
      }
  }
}
</script>

<style>
    .signupform{
        background-color: #7f8fa6;
        padding: 20px;
        position: absolute;
        width: 301px;
    
        text-align: center;
        top: 50%;
        left: 50%;
        transform:translate(-50%,-50%);
        overflow: hidden;
    }
    .signupform h1{
        margin-top: 60px;
        font-size: 44px;
        font-family: 'Do Hyeon', sans-serif;
        color: #fff
    }
    .signupform input{
        display: block;
        text-align: center;
        width: 100%;
        height: 44px;
        box-sizing: border-box;
        border-style: none;
    }
    .txtb{
        margin: 10px 0;
        border-radius: 10px/10px;
        background-color: rgba(255,255,255,0.5)
    }
    .signupbottom,.loginbottom{
        margin-top: 60px;
        margin-bottom:20px;
        border-radius: 44px;
        background-color:#40739e;
        outline: none;
        border-style: none;
        transition-duration: 300ms;
        color: #fff
    }

    .signupbottom:hover,.loginbottom:hover{
        background-color:rgba(106, 105, 209, 0.5);
    }

    .signupform a{
        text-decoration: none;
        color: #fff;
        display: block;
        transition-duration: 0.8s;
        padding: 10px;
    }

    .signupform a:hover{
        background:rgba(0, 0, 0, 0.2);
    }
</style>
