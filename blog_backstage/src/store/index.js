<<<<<<< HEAD
import Vue from "vue";
import Vuex from "vuex";
import createPersistedState from "vuex-persistedstate";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    collapse: false,
    avatar: null
  },
  mutations: {
    trigger(state) {
      state.collapse = !state.collapse;
    }
  },
  actions: {},
  modules: {},
  plugins: [
    createPersistedState({
      storage: window.sessionStorage
    })
  ]
});
=======
import Vue from "vue";
import Vuex from "vuex";
import createPersistedState from "vuex-persistedstate";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    collapse: false,
    avatar: null
  },
  mutations: {
    trigger(state) {
      state.collapse = !state.collapse;
    }
  },
  actions: {},
  modules: {},
  plugins: [
    createPersistedState({
      storage: window.sessionStorage
    })
  ]
});
>>>>>>> 6904d88... first commit
