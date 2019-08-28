<template>
  <div id="barAndBG">
    <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect" background-color="#545c64"
      text-color="#fff"
      active-text-color="#ffd04b">
  <el-menu-item index="1" @click="gotoByUrl('/')">首页</el-menu-item>
  <el-menu-item index="2" @click="gotoByUrl('/')">我的空间</el-menu-item>
  <el-submenu index="3">
    <template slot="title">发现</template>
    <el-menu-item index="3-1">最新内容</el-menu-item>
    <el-menu-item index="3-2">生活</el-menu-item>
    <el-menu-item index="3-3">学习</el-menu-item>
  </el-submenu>
  <el-menu-item index="4" @click="gotoByUrl('/editor')">写博客</el-menu-item>
  <router-link to="/login"><el-menu-item index="5" id="avartar">登录</el-menu-item></router-link>
</el-menu>
   
  </div>
</template>

<script>
export default {
  name: 'barAndBG',
  data () {
    return {
      msg: 'Welcome to Your Vue.js App',
      activeIndex: '1'
    }
  },
  methods: {
    gotoByUrl(url){
      this.$router.push(url)
    },
      handleSelect(key, keyPath) {
        console.log(key, keyPath);
      }
    }
}
</script>

<style>
#avartar{
  float: right;
}
body {
  font-family: Helvetica, sans-serif;
  background:url("../assets/images/background.jpg") no-repeat;
  background-size:cover;
  background-attachment:fixed;
  margin: 0 auto;
  text-align: center;
}
a {
  text-decoration: none;
}
</style>
