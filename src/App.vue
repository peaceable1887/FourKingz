<template>
  <router-view v-slot="{Component, route}">
    <transition name="fade" mode="out-in">
      <div :key="route.name">
        <component :is="Component"></component>
      </div>
    </transition>
  </router-view>
  <BackgroundAnimation></BackgroundAnimation>
</template>

<script>
//Import required components
import BackgroundAnimation from "./components/BackgroundAnimation.vue";

export default 
{
  name: 'App',
  components:
  {
      BackgroundAnimation,
  },
  mounted()
  {
    if(window.safari) 
    {
      history.pushState(null, null, location.href);
      window.onpopstate = function() 
      {
        history.go(1);
      };
    }
  },
}
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Lilita+One&family=Roboto:wght@100&family=Rubik&display=swap');

:root
{
  --color-main: #ed9623;
  --color-second: #222847;
  --font-main: 'Lilita One', cursive;
}

html,
body 
{
  overscroll-behavior-x: none;
  background: -o-linear-gradient(45deg, #a1371d, #ed9623);
  background: linear-gradient(45deg, #ed4b23, #ed9623);
  /*https://codepen.io/Momika/pen/ydaWmQ*/
  background-repeat: no-repeat;
  font-family: var(--font-main);
  overflow: hidden;
  height: 100vh;
}
.fade-enter-from,
.fade-leave-to{
  opacity: 0;
}

.fade-enter-active,
.fade-leave-active{
  transition: opacity 0.5s ease-out;
}

</style>
