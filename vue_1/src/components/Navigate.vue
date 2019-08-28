<template>
  <div>
    <div class="header">
      <ul class="nav">
          <li><router-link id="logo" to="/">WashBasin</router-link></li>
          <li class="option dropdown"><a href="#">首页</a>
          </li>
          <li class="option"><a href="#">讨论区</a></li>
          <li class="option"><a href="#">课程推荐 </a></li>
          <li class="option"><a href="#">刷题区 </a></li>
          <li class="option"><a href="#">校园周边</a></li>
          <li class="option"><a href="#">新手上路 </a></li>
          <li class="search"><input type="text" placeholder="输入搜索内容 " size="30" class="searchinput"></li>
          <li class="search"><input type="submit" value="搜索" class="searchbutton"></li>
          <li style="float: right" class="option" v-if="!userflag"><router-link to="/SignUp">登录</router-link></li>
          <li style="float: right" class="option" v-if="userflag"><router-link to="/homepage">{{usernow}}</router-link></li>
          <li></li>
      </ul>
    </div>
    <div style="height: 54px; width: 100%"></div>
  </div>
</template>

<script>


export default {
  name: 'Navigate',
  computed:{
      usernow(){
          return this.$store.state.usernow;
      },
      userflag(){
          if(this.usernow=="")
          return false;
          else return true;
      }
  }
 
}
</script>
<style scoped>
    .header {
        width: 100%;
        margin: 0px;
        background: #0097e6;
        top: 0%;
        left: 0%;
        position: absolute;
    }
    .nav{
        list-style-type: none;
        overflow: hidden;
        margin: 0%;
        padding: 0%;
    }
    .nav>li {
        margin: 0%;
        float: left;
        transition-duration: 200ms;
    }
    .nav>li>a,.nav>li>router-link{
        color: #fff;
        text-decoration: none;
        display: block;
        margin: 10px 20px;
        text-decoration: none;
        text-align: center;
    }
    
    .option:hover{
        background: rgba(0,0,0,0.5);
    }

    .option{
        padding-top: 3px;
        padding-bottom: 3px;
    }

    .search{
        padding-top: 0px;
        padding-bottom: 0px;
        float: right;
    }
    #logo{
        font-family:'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        margin-left:100px;
        padding-top: 3px;
        padding-bottom: 3px;
    }
     .searchinput{
        border-radius: 44px;
        border-style: none;
        text-align: right;
        font-size: 15px;
        height: 22px;
        margin: 10px 40px;
        margin-right: 9px;
        float: right;
    }
    .searchbutton{
        margin: 8px 8px;
        border-radius: 44px;
        border-style: none;
        font-size: 15px;
        height: 30px;
        width: 80px;
        color: #fff;
        background-color: #0fb9b1;
        transition-duration: 200ms;
        float: right;
    }

    .searchbutton:hover{
        background-color: #20bf6b
    }

    .ifin{
        border-style: solid;
    }
   

</style>
