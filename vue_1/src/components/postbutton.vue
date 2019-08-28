<template>
    <div class="postbutton">
        <router-link to="/PostPage"><button>发帖</button></router-link>
    </div>
</template>

<script>
export default {
    name:"postbutton",
}
</script>


<style scoped>
    .postbutton{
        position: fixed;
        top:24%;
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

