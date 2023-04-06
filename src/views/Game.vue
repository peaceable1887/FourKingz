<template>
    <div class="container">
        <Header @overlay="on()" text="Spiel"></Header>
        <div class="row row-cols-1">
            <div class="col">
                <GameHeader class=""
                :cards="`${32-activeIndex}`"
                :kings="`${displayCountKing}`">
                </GameHeader>  
            </div>
            <div class="col">
                <swiper
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
                    <swiper-slide v-for="card in cards" :key="card" v-slot="{isActive}" >
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
            </div>
            <div class="col">
                <ArrowAnimation v-if="showFlipArrow"></ArrowAnimation> 
            </div>
        </div>
    </div>
    <div id="overlay" ref="overlay">
        <div id="overlayContent" v-if="msg">
            <span class="text">Spiel beendet. Vier Könige gezogen.</span>
            <div class="btnWrapper">
                <a href="/game">
                    <Button class="remain" text="Neu starten"></Button>
                </a><br>
                <router-link to="/">
                    <Button class="backToMenu" @click="clearCardActionValue()" text="Hauptmenü"></Button>
                </router-link>
            </div>
        </div>
        <div id="overlayContent" v-else>
            <span class="text">Möchtest du das Spiel beenden?</span>
            <div class="btnWrapper">
                <Button class="remain" @click="off()" text="Nein"></Button>
                <router-link to="/">
                    <Button class="backToMenu" @click="clearCardActionValue()" text="Ja"></Button>
                </router-link>
            </div>
        </div>
    </div>
  
    
    
  </template>

  <script>
    // Import Swiper Vue.js components
    import { Swiper, SwiperSlide} from 'swiper/vue';
    // Import Swiper styles
    import 'swiper/css';
    import 'swiper/css/effect-cards';
    // import required modules
    import { EffectCards } from 'swiper';

    import Header from "../components/Header.vue";
    import GameHeader from "../components/GameHeader.vue";
    import ArrowAnimation from "../components/ArrowAnimation.vue";
    import Button from "../components/Button.vue";
    import Card from "../components/Card.vue";
    
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
            ArrowAnimation,
            Button,
            Card,
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
                    {index: "0", name: "bube", type: "", action: "Alle Männer müssen trinken!", text: "", counter: 0, img: require ("@/assets/iconmonstr-boy.png")}, 
                    {index: "1", name: "dame", type: "", action: "Alle Frauen müssen trinken!", text: "", counter: 0, img: require ("@/assets/iconmonstr-queen.png")},
                    {index: "2", name: "könig", type: "", action: "Du musst trinken!", text: "", counter: 0, isFinished: false, img: require ("@/assets/iconmonstr-crown-white.png")},
                    {index: "3", name: "ass", type: "", action: "Jeder muss trinken!", text: "", counter: 0, img: require ("@/assets/iconmonstr-friend-6-240.png")},
                    {index: "4", name: "10", type: "", action: "Wähle eine Wortgruppe", text: "", counter: 0, img: require ("@/assets/iconmonstr-school-9-240.png")},
                    {index: "5", name: "9", type: "", action: "Klopfen!", text: "", counter: 0, img: require ("@/assets/iconmonstr-speech-bubble-4-240.png")},
                    {index: "6", name: "8", type: "", action: "Ich packe meinen Koffer", text: "", counter: 0, img: require ("@/assets/iconmonstr-school-11-240.png")},
                    {index: "7", name: "7", type: "", action: "Schimpfwort", text: "", counter: 0, img: require ("@/assets/iconmonstr-speech-bubble-4-240.png")},
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
                msg: false,
                showFlipArrow: true,
                displayCountKing: "0",
            }
        },
        /* eslint-disable */
        mounted()
        {
            const swiper = document.querySelector(".swiper")
            
            swiper.addEventListener("mousemove" , this.handleTouchmove)
            swiper.addEventListener("touchmove" , this.handleTouchmove)    
        },
        updated()
        {
            const swiper = document.querySelector(".swiper")

            swiper.addEventListener("touchend", this.handleTouchend)
         
        },
        /* eslint-disable */
        methods:
        {
            handleTouchmove()
            {
                const swiper = document.querySelector(".swiper")
    
                const slide = swiper.swiper
                console.log("Active Index: " + slide.activeIndex)
                console.log("clickedIndex: " + slide.clickedIndex)
        
                //falls die nutzer versehentlich auf die verdeckten karten auf der rechte seite klickt
                if(slide.clickedIndex > slide.activeIndex)
                {
                    slide.clickedIndex = slide.activeIndex;
                }
                if(slide.clickedIndex === undefined)
                {
                    slide.clickedIndex = "0"
                }
                if(slide.activeIndex%slide.clickedIndex == 1 || isNaN(slide.activeIndex%slide.clickedIndex) || (slide.activeIndex === "2" && slide.clickedIndex === "1"))
                {
                    slide.clickedIndex = slide.activeIndex
                    console.log("modulo")
                }
                if(slide.slides[slide.clickedIndex].style.zIndex === "31" && slide.activeIndex === slide.clickedIndex) 
                {
                    this.transformStyle = "" 
                    this.showCardContent = false
                    slide.allowTouchMove = false
                    console.log(slide.slides[slide.clickedIndex].style.zIndex)
                    
                }
               
            },

            handleTouchend()
            {
                const swiper = document.querySelector(".swiper")
                const slide = swiper.swiper
            
                if(slide.clickedIndex < slide.activeIndex)
                {          
                    slide.allowSlideNext = false
                    slide.allowTouchMove = true
                    this.activeIndex = slide.activeIndex
                    slide.slides[slide.clickedIndex].style.visibility = "hidden"
                    console.log("geht rein")
                }
            },

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
            flipped()
            {  
                const swiper = document.querySelector(".swiper").swiper
                console.log("flipped")
                
                this.isFlipped = true
                this.showFlipArrow = false
                //muss noch rausgenommen werden!
                swiper.allowSlideNext = true
                swiper.allowTouchMove = true

                while(this.cardsType[2].isFinished === false && this.isFlipped === true && this.showCardContent === false)
                {
                    this.transformStyle = "transform: rotateY(180deg);" 
                    let rndNumber = Math.floor(Math.random() * 8+1);
                 
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
                                
                                if(this.cardsType[2].counter === 4)
                                {
                                    this.cardsType[2].isFinished = true
                                    this.msg = true;   
                                    if(this.msg)
                                    {
                                        swiper.allowSlideNext = false
                                        setTimeout(() => {
                                            this.on();
                                        }, 1500);
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

            clearCardActionValue()
            {
                let keysToRemove = ["king", "queen","boy", "ace","ten", "nine", "eight", "seven"]

                keysToRemove.forEach(key => localStorage.removeItem(key))
            },

            on()
            {
                this.$refs.overlay.style.display = "block";
            },

            off() 
            {
                this.$refs.overlay.style.display = "none";
            }
        
        },
       
      
    };
  </script>

<style scoped>
.container
{
    touch-action: none;
    margin: 0;
    padding: 0;
}
.row
{
    height: 100vh;
}
.swiper 
{
  width: 240px;
  height: 320px;
}
.swiper-slide 
{
  display: flex;
  align-items: center;
  justify-content: center;
  border-radius: 18px;
  font-size: 22px;
  font-weight: bold;
  color: #fff;
  -webkit-user-select: none; /* Safari */
  -ms-user-select: none; /* IE 10 and IE 11 */
  user-select: none; /* Standard syntax */
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
    z-index: 2;
    cursor: pointer;
    touch-action: none;
}

#overlayContent
{
    position: absolute;
    top: 50%;
    left: 50%;
    padding: 20px;
    font-size: 26px;
    width: 250px;
    text-align: center;
    color: #441d1d;
    background-color: white;
    transform: translate(-50%, -50%);
    -ms-transform: translate(-50%, -50%);
    border-radius: 10px;
}
.btnWrapper
{
    display: flex;
    justify-content: space-between;
    margin-top: 30px;
    flex-direction: column;
    align-items: center;
}

Button
{
    padding: 10px;
    width: 200px;
    font-size: 24px;
    border-radius: 10px;
    margin: 10px;
    color:#ccc661;
    background-color: #441d1d;
}
</style>