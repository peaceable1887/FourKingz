<template>
  <router-view></router-view>
</template>

<script>


export default 
{
  name: 'App',
}
</script>

<style>
html,
body 
{
  position: relative;
  height: 100%;
  width: 100%;
  min-height: 100vh;
  font-family: Impact, Regular;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
}
#app 
{
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
}
</style>
