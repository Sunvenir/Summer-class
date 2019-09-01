<template>
    <div >
        <barAndBG active-index="activeIndex"></barAndBG>
        <div id="rookie">
            <textarea id="readme" v-model="content"></textarea>
            <el-button type="primary" id="button" @click="submit()">确认提交</el-button>
        </div>
    </div>
</template>

<script>
import barAndBG from './barAndBG'
    export default{
        components:{barAndBG},
        data:{
            content:''
        },
        mounted:
        function(){
            if(this.this.$store.state.userinfo.name == '')
            this.$router.replace({path: '/'});
        },
        methods:{
            submit(){
                this.$axios.post('/uploadrookie',{content:this.content})
                    .then(successResponse=>{
                    if(successResponse.data.code===200){
                        console.log(successResponse.data);
                        this.$message({
                            message:'上传成功！',
                            type: 'success'
                        })
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

<style>
#rookie{
      background:url("../assets/images/background.jpg") no-repeat;
    background-color: rgb(107,108,109);
  background-size:cover;
  width: 1920px;
  height: 1080px;
  z-index: -1;
  position:fixed;
  top: 0px;
  left: 0px;
}
#readme{
    position: absolute;
    background-color: rgb(231, 238, 245);
    top:200px;
    left:600px;
    width:500px;
    height:400px;
    opacity: 0.5;
    font-family: 楷体;
    font-size:20px;
}
#button{
    position: absolute;
    top:610px;
    left:1000px;
}
</style>