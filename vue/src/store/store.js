import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);

export const store = new Vuex.Store({
    state: {
      usernow:'',
      barindex: '1',
      avartar: '',
      blognow:'',
      userinfo: '',
      viewtype: '1', //表示显示的分类
      editing: true //是否在发帖页面
    },
    mutations: {
        setUser(state,userinfo){
          state.userinfo = userinfo
        },
        changeuser(state,username){
            state.usernow=username;
        },
        changebarindex(state,index){
          state.barindex=index;
        },
        changeviewtype(state,viewtype){
          state.viewtype=viewtype;
        },
        setedit(state,editing){
          state.editing=editing
        },
        setAvartar(state,avartar){
          state.avartar=avartar
        },
        setAvatar(state,avatar){
          state.userinfo.avatar=avatar
        },
        quit(state){
          state.usernow=''
          state.barindex = '1'
          state.avartar = ''
          state.blognow = ''
          state.userinfo = ''
          state.viewtype = '1'
          state.editing = true
        },
        changeblognow(state,blognow){
          state.blognow=blognow
        },
    }
})
