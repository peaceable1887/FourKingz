<template>
    <div class="animationContainer">
        <div class="cards" ref="cards">
            <div class="card">
                <img src="../assets/king-card-pik-transparent.png" height="140" loading="lazy">
            </div>
            <div class="card">
                <img src="../assets/king-card-caro-transparent.png" height="140" loading="lazy">
            </div>
            <div class="card">
                <img src="../assets/king-card-kreuz-transparent.png" height="140" loading="lazy">
            </div>
            <div class="card">
                <img src="../assets/king-card-herz-transparent.png" height="140" loading="lazy">
            </div>
        </div>
        <div class="jugs" ref="jugs">
            <div class="jug">
                <img src="../assets/Krug-Single-Transparent.png" height="120" loading="lazy">
            </div>
            <div class="jug">
                <img src="../assets/Krug-Single-Transparent.png" height="120" loading="lazy">
            </div>
        </div>
        <div class="logo" ref="logo">
            <img src="../assets/logo-schrift.png" height="110" loading="lazy">
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

                //delete Keyframe Rule for Card,Jug and Logo at 50%
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
    height: 300px;
}
.cards 
{
    z-index: 1;
}
.card 
{
    background-size: cover;
    height: 140px;
    width: 90px;
    border-radius: 5px;
    border:none;
    position: absolute;
    box-shadow: 0px 3px 18px 3px rgba(0, 0, 0, 0.2);
    left: 50%;
    transform-origin: center 120%; 
}
.jugs
{
    z-index: 2;
}
.jug
{
    position: relative;
}
.logo
{
    position: relative;
    z-index: 3;
    top: 130px;
    text-align: center;
    opacity: 0;
    scale: 0;
    animation-name: showLogo;
    animation-duration: 2.5s;
    animation-iteration-count: 1;
    animation-fill-mode: forwards;
    animation-delay: 4s;
}

.jug:nth-child(1) 
{
    transform: scaleX(-1) translate(150vw, 0);
    left: 53%;
    right: 50%;
    position: absolute;
    animation: leftJug 2.5s ease-out forwards 1;
    animation-delay: 1.5s;

}
.jug:nth-child(2) 
{
    transform: translate(150vw, 0);
    left: 47%;
    right: 50%;
    position: absolute;
    animation: rightJug 2.5s ease-out forwards 1;
    animation-delay: 1.5s;
}
.card:nth-child(1) 
{
    transform: translate(-50%, -50%) rotate(0);
    animation-name: firstCard;
    animation-duration: 2s;
    animation-iteration-count: 1;
    animation-fill-mode: forwards;
}
.card:nth-child(2) 
{
    transform: translate(-50%, -50%) rotate(0);
    animation-name: secondCard;
    animation-duration: 2s;
    animation-iteration-count: 1;
    animation-fill-mode: forwards;  
}
.card:nth-child(3) 
{
    transform: translate(-50%, -50%) rotate(0);
    animation-name: thirdCard;
    animation-duration: 2s;
    animation-iteration-count: 1;
    animation-fill-mode: forwards;
}
.card:nth-child(4) 
{
    transform: translate(-50%, -50%) rotate(0);
    animation-name: fourthCard;
    animation-duration: 2s;
    animation-iteration-count: 1;
    animation-fill-mode: forwards;
}

@keyframes firstCard
{
    50%
    {
        transform: translate(-50%, -50%) rotate(-32deg);
    }
    100%
    {
        transform: translate(-50%, -50%) rotate(-30deg);
    }
}
@keyframes secondCard
{
    50%
    {
        transform: translate(-50%, -50%) rotate(-12deg);
    }
    100%
    {
        transform: translate(-50%, -50%) rotate(-10deg);
    }
}
@keyframes thirdCard
{
    50%
    {
        transform: translate(-50%, -50%) rotate(12deg);
    }
    100%
    {
        transform: translate(-50%, -50%) rotate(10deg);
    }
}
@keyframes fourthCard
{
    50%
    {
        transform: translate(-50%, -50%) rotate(32deg);
    }
    100%
    {
        transform: translate(-50%, -50%) rotate(30deg);
    }
}
@keyframes leftJug
{
    30%
    {
        transform: scaleX(-1) rotate(0deg);
    }
    50%
    {
        transform: scaleX(-1) rotate(10deg);
    }
    100%
    {
       
        transform: scaleX(-1) translate(0, 0) rotate(0deg);
    }
}
@keyframes rightJug
{
    30%
    {
        transform: rotate(0deg);
    }
    50%
    {
        transform: rotate(10deg);
    }
    100%
    {
      
        transform: translate(0, 0) rotate(0deg);
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
</style>