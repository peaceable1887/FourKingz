<template>
    <div class="animationContainer">
        <div class="cards" ref="cards">
            <div class="card">
                <img src="../assets/king-card-pik-transparent.png" loading="lazy">
            </div>
            <div class="card">
                <img src="../assets/king-card-caro-transparent.png" loading="lazy">
            </div>
            <div class="card">
                <img src="../assets/king-card-cross-transparent.png" loading="lazy">
            </div>
            <div class="card">
                <img src="../assets/king-card-heart-transparent.png" loading="lazy">
            </div>
        </div>
        <div class="jugs" ref="jugs">
            <div class="jug">
                <img src="../assets/jug-single-transparent.png" loading="lazy">
            </div>
            <div class="jug">
                <img src="../assets/jug-single-transparent.png" loading="lazy">
            </div>
        </div>
        <div class="logo" ref="logo">
            Four<br>Kingz
        </div>
    </div>
</template>

<script>
    export default 
    {
        name: "item-logoAnimation",
        data()
        {
            return{
                showLogoAnimation: localStorage.getItem("animation")
            }
        },
        mounted()
        {
            if(this.showLogoAnimation)
            {
                //disable Card animation
                this.$refs.cards.children[0].style.transform = "translate(-50%, -50%) rotate(-30deg)"
                this.$refs.cards.children[1].style.transform = "translate(-50%, -50%) rotate(-10deg)"
                this.$refs.cards.children[2].style.transform = "translate(-50%, -50%) rotate(10deg)"
                this.$refs.cards.children[3].style.transform = "translate(-50%, -50%) rotate(30deg)"
             
                //disable Jug Animation
                this.$refs.jugs.children[0].style.transform = "scaleX(-1) translate(0, 0) rotate(0deg)"
                this.$refs.jugs.children[1].style.transform = "translate(0, 0) rotate(0deg)"
                
                //disable Logo Animation
                this.$refs.logo.style.opacity = "1"
                this.$refs.logo.style.scale = "1"

                //delete Keyframe Rule from Card,Jug and Logo at 50%
                for(let i = 12; i <= 18; i++)
                {
                    document.styleSheets[6].cssRules[i].deleteRule("50%")
                }
            }
        },
    }
</script>

<style lang="scss" scoped>
.animationContainer
{
    margin-top: 10vh;
    height: 330px;
}
.cards 
{
    z-index: 1;
}
.card 
{
    height: 135px;
    background-size: cover;
    width: 90px;
    border-radius: 5px;
    border: none;
    position: absolute;
    -webkit-box-shadow: 0px 3px 18px 3px rgba(0, 0, 0, 0.2);
            box-shadow: 0px 3px 18px 3px rgba(0, 0, 0, 0.2);
    left: 50%;
    -webkit-transform-origin: center 120%;
        -ms-transform-origin: center 120%;
            transform-origin: center 120%; 
}
.jugs
{
    z-index: 2;
    margin-bottom: 15px;
}
.jug
{
    position: relative;
}
.logo
{
    position: relative;
    font-family: var(--font-logo);
    font-size: 75px;
    line-height: 90%;
    text-align: center;
    z-index: 3;
    -webkit-text-stroke-width: 2px;
    -webkit-text-stroke-color: #000000;
    -webkit-text-fill-color: var(--color-main);
    top: 130px;
    text-align: center;
    opacity: 0;
    scale: 0;
    -webkit-animation-name: showLogo;
            animation-name: showLogo;
    -webkit-animation-duration: 2.5s;
            animation-duration: 2.5s;
    -webkit-animation-iteration-count: 1;
            animation-iteration-count: 1;
    -webkit-animation-fill-mode: forwards;
            animation-fill-mode: forwards;
    -webkit-animation-delay: 4s;
            animation-delay: 4s;
}
.jug:nth-child(1) 
{
    -webkit-transform: scaleX(-1) translate(150vw, 0);
        -ms-transform: scaleX(-1) translate(150vw, 0);
            transform: scaleX(-1) translate(150vw, 0);
    left: 53%;
    right: 50%;
    position: absolute;
    -webkit-animation: leftJug 2.5s ease-out forwards 1;
            animation: leftJug 2.5s ease-out forwards 1;
    -webkit-animation-delay: 1.5s;
            animation-delay: 1.5s;

}
.jug:nth-child(2) 
{
    -webkit-transform: translate(150vw, 0);
        -ms-transform: translate(150vw, 0);
            transform: translate(150vw, 0);
    left: 47%;
    right: 50%;
    position: absolute;
    -webkit-animation: rightJug 2.5s ease-out forwards 1;
            animation: rightJug 2.5s ease-out forwards 1;
    -webkit-animation-delay: 1.5s;
            animation-delay: 1.5s;
}
.card:nth-child(1) 
{
    -webkit-transform: translate(-50%, -50%) rotate(0);
        -ms-transform: translate(-50%, -50%) rotate(0);
            transform: translate(-50%, -50%) rotate(0);
    -webkit-animation-name: firstCard;
            animation-name: firstCard;
    -webkit-animation-duration: 2s;
            animation-duration: 2s;
    -webkit-animation-iteration-count: 1;
            animation-iteration-count: 1;
    -webkit-animation-fill-mode: forwards;
            animation-fill-mode: forwards;
}
.card:nth-child(2) 
{
    -webkit-transform: translate(-50%, -50%) rotate(0);
        -ms-transform: translate(-50%, -50%) rotate(0);
            transform: translate(-50%, -50%) rotate(0);
    -webkit-animation-name: secondCard;
            animation-name: secondCard;
    -webkit-animation-duration: 2s;
            animation-duration: 2s;
    -webkit-animation-iteration-count: 1;
            animation-iteration-count: 1;
    -webkit-animation-fill-mode: forwards;
            animation-fill-mode: forwards;  
}
.card:nth-child(3) 
{
    -webkit-transform: translate(-50%, -50%) rotate(0);
        -ms-transform: translate(-50%, -50%) rotate(0);
            transform: translate(-50%, -50%) rotate(0);
    -webkit-animation-name: thirdCard;
            animation-name: thirdCard;
    -webkit-animation-duration: 2s;
            animation-duration: 2s;
    -webkit-animation-iteration-count: 1;
            animation-iteration-count: 1;
    -webkit-animation-fill-mode: forwards;
            animation-fill-mode: forwards;
}
.card:nth-child(4) 
{
    -webkit-transform: translate(-50%, -50%) rotate(0);
        -ms-transform: translate(-50%, -50%) rotate(0);
            transform: translate(-50%, -50%) rotate(0);
    -webkit-animation-name: fourthCard;
            animation-name: fourthCard;
    -webkit-animation-duration: 2s;
            animation-duration: 2s;
    -webkit-animation-iteration-count: 1;
            animation-iteration-count: 1;
    -webkit-animation-fill-mode: forwards;
            animation-fill-mode: forwards;
}

@-webkit-keyframes firstCard
{
    50%
    {
        -webkit-transform: translate(-50%, -50%) rotate(-32deg);
                transform: translate(-50%, -50%) rotate(-32deg);
    }
    100%
    {
        -webkit-transform: translate(-50%, -50%) rotate(-30deg);
                transform: translate(-50%, -50%) rotate(-30deg);
    }
}

@keyframes firstCard
{
    50%
    {
        -webkit-transform: translate(-50%, -50%) rotate(-32deg);
                transform: translate(-50%, -50%) rotate(-32deg);
    }
    100%
    {
        -webkit-transform: translate(-50%, -50%) rotate(-30deg);
                transform: translate(-50%, -50%) rotate(-30deg);
    }
}
@-webkit-keyframes secondCard
{
    50%
    {
        -webkit-transform: translate(-50%, -50%) rotate(-12deg);
                transform: translate(-50%, -50%) rotate(-12deg);
    }
    100%
    {
        -webkit-transform: translate(-50%, -50%) rotate(-10deg);
                transform: translate(-50%, -50%) rotate(-10deg);
    }
}
@keyframes secondCard
{
    50%
    {
        -webkit-transform: translate(-50%, -50%) rotate(-12deg);
                transform: translate(-50%, -50%) rotate(-12deg);
    }
    100%
    {
        -webkit-transform: translate(-50%, -50%) rotate(-10deg);
                transform: translate(-50%, -50%) rotate(-10deg);
    }
}
@-webkit-keyframes thirdCard
{
    50%
    {
        -webkit-transform: translate(-50%, -50%) rotate(12deg);
                transform: translate(-50%, -50%) rotate(12deg);
    }
    100%
    {
        -webkit-transform: translate(-50%, -50%) rotate(10deg);
                transform: translate(-50%, -50%) rotate(10deg);
    }
}
@keyframes thirdCard
{
    50%
    {
        -webkit-transform: translate(-50%, -50%) rotate(12deg);
                transform: translate(-50%, -50%) rotate(12deg);
    }
    100%
    {
        -webkit-transform: translate(-50%, -50%) rotate(10deg);
                transform: translate(-50%, -50%) rotate(10deg);
    }
}
@-webkit-keyframes fourthCard
{
    50%
    {
        -webkit-transform: translate(-50%, -50%) rotate(32deg);
                transform: translate(-50%, -50%) rotate(32deg);
    }
    100%
    {
        -webkit-transform: translate(-50%, -50%) rotate(30deg);
                transform: translate(-50%, -50%) rotate(30deg);
    }
}
@keyframes fourthCard
{
    50%
    {
        -webkit-transform: translate(-50%, -50%) rotate(32deg);
                transform: translate(-50%, -50%) rotate(32deg);
    }
    100%
    {
        -webkit-transform: translate(-50%, -50%) rotate(30deg);
                transform: translate(-50%, -50%) rotate(30deg);
    }
}
@-webkit-keyframes leftJug
{
    30%
    {
        -webkit-transform: scaleX(-1) rotate(0deg);
                transform: scaleX(-1) rotate(0deg);
    }
    50%
    {
        -webkit-transform: scaleX(-1) rotate(10deg);
                transform: scaleX(-1) rotate(10deg);
    }
    100%
    {
       
        -webkit-transform: scaleX(-1) translate(0, 0) rotate(0deg);
       
                transform: scaleX(-1) translate(0, 0) rotate(0deg);
    }
}
@keyframes leftJug
{
    30%
    {
        -webkit-transform: scaleX(-1) rotate(0deg);
                transform: scaleX(-1) rotate(0deg);
    }
    50%
    {
        -webkit-transform: scaleX(-1) rotate(10deg);
                transform: scaleX(-1) rotate(10deg);
    }
    100%
    {
       
        -webkit-transform: scaleX(-1) translate(0, 0) rotate(0deg);
       
                transform: scaleX(-1) translate(0, 0) rotate(0deg);
    }
}
@-webkit-keyframes rightJug
{
    30%
    {
        -webkit-transform: rotate(0deg);
                transform: rotate(0deg);
    }
    50%
    {
        -webkit-transform: rotate(10deg);
                transform: rotate(10deg);
    }
    100%
    {
      
        -webkit-transform: translate(0, 0) rotate(0deg);
      
                transform: translate(0, 0) rotate(0deg);
    }
}
@keyframes rightJug
{
    30%
    {
        -webkit-transform: rotate(0deg);
                transform: rotate(0deg);
    }
    50%
    {
        -webkit-transform: rotate(10deg);
                transform: rotate(10deg);
    }
    100%
    {
      
        -webkit-transform: translate(0, 0) rotate(0deg);
      
                transform: translate(0, 0) rotate(0deg);
    }
}
@-webkit-keyframes showLogo
{
    50%
    {
        opacity: 1;
        scale: 1.2;
    }
    100%
    {
        opacity: 1;
        scale: 1;
    }
}
@keyframes showLogo
{
    50%
    {
        opacity: 1;
        scale: 1.2;
    }
    100%
    {
        opacity: 1;
        scale: 1;
    }
}

@media (max-width: 320px) and (max-height: 568px)
{
    .animationContainer
    {
        height: 270px;
    }
    .card 
    {
        width: 70px;
        height: 100px;
    }
    .jug img
    {
        height: 100px;
    } 
    .logo
    {
        top: 100px;
        font-size: 57px;
    }
}
</style>