<template>
    <div id="change_pass">
      <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
          <el-form-item label-width=70px label="旧密码" prop="Pass" style="color:white">
            <el-input style="width:200px;" type="Password" v-model="ruleForm.Pass" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label-width=70px label="新密码" prop="CheckPass">
            <el-input style="width:200px" type="Password" v-model="ruleForm.CheckPass" autocomplete="off"></el-input>
          </el-form-item>

          <el-form-item label-width=100px>
            <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
            <el-button @click="resetForm('ruleForm')">重置</el-button>
          </el-form-item>
        </el-form>
        </div>
</template>

<style scoped>
#change_pass{
  position: absolute;
  top: 100px;
  left:200px;
  width:340px;
  height:250px;
  background-color: rgba(189,199,199,0.8);
  padding-top:20px;
}
</style>
<script>
    export default {
      data() {
        var validatePass = (rule, value, callback) => {
          if (value === '') {
            callback(new Error('请输入旧密码'));
          } else {
            if (this.ruleForm.CheckPass !== '') {
              this.$refs.ruleForm.validateField('CheckPass');
            }
            callback();
          }
        };
        var validatePass2 = (rule, value, callback) => {
          if (value === '') {
            callback(new Error('请输入新密码'));
          } else if (value === this.ruleForm.Pass) {
            callback(new Error('两次输入密码一致!'));
          } else {
            callback();
          }
        };
        return {
          ruleForm: {
            Pass: '',
            CheckPass: ''
          },
          rules: {
            Pass: [
              { validator: validatePass, trigger: 'blur' }
            ],
            CheckPass: [
              { validator: validatePass2, trigger: 'blur' }
            ]
          }
        };
      },
      mounted:
        function(){
            if(this.this.$store.state.userinfo.name == '')
            this.$router.replace({path: '/'});
      },
      methods: {
        submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.$axios
       .post('/editpassword',{
           username: this.$store.state.usernow,//this.$store.state.usernow,
           password: this.ruleForm.Pass,
           newpassword: this.ruleForm.CheckPass
       })
       .then(successResponse=>{
           if(successResponse.data.code===200){
               alert("修改密码成功");
               this.$router.replace({path: '/'})
           }
           else if(successResponse.data.code===300){
               alert("密码不正确，请重新输入");
           }
           else{
               alert("未知错误");
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
