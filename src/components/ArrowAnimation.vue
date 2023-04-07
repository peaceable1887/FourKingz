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
    display: flex;
    flex-direction: column;
    position: absolute;
    bottom: 2%;
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
    transform: translate(-50%, -50%);
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
    transform: rotate(45deg);
    animation: animate 2s infinite;
}

.arrow span:nth-child(2) {
    animation-delay: -0.2s;
}

.arrow span:nth-child(3) {
    animation-delay: -0.4s;
}

@keyframes animate {
    0% {
        opacity: 0;
        transform: rotate(45deg) translate(-10px, -10px);
    }
    50% {
        opacity: 1;
    }
    100% {
        opacity: 0;
        transform: rotate(45deg) translate(5px, 5px);
    }
}

</style>