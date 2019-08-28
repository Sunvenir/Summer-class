<template>
  <div>
  	<Navigate></Navigate>
    <div class="intro">
        <h1>WashBasin 脸盆网</h1>
    </div>
    <div class="table">
    <div class="information">

            <div class="headPhoto">
                <table>
                    <tr>
                        <td>
                            <img src="" width="60px" height="60px">

                        </td>

                        <td width="100px">

                        </td>
                        <td>
                            <table>
                                <tr>
                                    <td width="100px" style="font-family:'Microsoft YaHei';font-weight:bold;">
                                        昵称：{{oldname}}
                                    </td>
                                    
                                </tr>
                                <tr>
                                    <td>{{oldsentence}}</td>
                                </tr>
                            </table>
                        </td>
                        
                    </tr>

                </table>

            </div>
            <div style="height: 10px; width: 100%"></div>
            <div class="change">
                <table>
                    <tr>
                        <td class="option2" align="center" v-on:click="switch1">
                            <font color="white">个人信息</font>
                        </td>
                        <td class="option2" align="center" v-on:click="switch2">
                            <font color="white">我的帖子</font>
                        </td>
                    </tr>

                </table>
            </div>

            <div class="content">
                <form action="" v-show="flag">
                    <table>
                        <tr>
                            <td width="20%" style="font-family:'Microsoft YaHei';font-weight:bold;">用户名</td>
                            <td width="20%"></td>
                            <td width="20%"><input type="text" placeholder="编辑" v-bind="name" style="width:150px"></td>
                            <td width="20%"></td>
                            <td width="20%"></td>

                        </tr>
                        
                        <tr height="30px" ></tr>
                        <tr>
                            <td width="20%" style="font-family:'Microsoft YaHei';font-weight:bold;">修改头像</td>
                            <td width="20%"></td>                            
                            <td width="20%"><input type="file" accept=".jpg,.png" style="width:150px"></td>
                            <td width="20%"></td>
                            <td width="20%"></td>
                        </tr>
                        
                        <tr height="30px" ></tr>
                        <tr>
                            <td width="20%"></td>
                            <td width="20%">原密码</td>
                            <td width="20%"><input type="password" placeholder="编辑" v-model="password" style="width:150px"></td>
                            <td width="20%"></td>
                            <td width="20%"></td>
                        </tr>
                        <tr height="30px"></tr>
                        <tr>
                            <td width="20%" style="font-family:'Microsoft YaHei';font-weight:bold;">修改密码</td>
                            <td width="20%">新密码</td>
                            <td width="20%"><input type="password" placeholder="编辑" v-bind="password1" style="width:150px"></td>
                            <td width="20%"></td>
                            <td width="20%"></td>
                        </tr>
                        <tr height="30px"></tr>
                        <tr>
                            <td width="20%"></td>
                            <td width="20%">确认新密码</td>
                            <td width="20%"><input type="password" placeholder="编辑" v-bind="password2" style="width:150px"></td>
                            <td width="20%" align="center"><input type="button" value="验证" v-on:click="check2"></td>
                            <td v-if="word2" width="20%"><img src="" width="15px" height="15px"></td>
                        </tr>
                        <tr height="30px"></tr>
                        <tr>
                            <td width="20%" style="font-family:'Microsoft YaHei';font-weight:bold;">性别</td>
                            <td width="20%"><input type="radio" name="sex" value="female">男</td>
                            <td width="20%"><input type="radio" name="sex" value="male">女</td>
                            <td width="20%"><input type="radio" name="sex" value="no">隐藏</td>
                            <td width="20%"></td>
                        </tr>
                        <tr height="30px"></tr>
                        <tr>
                            <td width="20%" style="font-family:'Microsoft YaHei';font-weight:bold;">出生日期</td>
                            <td width="20%">
                                <select name="">
                                    <option value="0">1990</option>
                                    <option value="1">1991</option>
                                    <option value="2">1992</option>
                                    <option value="3">1993</option>
                                    <option value="4">1994</option>
                                    <option value="5">1995</option>
                                    <option value="6">1996</option>
                                    <option value="7">1997</option>
                                    <option value="8">1998</option>
                                    <option value="9">1999</option>
                                    <option value="10">2000</option>
                                    <option value="11">2001</option>
                                    <option value="12">2002</option>
                                    <option value="13">2003</option>
                                    <option value="14">2004</option>
                                </select>
                                年
                            </td>
                            
                            <td width="20%">
                                <select name="">
                                    <option value="0">1</option>
                                    <option value="1">2</option>
                                    <option value="2">3</option>
                                    <option value="3">4</option>
                                    <option value="4">5</option>
                                    <option value="5">6</option>
                                    <option value="6">7</option>
                                    <option value="7">8</option>
                                    <option value="8">9</option>
                                    <option value="9">10</option>
                                    <option value="10">11</option>
                                    <option value="11">12</option>
                                </select>
                                月
                            </td>
                            <td width="20%">
                                <select name="">
                                    <option value="0">1</option>
                                    <option value="1">2</option>
                                    <option value="2">3</option>
                                    <option value="3">4</option>
                                    <option value="4">5</option>
                                    <option value="5">6</option>
                                    <option value="6">7</option>
                                    <option value="7">8</option>
                                    <option value="8">9</option>
                                    <option value="9">10</option>
                                    <option value="10">11</option>
                                    <option value="11">12</option>
                                    <option value="12">13</option>
                                    <option value="13">14</option>
                                    <option value="14">15</option>
                                    <option value="15">16</option>
                                    <option value="16">17</option>
                                    <option value="17">18</option>
                                    <option value="18">19</option>
                                    <option value="19">20</option>
                                    <option value="20">21</option>
                                    <option value="21">22</option>
                                    <option value="22">23</option>
                                    <option value="23">24</option>
                                    <option value="24">25</option>
                                    <option value="25">26</option>
                                    <option value="26">27</option>
                                    <option value="27">28</option>
                                    <option value="28">29</option>
                                    <option value="29">30</option>
                                    <option value="30">31</option>
                                </select>
                                日
                            </td>
                            <td width="20%"></td>
                        </tr>
                        <tr height="30px"></tr>
                        <tr height="50px">
                            <td width="20%" style="font-family:'Microsoft YaHei';font-weight:bold;">个人签名</td>
                            <td colspan="3" ><textarea name="field" cols="70" rows="5" 
                            v-bind="sentence"></textarea></td>
                            <td width="20%"></td>
                        </tr>
                        <tr>
                            <td width="20%"></td>
                            <td width="20%"></td>
                            <td width="20%"><input type="button" value="提交修改" v-on:click="commit"></td>
                        </tr>
                    </table>
                </form>
                <div class=postlist v-show="!flag">
                    <table rules="cols">
                        <thead>
                            <tr>
                                <td width="50%">标题</td>
                                <td width="200px">版块</td>
                                <td width="200px">作者</td>
                                <td width="200px">回复</td>
                            </tr>
                        </thead>
                        <tbody>
                            <tr v-for="item in posts" :key="item.name">
                                <td>{{item.headline}}</td>
                                <td>{{item.section}}</td>
                                <td>{{item.author}}</td>
                                <td>{{item.reply}}</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <footer>Copyright ©</footer>
  </div>
</template>

<script>
import Navigate from './Navigate'

export default {
  name: 'Homepage',
  components:{
    'Navigate':Navigate,
  },
  data(){
    return{
      word1: null,
      word2: null,
      flag: true,
      oldname: "yixia",
      name:"",
      email: "1134200883@qq.com",
      oldsentence: "2333~~~",
      sentence: "",
      oldpassword:"123456",
      password:"",
      password1: "",
      password2: "",
      photo: '../assets/head.jpg',
      posts: [{
        headline: "村口母猪为何半夜惨叫",
        section: "讨论区",
        author: "廖洋",
        reply: ""
      }]
    }
  },
  methods:{
    check1() {
        if(this.password == this.oldpassword)
            this.word1 = true;
        else 
            this.word1 = false;
    },
    check2() {
        if (this.password1 == this.password2)
            this.word2 = true;
        else
            this.word2 = false;
    },
    switch1() {
        this.flag = true;
    },
    switch2() {
        this.flag = false;
    },
    commit() {

    }
  }
}
</script>

<style scoped>
    textarea{
        resize: none;
    }
    .intro{
        background: #ffffff;
        width: 70%;
        margin:20px 15%;
        border-top-left-radius: 10px;
        border-top-right-radius: 10px
    }
    .intro h1{
        padding:30px;
        padding-top: 10px;
    }
    footer {
        height: 75px;
        margin-top: 30px;
        background: #487eb0;
        text-align: center;
        padding-top: 40px;
        color:#505050
    }
    .information {
            margin-top: 20px;
            background-color: white;
            width: 80%;
            margin-left: 10%;
            margin-right: 10%;
    }

    .content {
            margin-top: 30px;
            width: 100%;
    }
    .postlist {
            border-radius: 10px;
            background-color: #ffffff;
            border-style: solid;
            border-color: #f1f2f6;
            width: 90%;
            margin-top: 10px;
            margin-left: 0px;

            
    }

    .postlist table {
            width: 100%;
    }

    .postlist table td {
            border-style: none;
            border-bottom-style: solid;
            border-bottom-width: 1px;
            padding-left: 10px;
    }

    .postlist tr {
            height: 40px;
            transition-duration: 200ms;
    }

    .postlist tr:hover {
            background-color: #dfe4ea
    }

    .postlist table thead {
            background-color: #dfe4ea
    }
    .change {
            width: 200px;
            margin-top: 30px;
            margin-left: 0px;
            background: #2592eb;
    }

    .option2:hover {
            background: rgba(0, 0, 0, 0.5);
    }

    .option2 {
            padding-top: 5px;
            padding-bottom: 7px;
            width: 100px;
    }
    .headPhoto {
            overflow: hidden;
            height: 70px;
            width: 100%;
            border-bottom-style: solid;
            margin-top: 20px;
            position: absolute；
    }
    .table {
        background-color: rgb(255, 255, 255);
        width: 70%;
        margin-left: 15%;
        margin-right: 15%;
    }
</style>
