<template>
  <router-view></router-view>
</template>

<script>


export default 
{
  name: 'App',
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
  }
}
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Lilita+One&family=Roboto:wght@100&family=Rubik&display=swap');
html,
body 
{
  overscroll-behavior-x: none;
  background: -o-linear-gradient(45deg, #a1371d, #ed9623);
  background: linear-gradient(45deg, #ed4b23, #ed9623);
  background-repeat: no-repeat;
  font-family: 'Lilita One', cursive;
  overflow: hidden;
  height: 100vh;
}


</style>
