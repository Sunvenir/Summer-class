<template>
    <div class="postbutton">
        <button @click="totop">toTop</button>
    </div>
</template>

<script>
export default {
    name:"backtotop",
    methods:{
        totop(){
            scroll(0,0);
        }
    }
}
</script>


<style scoped>
    .postbutton{
        position: fixed;
        top:32%;
        left: 87%;
    }

    .postbutton button{
        border-style: none;
        background: white;
        width: 75px;
        height: 55px;
    }

    .postbutton button:hover{
        background: #0984e3;
        color:white
    }
</style>
