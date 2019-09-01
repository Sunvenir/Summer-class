<template>
  <div id="register">
    <div id='div1' v-if="flag==1">
      <div id='div2' v-if="flag==1">
        <div>
          <h style="margin-left:30px;font-family: 楷体;font-size:30px">注册</h>
        </div>
        <div style="margin: 20px">
      <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
          <el-form-item label-width=70px label="用户名" prop="UserName">
            <el-input v-model="ruleForm.UserName"></el-input>
          </el-form-item>
          <el-form-item label-width=70px label="密码" prop="Pass">
            <el-input type="Password" v-model="ruleForm.Pass" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label-width=70px label="确认密码" prop="CheckPass">
            <el-input type="Password" v-model="ruleForm.CheckPass" autocomplete="off"></el-input>
          </el-form-item>

          <el-form-item label-width=0px>
            <el-button style="margin-left: 60px" type="primary" @click="submitForm('ruleForm')">提交</el-button>
            <el-button @click="resetForm('ruleForm')">重置</el-button>
          </el-form-item>
        </el-form>
        </div>
      </div>
    </div>
    <div id="rookie" v-if="flag==2" style="overflow:scroll">
      <p>{{text}}</p>
    </div>
    <el-button v-if="flag==2" style="margin-top:620px;margin-left:1000px"type="primary" @click = "endrookie">我知道了</el-button>
  </div>
</template>

<style scoped>
#div1{
  position: absolute;
  top: 250px;
  left: 700px;
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
#rookie{
  position: absolute;
  top: 200px;
  left: 650px;
  height:400px;
  width:450px;
  background-color: rgba(221,243,242, 0.726)
}
</style>
<script>
    export default {
      data() {
        var CheckUserName = (rule, value, callback) => {
          if (!value) {
            return callback(new Error('用户名不能为空'));
          }
          else if(!this.$options.methods.judge_content.bind(this)(value)){
            return callback(new Error('只能包含数字、字母或下划线'))
          }
          else{
            callback();
          }
        };
        var validatePass = (rule, value, callback) => {
          if (value === '') {
            callback(new Error('请输入密码'));
          }
          else if(!this.$options.methods.judge_content.bind(this)(value)){
            return callback(new Error('只能包含数字、字母或下划线'))
          }
          else {
            if (this.ruleForm.CheckPass !== '') {
              this.$refs.ruleForm.validateField('CheckPass');
            }
            callback();
          }
        };
        var validatePass2 = (rule, value, callback) => {
          if (value === '') {
            callback(new Error('请再次输入密码'));
          } else if (value !== this.ruleForm.Pass) {
            callback(new Error('两次输入密码不一致!'));
          } else {
            callback();
          }
        };
        return {
          flag:1,
          text:'',
          ruleForm: {
            Pass: '',
            CheckPass: '',
            UserName: ''
          },
          rules: {
            Pass: [
              { validator: validatePass, trigger: 'blur' }
            ],
            CheckPass: [
              { validator: validatePass2, trigger: 'blur' }
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
                .post('/register',{
                    username: this.ruleForm.UserName,
                    password: this.ruleForm.Pass,
                })
                .then(successResponse=>{
                    if(successResponse.data.code===200){
                        this.flag = 2;
                        alert("注册成功");
                        this.$store.commit('changeuser',this.ruleForm.UserName);
                        this.$axios
                        .post('/getRookie',{})
                        .then(successResponse=>{
                          if(successResponse.data.code===200){
                            this.text = successResponse.data.content;
                          }
                          else{
                            console.log('error getting rookie!!');
                            return false;
                          }
                        })
                    }
                    else if(successResponse.data.code===300){
                        alert("用户已存在");
                    }
                    else{
                        alert("未知错误");
                    }
                })
                .catch(failResponse=>{
                    alert("发生未知错误");
                })
              } 
              else {
                    console.log('error submit!!');
                    return false;
              }
            });
          },
        endrookie(){
          this.$router.replace({path: '/'})
        },
        resetForm(user) {
          this.$refs[user].resetFields();
        },
        judge_content(str){
          return new RegExp('^[a-zA-Z0-9_]{1,}$').test(str);
        }
      }
    }
  </script>
