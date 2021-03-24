import Vue from 'vue'
import './plugins/axios'
import App from './App.vue'
import router from './router'
import store from './store'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import 'animate.css/animate.min.css'
import VueParticles from 'vue-particles'
import GeminiScrollbar from 'vue-gemini-scrollbar'
import './assets/icon/iconfont.css'

Vue.use(GeminiScrollbar)
Vue.use(VueParticles)

router.beforeEach((to, from, next) => {
  /* 路由发生变化修改页面title */
  if (to.meta.title) {
    document.title = to.meta.title
  }
  next()
})

Vue.use(ElementUI)
Vue.config.productionTip = false


new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
