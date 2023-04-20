<template>
    <div class="animationContainer">
        <div class="cards">
            <div class="card">
                <img src="../assets/king-card-pik-transparent.png" height="150" loading="lazy">
            </div>
            <div class="card">
                <img src="../assets/king-card-caro-transparent.png" height="150" loading="lazy">
            </div>
            <div class="card">
                <img src="../assets/king-card-kreuz-transparent.png" height="150" loading="lazy">
            </div>
            <div class="card">
                <img src="../assets/king-card-herz-transparent.png" height="150" loading="lazy">
            </div>
        </div>
        <div class="jugs">
            <div class="jug">
                <img src="../assets/Krug-Single-Transparent.png" height="130" loading="lazy">
            </div>
            <div class="jug">
                <img src="../assets/Krug-Single-Transparent.png" height="130" loading="lazy">
            </div>
        </div>
        <div class="logo">
            <img src="../assets/logo-schrift.png" height="100" loading="lazy">
        </div>
    </div>
    
</template>

<script>
    export default 
    {
        name: "item-logoAnimation",
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
    height: 150px;
    width: 100px;
    border-radius: 5px;
    position: absolute;
    box-shadow: 0 0 30px transparentize(black, 0.8);
    left: 50%;
    transform-origin: center 120%;
    transition: transform 1s ease-out;
    
}
.jugs
{
    z-index: 2;
}
.jug
{
    height:300px;
    position: absolute;
}
.logo
{
    position: relative;
    z-index: 3;
    top: 140px;
    text-align: center;
}
.logo img
{
    opacity: 0;
    animation-name: showLogo;
    animation-duration: 2s;
    animation-iteration-count: 1;
    animation-fill-mode: forwards;
    animation-delay: 3.8s;
}
.jug:nth-child(1) 
{
    transform: scaleX(-1) translate(15rem, 0);
    left: 55%;
    right: 50%;
    animation-name: leftJug;
    animation-duration: 2s;
    animation-iteration-count: 1;
    animation-fill-mode: forwards;
    animation-delay: 1.5s;
}
.jug:nth-child(2) 
{
    transform: translate(15rem, 0);
    left: 50%;
    right: 70%;
    animation-name: rightJug;
    animation-duration: 2s;
    animation-iteration-count: 1;
    animation-fill-mode: forwards;
    animation-delay: 1.5s;
}
.card:nth-child(1) 
{
    transform: translate(-50%, -50%) rotate(0);
    animation-name: firstChild;
    animation-duration: 2s;
    animation-iteration-count: 1;
    animation-fill-mode: forwards;
    
}
.card:nth-child(2) 
{
    transform: translate(-50%, -50%) rotate(0);
    animation-name: secondChild;
    animation-duration: 2s;
    animation-iteration-count: 1;
    animation-fill-mode: forwards;
    
}
.card:nth-child(3) 
{
    transform: translate(-50%, -50%) rotate(0);
    animation-name: thirdChild;
    animation-duration: 2s;
    animation-iteration-count: 1;
    animation-fill-mode: forwards;
    
}
.card:nth-child(4) 
{
    transform: translate(-50%, -50%) rotate(0);
    animation-name: fourthChild;
    animation-duration: 2s;
    animation-iteration-count: 1;
    animation-fill-mode: forwards;
    
    
}

@keyframes firstChild
{
    100%
    {
        transform: translate(-50%, -50%) rotate(-30deg);
    }
}
@keyframes secondChild
{
    100%
    {
        transform: translate(-50%, -50%) rotate(-10deg);
    }
}
@keyframes thirdChild
{
    100%
    {
        transform: translate(-50%, -50%) rotate(10deg);
    }
}
@keyframes fourthChild
{
    100%
    {
        transform: translate(-50%, -50%) rotate(30deg);
    }
}
@keyframes leftJug
{
    100%
    {
        transform: scaleX(-1)  translate(0, 0);
    }
}
@keyframes rightJug
{
    100%
    {
        transform: translate(0, 0);
    }
}
@keyframes showLogo
{
    100%
    {
        opacity: 1;
    }
}
</style>