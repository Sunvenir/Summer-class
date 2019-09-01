<template>
  <div>
    <div id="background"></div>
      <barAndBG active-index="activeIndex"></barAndBG>
    <div style="width:800px;margin:0 auto" @click="clickdiv">
    <div v-if="this.$store.state.editing" style="width:800px;background: royalblue">
      <div style="height:60px;background: white;font-size:20px;line-height: 60px">
        <p><div style="height:50px;float:left;margin-left:30px">标题:</div><input v-model = "title" class="title"></input></p>
      </div>
      <div style="width:780px;background:white;padding:10px;">
        <textarea style="height:110px;width:760px;resize: none;" v-model = "content">
        </textarea>
      </div>
      <div style="height:60px;background:white;margin:0 auto;padding-bottom: 10px">
              <div style="height:50px; width:120px;font-size: 20px;float:left;line-height: 50px;color:red"><i class=el-icon-lollipop></i>表情</div>
              <el-popover
                placement="bottom"
                title="标题"
                width="200"
                trigger="click"
                >
                <el-upload
                      action="https://jsonplaceholder.typicode.com/posts/"
                      :http-request='uploadImage'
                      :multiple = 'true'
                      list-type="picture-card"
                      :on-preview="handlePictureCardPreview"
                      :on-remove="handleRemove">
                      <i class="el-icon-plus"></i>
                    </el-upload>
                    <el-dialog :visible.sync="dialogVisible">
                      <img width="100%" :src="dialogImageUrl" alt="">
                    </el-dialog>

                <el-button slot="reference" type="primary" plain style="height:50px; width:120px;font-size: 20px;float: left;color:springgreen"><i class=el-icon-ice-cream-square></i>图片</el-button>
              </el-popover>
              <div style="height:50px; width:120px;font-size: 20px;float: left;line-height: 50px;color:steelblue"><i class=el-icon-ice-cream-round></i>话题</div>
              <template>
                  <el-select size=medium style="height:50px; width:120px;font-size: 20px;float: left;line-height: 50px;color:steelblue" v-model="stype" placeholder="分区">
                    <el-option style="height:50px; width:120px;font-size: 20px;float: left;line-height: 50px;color:steelblue"
                      v-for="item in options"
                      :key="item.value"
                      :label="item.label"
                      :value="item.value">
                    </el-option>
                  </el-select>
                </template>
              <el-button type="primary" plain style="height:50px;margin:0 auto; width:120px;font-size: 20px;float:right" @click="submitBlog">发布</el-button>
      </div>
    </div>
    <div style="height:50px;margin-top:20px" >
        <el-menu :default-active="this.$store.state.viewtype" class="el-menu-demo" mode="horizontal" background-color=steelblue text-color="#fff" active-text-color="#ffd04b">
        <el-menu-item index="1" style="font-size:20px" @click="changetype('1')">课程推荐</el-menu-item>
        <el-menu-item index="2" style="font-size:20px" @click="changetype('2')">刷题</el-menu-item>
        <el-menu-item index="3" style="font-size:20px" @click="changetype('3')">校园周边</el-menu-item>
        <el-menu-item index="4" style="font-size:20px" @click="changetype('4')">讨论区</el-menu-item>
        </el-menu>
    </div>
    <div style="margin-bottom: 100px;">
        <div @click="trigger(count)"
        style="cursor:pointer;background:rgba(0, 132, 255, 0.39);width:800px;margin-top: 20px" v-for = "count in showBlog.length">
            <div style="width:80px;background: blue;float: left;">
                <div  style="width: 80px">
                  <div style="width: 74px; height:74px;border-radius: 50%; border: 3px solid #eee; overflow: hidden;">
                      <img :src="showBlog[count-1].post_owner.avatar" width="80" height="80">
                  </div>
                </div>
              </div>
              <div style="width:720px;margin-left:0px;float: left;">
                <div style="height:40px;font-size: 20px;text-align:left;line-height:40px;background: rgba(0, 132, 255, 0.39)">
                  {{showBlog[count-1].post_owner.name+"     "}}{{showBlog[count-1].date}}
                </div>
              <div style="height:40px;font-size: 20px;text-align:left;line-height:40px;background: rgba(0, 255, 85, 0.39)">
                  {{showBlog[count-1].title}}
               </div>
                <div style="font-size: 20px;text-align:left;line-height:40px;color: white;height:120px;overflow:hidden">
                  {{showBlog[count-1].detail}}
                </div>
              </div>
              <div>
                <el-button-group>
                  <el-button type="primary" plain style="height:50px; width:400px;font-size: 20px;opacity:0;" ></el-button>
              </el-button-group>
              </div>
        </div>
        <el-footer class = "el-footer">
               <div style="left:30%" class="p-switch" @click="toLast"><<上一页</div>
               <div style="left:45%" class="p-switch" @click="toTop">首页({{this.page}}/{{this.pageCount}})</div>
               <div style="left:60%" class="p-switch" @click="toNext">下一页>></div>
        </el-footer>
      </div>
    </div>
  </div>
</template>

<style scoped>
  .title{
    margin:15px;
    float: left;
    height: 25px;
    width: 300px;
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
  .el-footer {
        width: 800px;
        background-color: rgb(255, 255, 255);
        color: rgb(0, 0, 0);
        text-align: center;
      }
</style>

<script>
  import barAndBG from './barAndBG'
  export default {
    components:{barAndBG},
    mounted:
    function(){
      if(this.$store.state.userinfo.name == ''){
        this.$router.replace({path: '/'});
      }
      var time = new Date()
      console.log(time.toLocaleDateString()+' '+time.toTimeString())
      var typenow
        if(this.$store.state.viewtype == '1'){
          typenow = '推荐区'
        }
        else if(this.$store.state.viewtype == '2'){
          typenow = '刷题区'
        }
        else if(this.$store.state.viewtype == '3'){
          typenow = '校园周边'
        }
        else if(this.$store.state.viewtype == '4'){
          typenow = '讨论区'
        }
      this.$axios.post('/getTypeBlog',{
        username:this.$store.state.usernow,
        type:typenow,
        step:this.step,
        page:1
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
    name:'Blog',
    data(){
      return {
        options: [{
          value: '推荐区',
          label: '推荐区'
        }, {
          value: '刷题区',
          label: '刷题区'
        }, {
          value: '校园周边',
          label: '校园周边'
        },{
          value: '讨论区',
          label: '讨论区'
        }],
        stype: '',
        images: [],
        date: '',
        content: '',
        visible: false,
        dialogImageUrl: '',
        dialogVisible: false,
        title: '',
        showBlog: [],
        step: 5,
        page: 1,
        pageCount: 1,
        nameList:['image1','image2','image3','image4','image5','image6','image7','image8','image9']
      };
    },
    computed:{
            usernow(){
                return this.$store.state.usernow;
            }
    },
    methods: {
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
        },
            handleAvatarSuccess(res, file) {
                this.imageUrl = URL.createObjectURL(file.raw);
            },
            beforeAvatarUpload(file) {
                const isJPG = file.type === 'image/jpeg' || file.type === 'image/jpg' || file.type === 'image/png';
                const isLt2M = file.size / 1024 / 1024 < 2;

                if (!isJPG) {
                this.$message.error('上传头像图片仅支持JPG,PNG 格式!');
                }
                if (!isLt2M) {
                this.$message.error('上传头像图片大小不能超过 2MB!');
                }
                return isJPG && isLt2M;
            },
            uploadImage(param){
                let form = new FormData()
                let Image = param.file;
                this.images.push(Image);
            },
    change(val) {
      console.log(val)
      },
      handleRemove(file, fileList) {
        for(var i=0;i<this.images.length;i++){
          if(this.images[i].name == file.name){
            var index = i
            this.images.splice(i,1)
          }
        }
        
      },
      handlePictureCardPreview(file) {
        this.dialogImageUrl = file.url;
        this.dialogVisible = true;
      },
      clickdiv(){
        console.log(this.$store.state.editing)
      },
      submitBlog(){
        if(this.title == ''){
          this.$message({
           message:'请输入标题',
           type: 'warning'
         })
        }
        else if(this.content == ''){
          this.$message({
           message:'发布内容不能为空',
           type: 'warning'
         })
        }
        else if(this.stype == ''){
          this.$message({
           message:'请选择一个分区',
           type: 'warning'
         })
        }
        else {
          var images = new FormData()
          for(var i=0;i<9;i++){
            if(i<this.images.length){
              images.append(this.nameList[i],this.images[i])
            }
            else{
              images.append(this.nameList[i],null)
            }
          }
          images.append("username",this.$store.state.usernow)
          images.append("title",this.title)
          images.append("type",this.stype)
          images.append("content",this.content)
          var time = new Date()
          images.append("date",time)
          var _this = this
          setTimeout(function(){
            for(var i=0;i<9;i++){
              console.log(images.get(_this.nameList[i]))
            }
            _this.$axios.post('/blog',images,{
            headers: {'Content-Type': 'multipart/form-data'}
          })
          .then(successResponse=>{
           if(successResponse.data.code===200){
            _this.$message({
              message:'发布成功！',
              type: 'success'
            })
               _this.$router.replace({path: '/'})
           }
           else if(successResponse.data.code===300){
             _this.$message({
                message:'您已发送过这篇文章了，请重新起一个标题吧！',
                type: 'warning'
              })
           }
           else{
             _this.$message({
                message:'发生未知错误，修改失败',
                type: 'error'
              })
           }
         })
         .catch(failResponse=>{
              _this.$message({
                message:'catch error!',
                type: 'error'
              })
         })
          }, 1000);
          
        }
      },
       changetype(typenow){
        this.$store.commit('changeviewtype',typenow)
          if(this.$store.state.viewtype == '1'){
            typenow = '推荐区'
          }
          else if(this.$store.state.viewtype == '2'){
            typenow = '刷题区'
          }
          else if(this.$store.state.viewtype == '3'){
            typenow = '校园周边'
          }
          else if(this.$store.state.viewtype == '4'){
            typenow = '讨论区'
          }
        this.$axios.post('/getTypeBlog',{
          username:this.$store.state.usernow,
          type:typenow,
          step:this.step,
          page:1
        })
        .then(successResponse=>{
          if(successResponse.data.code===200){
            console.log(successResponse.data);
            this.pageCount = successResponse.data.pagenum
            this.showBlog = successResponse.data.list
            this.page = 1
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
      toLast(){
        if(this.page == 1){
          this.$message({
            message: '当前已经是第一页',
            type: 'warning'
          })
        }
        else{
          this.page = this.page - 1
          var typenow
            if(this.$store.state.viewtype == '1'){
              typenow = '推荐区'
            }
            else if(this.$store.state.viewtype == '2'){
              typenow = '刷题区'
            }
            else if(this.$store.state.viewtype == '3'){
              typenow = '校园周边'
            }
            else if(this.$store.state.viewtype == '4'){
              typenow = '讨论区'
            }
          this.$axios.post('/getTypeBlog',{
            username:this.$store.state.usernow,
            type:typenow,
            step:this.step,
            page:this.page
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
        this.page = this.page + 1
        if(this.page > this.pageCount){
          this.$message({
            message: '当前已经是最后一页',
            type: 'warning'
          })
          this.page = this.page-1;
        }
        else{
          var typenow
            if(this.$store.state.viewtype == '1'){
              typenow = '推荐区'
            }
            else if(this.$store.state.viewtype == '2'){
              typenow = '刷题区'
            }
            else if(this.$store.state.viewtype == '3'){
              typenow = '校园周边'
            }
            else if(this.$store.state.viewtype == '4'){
              typenow = '讨论区'
            }
          this.$axios.post('/getTypeBlog',{
            username:this.$store.state.usernow,
            type:typenow,
            step:this.step,
            page:this.page
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
        var typenow
            if(this.$store.state.viewtype == '1'){
              typenow = '推荐区'
            }
            else if(this.$store.state.viewtype == '2'){
              typenow = '刷题区'
            }
            else if(this.$store.state.viewtype == '3'){
              typenow = '校园周边'
            }
            else if(this.$store.state.viewtype == '4'){
              typenow = '讨论区'
            }
          this.$axios.post('/getTypeBlog',{
            username:this.$store.state.usernow,
            type:typenow,
            step:this.step,
            page:1
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
    },
    toDetail(){
      this.$router.push('/Page')
    }
  }

</script>
