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
    position: absolute;
    margin-left: auto;
    margin-right: auto;
    left: 0;
    right: 0;
    display: flex;
    flex-direction: column;
}
.arrowText
{
    color: #441d1d;
    font-size: 18px;
    text-align: center;
    margin-bottom: 20px;
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
    border-bottom: 5px solid #441d1d;
    border-right: 5px solid #441d1d;
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