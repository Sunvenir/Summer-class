<template>
  <div >
  	 <div class="searcharea">
        <form action="">
            <input type="text" placeholder="输入搜索内容 " size="30" class="searchinput">
            <input type="submit" value="搜索" class="searchbutton">
        </form>
    </div>
</div>
</template>

<script>


export default {
  name: 'SearchArea',
}
</script>

<style>
    .searcharea{
        text-align: right;
        padding: 8px;
        background-color: #40739e;
        margin: 0px
    }

    .searchinput{
        border-radius: 44px;
        border-style: none;
        text-align: right;
        font-size: 15px;
        height: 25px;
    }
    .searchbutton{
        border-radius: 44px;
        border-style: none;
        font-size: 15px;
        height: 30px;
        width: 80px;
        color: #fff;
        background-color: #0fb9b1;
        transition-duration: 200ms;
    }

    .searchbutton:hover{
        background-color: #20bf6b
    }

</style>
