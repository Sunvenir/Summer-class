<template>
  <div>
  	<Navigate></Navigate>
    <div class="intro">
        <h1>WashBasin 脸盆网·发帖</h1>
        <h4>在这里发布你的想法与创意，和来自五湖四海的人们分享天南海北的事情</h4>
    </div>
    <div class="postpanel">
        <form>
            <table>
                <tr>
                    <td style="text-align:right;vertical-align:top;width:22%"><p style="margin:0px 10px;margin-left:10px">帖子标题</p></td>
                    <td><textarea  cols="50" rows="5" v-model="title"></textarea></td>
                </tr>
                <tr style="height:50px">
                    <td style="text-align:right;width:22%"><p style="margin:0px 10px;margin-left:10px">发布版块</p></td>
                    <td class="radiotr">
                        <input type="radio" value="1" v-model="section">讨论区
                        <input type="radio" value="2" v-model="section">课程推荐
                        <input type="radio" value="3" v-model="section">刷题区
                        <input type="radio" value="4" v-model="section">校园周边
                    </td>
                </tr>
                <tr>
                    <td style="text-align:right;vertical-align:top;width:22%"><p style="margin:0px 10px;margin-left:10px">帖子内容</p></td>
                    <td><textarea cols="65" rows="35" v-model="content"></textarea></td>
                </tr>
                <tr>
                    <td colspan="2" style="text-align:center;padding:10px;"><button class="commitbutton" style="">发布帖子</button></td>
                </tr>
            </table>
        </form>
    </div>
    <backtotop></backtotop>
    <footer>Copyright ©</footer>
    <div class="postbutton">
        <router-link to="/"><button>返回首页</button></router-link>
    </div>
  </div>
</template>

<script>
import Navigate from './Navigate'
import backtotop from './backtotop'

export default {
  name: 'PostPage',
  data(){
      return{
          section:"",
          title:"",
          content:"",
      }
  },
  components:{
      'Navigate':Navigate,
      'backtotop':backtotop
  }
}
</script>

<style scoped>
    .intro{
        background: #ffffff;
        width: 70%;
        margin:20px 15%;
        border-top-left-radius: 10px;
        border-top-right-radius: 10px
    }
    .intro h1{
        padding:10px 30px;
        padding-bottom: 0px;
        margin-bottom: 0;
    }
    .intro h4{
         padding:13px 30px;
         padding-top:0px;
    }
    .postpanel{
        border-radius: 2px;
        background-color: #ffffff;
        border-style: solid;
        border-color: #f1f2f6;
        width: 70%;
        margin: 10px 15%;
        
    }
    .postpanel form{
        margin: 20px 10%;
        width: 80%;
    }
    .postpanel form table{
        width: 100%;
    }
    .postpanel form textarea{
        resize: none;
        font-size: 18px
    }
    .postpanel p{
        font-family:'Microsoft YaHei';
        font-weight:bold; 
    }

    .commitbutton{
        border-style:none;
        background:#5f6b74;
        color: white;
        width:100px;
        height:40px;
        transition-duration: 200ms;
    }

     .commitbutton:hover{
        border-style:none;
        background:#0984e3;
        color: white;
        width:100px;
        height:40px
    }
    footer {
        height: 75px;
        margin-top: 30px;
        background: #487eb0;
        text-align: center;
        padding-top: 40px;
        color:#505050
    }
    .postbutton{
        position: fixed;
        top:24%;
        left: 87%;
    }

    .postbutton button{
        border-style: none;
        background: white;
        width: 75px;
        height: 55px;
    }

    .postbutton button:hover{
        background: #0984e3;
        color:white
    }

</style>
