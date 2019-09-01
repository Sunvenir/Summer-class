<template>

  <div id="barAndBG">
    <el-menu :default-active="this.$store.state.barindex" class="el-menu-demo" mode="horizontal" @select="handleSelect" background-color="#545c64"
      text-color="#fff"
      active-text-color="#ffd04b">
  <el-menu-item index="1" @click="gotoByUrl('/','1')">首页</el-menu-item>
  <el-menu-item index="2" @click="gotoByUrl('/personal','2')">我的空间</el-menu-item>
  <el-submenu index="3">
    <template slot="title">发现</template>
    <el-menu-item index="3-1" @click="choose('1')">推荐区</el-menu-item>
    <el-menu-item index="3-2" @click="choose('2')">刷题区</el-menu-item>
    <el-menu-item index="3-3" @click="choose('3')">校园周边</el-menu-item>
    <el-menu-item index="3-4" @click="choose('4')">讨论区</el-menu-item>
  </el-submenu>
  <el-menu-item index="4" @click="gotoByUrl('/Blog','4')">写博客</el-menu-item>
  <el-menu-item index="8" @click="gotoByUrl('/management','8')" v-if = "this.$store.state.usernow == 'sun'">管理用户</el-menu-item>
  <el-menu-item index="9" @click="gotoByUrl('/rookie','9')" v-if = "this.$store.state.usernow == 'sun'">新手上路</el-menu-item>
  <router-link to="/login"><el-menu-item index="5" id="login" v-if="this.$store.state.usernow == ''">登录</el-menu-item></router-link>
  <el-menu-item index="7" id="login" v-if="!(this.$store.state.usernow == '')" @click="quit()">注销</el-menu-item>
  <el-menu-item index="6" id="login" v-if="!(this.$store.state.usernow == '')" @click="clickName()">hello,{{this.$store.state.usernow}}</el-menu-item>
</el-menu>

  </div>
</template>

<script>
export default {
  name: 'barAndBG',
  data () {
    return {
      msg: 'Welcome to Your Vue.js App',
      activeIndex: this.$store.state.barindex
    }
  },
    computed:{
      barindex(){
          return this.$store.state.barindex;
      },

  },
  methods: {
    gotoByUrl(url,index){
      if(this.$store.state.usernow == "" && index != '1'){
        this.$message({
              message:'请先登录',
              type: 'error'
            })
      }
      else{
        this.$router.push(url)
        this.$store.commit('changebarindex',index);
        if(index == 4){
          this.$store.commit('setedit',true);
        }
      }
    },
    clickName(){
      if(this.activeIndex != '2'){
          this.$router.push('/personal')
          this.$store.commit('changebarindex','2');
      }
    },
    choose(viewtype){
        this.$router.push('/Blog');
        this.$store.commit('changebarindex','3');
        this.$store.commit('setedit',false);
        this.$store.commit('changeviewtype',viewtype);
        this.$parent.changetype(viewtype)
    },
      handleSelect(key, keyPath) {
          console.log(key, keyPath);
      },
      quit(){
        this.$store.commit('quit');
        this.$router.replace('/')
      }
    },
}
</script>

<style>
#login{
  float: right;
}

a {
  text-decoration: none;
}
</style>
