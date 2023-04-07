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
html,
body 
{
  overscroll-behavior-x: none;
  background: linear-gradient(45deg, #a8511e, #ed9623);
}

</style>
