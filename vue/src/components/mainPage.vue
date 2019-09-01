<template>
  <div>
    <div id="background"></div>
    <barAndBG active-index="activeIndex"></barAndBG>
    <el-container class=page1>
      <el-header style="height:0px"></el-header>
      <el-main  style="width:1400px;color:white;padding:0px">
        <div style="height:360px;width:100px;float:left;">
          <div style="text-align:0px;line-height:60px;background: lightblue;border:white 20px solid;height:360px;width:60px;font-size:60px">
            T<br>U<br>T<br>U
          </div>
        </div>
        <div style="line-height:100px;border-top:white 20px solid;border-bottom:white 20px solid;height:360px;width:400px;float:left;font-size:100px">TUTU<br>BLOG</div>
        <div style="line-height:360px;border:white 20px solid;height:360px;width:760px;float:left">
          <el-carousel height=360px >
            <el-carousel-item v-for="item in 4" :key="item">
              <h3>{{ item }}</h3>
            </el-carousel-item>
          </el-carousel>
        </div>
      </el-main>
      <el-footer style="height:0px"></el-footer>
    </el-container>
    <el-container class='page2'>
      <el-aside style="background:rgba(0, 132, 255, 0.39);padding:0px;width:400px;margin-left: 100px;overflow: hidden">
          <div class='biaoqian' >
            最近发帖 >
          </div>
          <div style="line-height: 180px;text-align:center;border:white 20px solid;height:360px;width:360px;float:left;font-size:50px;color:white">
            JOIN TUTU
            <div style="line-height: 0px;text-align:center;height:360px;width:360px;font-size:100px">
                <router-link to='/register'><i class=el-icon-s-promotion></i></router-link>
            </div>
          </div>
      </el-aside>
      <el-main style="padding:0px;width:800px;">
        <el-container class='page3'>
          <el-header style="height:0px;">
          </el-header>
          <el-main style="padding:0px">
            <div @click="trigger(count)" 
             style="margin-left:20px;border-top:white 20px solid;border-left:white 20px solid;background:rgba(0, 132, 255, 0.39);width:760px;cursor:pointer;" v-for="count in showBlog.length">
              <div style="width:80px;float: left;">
                <div  style="width: 80px">
                  <div style="width: 74px; height:74px;border-radius: 50%; border: 3px solid #eee; overflow: hidden;">
                    <img :src="showBlog[count-1].post_owner.avatar" width="80" height="80">
                  </div>
                </div>
              </div>
              <div style="width:680px;margin-left:0px;float: left;">
                <div style="height:40px;font-size: 20px;text-align:left;line-height:40px;background: rgba(0, 132, 255, 0.39)">
                  {{showBlog[count-1].post_owner.name+" "}}{{showBlog[count-1].date.slice(0,10) + " "+ showBlog[count-1].date.slice(11,16)}}
                </div>
                <div   style="height:40px;font-size: 20px;text-align:left;line-height:40px;background: rgba(0, 255, 85, 0.39)" >
                  {{showBlog[count-1].title}}
                </div>
                <div  style="font-size: 20px;text-align:left;line-height:40px;color: white">
                 {{showBlog[count-1].detail}}
                </div>
              </div>
              <div>
                <el-button-group style="opacity:0;">
                  <el-button type="primary"  plain style="height:50px; width:400px;font-size: 20px">评论{{comnum}}</el-button>
                  <el-button type="primary" plain style="height:50px; width:400px;font-size: 20px">点赞{{likenum}}</el-button>
                </el-button-group>
              </div>
            </div>
          </el-main>
          <el-footer style="height:0px"></el-footer>
        </el-container>
      </el-main>
    </el-container>
  </div>
</template>
<style scoped>
  body{
    margin:0 auto;
     text-align: center;
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
  .el-header, .el-footer {
    background-color: rgb(255, 255, 255);
    color: white;
    text-align: center;
    width:800px;
  }
  .el-main {
    color: white;
    text-align: center;
  }

  .biaoqian{
    line-height: 60px;
    text-align:center;
    border-top:white 20px solid;
    height:60px;width:400px;
    float:left;
    font-size:50px;
    color:white;
  }
  .page1{
    
    margin:0 auto;
    margin-top:0px;
    margin-bottom:0px;
    height:400px;
    width:1400px;
  }
  .page2{
    
    margin:0 auto;
    margin-top:20px;
    margin-bottom:20px;
    width:1400px;
  }
  .page3{
  
    margin:0 auto;
    margin-left: 0px;
    width:800px;
  }
  .el-carousel__item h3 {
    color: #475669;
    font-size: 200px;
    opacity: 0.75;
    line-height: 360px;
    margin: 0;
  }

  .el-carousel__item:nth-child(2n) {
    background:url("../assets/images/1.jpg") no-repeat;
          background-size:cover;
  }

  .el-carousel__item:nth-child(2n+1) {
    background:url("../assets/images/2.png") no-repeat;
          background-size:cover;
  }

</style>
<script>
  import barAndBG from './barAndBG'
  export default {
    name:'mainPage',
    components: {barAndBG},
    mounted:
    function() {
      this.$axios.post('/getRecentFive',{
          mession:'get recent five blogs'
        })
        .then(successResponse=>{
           if(successResponse.data.code===200){
             console.log(successResponse.data);
             this.pageCount = successResponse.data.pagenum
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
    change(val) {
      console.log(val)
      },
    trigger1(){
      this.showflag1 = true,
      this.showflag2 = false
    },
    trigger2(){
      this.showflag2 = true,
      this.showflag1 = false
      },
    trigger(index){
      if(this.$store.state.usernow == ""){
        this.$message({
              message:'请先登录',
              type: 'error'
            })
      }
      else{
        this.$store.commit('changeblognow',this.showBlog[index-1])
        this.$router.push('/Page');
      }
    }
    },
    data() {
      return {
        value: true,
        showBlog:[],
        name:"昵称",
        time:"时间",
        title:"标题",
        content:"《龙族V》的创作遇到了瓶颈，简单地说就是有几个人物我写歪了，完成西伯利亚的故事之后，我必须暂停一下来修订目前遇到的一些偏向。修订的幅度之大应该跟龙族III差不多，很繁重的工作，特此告知。我知道有些读者很希望有日常更新的陪伴，但请给我一点时间。",
        comnum:1,
        likenum:1,
        showflag:false,
        showflag1:false,
        showflag2:false,

      }
    }
  }

</script>
