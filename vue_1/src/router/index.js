import Vue from 'vue'
import Router from 'vue-router'
import Home from "@/components/Home"
import SignUp from "@/components/SignUp"
import PostPage from "@/components/PostPage"
import postcontent from "@/components/postcontent"
import homepage from "@/components/Homepage"
import register from "@/components/register"
import login from "@/components/login"
import barAndBG from "@/components/barAndBG"

Vue.use(Router)

export default new Router({
    routes:[
        {
            path:"/",
            name:'barAndBG',
            component:barAndBG,
        },
        {
            path:"/SignUp",
            name:"SignUp",
            component:SignUp
        },
        {
            path:"/PostPage",
            name:"PostPage",
            component:PostPage
        },
        {
            path:"/postcontent",
            name:"postcontent",
            component:postcontent
        },
        {
            path:"/homepage",
            name:"Homepage",
            component:homepage
        },
        {
          path:"/login",
          name:"login",
          component:login
        },
        {
          path:"/register",
          name:"register",
          component:register
        }
    ]
})
