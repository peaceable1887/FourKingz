<!--   
    Version: 3.2.41
    Auhtor: Felix Hansmann
    
    ---(WIRD AKTUELL NICHT VERWENDET!)---

    Die Komponente "ArrowAnimation.vue" stellt einen animierten Pfeil zur Verfügung.
-->
<template>
    <div class="arrowWrapper">
        <div class="arrow">
            <span></span>
        </div>
        <div class="arrowText">Klick auf die Karte</div>
    </div>
</template>

<script>
    export default 
    {
        name: "item-arrowAnimation"
    }
</script>

<style lang="scss" scoped>
.arrowWrapper
{
    margin-left: auto;
    margin-right: auto;
    left: 0;
    right: 0;
    display: -webkit-box;
    display: -ms-flexbox;
    display: flex;
    -webkit-box-orient: vertical;
    -webkit-box-direction: normal;
        -ms-flex-direction: column;
            flex-direction: column;
    position: absolute;
}
.arrowText
{
    color: #222847;
    font-size: 18px;
    text-align: center;
    font-weight: bold;
}
.arrow 
{
    -webkit-transform: translate(-50%, -50%);
        -ms-transform: translate(-50%, -50%);
            transform: translate(-50%, -50%);
    -webkit-transform: rotate(180deg);
        -ms-transform: rotate(180deg);
            transform: rotate(180deg);
    margin: 0 auto;
}

.arrow span 
{
    display: block;
    width: 25px;
    height: 25px;
    border-bottom: 5px solid #222847;
    border-right: 5px solid #222847;
    -webkit-transform: rotate(45deg);
        -ms-transform: rotate(45deg);
            transform: rotate(45deg);
    -webkit-animation: animate 2s infinite;
            animation: animate 2s infinite;
}

.arrow span:nth-child(2) {
    -webkit-animation-delay: -0.2s;
            animation-delay: -0.2s;
}

.arrow span:nth-child(3) {
    -webkit-animation-delay: -0.4s;
            animation-delay: -0.4s;
}

@-webkit-keyframes animate {
    0% {
        opacity: 0;
        -webkit-transform: rotate(45deg) translate(-10px, -10px);
                transform: rotate(45deg) translate(-10px, -10px);
    }
    50% {
        opacity: 1;
    }
    100% {
        opacity: 0;
        -webkit-transform: rotate(45deg) translate(5px, 5px);
                transform: rotate(45deg) translate(5px, 5px);
    }
}

@keyframes animate {
    0% {
        opacity: 0;
        -webkit-transform: rotate(45deg) translate(-10px, -10px);
                transform: rotate(45deg) translate(-10px, -10px);
    }
    50% {
        opacity: 1;
    }
    100% {
        opacity: 0;
        -webkit-transform: rotate(45deg) translate(5px, 5px);
                transform: rotate(45deg) translate(5px, 5px);
    }
}
@media(max-height: 568px)
{
    .arrowText
    {
        color: #222847;
        font-size: 14px;
        text-align: center;
    }
    .arrow span 
    {
        width: 20px;
        height: 20px;
    }
}
</style>