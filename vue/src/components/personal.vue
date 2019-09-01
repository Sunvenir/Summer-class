<template>
  <div id = "personal">
    <div id="background"></div>
    <barAndBG active-index="activeIndex"></barAndBG>
<el-container>
  <el-container>
      <el-aside width="150px" class="aside">
          <el-menu background-color="#545c64" text-color="#fff" active-text-color="#ffd04b" :default-active="activeIndex">
            <el-menu-item index="1" @click="jumpto(1)"><i class="el-icon-user-solid"></i>个人信息</el-menu-item>
              <el-menu-item index="2" @click="jumpto(2)"><i class="el-icon-picture"></i>头像</el-menu-item>
            <el-menu-item index="3" @click="jumpto(3)"><i class="el-icon-key"></i>更改密码</el-menu-item>
            <el-menu-item index="4" @click="jumpto(4)"><i class="el-icon-edit-outline"></i>我的发帖</el-menu-item>

          </el-menu>
        </el-aside>
<div v-if="flag == 1" id = 'personalList'>
        <div>
          <h1 style="color:white; font-size:20px;margin-left:100px;margin-top: 50px">您的个人信息</h1>
        </div>

    <el-row>
      <el-col :span="12">
    <div style="margin-left: -10px;margin-top: 20px">
    <div style="margin-top: 20px; color:white">
        <span >用户名：</span>
        <el-input style="width:200px"
          placeholder="原始用户名"
          prefix-icon="el-icon-edit"
          :disabled = "true"
          v-model="this.$store.state.usernow">
        </el-input>
    </div>
    <div style="margin-top:30px">
        <span style="color:white">邮箱：</span>
          <el-input style="width:200px; margin-left:16px"
            placeholder="your email address？"
            prefix-icon="el-icon-message"
            v-model="info.email">
          </el-input>
      </div>
      <div class="block" style = "margin-top: 30px">
        <span style="color:white" class="demonstration">生日:</span>
        <el-date-picker
          v-model="info.birthday"
          type="date"
          placeholder="选择日期" style="width:200px;margin-left:30px"
          :picker-options="pickerOptions">
        </el-date-picker>
      </div>
    </div></el-col>
      <el-col :span="12">
        <div style="width:400px;margin-top:-40px;margin-left: 50px">
        <div style="margin-top:60px">
          <span style="color:white;">真实姓名：</span>
          <el-input style="width:200px"
            placeholder="你的名字？"
            prefix-icon="el-icon-user"
            v-model="info.name">
          </el-input>
        </div>
        <div style="color:white;margin-top: 40px">
          性别：
            <el-radio style="color:white;margin-left: 30px" v-model="info.gender" label="1">男</el-radio>
            <el-radio style="color:white"v-model="info.gender" label="2">女</el-radio>
            <el-radio style="color:white"v-model="info.gender" label="3">未知</el-radio>
        </div>
        <div style="margin-top:40px">
            <span style="color:white">所在地：</span>
            <el-input style="width:250px"
            placeholder="where are you？"
            prefix-icon="el-icon-discover"
            v-model="info.location">
          </el-input>
        </div>
        <el-button style="margin-left:150px;margin-top: 60px" type="primary" @click="submitInfo('info')">确认修改</el-button>
      </div></el-col>
    </el-row>
    </div>
  </el-container>
  <head_portrait v-if="flag == 2"></head_portrait>
  <change_pass v-if="flag == 3"></change_pass>

  <!-- Preson -->
  <div id = "Person" v-if="flag == 4">

          <el-container id="container">
            <el-header style="height:0px"></el-header>

            <el-container>
              <el-aside style="background: rgba(0, 132, 255, 0.39);width:360px">
                <div style="margin-top: 50px;margin-left: 100px">
                    <el-avatar :size="100" :src="this.$store.state.userinfo.avatar"></el-avatar>
                </div>
                <div style="height:60px;width:360px">
                    <div
            style="font-size:20px;text-align: left;margin-left:20px; margin-right:10px;padding-top:10px;padding-bottom: 10px;border-bottom:rgb(190,190,190) 2px solid">
            用户名:{{" "+this.$store.state.usernow}}</div>
            <div
            style="font-size:20px;text-align: left;margin-left:20px; margin-right:10px;padding-top:10px;padding-bottom: 10px;border-bottom:rgb(190,190,190) 2px solid">
            性别：{{" "+this.getsex(this.$store.state.userinfo.gender)}}</div>
            <div
            style="font-size:20px;text-align: left;margin-left:20px; margin-right:10px;padding-top:10px;padding-bottom: 10px;">
            生日：{{this.$store.state.userinfo.birthday == null? ' 暂无信息':
            " "+this.$store.state.userinfo.birthday.slice(0,10)}}</div>
          </div>
                
              </el-aside>

              <div id = "blog-area"  style="width:800px;margin-left:10px;margin-top:10px">
                  <div @click="trigger(count)"
                   style="cursor:pointer;background:rgba(0, 132, 255, 0.39);width:800px;margin-bottom:20px" v-for = "count in showBlog.length">
                      <div style="width:80px;float: left;">
                          <div  style="width: 80px">
                            <div style="width: 74px; height:74px;border-radius: 50%; border: 3px solid #eee; overflow: hidden;">
                                <img :src="showBlog[count-1].post_owner.avatar" width="80" height="80">
                            </div>
                          </div>
                        </div>
                        <div style="width:720px;margin-left:0px;float: left;">
                          <div style="height:30px;font-size: 20px;text-align:left;line-height:30px;background: rgba(0, 132, 255, 0.39)">
                            {{showBlog[count-1].post_owner.name+" "}}{{showBlog[count-1].date.slice(0,10) + " "+ showBlog[count-1].date.slice(12,16)}}
                          </div>
                        <div style="height:40px;font-size: 25px;text-align:left;line-height:40px;background: rgba(0, 255, 85, 0.39)" >
                            {{showBlog[count-1].title}}
                         </div>
                          <div  style="font-size: 20px;text-align:left;line-height:30px;color: white;height:60px;overflow:hidden">
                            {{showBlog[count-1].detail}}
                          </div>
                        </div>
                        <div>
                          <el-button-group style="opacity:0;">
                            
                            <el-button type="primary"  plain style="height:50px; width:400px;font-size: 20px">详情</el-button>
                            
                            <el-button type="primary" plain style="height:50px; width:400px;font-size: 20px">点赞{{likenum}}</el-button>
                        </el-button-group>
                        </div>

                  </div>

              </div>
              </el-container>

             <el-footer class = "el-footer">
               <div style="left:0px" class="p-switch" @click="toLast">上一页</div>
               <div style="left:530px" class="p-switch" @click="toTop">首页({{this.page}}/{{this.pageCount}})</div>
               <div style="left:1060px" class="p-switch" @click="toNext">下一页>></div>
             </el-footer>
             </el-container>
    </div>
</el-container>
</div>
</template>
<script>
import sideBar from './sideBar'
import barAndBG from './barAndBG'
import head_portrait from './head_portrait'
import change_pass from './change_pass'
import Page from './Page'
export default {
      components: {barAndBG ,sideBar,head_portrait, change_pass, Page},
      data() {

        return {
          name:"昵称",
          avatar: '',
          time:"时间",
          title:"标题",
          content:"《龙族V》的创作遇到了瓶颈，简单地说就是有几个人物我写歪了，完成西伯利亚的故事之后，我必须暂停一下来修订目前遇到的一些偏向。修订的幅度之大应该跟龙族III差不多，很繁重的工作，特此告知。我知道有些读者很希望有日常更新的陪伴，但请给我一点时间。",
          comnum:1,
          likenum:100,
          pickerOptions: {
            disabledDate(time) {
              return time.getTime() >= Date.now();
            }
          },
          info:
          {
            username: '',
            email: '',
            name:'',
            gender: '',
            birthday:'',
            location: ''
          },
          flag: 4,
          activeIndex: '4',
          pageCount: 1,
          showBlog: [], //当前显示的帖子列表
          page: 1 //自己的帖子列表在第几页
        }
      },
      mounted:
      function(){
        if(this.$store.state.userinfo.name == '')
          this.$router.replace({path: '/'});
        this.info.username = this.$store.state.userinfo.name;
        this.info.email = this.$store.state.userinfo.email;
        this.info.name = this.$store.state.userinfo.realname;
        this.info.birthday = this.$store.state.userinfo.birthday;
        this.info.location = this.$store.state.userinfo.location;
        this.info.gender = this.$store.state.userinfo.gender;
        console.log(this.info)
        this.$axios.post('/getUserBlog',{
          username:this.$store.state.usernow,
          page:1,
          step:4
        })
        .then(successResponse=>{
           if(successResponse.data.code===200){
             console.log(successResponse.data);
             this.pageCount = successResponse.data.pagenum
             this.showBlog = successResponse.data.list
             for(var i = 0 ;i<this.showBlog.length;i++)  {
                if(this.showBlog[i] == null )  {
                    this.showBlog.splice(i,1);
                    i= i-1;
                  }
              }
           }
           else{
             this.$message({
                message:'发生未知错误，修改失败',
                type: 'error'
              })
           }
       })
       .catch(failResponse=>{
            this.$message({
              message:'catch error!',
              type: 'error'
            })
     })
      },
      methods: {
        getsex(index){
        if(index == 1){
          return '男'
        }
        else if(index == 2){
          return '女'
        }
        else{
          return '未知'
        }
      },
        change(val) {
          console.log(val)
        },
        trigger(index){
          this.$store.commit('changeblognow',this.showBlog[index-1])
          this.$router.push('/Page');
        },
      submitInfo(Info){
        if(this.info.birthday.toString().replace(/\s/g, '').length == 0){
          this.info.birthday = '2332-12-31T16:00:00.000Z'
        }
        if(!this.$options.methods.checkEmail.bind(this)(this.info.email)){
          this.$message({
           message:'邮箱格式不正确',
           type: 'error'
         })
        }
        else{
          this.$axios.post('/personalInfo',{
            username: this.$store.state.usernow,
            email: this.info.email,
            name: this.info.name,
            gender: this.info.gender,
            birthday: this.info.birthday,
            location: this.info.location
          })
          .then(successResponse=>{
           if(successResponse.data.code===200){
            this.$message({
              message:'修改信息成功',
              type: 'success'
            })
               this.$router.replace({path: '/'})
           }
           else{
             this.$message({
                message:'发生未知错误，修改失败',
                type: 'error'
              })
           }
       })
       .catch(failResponse=>{
            this.$message({
              message:'catch error!',
              type: 'error'
            })
       })
        }
      },
      jumpto(index){
        this.flag = index
      },
      checkEmail(str){
        if(str == '') return true;
        return new RegExp('^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\.[a-zA-Z0-9-]+)*\.[a-zA-Z0-9]{2,6}$').test(str);
      },
      toLast(){
        if(this.page == 1){
          this.$message({
            message: '当前已经是第一页',
            type: 'warning'
          })
        }
        else{
          this.page = this.page - 1
          this.$axios.post('/getUserBlog',{
            username:this.$store.state.usernow,
            page:this.page,
            step:4
          })
          .then(successResponse=>{
             if(successResponse.data.code===200){
               console.log(successResponse.data);
               this.showBlog = successResponse.data.list
               for(var i = 0 ;i<this.showBlog.length;i++)  {
                if(this.showBlog[i] == null || typeof(this.showBlog[i]) == "undefined")  {
                    this.showBlog.splice(i,1);
                    i= i-1;
                  }
                }
             }
             else{
               this.$message({
                  message:'发生未知错误，修改失败',
                  type: 'error'
                })
                this.page = this.page + 1
             }
         })
         .catch(failResponse=>{
              this.$message({
                message:'catch error!',
                type: 'error'
              })
              this.page = this.page + 1
          })
        }
      },
      toNext(){
        if(this.page == this.pageCount){
          this.$message({
            message: '当前已经是最后一页',
            type: 'warning'
          })
        }
        else{
          this.page = this.page + 1
          this.$axios.post('/getUserBlog',{
            username:this.$store.state.usernow,
            page:this.page,
            step:4
          })
          .then(successResponse=>{
             if(successResponse.data.code===200){
               console.log(successResponse.data);
               this.showBlog = successResponse.data.list
               for(var i = 0 ;i<this.showBlog.length;i++)  {
                if(this.showBlog[i] == null || typeof(this.showBlog[i]) == "undefined")  {
                    this.showBlog.splice(i,1);
                    i= i-1;
                  }
                }
             }
             else{
               this.$message({
                  message:'发生未知错误，修改失败',
                  type: 'error'
                })
                this.page = this.page - 1
             }
         })
         .catch(failResponse=>{
              this.$message({
                message:'catch error!',
                type: 'error'
              })
              this.page = this.page - 1
          })
        }
      },
      toTop(){
        this.$axios.post('/getUserBlog',{
          username:this.$store.state.usernow,
          page:1,
          step:4
        })
        .then(successResponse=>{
           if(successResponse.data.code===200){
             console.log(successResponse.data);
             this.showBlog = successResponse.data.list
             for(var i = 0 ;i<this.showBlog.length;i++)  {
                if(this.showBlog[i] == null || typeof(this.showBlog[i]) == "undefined")  {
                    this.showBlog.splice(i,1);
                    i= i-1;
                  }
                }
                this.page = 1
           }
           else{
             this.$message({
                message:'发生未知错误，修改失败',
                type: 'error'
              })
           }
       })
       .catch(failResponse=>{
            this.$message({
              message:'catch error!',
              type: 'error'
            })
          })
      }
    }
  }
</script>

<style scoped>
.aside{
  position: absolute;
  left: 0px;
  top: 65px;
  z-index: 1;
}
#personalList{
  margin: 100px;
  position: absolute;
  left: 150px;
  background-color: rgb(107,108,109);
  border-radius: 20px;
  opacity: 0.8;
  width: 800px;
  height: 450px;
  padding-left: 50px;
}
.el-header {
  background-color: rgba(102, 94, 83, 0.801);
  color: #333;
  line-height: 60px;
}

.el-aside {
  color: #333;
}
#Person{
  position: absolute;
  left: 200px;
}
.el-footer {
        width: 1150px;
        background-color: rgb(255, 255, 255);
        color: rgb(0, 0, 0);
        text-align: center;
}
.el-container:nth-child(1){
  margin:0 auto;
  margin-top:0px;
  margin-bottom:0px;
  height:300px;
}

.el-container:nth-child(2){
  margin:0 auto;
  margin-top:20px;
  margin-bottom:20px;
  width:1200px;
}
.container{

}
.p-switch{
  height: 70px;
  width: 120px;
  line-height: 60px;
  position: absolute;
}
.p-switch:hover{
  height: 70px;
  cursor: pointer;
  color: blue;
}
#background{
  background:url("../assets/images/background.jpg") no-repeat;
  background-size:cover;
  width: 1920px;
  height: 1080px;
  z-index: -1;
  position:fixed;
  top: 0px;
  left: 0px;
}
</style>
