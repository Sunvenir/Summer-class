<template>
  <div id="login" style="margin:0 auto">
    <div id='div1'>
      <div id='div2'>
        <div>
          <h style="margin-left:30px;font-family:楷体;font-size:30px">登录</h>
        </div>
        <div style="margin: 20px">
      <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
          <el-form-item label-width=70px label="用户名" prop="UserName">
            <el-input v-model="ruleForm.UserName"></el-input>
          </el-form-item>
          <el-form-item label-width=70px label="密码" prop="Pass" type="password">
            <el-input type="Password" v-model="ruleForm.Pass" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label-width=0px>
            <el-button style="margin-left: 50px; margin-top: 10px" type="primary" @click="submitForm('ruleForm')">登录</el-button>
            <router-link to="/register" id="gotoRegister"><el-button>注册</el-button></router-link>
          </el-form-item>
        </el-form>
        </div>
      </div>
    </div>
  </div>
</template>

<style>
#div1{
  position:absolute;
  top:250px;
  left:700px;
  width:340px;
  height:320px;
  background: hsla(0, 0%, 100%, 0.6);
  padding-top:20px;
}
#div2{
  margin: 0px auto;
  width:300px;
  height:270px;
  background: hsla(0, 0%, 100%, 0.8); 
  padding-top:20px;
}
#gotoRegister{
  margin-left: 10px;
}
</style>
<script>
    import qs from 'qs'
    export default {
      name: 'login',
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
            if (this.ruleForm.CheckPass !== '') {
              this.$refs.ruleForm.validateField('CheckPass');
            }
            callback();
          }
        };
        return {
          ruleForm: {
            Pass: '',
            UserName: ''
          },
          rules: {
            Pass: [
              { validator: validatePass, trigger: 'blur' }
            ],
            UserName: [
              { validator: CheckUserName, trigger: 'blur' }
            ]
          }
        };
      },
      methods: {
          submitForm(formName) {
          this.$refs[formName].validate((valid) => {
            if (valid) {
              this.$axios
         .post('/login',{
             username: this.ruleForm.UserName,
             password: this.ruleForm.Pass,
         })
         .then(successResponse=>{
             if(successResponse.data.code===200){
               if(successResponse.data.banned)
                  alert("Sorry，你的号已被封禁，请联系管理员");
                else
                {
                 alert("登录成功");
                 this.$store.commit('setUser',successResponse.data.user)
                 this.$store.commit('changeuser',this.ruleForm.UserName)
                 this.$store.commit('changebarindex',1)
                 this.$store.commit('changeviewtype',1)
                 console.log(this.$store.state.userinfo)
                 this.$router.replace({path: '/'})
                }
             }
             else if(successResponse.data.code===300){
                 alert("用户已存在");
             }
             else{
                 alert("输入密码不正确");
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
