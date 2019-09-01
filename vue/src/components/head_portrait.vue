  <template>
    <div id = "head_portrait">
    <div>
    <!-- 如果想upload只能上传图片，可以加上 accept="image/jpeg,image/jpg,image/png" 这样只能选择图片 -->
    <el-upload class="avatar-uploader" 
    action="" 
    :http-request='uploadImage'
    :show-file-list="false"
    :on-success="handleAvatarSuccess"
    :before-upload="beforeAvatarUpload">
    <img v-if="imageUrl" :src="imageUrl" class="avatar">
    <i v-else class="el-icon-plus avatar-uploader-icon"></i>
    </el-upload>
    </div>   
    <div style=" margin-top: 30px">
        <h style="letter-spacing:5px;font-size:25px;font-family:楷体">您的靓照：</h>
        <br>
        <h style="letter-spacing:3px;font-size:20px;font-family:楷体">点击图片框上传或修改头像</h>
        <br>
        <h style="color:red;letter-spacing:2px;font-size: 15px;font-family: 楷体">仅支持上传JPG,PNG格式的文件,请注意上传文件格式</h>
    </div>
</div>
</template>
<script>
        export default {
          data() {
            return {
                param:'',
                imageUrl:''
            }
        },
        computed:{
            usernow(){
                return this.$store.state.usernow;
            }
        },
        mounted:
        function(){
            if(this.this.$store.state.userinfo.name == '')
                this.$router.replace({path: '/'});
            this.imageUrl=this.$store.state.userinfo.avatar;
        },
        methods:{
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
                let username=this.usernow;
                let Image = param.file;
                let formData = new FormData();
                formData.append("image", Image);
                formData.append("username",username);
                this.$axios.post('/uploadImage', formData,{ headers: {'Content-Type': 'multipart/form-data'} })
                .then(successResponse=>{
                    if(successResponse.data.code === 200)
                    {
                        console.log(successResponse.data);
                        this.$message({
                            message:'上传成功',
                            type: 'success'
                        })
                        this.imageUrl = successResponse.data.url
                    }
                    else{
                    this.$message({
                        message:'发生未知错误，上传失败',
                        type: 'error'
                    })
                    }
                })
                .catch(faleResponse=>{
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
#head_portrait{
    background-color: rgba(189,199,199,0.8);
    position: absolute;
    left: 250px;
    top: 110px;
    height:350px;
}
.avatar-uploader .el-upload {
    border: 1px dashed #0f163f;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
    margin-left: 50px;
    margin-top: 30px;
    color:black
    }
    .avatar-uploader .el-upload:hover {
    border-color: rgb(121, 184, 247);
    color:black
    }
    .avatar-uploader-icon {
    font-size: 28px;
    color: #ffffff;
    width: 150px;
    height: 150px;
    line-height: 150px;
    text-align: center;
    }
    .avatar {
    width: 150px;
    height: 150px;
    display: block;
    }
    body{
    background: rgb(187, 170, 170,0.5);
    background-size:cover;
    }
    .el-header {
    background-color: rgba(102, 94, 83, 0.801);
    color: #333;
    line-height: 60px;
    }

    .el-aside {
    color: #333;
    }
</style>