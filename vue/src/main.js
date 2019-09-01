// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import {store} from './store/store.js'
import ElementUI from 'element-ui'

import 'element-ui/lib/theme-chalk/index.css'

Vue.config.productionTip = false
var axios = require('axios')
axios.defaults.baseURL = 'http://localhost:8666/api'
Vue.prototype.$axios=axios
Vue.use(ElementUI)

Vue.filter('dateFormatter',function(datestr){
  //过滤器的方法
  if(datestr=="")return;
  var dt=new Date(datestr);
  var y=dt.getFullYear();
  var m=dt.getMonth()+1;//返回值从0-11所以要加1
  var d=dt.getDate();
  return y+'-'+m+'-'+d;
})


/* eslint-disable no-new */
new Vue({
  el: '#app',
  store,
  router,
    components: { App },
        template: '<App/>'
})
