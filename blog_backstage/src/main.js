<<<<<<< HEAD
import Vue from 'vue'
import './plugins/axios'
import App from './App.vue'
import router from './router'
import store from './store'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import "./assets/css/index.css";
import "./assets/css/iconfont.css";
import mavonEditor from 'mavon-editor'
import 'mavon-editor/dist/css/index.css'
import md5 from 'js-md5'

// 按需引入 引入 ECharts 主模块
var echarts = require('echarts/lib/echarts')
// 引入柱状图
require('echarts/lib/chart/bar')
require("echarts/lib/chart/pie")
// 引入提示框和标题组件
require('echarts/lib/component/tooltip')
require('echarts/lib/component/title')

Vue.use(ElementUI);
Vue.prototype.$echarts = echarts
Vue.config.productionTip = false
Vue.component("v-chart", echarts);
Vue.use(mavonEditor)
Vue.prototype.$md5=md5

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
=======
import Vue from 'vue'
import './plugins/axios'
import App from './App.vue'
import router from './router'
import store from './store'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import "./assets/css/index.css";
import "./assets/css/iconfont.css";
import mavonEditor from 'mavon-editor'
import 'mavon-editor/dist/css/index.css'
import md5 from 'js-md5'

// 按需引入 引入 ECharts 主模块
var echarts = require('echarts/lib/echarts')
// 引入柱状图
require('echarts/lib/chart/bar')
require("echarts/lib/chart/pie")
// 引入提示框和标题组件
require('echarts/lib/component/tooltip')
require('echarts/lib/component/title')

Vue.use(ElementUI);
Vue.prototype.$echarts = echarts
Vue.config.productionTip = false
Vue.component("v-chart", echarts);
Vue.use(mavonEditor)
Vue.prototype.$md5=md5

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
>>>>>>> 6904d88... first commit
