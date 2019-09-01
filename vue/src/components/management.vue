<template>
  <div id = "management">
        <barAndBG active-index="activeIndex"></barAndBG>
        
    <el-table id=usertable :data="userList" height="600" :row-class-name="rowClassName">
        <el-table-column prop="id" label="序号" width="80" height= 20px></el-table-column>
        <el-table-column prop="username" label="用户名"  width="200px"></el-table-column>
        <el-table-column prop="status" label="封禁状态" width="150px"></el-table-column>
        <el-table-column label="操作" align="center" min-width="200">
    　　　　<template slot-scope = "scope">
    　　　　　　<el-button type="primary" @click.native.prevent = "ban(scope.$index)">封禁</el-button>
    　　　　　　<el-button type="danger" @click.native.prevent = "unban(scope.$index)">解封</el-button>
    　　　　</template>
        </el-table-column>
    </el-table>
  </div>
</template>

<script>
import barAndBG from './barAndBG'

export default {
    components: {barAndBG},
    data() {
        return {
            usernow:'',
            status:'',
            row_id: 0,
            userList:[]
        }
    },
    mounted:
      function(){
        if(this.$store.state.userinfo.name == '')
            this.$router.replace({path: '/'});
        this.$axios.post('/getUserList',{})
        .then(successResponse=>{
           if(successResponse.data.code===200){
             console.log(successResponse.data);
             this.userList = successResponse.data.userList
           }
           else{
             this.$message({
                message:'发生未知错误，修改失败',
                type: 'error'
              })
           }
       })
    },
    methods:{
        handle(row,column,event,cell){
            console.log(row)
            console.log(column)
            console.log(event)
            console.log(cell)
        },  
        rowClassName({row, rowIndex}) {
            //把每一行的索引放进row.id
            row.id = rowIndex+1;
        },
        ban(index){
            this.$axios.post('/BanUser',{username: this.userList[index].username})
            .then(successResponse=>{
                if(successResponse.data.code===200){
                    alert("用户"+this.userList[index].username+'已被封禁!'),
                    this.userList[index].status = '被封禁'
                }
                else{
                    this.$message({
                        message:'发生未知错误，修改失败',
                        type: 'error'
                    })
                }
            })
        },
        unban(index){
            this.$axios.post('/UnbanUser',{username: this.userList[index].username})
            .then(successResponse=>{
                if(successResponse.data.code===200){
                    alert("用户"+this.userList[index].username+'已被解封!'),
                    this.userList[index].status = '未被封禁'
                }
                else{
                    this.$message({
                        message:'发生未知错误，修改失败',
                        type: 'error'
                    })
                }
            })
        }
    }
}
</script>

<style>
#usertable{
    position:absolute;
    width:700px;
    left:550px;
    top:200px;
}
#management{
  background:url("../assets/images/background.jpg") no-repeat;
  background-size:cover;
  width: 100%;
  height: 100%;
  z-index: -1;
  position:fixed;
  top: 0px;
  left: 0px;
}
</style>