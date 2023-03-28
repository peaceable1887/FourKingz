<template>
    <Header 
    :cards="`${33-activeIndex}`"
    :kings="`${displayCountKing}`">
    </Header>
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
        <swiper-slide v-for="card in cards" :key="card" v-slot="{isActive}">
            <Card
            @flip-card="isActive ? flipped() : null" 
            :cardName="`${cardsName}`"
            :cardAction="`${cardsAction}`"
            :style="[isActive ? `${this.transformStyle}` : '' ]"
            :class="{card_inner: card_inner, isFlipped: isFlipped}"
            >
            </Card>
        </swiper-slide>      
    </swiper>
    <div class="msg" v-if="msg">
        <span class="text">Spiel beendet. Vier Könige gezogen.</span>
        <div class="btnWrapper">
            <router-link to="/">
                <Button @click="clearCardActionValue()" text="Hauptmenü"></Button>
            </router-link>
            <a href="/game">
                <Button text="Neu Starten"></Button>
            </a>
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
            Button,
            Card
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
                activeIndex: 1,
                activeI: "",
                imageUrl: "",
                cardImg: "",
                currentValue: 0,
                showCardContent: false,
                msg: false,
                displayCountKing: "0",
            }
        },
        /* eslint-disable */
        mounted()
        {
            const swiper = document.querySelector(".swiper")
            
            swiper.addEventListener("mousemove" , () => {
                
                const slide = swiper.swiper

                this.activeIndex = slide.activeIndex+1

                if(slide.clickedIndex < slide.activeIndex)
                {
                    this.transformStyle = "" 
                    this.showCardContent = false
                }
                     
            })

            swiper.addEventListener("touchmove" , () => {
                
                const slide = swiper.swiper

                this.activeIndex = slide.activeIndex+1
        
                if(slide.clickedIndex < slide.activeIndex)
                {
                    this.transformStyle = "" 
                    this.showCardContent = false
                }
            })
        },
        updated()
        {
            const swiper = document.querySelector(".swiper")

            swiper.addEventListener("touchend" , () => {
                
                const slide = swiper.swiper
                
                if(slide.clickedIndex < slide.activeIndex)
                {          
                    slide.allowSlideNext = false    
                }
            })
             
        },
        /* eslint-disable */
        methods:
        {
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
                swiper.allowSlideNext = true
                this.isFlipped = true

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
            }
        
        },
       
      
    };
  </script>

<style scoped>
.swiper 
{
  width: 240px;
  height: 320px;
  position: fixed;

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

.msg
{
    display: flex;
    justify-content: center;
    flex-direction: column;
    position: fixed;
    text-align: center;
    top: 70px;
    font-size: 20px;
    color:#441d1d;
    background-color: white;
}
.msg img 
{
    height: 50px;
    width: 50px;
    margin: auto;
}
.msg span
{
    margin-top: 10px;
}
.msg .btnWrapper
{
    display: flex;
    justify-content: center;
    margin-top: 10px;
}
.msg .btnWrapper Button
{
    width: 150px;
    padding: 5px;
    margin: 10px 5px;
    border-radius: 10px;
    font-size: 18px;
    background-color: #441d1d;
    color: #ccc661;
}
.backToMenu
{
    position: fixed;
    bottom: 1%;
    display: flex;
    justify-content: center;
    
}
.backToMenu Button
{
    background-color: #441d1d;
    color: #ccc661;
    width: 180px;
    height: 40px;
    padding: 6px 25px;
    font-size: 20px;
    border-radius: 10px;
}


</style>