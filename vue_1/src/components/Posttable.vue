<template>
  <div >
    <div>
        <div class="postlist">
            <table rules="cols">
                <tr class="topline" >
                    <td width="70%" style="font-family:'Microsoft YaHei';font-weight:bold;">热帖·{{section}}</td>
                    <td></td>
                    <td></td>
                    <td style="text-align:right;padding-right:20px;">更多</td>
                </tr>
                <tr class="headrow" style="height:30px">
                    <td>标题</td>
                    <td>发帖人</td>
                    <td>回复数</td>
                    <td>发帖时间</td>
                </tr>
                <tr v-for="item in sortPostlist()" :key="item.name" class="contentline">
                    <td class="topic" style="font-family:'Microsoft YaHei';font-weight:bold;color:#606060"><router-link to="/postcontent" style="text-decoration:none;color:#606060"><a>{{item.headline}}</a></router-link></td>
                    <td style="color:#707070"><a>{{item.author}}</a></td>
                    <td style="color:#707070"><a>{{item.reply}}</a></td>
                    <td style="color:#707070"><a>{{item.date | dateFormatter}}</a></td>
                </tr>
               
            </table>
        </div>

    </div>

  </div>
</template>

<script>


export default {
  name: 'Posttable',
  props:['section'],
  data(){
    return{
      posts:[
         {headline:"出一瓶八二年的可乐",section:"讨论区",author:"廖洋",date:new Date(),reply:"1020"},
          {headline:"廖洋三发十连竟出了6个杰哥！",section:"讨论区",author:"朱桐",date:"",reply:"12093"},
          {headline:"",section:"",author:"",date:"",reply:""},
          {headline:"",section:"",author:"",date:"",reply:""},
          {headline:"",section:"",author:"",date:"",reply:""},
          {headline:"",section:"",author:"",date:"",reply:""},
      ]
    }
  },
  methods:{
      sortPostlist(){
          var sortedpost=this.posts;
          sortedpost.sort(function(a,b){
              return -parseInt(a.reply)+parseInt(b.reply);
          })
          return sortedpost;
      }
  }
}
</script>

<style scoped>
    .postlist{
        border-radius: 2px;
        background-color: #ffffff;
        border-style: solid;
        border-color: #f1f2f6;
        width: 70%;
        margin: 10px 15%;
    }

    .postlist table{
        width: 100%;
    }

    .postlist table td{
        border-style: none;
        border-bottom-style: solid;
        border-bottom-width: 0.5px;
        border-color: #dfe4ea;
        padding-left: 40px;
    }

    .postlist tr{
        height: 40px;
        transition-duration: 200ms;
    }
    .topic a:hover{
        color: #e84118
    }

    .topline{
        background-color: #dfe4ea
    }

    .headrow{
        color: gray;
        font-size: 14px;
        background: #eeeeee;
    }
</style>
