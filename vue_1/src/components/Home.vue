<template>
  <div>
  	<Navigate></Navigate>
    <div class="intro">
        <h1>WashBasin 脸盆网</h1>
        <h4>1111</h4>
    </div>
    <Posttable section="讨论区"></Posttable>
    <Posttable section="课程推荐"></Posttable>
    <Posttable section="刷题区"></Posttable>
    <Posttable section="校园周边"></Posttable>
    <footer>Copyright ©</footer>
    <postbutton></postbutton>
    <backtotop></backtotop>
  </div>
</template>

<script>
import Navigate from './Navigate'
import Posttable from './Posttable'
import postbutton from './postbutton'
import backtotop from './backtotop'

export default {
  name: 'Home',
  components:{
    'Navigate':Navigate,
    'Posttable':Posttable,
    'postbutton':postbutton,
    'backtotop':backtotop
  }
}
</script>

<style scoped>
    .intro{
        background: #ffffff;
        width: 70%;
        margin:20px 15%;
        border-top-left-radius: 10px;
        border-top-right-radius: 10px
    }
    .intro h1{
        padding:10px 30px;
        padding-bottom: 0px;
        margin-bottom: 0;
    }
    .intro h4{
         padding:13px 30px;
         padding-top:0px;
    }
    footer {
        height: 75px;
        margin-top: 30px;
        background: #487eb0;
        text-align: center;
        padding-top: 40px;
        color:#505050
    }

</style>
