import Vue from 'https://cdn.jsdelivr.net/npm/vue@2.6.11/dist/vue.esm.browser.js'
import Vuex from 'https://cdn.jsdelivr.net/npm/vuex@3.1.2/dist/vuex.esm.browser.js'
Vue.use(Vuex)

export const store = new Vuex.Store({
  state: {
    currentUser: null,
    currentChannel: null
  },
  mutations: {
    setCurrentUser(state, user) {
      state.currentUser = user
    },
    setCurrentChannel(state, channel) {
      state.currentChannel = channel
    },
    //remove?
    getCurrentUser(state) {
      return state.currentUser
    }
  },
  actions: {

  }
})