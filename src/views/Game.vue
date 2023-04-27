<!--   
    Version: 3.2.41
    Auhtor: Felix Hansmann
    
    Die Komponente "Game.vue" ist für die Darstellung und Anwendungslogik, 
    des Spiels zuständig.
-->
<template>
    <div class="container">
        <Header @atClickArrow="showOverlay(); leaveGame = true" text="Spiel"></Header>
        <div class="row">
            <div class="col-1">
                <GameHeader  
                :cards="`${32-activeIndex}`"
                :kings="`${displayCountKing}`">
                </GameHeader>  
            </div>
            <div class="cardContainer">
                <Transition>  
                    <swiper
                    v-if="gaming"
                    :effect="'cards'"
                    :grabCursor="true"
                    :touchStartPreventDefault="false"
                    :allowSlidePrev="false"
                    :allowSlideNext="false"
                    :shortSwipes="false"
                    :longSwipesMs="0"
                    :modules="modules"
                    class="mySwiper"
                    >
                        <swiper-slide v-for="card in cards" :key="card" v-slot="{isActive}">
                            <Card
                            @flip-card="isActive ? flipped() : null" 
                            :cardName="`${cardsName}`"
                            :cardAction="`${cardsAction}`"
                            :style="[isActive ? `${this.transformStyle}` : '']"
                            :class="{card_inner: card_inner, isFlipped: isFlipped}"
                            >
                            </Card>
                        </swiper-slide>      
                    </swiper>
                </Transition>  
                <div v-if="msg" class="cardOverlayBg"></div>
                <CardAnimation v-if="msg" class="cardOverlay"></CardAnimation>
            </div>
        </div>
    </div>
    <div id="overlay" ref="overlay">
        <div id="overlayContent" v-if="leaveGame">
            <div class="image">
                <img src="../assets/questionmark-orange.png">
            </div>
            <span class="text">Möchtest du das Spiel beenden?</span>
            <div class="btnWrapper">
                <Button class="remain" @click="hideOverlay(); leaveGame = false" text="Nein"></Button>
                <router-link to="/">
                    <Button class="backToMenu" text="Ja"></Button>
                </router-link>
            </div>
        </div>
        <div id="overlayContent" v-if="showTutorial" >
            <span class="text">Tutorial</span>
            <div class="image">
                <img class="gif" src="../assets/tutorial-fourkingz-4zu3_AdobeExpress.gif">
            </div>
            <div class="btnWrapper">
                <Button class="remain" @click="hideOverlay()" text="Verstanden"></Button>
            </div>
        </div>
    </div>
  </template>

  <script>

    //Import Swiper Vue.js components
    import { Swiper, SwiperSlide} from 'swiper/vue';
    //Import Swiper styles
    import 'swiper/css';
    import 'swiper/css/effect-cards';
    //Import required modules
    import { EffectCards } from 'swiper';
    //Import required components
    import Header from "../components/Header.vue";
    import GameHeader from "../components/GameHeader.vue";
    import Button from "../components/Button.vue";
    import Card from "../components/Card.vue";
    import CardAnimation from "../components/CardAnimation.vue";
    
    //Number of Cards
    const CARD_COUNT = 32;

    export default 
    {
        name: "item-main",
        components: 
        {
            Swiper,
            SwiperSlide,
            Header,
            GameHeader,
            Button,
            Card,
            CardAnimation
        },
        setup() 
        {
            return {
                modules: [EffectCards],
            };
        },
        data()
        {
            return{
                card_inner: true,
                isFlipped: false,
                cards: Array.from(Array(CARD_COUNT).keys()),
                cardsType: 
                [
                    {index: "0", name: "bube", type: "", action: "Alle Männer müssen trinken!", text: "", counter: 0, img: ""}, 
                    {index: "1", name: "dame", type: "", action: "Alle Frauen müssen trinken!", text: "", counter: 0, img: ""},
                    {index: "2", name: "könig", type: "", action: "Du musst trinken!", text: "", counter: 0, isFinished: false, img: ""},
                    {index: "3", name: "ass", type: "", action: "Jeder muss trinken!", text: "", counter: 0, img: ""},
                    {index: "4", name: "10", type: "", action: "Wähle eine Wortgruppe", text: "", counter: 0, img: ""},
                    {index: "5", name: "9", type: "", action: "Klopfen!", text: "", counter: 0, img: ""},
                    {index: "6", name: "8", type: "", action: "Ich packe meinen Koffer", text: "", counter: 0, img: ""},
                    {index: "7", name: "7", type: "", action: "Schimpfwort", text: "", counter: 0, img: ""},
                ],
                cardsName: "",
                cardsAction: "",
                transformStyle: "",
                activeIndex: null,
                activeI: "",
                imageUrl: "",
                cardImg: "",
                currentValue: 0,
                showCardContent: false,
                gaming: true,
                msg: false,
                showFlipArrow: true,
                displayCountKing: "0",
                leaveGame: false,
                showTutorial: true,
            }
        },

        mounted()
        {
            //zeigt ein Tutorial zu beginn das Spiels
            if(this.showTutorial)
            {
                this.showOverlay()
            }

            //swiper wird initialisiert
            const swiper = document.querySelector(".swiper")
            
            //touch - und mousemove events
            if(swiper) 
            {
                swiper.addEventListener("mousemove" , this.handleTouchmove)
                swiper.addEventListener("touchmove" , this.handleTouchmove) 
            }   
        },
        updated()
        {
            //swiper wird initialisiert
            const swiper = document.querySelector(".swiper")

            //touchend und mousup events
            if(swiper) 
            {
                swiper.addEventListener("mouseup", this.handleTouchend)
                swiper.addEventListener("touchend", this.handleTouchend)
            }
         
        },
      
        methods:
        {
            /**
             * Die Methode "handleTouchmove" verwaltet die das ziehen einer Karte.
             */
            handleTouchmove()
            {
                //swiper wird initialisiert
                const swiper = document.querySelector(".swiper")
                const slide = swiper.swiper

                //setzt den "clickedIndex" der ersten Karte von undefined auf 0 
                if(slide.clickedIndex === undefined)
                {
                    slide.clickedIndex = "0"
                }

                //falls während des ziehen der "clickedIndex" ungleich zum "activeIndex" ist
                if(slide.activeIndex%slide.clickedIndex == 1 || isNaN(slide.activeIndex%slide.clickedIndex) || 
                (slide.activeIndex === "2" && slide.clickedIndex === "1") || slide.clickedIndex > slide.activeIndex)
                {
                    slide.clickedIndex = slide.activeIndex
                }

                //flippt die Karte zurück, wenn der "activeIndex" incrementiert
                if(slide.slides[slide.clickedIndex].style.zIndex === "31" && slide.activeIndex === slide.clickedIndex) 
                {
                    this.transformStyle = "" 
                    this.showCardContent = false
                    slide.allowTouchMove = false
                }
               
            },

            /**
             * Die Methode "handleTouchend" wird ausgeführt, sobald eine Karte beim Slidewechsel losgelassen wird.
             */
            handleTouchend()
            {
                //swiper wird initialisiert
                const swiper = document.querySelector(".swiper")
                const slide = swiper.swiper
            
                //wird asugeführt wenn der "clickedIndex" kleiner als der "activeIndex" ist.
                if(slide.clickedIndex < slide.activeIndex)
                {          
                    slide.allowSlideNext = false
                    slide.allowTouchMove = true
                    this.activeIndex = slide.activeIndex
                    slide.slides[slide.clickedIndex].style.visibility = "hidden"
                }
            },

            /**
             * Die Methode "chooseCardActionValue" prüft ob die Aktion einer Karte in den Einstellungen selbst belegt wurde.
             */
            chooseCardActionValue(cardAction, localStorageValue)
            {
                if(localStorageValue === "" || localStorageValue === null )
                {
                    this.cardsAction = cardAction
                }else
                {
                    this.cardsAction = localStorageValue;
                }
            },

            /**
             * Die Methode "flipped" wird ausgeführt sobald eine verdeckte Karte per Klick umgedreht wurde
             */
            flipped()
            {  
                //swiper wird initialisiert
                const swiper = document.querySelector(".swiper").swiper
                
                this.isFlipped = true
                this.showFlipArrow = false
                //muss noch rausgenommen werden!
                swiper.allowSlideNext = true
                swiper.allowTouchMove = true

                //wird solange ausgeführt bis 4 Könige gezogen sind
                while(this.cardsType[2].isFinished === false && this.isFlipped === true && this.showCardContent === false)
                {
                    //dreht die Karte um 180 Grad
                    this.transformStyle = "transform: rotateY(180deg);" 
                    
                    //generiert zuällige Karte
                    let rndNumber = Math.floor(Math.random() * 8+1);
                 
                    //wählt eine Karte entsprechend der "rndNumber"
                    switch(rndNumber)
                    {
                        case 1:          
                            if(this.cardsType[0].counter != 4)
                            {
                                this.cardsName = this.cardsType[0].name
                                this.chooseCardActionValue(this.cardsType[0].action, localStorage.getItem("boy"))
                                this.cardImg = this.cardsType[0].img
                                this.showCardContent = !this.showCardContent
                                this.cardsType[0].counter++     
                            }else
                            {
                                continue;     
                            }
                            break;
                        case 2:
                            if(this.cardsType[1].counter != 4)
                            {
                                this.cardsName = this.cardsType[1].name
                                this.chooseCardActionValue(this.cardsType[1].action, localStorage.getItem("queen"))
                                this.cardImg = this.cardsType[1].img
                                this.showCardContent = !this.showCardContent
                                this.cardsType[1].counter++
                            }else
                            {
                                continue;     
                            }
                            break;
                        case 3:
                                this.cardsName = this.cardsType[2].name
                                this.chooseCardActionValue(this.cardsType[2].action, localStorage.getItem("king"))
                                this.cardImg = this.cardsType[2].img
                                this.showCardContent = !this.showCardContent;
                                this.cardsType[2].counter++
                                this.displayCountKing = this.cardsType[2].counter
                                
                                //wird ausgeführt sobald 4 Könige gezogen wurden
                                if(this.cardsType[2].counter === 4)
                                {
                                    this.cardsType[2].isFinished = true
                                    this.msg = true
                                    this.gaming = false
                                    if(this.msg)
                                    {
                                        swiper.allowSlideNext = false
                                    }       
                                }
                            break;
                        case 4:
                            if(this.cardsType[3].counter != 4)
                            {
                                this.cardsName = this.cardsType[3].name
                                this.chooseCardActionValue(this.cardsType[3].action, localStorage.getItem("ace"))
                                this.cardImg = this.cardsType[3].img
                                this.showCardContent = !this.showCardContent
                                this.cardsType[3].counter++
                            }else
                            {
                                continue;     
                            }
                            break;
                        case 5:
                            if(this.cardsType[4].counter != 4)
                            {
                                this.cardsName = this.cardsType[4].name
                                this.chooseCardActionValue(this.cardsType[4].action, localStorage.getItem("ten"))
                                this.cardImg = this.cardsType[4].img
                                this.showCardContent = !this.showCardContent
                                this.cardsType[4].counter++     
                            }else
                            {
                                continue;     
                            }
                            break;
                        case 6:
                            if(this.cardsType[5].counter != 4)
                            {
                                this.cardsName = this.cardsType[5].name
                                this.chooseCardActionValue(this.cardsType[5].action, localStorage.getItem("nine"))
                                this.cardImg = this.cardsType[5].img
                                this.showCardContent = !this.showCardContent
                                this.cardsType[5].counter++
                            }else
                            {
                                continue;     
                            }
                            break;
                        case 7:
                            if(this.cardsType[6].counter != 4)
                            {
                                this.cardsName = this.cardsType[6].name
                                this.chooseCardActionValue(this.cardsType[6].action, localStorage.getItem("eight"))
                                this.cardImg = this.cardsType[6].img
                                this.showCardContent = !this.showCardContent
                                this.cardsType[6].counter++
                            }else
                            {
                                continue;     
                            }
                            break;
                        case 8:
                            if(this.cardsType[7].counter != 4)
                            {
                                this.cardsName = this.cardsType[7].name
                                this.chooseCardActionValue(this.cardsType[7].action, localStorage.getItem("seven"))
                                this.cardImg = this.cardsType[7].img
                                this.showCardContent = !this.showCardContent
                                this.cardsType[7].counter++
                            }else
                            {
                                continue;     
                            }
                            break;
                    }
                    this.isFlipped = false;
                  
                }
            },

            /**
             * Die Methode "showOverlay" macht das Overlay sichtar
             */
            showOverlay()
            {
                this.$refs.overlay.style.display = "block";
            },

            /**
             * Die Methode "showOverlay" verbirgt das Overlay
             */
            hideOverlay() 
            {
                this.fadeOut(this.$refs.overlay);
                this.showTutorial = false;
            }, 

            /**
             * Die Methode "out" nimm das Overlay-Element entgegen und lässt es langsam und glatt ausblenen
             * 
             * @param element
             */
            fadeOut(element)
            {
                let opacity = 1; 
                let interval = setInterval(() => {
                if(opacity > 0) 
                {
                    opacity -= 0.1;
                    element.style.opacity = opacity;
                } 
                else 
                {
                    clearInterval(interval); 
                    element.style.display = 'none'; 
                    element.style.opacity = 1;
                }
                }, 50);
            }
        },     
    };
  </script>

<style scoped>

.container
{
    -ms-touch-action: none;
        touch-action: none;
    padding: 0;
    width: 100vw;
    z-index: 1;
    position: relative;
}
.row
{
    height: 100vh;
    -webkit-box-orient: vertical;
    -webkit-box-direction: normal;
        -ms-flex-direction: column;
            flex-direction: column;
}
.cardContainer
{
    position: relative;
    display: -webkit-box;
    display: -ms-flexbox;
    display: flex;
    -webkit-box-pack: center;
        -ms-flex-pack: center;
            justify-content: center;
}
.swiper 
{
    width: 240px;
    height: 320px;
    position: absolute;
    top: 0;
}

.swiper-slide 
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
    border-radius: 18px;
    font-size: 22px;
    font-weight: bold;
    color: #fff;
    -webkit-user-select: none; /* Safari */
    -ms-user-select: none; /* IE 10 and IE 11 */
    -moz-user-select: none;
         user-select: none; /* Standard syntax */
}
.v-leave-active 
{
    -webkit-transition: opacity 0.5s ease;
    -o-transition: opacity 0.5s ease;
    transition: opacity 0.5s ease;
}
.v-leave-to 
{
    opacity: 0;
}
#overlay 
{
    position: fixed;
    display: none;
    width: 100%;
    height: 100%;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
    background-color: rgba(0,0,0,0.5);
    z-index: 1;
    cursor: pointer;
    -ms-touch-action: none;
        touch-action: none; 
}

#overlayContent
{
    position: absolute;
    display: -webkit-box;
    display: -ms-flexbox;
    display: flex;
    -webkit-box-orient: vertical;
    -webkit-box-direction: normal;
        -ms-flex-direction: column;
            flex-direction: column;
    -ms-flex-pack: distribute;
        justify-content: space-around;
    top: 50%;
    left: 50%;
    font-size: 24px;
    width: 280px;
    height: 400px;
    text-align: center;
    color: var(--color-main);
    background-color: var(--color-second);
    border: 4px solid var(--color-main);
    border-radius: 10px;
    -webkit-transform: translate(-50%, -50%);
        -ms-transform: translate(-50%, -50%);
            transform: translate(-50%, -50%);
    -webkit-animation-name: defaultOverlay;
            animation-name: defaultOverlay;
    -webkit-animation-duration: 0.5s;
            animation-duration: 0.5s;
    -webkit-animation-iteration-count: 1;
            animation-iteration-count: 1;
    -webkit-animation-fill-mode: forwards;
            animation-fill-mode: forwards;
    -webkit-animation-direction: alternate;
            animation-direction: alternate;
}
.gif
{
    width: 200px !important;
    padding: 0px 0 0 0 !important;
    border-radius: 10px;
    -webkit-box-shadow: rgba(0, 0, 0, 0.24) 0px 3px 8px;
            box-shadow: rgba(0, 0, 0, 0.24) 0px 3px 8px;
}
Button
{
    padding: 5px;
    width: 180px;
    font-size: 22px;
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
.cardOverlayBg
{
    position: fixed; 
    z-index: 2;
    top: 0; 
    width: 100%;
    height: 100%;
    background-color: rgba(0,0,0,0.5);
}
.cardOverlay
{
    position: absolute;
    z-index: 3;
    width: 240px;
    height: 320px;
    -webkit-transition: -webkit-transform 1s;
    transition: -webkit-transform 1s;
    -o-transition: transform 1s;
    transition: transform 1s;
    transition: transform 1s, -webkit-transform 1s;
    -webkit-transform-style: preserve-3d;
            transform-style: preserve-3d;
    -webkit-animation-name: cardOverlay;
            animation-name: cardOverlay;
    -webkit-animation-duration: 4s;
            animation-duration: 4s;
    -webkit-animation-iteration-count: 1;
            animation-iteration-count: 1;
    -webkit-animation-fill-mode: forwards;
            animation-fill-mode: forwards;
}
@media(max-height: 568px)
{
    .swiper
    {
        width: 200px;
        height: 270px;
    }
}
@-webkit-keyframes defaultOverlay
{
    from
    {
        opacity: 0;   
    }
    to
    {
        -webkit-transition: opacity 0.5s ease-out;
        -o-transition: opacity 0.5s ease-out;
        transition: opacity 0.5s ease-out;
    }
}
@keyframes defaultOverlay
{
    from
    {
        opacity: 0;   
    }
    to
    {
        -webkit-transition: opacity 0.5s ease-out;
        -o-transition: opacity 0.5s ease-out;
        transition: opacity 0.5s ease-out;
    }
}
@-webkit-keyframes cardOverlay
{
   0%
   {
        -webkit-transform: scale(1);
                transform: scale(1);
   }
   50%
   {
        -webkit-transform: scale(1.15) translate(0, -20%);
                transform: scale(1.15) translate(0, -20%)
   }
   100%
   {
        -webkit-transform: scale(1.15) translate(0, -20%) rotateY(180deg);
                transform: scale(1.15) translate(0, -20%) rotateY(180deg);  
   }
}
@keyframes cardOverlay
{
   0%
   {
        -webkit-transform: scale(1);
                transform: scale(1);
   }
   50%
   {
        -webkit-transform: scale(1.15) translate(0, -20%);
                transform: scale(1.15) translate(0, -20%);
   }
   100%
   {
        -webkit-transform: scale(1.15) translate(0, -20%) rotateY(180deg);
                transform: scale(1.15) translate(0, -20%) rotateY(180deg);  
   }
}


</style>