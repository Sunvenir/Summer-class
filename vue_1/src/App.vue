<template>
  <div id="app">
  	<router-view></router-view>
  </div>
</template>

<script>


export default {
  name: 'App',
}
</script>

<style>
  body {
    font-family: Helvetica, sans-serif;
    background:url("./assets/images/background.jpg") no-repeat;
    background-size:cover;
    background-attachment:fixed;
    margin: 0 auto;
    text-align: center;
  }
  a {
    text-decoration: none;
  }
</style>
