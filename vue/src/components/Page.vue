<template>
  <div>
    <div id="background"></div>
    <el-button @click="deleteBlog" icon="el-icon-delete" id = "delete" v-if = "name == this.$store.state.usernow || this.$store.state.usernow == 'sun'"></el-button>
    <barAndBG active-index="activeIndex"></barAndBG>

    <el-container>
      <el-header style="height:0px"></el-header>

      <el-container>
        <el-aside style="background: rgba(0, 132, 255, 0.39);width:360px">
          <div style="margin-top: 50px">
            <el-avatar :size="100" :src="avatar">
            </el-avatar>
          </div>
          <div style="height:60px;width:360px">
            <div
            style="font-size:20px;text-align: left;margin-left:20px; margin-right:10px;padding-top:10px;padding-bottom: 10px;border-bottom:rgb(190,190,190) 2px solid">
            用户名:{{" "+name}}</div>
            <div
            style="font-size:20px;text-align: left;margin-left:20px; margin-right:10px;padding-top:10px;padding-bottom: 10px;border-bottom:rgb(190,190,190) 2px solid">
            性别：{{" "+this.getsex(this.$store.state.blognow.post_owner.gender)}}</div>
            <div
            style="font-size:20px;text-align: left;margin-left:20px; margin-right:10px;padding-top:10px;padding-bottom: 10px;">
            生日：{{
              this.$store.state.blognow.post_owner.birthday==null?' 暂无数据':
              " "+this.$store.state.blognow.post_owner.birthday.slice(0,10)}}</div>
          </div>
          <div style="margin-top:20px;background: white">
          </div>
        </el-aside>

        <el-main class=page1 style="width:820px;margin-left:20px; ">
          <div style="background:rgba(0, 132, 255, 0.39);width:820px;overflow: hidden;">
            <div style="width:100px;float: left;">
              <div style="width: 100px">
                <div
                  style="margin-left:10px;margin-top:10px;width: 80px; height:80px;border-radius: 50%;">
                  <img :src="avatar" width="80" height="80">
                </div>
              </div>
            </div>
            <div style="width:710px;margin-left:0px;margin-top:10px;float: left;overflow: hidden;">
              <div
                style="height:40px;font-size: 20px;text-align:left;line-height:60px;background: rgba(0, 132, 255, 0.39)">
                {{name}} {{time}}
              </div>
              <div
                style="height:40px;font-size: 20px;text-align:left;line-height:40px;background: rgba(0, 255, 85, 0.39)">
                {{title}}
              </div>
              <div style="font-size: 20px;text-align:left;line-height:40px;color: white">
                {{content}}
              </div>
              <div>
                <div v-for = "count in images.length" style="width:180px;height:180px;border:10px white solid;float:left">
                  <img :src="images[count-1]" width="180px"
                    height="180px"></img>
                </div>
                
              </div>
            </div>

            <div
              style="float:left;margin-top:20px;overflow: hidden;margin-top:20px;width:710px;margin-left:100px;">
              <div @click=showme
                style="height:40px;float: left;width:298px;border:1px white solid;font-size: 20px;line-height:40px;color: white" class = "buttons">
                评论
              </div>
              <div class = "buttons" @click="likeBlog"
                style="height:40px;float:left;width:298px;border:1px white solid;font-size: 20px;line-height:40px;color: white">
                {{'点赞('+like+')'}}
              </div>
            </div>
            <div v-if=me style="float:left;width:720px;margin-left: 100px;margin-top:20px">
              <div style="width:720px;padding:0;overflow: hidden">
                <div style="float:left;margin-top:20px;margin-left:0px;width:40px;height:40px;">
                  <img :src="selfavatar" width="40"
                  height="40">
                </div>
                <el-button @click="postReply" type="primary" plain
                  style="padding:0px;height:40px;margin-top:20px;margin-right:10px; width:100px;font-size: 20px;float:right">发布
                </el-button>
                <el-input style="float:right;margin-top:20px;margin-right: 10px;height:50px;width:550px" v-model = "reply">
                  
                </el-input>
              </div>
              
            </div>
            <div v-for = "count in replyList.length"
            v-if=me style="margin-top:20px;border-top:1px white solid;border-bottom:1px white solid;margin-left:100px;float: left;width:710px">
              <div style="width:40px;float: left;">
                <div style="width: 40px">
                  <div
                    style="margin-left:0px;margin-top:10px;width: 40px; height:40px; overflow: hidden;">
                    <img :src="replyList[count-1].avatar" width="40"
                      height="40">
                  </div>
                </div>
              </div>
              <div style="margin-top:10px;width:660px;margin-left:10px;float: left;">
                <div
                  style="height:40px;font-size: 20px;text-align:left;line-height:60px;background: rgba(0, 132, 255, 0.39)">
                  {{replyList[count-1].username}}
                </div>

                <div style="font-size: 20px;text-align:left;line-height:40px;color: white;width: 560px;">
                  {{replyList[count-1].content}}
                </div>

              </div>


              <div style="text-align:left;float: left;width:355px;font-size: 20px;line-height:40px;color: white">
                {{replyList[count-1].date}}
              </div>
              <div  @click="likeReply(count)"
               style="text-align: right;float:left;width:355px;font-size: 20px;line-height:40px;color: white;cursor:pointer">
                {{"点赞("+replyList[count-1].like+")"}}
              </div>
            </div>
          </div>
        </el-main>
      </el-container>

      <el-footer style="opacity:0;">Footer</el-footer>
    </el-container>
  </div>
</template>


<script>
  import barAndBG from './barAndBG'
  export default {
    name: 'Page',
    components: {
      barAndBG
    },
    mounted:
    function() {
      if(this.$store.state.userinfo.name == '')
        this.$router.replace({path: '/'});
      this.name = this.$store.state.blognow.post_owner.name
      this.time = this.$store.state.blognow.date
      this.title = this.$store.state.blognow.title
      this.content = this.$store.state.blognow.detail
      this.avatar = this.$store.state.blognow.post_owner.avatar
      this.images = this.$store.state.blognow.urls
      this.like = this.$store.state.blognow.like
      this.selfavatar = this.$store.state.userinfo.avatar
      this.$axios.post('/findReply',{
          blog_owner:this.name,
          blog_name:this.title,
        })
        .then(successResponse=>{
           if(successResponse.data.code===200){
             console.log(successResponse.data)
             this.replyList = successResponse.data.replies;
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
    data() {
      return {
        reply: '',
        avatar: '',
        name: "昵称",
        time: "时间",
        title: "标题",
        content: "",
        comnum: 1,
        likenum: 1,
        images:['','','','','','','','',''],
        replyList:[],
        selfavatar: '',
        me: false,
        like: 0
      }
    },
    methods: {
      likeReply(index){
        this.$axios.post('/likeReply',{
          username:this.$store.state.usernow,
          blog_owner:this.name,
          blog_name:this.title,
          date:this.replyList[index-1].date
        })
        .then(successResponse=>{
           if(successResponse.data.code===200){
             this.$message({
                message:'点赞成功',
                type: 'success'
              })
             this.replyList = successResponse.data.replies
           }
           else{
             this.$message({
                message:'发生未知错误，点赞失败',
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
      likeBlog(){
        this.$axios.post('/likeBlog',{
          username:this.$store.state.usernow,
          blog_owner:this.name,
          blog_name:this.title,
        })
        .then(successResponse=>{
           if(successResponse.data.code===200){
             this.$message({
                message:'点赞成功',
                type: 'success'
              })
             this.like = successResponse.data.like
           }
           else{
             this.$message({
                message:'发生未知错误，点赞失败',
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
      deleteBlog(){
        this.$axios.post('/deleteBlog',{
          blog_owner:this.name,
          blog_name:this.title,
        })
        .then(successResponse=>{
           if(successResponse.data.code===200){
             this.$message({
                message:'删除成功',
                type: 'success'
              })
             this.$router.replace('/')
           }
           else{
             this.$message({
                message:'发生未知错误，删除',
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
      postReply(){
        console.log(this.reply)
        this.$axios.post('/postReply',{
          username:this.$store.state.usernow,
          blog_owner:this.name,
          blog_name:this.title,
          content:this.reply
        })
        .then(successResponse=>{
           if(successResponse.data.code===200){
             this.$message({
                message:'发布成功',
                type: 'success'
              })
             this.replyList = successResponse.data.replies
             this.reply = ''
           }
           else{
             this.$message({
                message:'发生未知错误，发布失败',
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
      change(val) {
        console.log(val)
      },
      showme() {
        this.me = !this.me
      }
    }
  }
</script>
<style scoped>
  #delete{
    position: fixed;
    height:60px;
    width:60px;
    right:30px;
    top:70px;
  }
  .page1 {
    background: url("../assets/images/3.jpg") no-repeat;
    background-size: cover;
  }

  .el-header,
  .el-footer {
    background-color: rgb(255, 255, 255);
    color: rgb(0, 0, 0);
    text-align: center;
  }

  .el-aside {
    text-align: center;
    padding: 0px;
    margin: 0px;
  }

  .el-main {
    text-align: center;
    padding: 0px;
    margin: 0px;
  }

  .buttons{
    cursor: pointer;
  }

  .buttons:hover{
    color: #FF00FF;
  }

  .el-container:nth-child(1) {
    margin: 0 auto;
    margin-top: 0px;
    margin-bottom: 0px;
    height: 300px;
  }

  .el-container:nth-child(2) {
    margin: 0 auto;
    margin-top: 20px;
    margin-bottom: 20px;
    width: 1220px;
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