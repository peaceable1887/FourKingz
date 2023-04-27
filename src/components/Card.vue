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
            <div class="imgLogo" loading="lazy"></div>
            <div class="imgBg" loading="lazy"></div>
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
    box-shadow: 0px 3px 18px 3px rgba(0, 0, 0, 0.2);
    border: 4px solid var(--color-main);
}

.card_face--front
{
    background-color: var(--color-second);
    display: flex;
    align-items: center;
    justify-content: center;
  
}

.card_face--front h2
{
    color: white;
    font-size: 32px;
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
    background-color: var(--color-main);
    display: flex;
    justify-content: center;
    flex-direction: column;
    height: 160px;
    align-items: center;
    text-align: center;
}
.card_header h2
{
    color: #222847;
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
    color: var(--color-main);
    height: 160px;
    padding: 0 15px;
    font-size: 22px;
    background-color: var(--color-second);
    border-radius: 16px;

}
.cardAction
{
    word-break: break-word;
}
@media(max-height: 568px)
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