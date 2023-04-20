import { createRouter, createWebHistory } from 'vue-router'
import Menu from '../views/Menu.vue';
import Main from '../views/Game.vue';
import Settings from '../views/Settings.vue';

const routes = [
  {
    path: '/',
    name: 'Menu',
    component: Menu, 
  },
  {
    path: '/game',
    name: 'Game',
    component: Main, 
  },
  {
    path: '/settings',
    name: 'Settings',
    component: Settings, 
  },
]

const router = createRouter({history: createWebHistory(process.env.BASE_URL), routes,});

export default router;
