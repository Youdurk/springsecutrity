import { createRouter, createWebHistory } from 'vue-router'


const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: ()=>import('../views/WelcomeView.vue'),
      children:[
        {  path: '',
        name: 'login',
        component: ()=>import('../components/login/login.vue')},
        {
          path: '/register',
        name: 'register',
        component: ()=>import('../components/login/register.vue')},
      ]
    },{
      path: '/index',
      name: 'index',
      component: ()=>import('../views/index.vue'),
    }
  ]
})

export default router
