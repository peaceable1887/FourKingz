<template>
    <div id="overlay" @click="off()">
        <div id="text">
            <div class="msg">
                <span class="text">{{text}}</span>
                <div class="btnWrapper">
                    <router-link to="/">
                        <Button @click="$emit('backToMain')">{{ btnOneText }}</Button>
                    </router-link>
                    <a href="/game">
                        <Button >{{ btnTwoText }}</Button>
                    </a>
                </div>
            </div>
        </div>
    </div>
    <div>
        <h2>Overlay with Text</h2>
        <button @click="on()">Turn on overlay effect</button>
    </div>
</template>

<script>
    import Button from "../components/Button.vue";
    export default 
    {
        name: "itmem-overlay",
        emits: ['backToMain', "overlayOff", "overlayOn"],
        components:
        {
            Button,
        },
        props:
        {
            text: String,
            btnOneText: String,
            btnTwoText: String,
        },
        methods:
        {
            on() 
            {
                document.getElementById("overlay").style.display = "block";
            },
            off() 
            {
                document.getElementById("overlay").style.display = "none";
            }
        }
    }
</script>

<style lang="scss" scoped>
#overlay {
  position: fixed;
  display: none;
  width: 100%;
  height: 100%;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background-color: rgba(0,0,0,0.5);
  z-index: 2;
  cursor: pointer;
}
#text{
  position: absolute;
  top: 50%;
  left: 50%;
  font-size: 50px;
  color: white;
  transform: translate(-50%,-50%);
  -ms-transform: translate(-50%,-50%);
}
.msg
{
    display: flex;
    justify-content: center;
    flex-direction: column;
    position: fixed;
    text-align: center;
    top: 70px;
    font-size: 20px;
    color:#441d1d;
    background-color: white;
}
.msg img 
{
    height: 50px;
    width: 50px;
    margin: auto;
}
.msg span
{
    margin-top: 10px;
}
.msg .btnWrapper
{
    display: flex;
    justify-content: center;
    margin-top: 10px;
}
.msg .btnWrapper Button
{
    width: 150px;
    padding: 5px;
    margin: 10px 5px;
    border-radius: 10px;
    font-size: 18px;
    background-color: #441d1d;
    color: #ccc661;
}
</style>