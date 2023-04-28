<!--   
    Version: 3.2.41
    Auhtor: Felix Hansmann
    
    Die Komponente "Menu.vue" ist für die Darstellung des Menü bzw. der Startseite veranwortlich.
-->
<template>
    <div class="container">
        <LogoAnimation></LogoAnimation>
        <div class="row row-cols-1 g-4" ref="row">
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
    <BackgroundAnimation></BackgroundAnimation>
</template>
<script>
    //Import required components
    import LogoAnimation from "../components/LogoAnimation.vue";
    import Button from "../components/Button.vue";
    import BackgroundAnimation from "../components/BackgroundAnimation.vue";

    export default 
    {
        name: "item-menu",
        components:
        {
            LogoAnimation,
            Button,
            BackgroundAnimation,
        },
        data()
        {
            return{
                snackbar: false,
                showMenuAnimation: localStorage.getItem("animation")
            }
        },
        mounted()
        {
            //wird angezeigt wenn die Einstellungen in "Settings" erfolgreich gespeichert wurden
            if(JSON.parse(localStorage.getItem("snackbar")) === true)
            {
                this.sucMsg()
                localStorage.setItem("snackbar", this.snackbar) 
            }

            if(localStorage.getItem("animation") === null)
            {
                localStorage.setItem("animation", false);
            }

            if(this.showMenuAnimation)
            {
                this.$refs.row.style.opacity = 1;
                this.$refs.row.style.animation = "none";
            }
        },
        methods:
        {
            //zeigt die Snackbar an
            sucMsg()
            {
                let x = document.getElementById("snackbar");
                x.className = "show";
                setTimeout(()=>{ x.className = x.className.replace("show", ""); }, 3000);
            },
        }
    }
</script>

<style scoped>

.container
{
    display: -webkit-box;
    display: -ms-flexbox;
    display: flex;
    -webkit-box-orient: vertical;
    -webkit-box-direction: normal;
        -ms-flex-direction: column;
            flex-direction: column;
    -webkit-box-pack: center;
        -ms-flex-pack: center;
            justify-content: center;
    -webkit-box-align: center;
        -ms-flex-align: center;
            align-items: center;
    -ms-touch-action: none;
        touch-action: none;
    min-height: 100vh;
    z-index: 1;
    position: relative;
}
.row
{
    opacity: 0;
    -webkit-animation-name: showMenu;
            animation-name: showMenu;
    -webkit-animation-duration: 3s;
            animation-duration: 3s;
    -webkit-animation-iteration-count: 1;
            animation-iteration-count: 1;
    -webkit-animation-fill-mode: forwards;
            animation-fill-mode: forwards;
    -webkit-animation-delay: 6s;
            animation-delay: 6s;
}
.col
{
    display: -webkit-box;
    display: -ms-flexbox;
    display: flex;
    -webkit-box-pack: center;
        -ms-flex-pack: center;
            justify-content: center;

}
Button
{
    width: 250px;
    font-size: 24px;
    padding: 10px 0 10px 0;
}

#snackbar 
{
    visibility: hidden;
    min-width: 250px;
    background-color:rgb(36, 112, 36);
    color: white;
    text-align: center;
    border-radius: 2px;
    padding: 8px;
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
@-webkit-keyframes showMenu 
{
    from
    {
        opacity: 0;
    }
    to
    {
        opacity: 1;
    }
}
@keyframes showMenu 
{
    from
    {
        opacity: 0;
    }
    to
    {
        opacity: 1;
    }
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

@media screen and (orientation: landscape) 
{
    
}
@media(max-height: 568px)
{
    Button
    {
        width: 200px;
        font-size: 20px;
    }
}
</style>