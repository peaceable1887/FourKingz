<template> 
    <div
        @click="$emit('flip-card')" 
        >
        <div class="card_face card_face--front">
            <img src="../assets/logo_fourKingz2.png">
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
    display: -webkit-box;
    display: -ms-flexbox;
    display: flex;
    -webkit-box-orient: vertical;
    -webkit-box-direction: normal;
        -ms-flex-direction: column;
            flex-direction: column;
    -webkit-perspective: 1000px;
            perspective: 1000px;
    border: none;
 
}

.card_inner
{
    width: 100%;
    height: 100%;
    -webkit-transition: -webkit-transform 1s;
    transition: -webkit-transform 1s;
    -o-transition: transform 1s;
    transition: transform 1s;
    transition: transform 1s, -webkit-transform 1s;
    -webkit-transform-style: preserve-3d;
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
    -webkit-box-shadow: 0px 3px 18px 3px rgba(0, 0, 0, 0.2);
            box-shadow: 0px 3px 18px 3px rgba(0, 0, 0, 0.2);
}

.card_face--front
{
    /*background-image: linear-gradient(to bottom right, rgb(255, 217, 0), red);*/
    /*background-image: url("../assets/logo_fourKingz2.png");*/
    background-color: #222847;
    display: -webkit-box;
    display: -ms-flexbox;
    display: flex;
    -webkit-box-align: center;
        -ms-flex-align: center;
            align-items: center;
    -webkit-box-pack: center;
        -ms-flex-pack: center;
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
    background-color: #ccc661;
    -webkit-transform: rotateY(180deg);
            transform: rotateY(180deg);
}

.card_content
{
    width: 100%;
    height: 100%;
}

.card_header
{
    background-color: white;
}
</style>