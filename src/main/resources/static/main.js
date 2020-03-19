import Vue from 'https://cdn.jsdelivr.net/npm/vue@2.6.11/dist/vue.esm.browser.js'
import { store } from './store.js'
import { router } from './router.js'
import app from './app.js'

new Vue({
  store,
  router,
  render: h => h(app)
}).$mount('#app');