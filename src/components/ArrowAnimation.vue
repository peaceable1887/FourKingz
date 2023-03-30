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
    display: flex;
    justify-content: center;
    width: 100%;
}
.arrowText
{
    position: fixed;
    bottom: 7%;
    display: flex;
    justify-content: center;
    width: 100%;
    color: #441d1d;
    font-size: 18px;
}
.arrow {
    position: fixed;
    bottom: 15%;
    transform: translate(-50%, -50%);
    transform: rotate(180deg);
}

.arrow span {
    display: block;
    width: 4vw;
    height: 4vw;
    border-bottom: 5px solid #441d1d;
    border-right: 5px solid #441d1d;
    transform: rotate(45deg);
    margin: -10px;
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
        transform: rotate(45deg) translate(-20px, -20px);
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