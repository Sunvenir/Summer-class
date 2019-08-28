<template>
  <div id="register">
    <div id='div1'>
      <div id='div2'>
        <div>
          <h style="font-family: 黑体;font-size:30px">注册</h>
        </div>
        <div style="margin: 20px">
      <el-form :model="user" status-icon :rules="rules" ref="user" label-width="100px" class="demo-ruleForm">
          <el-form-item label-width=70px label="用户名" prop="username">
            <el-input v-model="user.userName"></el-input>
          </el-form-item>
          <el-form-item label-width=70px label="密码" prop="password">
            <el-input type="Password" v-model="user.password" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label-width=70px label="确认密码" prop="CheckPass">
            <el-input type="Password" v-model="user.CheckPass" autocomplete="off"></el-input>
          </el-form-item>

          <el-form-item label-width=0px>
            <el-button type="primary" @click="register('user')">提交</el-button>
            <el-button @click="resetForm('user')">重置</el-button>
          </el-form-item>
        </el-form>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data () {
    return {
      user: {
        username: '',
        psaaword: ''
      },
      msg: 'Welcome to Your Vue.js App'
    }
  }
}
</script>

<style>
#div1{
  margin: 0px auto;
  margin-top: 60px;
  width:340px;
  height:360px;
  background: hsla(0, 0%, 100%, 0.6);
  padding-top:20px;
}
#div2{
  margin: 0px auto;
  width:300px;
  height:320px;
  background: hsla(0, 0%, 100%, 0.8);
  padding-top:20px;
}
</style>
<script>
    export default {
      name: 'register',
      data() {
        var CheckUserName = (rule, value, callback) => {
          if (!value) {
            return callback(new Error('用户名不能为空'));
          }
          else{
            callback();
          }
        };
        var validatePass = (rule, value, callback) => {
          if (value === '') {
            callback(new Error('请输入密码'));
          } else {
            if (this.user.CheckPass !== '') {
              this.$refs.user.validateField('CheckPass');
            }
            callback();
          }
        };
        var validatePass2 = (rule, value, callback) => {
          if (value === '') {
            callback(new Error('请再次输入密码'));
          } else if (value !== this.user.password) {
            callback(new Error('两次输入密码不一致!'));
          } else {
            callback();
          }
        };
        return {
          user: {
            password: '',
            CheckPass: '',
            username: ''
          },
          rules: {
            password: [
              { validator: validatePass, trigger: 'blur' }
            ],
            CheckPass: [
              { validator: validatePass2, trigger: 'blur' }
            ],
            username: [
              { validator: CheckUserName, trigger: 'blur' }
            ]
          }
        };
      },
      methods: {
        register(user) {
          this.$refs[user].validate((valid) => {
            if (valid) {
              this.$axios
         .post('/register',{
             username: this.user.username,
             password: this.user.password,
             CheckPass: this.user.repassword
         })
         .then(successResponse=>{
             if(successResponse.data.code===200){
                 alert("注册成功");
                 this.$store.commit('changeuser',this.user.username);
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
             alert("发生未知错误");
         })
            } else {
              console.log('error submit!!');
              return false;
            }
          });
        },
        resetForm(user) {
          this.$refs[user].resetFields();
        }
      }
    }
  </script>
