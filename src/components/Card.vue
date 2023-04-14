<template> 
    <div
        @click="$emit('flip-card')" 
        >
        <div class="card_face card_face--front">
            <img src="../assets/logo_fourKingz2.png" loading="lazy" alt="Four Kingz Logo">
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
            cardAction: String
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
    --bs-card-bg: #ed9623;
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
}

.card_face--front
{
    /*background-image: linear-gradient(to bottom right, rgb(255, 217, 0), red);*/
    /*background-image: url("../assets/logo_fourKingz2.png");*/
    background-color: #222847;
    display: flex;
    align-items: center;
    justify-content: center;
}
img
{
    height: 200px;
}
.card_face--front h2
{
    color: white;
    font-size: 32px;
}

.card_face--back
{
    transform: rotateY(180deg);
    border: 4px solid #ed9623;

}

.card_content
{
    width: 100%;
    height: 100%;
}

.card_header
{
    background-color: #ed9623;
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
    color: #ed9623;
    height: 160px;
    padding: 0 15px;
    font-size: 22px;
    background-color: #222847;
    border-radius: 16px;

}
.cardAction
{
    word-break: break-word;
}
@media(max-height: 568px)
{
    img
    {
        height: 140px;
    }
    .card_header
    {
        height: 115px;
    }
    .card_header h2
    {
        font-size: 30px;
    }
    .card_body
    {
        height: 115px;
    }
    .cardAction
    {
        font-size: 16px;
    }
}
</style>