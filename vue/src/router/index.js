import Vue from 'vue'
import Router from 'vue-router'
import register from "@/components/register"
import login from "@/components/login"
import editor from "@/components/editor"
import personal from "@/components/personal"
import Blog from "@/components/Blog"
import Person from "@/components/Person"
import mainPage from "@/components/mainPage"
import Page from "@/components/Page"
import rookie from "@/components/rookie"
import management from "@/components/management"

Vue.use(Router)

export default new Router({
    routes:[
      {
        path:'/',
        name:'mainPage',
        component:mainPage
      },
      {
        path:'/personal',
        name:'personal',
        component:personal
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
      },
      {
        path:"/editor",
        name:"editor",
        component:editor
      },
      {
        path:"/Blog",
        name:"Blog",
        component:Blog
      },
      {
        path:"/Person",
        name:"Person",
        component:Person
      },
      {
        path:"/Page",
        name:"Page",
        component:Page
      },
      {
        path:"/rookie",
        name:"rookie",
        component:rookie
      },
      {
        path:"/management",
        name:"management",
        component:management
      }
    ]
})
