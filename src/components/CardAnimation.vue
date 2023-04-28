<!--   
    Version: 3.2.41
    Auhtor: Felix Hansmann
    
    Die Komponente "CardAnimation.vue" ist eine seperate Karte die erstellt wird sobald der vierte König gezogen wurde.
-->
<template> 
    <div>
        <div class="card_face card_face--front">
            <div class="card content" >
                <div class="card_header">
                    <h2>König</h2>
                </div>
                <div class="card_body">
                    <span class="cardAction">Du musst trinken!</span>
                </div>
            </div>
        </div>
        <div class="card_face card_face--back">
            <div class="image">
                <img src="../assets/check-mark-organge.png">
            </div>
            <span class="text">Spiel beendet.<br>Vier Könige gezogen.</span>
            <div class="btnWrapper">
                <a href="/game">
                    <Button class="remain" text="Neu starten"></Button>
                </a>
                <a href="/">
                    <Button class="backToMenu" text="Hauptmenü"></Button>
                </a>
            </div>
        </div>     
    </div>
</template>

<script>
    //Import required components
    import Button from "../components/Button.vue";

    export default 
    {
        name: "item-card",
        components:
        {
            Button,
        },
        props:
        {
            cardNumber: String,
            cardName: String,
            cardAction: String,
        },

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
    --bs-card-bg: var(--color-main);
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
    background-color: var(--color-second);
    border: 6px solid var(--color-main);
}
.card_face--front h2
{
    color: white;
    font-size: 32px;
}

.card_face--back
{
    -webkit-transform: rotateY(180deg);
            transform: rotateY(180deg);
    border: 6px solid var(--color-main);
    background-color: var(--color-second);
    display: -webkit-box;
    display: -ms-flexbox;
    display: flex;
    text-align: center;
    -webkit-box-orient: vertical;
    -webkit-box-direction: normal;
        -ms-flex-direction: column;
            flex-direction: column;
}
.image img
{
    height: 90px;
    padding: 15px 0 15px 0;
}
.card_content
{
    width: 100%;
    height: 100%;
}

.card_header
{
    background-color: var(--color-second);
    display: -webkit-box;
    display: -ms-flexbox;
    display: flex;
    -webkit-box-pack: center;
        -ms-flex-pack: center;
            justify-content: center;
    -webkit-box-orient: vertical;
    -webkit-box-direction: normal;
        -ms-flex-direction: column;
            flex-direction: column;
    height: 160px;
    -webkit-box-align: center;
        -ms-flex-align: center;
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
.card_body
{
    display: -webkit-box;
    display: -ms-flexbox;
    display: flex;
    -webkit-box-align: center;
        -ms-flex-align: center;
            align-items: center;
    -webkit-box-pack: center;
        -ms-flex-pack: center;
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

.text
{
    color: var(--color-main);
    font-size: 20px;
}
.btnWrapper
{
    display: -webkit-box;
    display: -ms-flexbox;
    display: flex;
    -webkit-box-pack: justify;
        -ms-flex-pack: justify;
            justify-content: space-between;
    margin-top: 20px;
    -webkit-box-orient: vertical;
    -webkit-box-direction: normal;
        -ms-flex-direction: column;
            flex-direction: column;
    -webkit-box-align: center;
        -ms-flex-align: center;
            align-items: center;
}
Button
{
    padding: 5px;
    width: 180px;
    font-size: 20px;
    border-radius: 10px;
    margin: 10px;
    color: var(--color-second);
    background-color: var(--color-main);
    -webkit-box-shadow: none;
            box-shadow: none;
}
Button:active
{
    color: var(--color-main);
    border: 1px solid var(--color-main);
    background-color: var(--color-second);
}
</style>