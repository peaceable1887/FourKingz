<template>
  <router-view v-slot="{Component, route}">
    <transition name="fade" mode="out-in">
      <div :key="route.name">
        <component :is="Component"></component>
      </div>
    </transition>
  </router-view>
</template>

<script>
//Import required components


export default 
{
  name: 'App',
  components:
  {
      
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
    window.addEventListener('load', this.clearStorage())

    localStorage.setItem("sound", false)
  },
  methods:
  {
    clearStorage() 
        {
          let session = sessionStorage.getItem('animation');

          if(session == null) 
          {
              localStorage.removeItem('animation')
          }
          sessionStorage.setItem('animation', 1)
        }
  }
}
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Lilita+One&family=Roboto:wght@100&family=Rubik&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Lilita+One&family=Luckiest+Guy&family=Roboto:wght@100&family=Rubik&display=swap');
:root
{
  --color-main: #ed9623;
  --color-second: #222847;
  --font-main: 'Lilita One', cursive;
  --font-logo: 'Luckiest Guy', cursive;
}

html,
body 
{
  overscroll-behavior-x: none;
  background: -o-linear-gradient(45deg, #a1371d, #ed9623);
  background: -o-linear-gradient(45deg, #ed4b23, #ed9623);
  background: linear-gradient(45deg, #ed4b23, #ed9623);
  /*https://codepen.io/Momika/pen/ydaWmQ*/
  background-repeat: no-repeat;
  font-family: var(--font-main);
  overflow: hidden;
  height: 100vh;
  position: relative;
  
}
.fade-enter-from,
.fade-leave-to
{
  opacity: 0;
}

.fade-enter-active,
.fade-leave-active
{
  -webkit-transition: opacity 0.5s ease-out;
  -o-transition: opacity 0.5s ease-out;
  transition: opacity 0.5s ease-out;
}

</style>
