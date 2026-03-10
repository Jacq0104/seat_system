import Vue from 'vue'
import Router from 'vue-router'
import Seat from '@/components/Seat'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Seat',
      component: Seat
    }
  ]
})
