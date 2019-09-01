<template>
<el-aside width="150px">
    <el-menu background-color="#545c64" text-color="#fff" active-text-color="#ffd04b">
    <el-menu-item index="1"><i class="el-icon-user-solid"></i>个人信息</el-menu-item>
    
        <el-menu-item index="2"><i class="el-icon-picture"></i>头像</el-menu-item>
   
    <el-menu-item index="3"><i class="el-icon-edit-outline"></i>我的发帖</el-menu-item>
    <el-menu-item index="4"><i class="el-icon-search"></i>我的关注</el-menu-item>
        
    </el-menu>
</el-aside>
</template>

<script>
    export default {
        name: 'sideBar'
    }
</script>