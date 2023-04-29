<!--   
    Version: 3.2.41
    Auhtor: Felix Hansmann
    
    Die Komponente "Card.vue" stellt die Struktur, einer einzelenen Karten, 
    sowohl für die Vorderseite als auch Rückseite zur Verfügung.
-->
<template> 
    <div
        @click="$emit('flip-card')" 
        >
        <div class="card_face card_face--front">
            <div class="fontBg">Four<br>Kingz</div>
        </div>
        <div class="card_face card_face--back">
            <div class="card content" >
                <div class="card_header">
                    <h2>{{cardName}}</h2>
                </div>
                <div class="card_body">
                    <span class="cardAction">{{cardAction}}</span>
                </div>
            </div>
        </div>     
    </div>
</template>

<script>
    export default 
    {
        name: "item-card",
        emits: ['flip-card'],
        props:
        {
            cardNumber: String,
            cardName: String,
            cardAction: String,
        }

    }
</script>

<style lang="scss" scoped>
.card
{
    display: flex;
    flex-direction: column;
    perspective: 1000px;
    border: none;
    --bs-card-bg: var(--color-main);
}

.card_inner
{
    width: 100%;
    height: 100%;
    transition: transform 1s;
    transform-style: preserve-3d;
    cursor: pointer;
    position: relative;
}

.card_face
{
    position: absolute;
    width: 100%;
    height: 100%;
    -webkit-backface-visibility: hidden;
    backface-visibility: hidden;
    overflow: hidden;
    border-radius: 16px;
    border: 4px solid var(--color-main);
}

.card_face--front
{
    
    display: flex;
    justify-content: center;
    align-items: center;
    background-color: var(--color-second);
    opacity: 1;
    background: repeating-linear-gradient( 45deg, #1e233b, #1e233b 4.5px, var(--color-second) 4.5px, var(--color-second) 22.5px );
}
.fontBg
{
    font-family: var(--font-logo);
    font-size: 55px;
    line-height: 90%;
    text-align: center;
    -webkit-text-stroke-width: 0.5px;
    -webkit-text-stroke-color: #000000;
    -webkit-text-fill-color: var(--color-main);
}
.card_face--back
{
    transform: rotateY(180deg);
}

.card_content
{
    width: 100%;
    height: 100%;
}

.card_header
{
    background-color: var(--color-second);
    display: flex;
    justify-content: center;
    flex-direction: column;
    height: 160px;
    align-items: center;
    text-align: center;
}
.card_header h2
{
    color: var(--color-main);
    font-size: 50px;
    font-weight: bold;
    text-transform: uppercase;
    padding: 0;
    margin: 0;
    letter-spacing: 1.5px; 
}
.logo
{
    height: 90px;
    width: 90px;
}
.card_body
{
    display: flex;
    align-items: center;
    justify-content: center;
    text-align: center;
    color: var(--color-second);
    height: 160px;
    padding: 0 15px;
    font-size: 22px;
    background-color: var(--color-main);
    border-radius: 16px;
}
.cardAction
{
    word-break: break-word;
}
@media(max-width: 320px) and (max-height: 568px)
{
    .img
    {
        height: 140px;
    }
    .card_header
    {
        height: 135px;
    }
    .card_header h2
    {
        font-size: 30px;
    }
    .card_body
    {
        height: 135px;
    }
    .cardAction
    {
        font-size: 16px;
    }
}
</style>