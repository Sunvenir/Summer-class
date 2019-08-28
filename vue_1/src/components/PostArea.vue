<template>
  <div >
    <div>
      <div class="sendpost">
              <router-link to="/PostPage"><button>发帖</button></router-link>
              <button>上一页</button>
              <button>第1页</button>
              <button>下一页</button>
      </div>
      <p style="margin:5px;margin-left: 30px;margin-right: 30px;text-align: right;">当前板块</p>
        <div class="postlist">
            <table rules="cols">
                <thead>
                    <tr>
                        <td width="50%">标题</td>
                        <td>版块</td>
                        <td>作者</td>
                        <td>回复</td>
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
</template>

<script>


export default {
  name: 'PostArea',
  data(){
    return{
      posts:[
         {headline:"村口母猪为何半夜惨叫",section:"讨论区",author:"廖洋",reply:""},
          {headline:"廖洋三发十连竟出了6个杰哥！",section:"讨论区",author:"朱桐",date:"",reply:""},
          {headline:"",section:"",author:"",date:"",reply:""},
          {headline:"",section:"",author:"",date:"",reply:""},
          {headline:"",section:"",author:"",date:"",reply:""},
          {headline:"",section:"",author:"",date:"",reply:""},
      ]
    }
  }
}
</script>

<style>
    .sendpost{
        background-color: #dcdde1;
        border-bottom-style: solid;
        border-color: #ffffff;
        border-width: 2px;
        width: 98%;
        margin: 30px 1%;
        margin-bottom: 0px;
        padding-top: 5px;
        padding-bottom: 5px;
        
    }

    .sendpost button{
        width: 80px;
        border-radius: 10px;
        border-style: none;
        color: #fff;
        padding: 10px;
        margin-left: 1px;
        font-size: 15px;
        background: #0097e6;
        
        
    }

    .postlist{
        border-radius: 2px;
        background-color: #ffffff;
        border-style: solid;
        border-color: #f1f2f6;
        width: 98%;
        margin: 10px 1%;
    }

    .postlist table{
        width: 100%;
    }

    .postlist table td{
        border-style: none;
        border-bottom-style: solid;
        border-bottom-width: 1px;
        padding-left: 10px;
    }

    .postlist tr{
        height: 40px;
        transition-duration: 200ms;
    }

    .postlist tr:hover{
        background-color: #dfe4ea
    }

    .postlist table thead{
        background-color: #dfe4ea
    }
</style>
