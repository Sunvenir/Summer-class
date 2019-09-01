<template>
  <div >

          <el-container id="container">
            <el-header style="height:0px"></el-header>

            <el-container>
              <el-aside style="background: rgba(0, 132, 255, 0.39);width:360px">
                <div style="margin-top: 50px">
                    <el-avatar :size="100" src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png"></el-avatar>
                </div>
                <div style="height:60px;width:360px">
                    <el-button-group>
                        <el-button type="primary" plain style="height:60px; width:120px;font-size: 20px">关注 100</el-button>
                        <el-button type="primary" plain style="height:60px; width:120px;font-size: 20px">粉丝 100</el-button>
                        <el-button type="primary" plain style="height:60px; width:120px;font-size: 20px">帖子 100</el-button>
                    </el-button-group>
                </div>
                <div style="margin-top:20px;background: white">
                    <div style="font-size:20px;text-align: left;margin-left:20px; margin-right:10px;padding-top:10px;padding-bottom: 10px;border-bottom:rgb(190,190,190) 2px solid">姓名</div>
                    <div style="font-size:20px;text-align: left;margin-left:20px; margin-right:10px;padding-top:10px;padding-bottom: 10px;border-bottom:rgb(190,190,190) 2px solid">姓名</div>
                    <div style="font-size:20px;text-align: left;margin-left:20px; margin-right:10px;padding-top:10px;padding-bottom: 10px;border-bottom:rgb(190,190,190) 2px solid">姓名</div>
                    <div style="font-size:20px;text-align: left;margin-left:20px; margin-right:10px;padding-top:10px;padding-bottom: 10px;border-bottom:rgb(190,190,190) 2px solid">姓名</div>
                    <div style="font-size:20px;text-align: left;margin-left:20px; margin-right:10px;padding-top:10px;padding-bottom: 10px;border-bottom:rgb(190,190,190) 2px solid">姓名</div>
                    <div style="font-size:20px;text-align: left;margin-left:20px; margin-right:10px;padding-top:10px;padding-bottom: 10px;">姓名</div>
                </div>
              </el-aside>

              <el-main style="width:800px;margin-left:40px">
                  <div style="background:rgba(0, 132, 255, 0.39);width:800px">
                      <div style="width:80p;float: left;">
                          <div  style="width: 80px">
                            <div style="width: 74px; height:74px;border-radius: 50%; border: 3px solid #eee; overflow: hidden;">
                                <img src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png" width="80" height="80">
                            </div>
                          </div>
                        </div>
                        <div style="width:720px;margin-left:0px;float: left;">
                          <div style="height:40px;font-size: 20px;text-align:left;line-height:40px;background: rgba(0, 132, 255, 0.39)">
                            {{name}}{{time}}
                          </div>
                        <div   style="height:40px;font-size: 20px;text-align:left;line-height:40px;background: rgba(0, 255, 85, 0.39)" >
                            {{title}}
                         </div>
                          <div  style="font-size: 20px;text-align:left;line-height:40px;color: white">
                            {{content}}
                          </div>
                        </div>
                        <div>
                          <el-button-group>
                            <el-button type="primary" @click="trigger" plain style="height:50px; width:400px;font-size: 20px">评论{{comnum}}</el-button>
                            <el-button type="primary" plain style="height:50px; width:400px;font-size: 20px">点赞{{likenum}}</el-button>
                        </el-button-group>
                        </div>

                  </div>
                  <el-container v-if="showflag"  style="margin: 0;background:rgba(0, 132, 255, 0.39);width:800px;">
                      <el-header style="height:0px">
                      </el-header>
                    <el-container style="margin :0;width:800px;">
                      <el-aside style="width:80px;">
                          <div  style="width: 80px;">
                            <div style="width: 74px; height:74px;border-radius: 50%; border: 3px solid #eee; overflow: hidden;">
                                <img src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png" width="80" height="80">
                            </div>
                          </div>
                        </el-aside>
                        <el-main style="width:720px;margin-left: 0px;">
                            <div style="height:40px;font-size: 20px;text-align:left;line-height:40px;background: rgba(0, 132, 255, 0.39)">
                                {{name}}{{time}}
                              </div>
                          <div style="width:720px;font-size: 20px;text-align:left;line-height:40px;color: white">
                              {{content}}
                            </div>
                        </el-main>
                      </el-container>
                        <el-footer style="margin:0;padding:0;width:800px;height:50px;font-size: 20px;line-height:40px;">

                              <el-button  type="primary" plain style="height:50px; width:100px;font-size: 20px;float: right">赞</el-button>

                        </el-footer>
                        <el-header style="height:0px">
                          </el-header>
                        <el-container style="margin :0;width:800px;">
                          <el-aside style="width:80px;">
                              <div  style="width: 80px;">
                                <div style="width: 74px; height:74px;border-radius: 50%; border: 3px solid #eee; overflow: hidden;">
                                    <img src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png" width="80" height="80">
                                </div>
                              </div>
                            </el-aside>
                            <el-main style="width:720px;margin-left: 0px;">
                                <div style="height:40px;font-size: 20px;text-align:left;line-height:40px;background: rgba(0, 132, 255, 0.39)">
                                    {{name}}{{time}}
                                  </div>
                              <div style="width:720px;font-size: 20px;text-align:left;line-height:40px;color: white">
                                  {{content}}
                                </div>
                            </el-main>
                          </el-container>
                            <el-footer style="margin:0;padding:0;width:800px;height:50px;font-size: 20px;line-height:40px;">

                                  <el-button  type="primary" plain style="height:50px; width:100px;font-size: 20px;float: right">赞</el-button>

                            </el-footer>
                  </el-container>

              </el-main>
              </el-container>

             <el-footer>Footer</el-footer>
             </el-container>
    </div>
      </template>


<script scoped>
  export default {
    name:'Person',
    data(){
    return{
      name:"昵称",
      time:"时间",
      title:"标题",
      content:"《龙族V》的创作遇到了瓶颈，简单地说就是有几个人物我写歪了，完成西伯利亚的故事之后，我必须暂停一下来修订目前遇到的一些偏向。修订的幅度之大应该跟龙族III差不多，很繁重的工作，特此告知。我知道有些读者很希望有日常更新的陪伴，但请给我一点时间。",
      comnum:1,
      likenum:1,
      showflag:false
    }
 },
    methods: {
    change(val) {
      console.log(val)
    },
    trigger(){
      this.showflag = !this.showflag
    }
  }
 }
</script>
<style>
    .el-header, .el-footer {
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
            margin:0px;
          }

          .el-container:nth-child(1){
            margin:0 auto;
            margin-top:0px;
            margin-bottom:0px;
            height:300px;
          }

          .el-container:nth-child(2){
            margin:0 auto;
            margin-top:20px;
            margin-bottom:20px;
            width:1200px;
          }
          body{
          font-family: Helvetica, sans-serif;
          background-size:cover;
          background-attachment:fixed;
          margin: 0 auto;
          text-align: center;
}
</style>
