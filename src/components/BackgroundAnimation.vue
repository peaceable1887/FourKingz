<!--   
    Version: 3.2.41
    Auhtor: Felix Hansmann
    
    Die Komponente "BackgroundAnimation.vue" stellt den animierten Hintergrund zur Verfügung.
-->
<template>
      <section class="sticky">
        <div class="bubbles">
            <div class="bubble"></div>
            <div class="bubble"></div>
            <div class="bubble"></div>
            <div class="bubble"></div>
            <div class="bubble"></div>
            <div class="bubble"></div>
            <div class="bubble"></div>
            <div class="bubble"></div>
            <div class="bubble"></div>
            <div class="bubble"></div>
        </div>
    </section>
</template>

<script>
    export default 
    {
        name: "item-backgroundAnimation"
    }
</script>

<style lang="scss" scoped>
.bubbles
{
  position:absolute;
  width:100%;
  height: 100%;
  overflow:hidden;
  top:0;
  left:0;
}
.bubble
{
  position: absolute;
  bottom:-100px;
  width:40px;
  height: 40px;
  background:#f1f1f1;
  border-radius:50%;
  opacity:0.5;
  -webkit-animation: rise 10s infinite ease-in;
          animation: rise 10s infinite ease-in;
}
.bubble:nth-child(1)
{
  width:40px;
  height:40px;
  left:10%;
  -webkit-animation-duration:8s;
          animation-duration:8s;
}
.bubble:nth-child(2)
{
  width:20px;
  height:20px;
  left:20%;
  -webkit-animation-duration:5s;
          animation-duration:5s;
  -webkit-animation-delay:1s;
          animation-delay:1s;
}
.bubble:nth-child(3)
{
  width:50px;
  height:50px;
  left:35%;
  -webkit-animation-duration:7s;
          animation-duration:7s;
  -webkit-animation-delay:2s;
          animation-delay:2s;
}
.bubble:nth-child(4)
{
  width:80px;
  height:80px;
  left:50%;
  -webkit-animation-duration:11s;
          animation-duration:11s;
  -webkit-animation-delay:0s;
          animation-delay:0s;
}
.bubble:nth-child(5)
{
  width:35px;
  height:35px;
  left:55%;
  -webkit-animation-duration:6s;
          animation-duration:6s;
  -webkit-animation-delay:1s;
          animation-delay:1s;
}
.bubble:nth-child(6)
{
  width:45px;
  height:45px;
  left:65%;
  -webkit-animation-duration:8s;
          animation-duration:8s;
  -webkit-animation-delay:3s;
          animation-delay:3s;
}
.bubble:nth-child(7)
{
  width:90px;
  height:90px;
  left:70%;
  -webkit-animation-duration:12s;
          animation-duration:12s;
  -webkit-animation-delay:2s;
          animation-delay:2s;
}
.bubble:nth-child(8)
{
  width:25px;
  height:25px;
  left:80%;
  -webkit-animation-duration:6s;
          animation-duration:6s;
  -webkit-animation-delay:2s;
          animation-delay:2s;
}
.bubble:nth-child(9)
{
  width:15px;
  height:15px;
  left:70%;
  -webkit-animation-duration:5s;
          animation-duration:5s;
  -webkit-animation-delay:1s;
          animation-delay:1s;
}
.bubble:nth-child(10){
  width:90px;
  height:90px;
  left:25%;
  -webkit-animation-duration:10s;
          animation-duration:10s;
  -webkit-animation-delay:4s;
          animation-delay:4s;
}
@-webkit-keyframes rise{
  0%{
    bottom:-100px;
    -webkit-transform:translateX(0);
            transform:translateX(0);
  }
  50%{
    -webkit-transform:translate(100px);
            transform:translate(100px);
  }
  100%{
    bottom:1080px;
    -webkit-transform:translateX(-200px);
            transform:translateX(-200px);
  }
}
@keyframes rise{
  0%{
    bottom:-100px;
    -webkit-transform:translateX(0);
            transform:translateX(0);
  }
  50%{
    -webkit-transform:translate(100px);
            transform:translate(100px);
  }
  100%{
    bottom:1080px;
    -webkit-transform:translateX(-200px);
            transform:translateX(-200px);
  }
}
</style>