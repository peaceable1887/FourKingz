<template>
    <div class="container">
        <div class="row row-cols-1 g-4">
            <div class="col mb-5">
                <img class="rounded mx-auto d-block" src="../assets/transparent_logo.png">
            </div>
            <div class="col">
                <router-link to="/game">
                    <Button text="Spiel starten"></Button>
                </router-link>
            </div>
            <div class="col">
                <router-link to="/settings">
                    <Button text="Einstellungen"></Button>
                </router-link>
            </div>
        </div>
    </div>
    <div class="container">
        <div id="snackbar">Erfolgreich gespeichert</div>
    </div>
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
            this.sucMsg()
            localStorage.setItem("snackbar", this.snackbar) 
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
.container
{
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    touch-action: none;
    height: 100vh;
}
img
{
    height: 200px;
}
Button
{
    padding: 10px 0 10px 0;
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
    font-size: 18px;
    border-radius: 10px;
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