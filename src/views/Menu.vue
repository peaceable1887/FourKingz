<template>
    <img src="../assets/transparent_logo.png">
    <div class="btnWrapper">
        <router-link to="/game">
            <Button text="Spiel starten"></Button>
        </router-link>
        <router-link to="/settings">
            <Button text="Einstellungen"></Button>
        </router-link>
    </div>
    <div id="snackbar">Erfolgreich gespeichert</div>
</template>

<script>
import Button from "../components/Button.vue";

export default 
{
    name: "item-menu",
    components:
    {
        Button,
    },
    data()
    {
        return{
            snackbar: false,
        }
    },
    mounted()
    {
        if(JSON.parse(localStorage.getItem("snackbar")) === true)
        {
            localStorage.setItem("snackbar", this.snackbar) 
            this.sucMsg()
            
        }else
        {
            console.log("test")
        }
    },
    methods:
    {
        sucMsg()
        {
            let x = document.getElementById("snackbar");
            x.className = "show";
            setTimeout(function(){ x.className = x.className.replace("show", ""); }, 3000);
        },
    }
}
</script>

<style scoped>
.menu
{
    height: 100%;
    display: flex;
    justify-content: center;
    align-items: center;
    touch-action: none;
    flex-direction: column;
    margin: 10px;
}
img
{
    height: 200px;
    margin-bottom: 40px;
    top: 0;
}
.btnWrapper
{
    display: flex;
    flex-direction: column;
}
.btnWrapper Button
{
    margin: 20px 30px;
    width: 250px;
    padding: 12px 40px;
    font-size: 26px;
    border-radius: 10px;
}
@media screen and (orientation: landscape) 
{
    img
    {
        height: 150px;
        margin-bottom: 20px;
        top: 0;
    }
    .btnWrapper Button
    {
        margin: 10px 30px;
        width: 200px;
        padding: 8px 20px;
        font-size: 22px;
        border-radius: 10px;
    }
}
#snackbar 
{
    visibility: hidden;
    min-width: 250px;
    background-color: #441d1d;
    color: #ccc661;
    text-align: center;
    border-radius: 2px;
    padding: 16px;
    position: fixed;
    z-index: 1;
    margin-left: auto;
    margin-right: auto;
    bottom: 30px;
    font-size: 17px;
}
#snackbar.show {
  visibility: visible;
  -webkit-animation: fadein 0.5s, fadeout 0.5s 2.5s;
  animation: fadein 0.5s, fadeout 0.5s 2.5s;
}

@-webkit-keyframes fadein {
  from {bottom: 0; opacity: 0;} 
  to {bottom: 30px; opacity: 1;}
}

@keyframes fadein {
  from {bottom: 0; opacity: 0;}
  to {bottom: 30px; opacity: 1;}
}

@-webkit-keyframes fadeout {
  from {bottom: 30px; opacity: 1;} 
  to {bottom: 0; opacity: 0;}
}

@keyframes fadeout {
  from {bottom: 30px; opacity: 1;}
  to {bottom: 0; opacity: 0;}
}
</style>