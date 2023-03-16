<template>
    <swiper
      :effect="'cards'"
      :grabCursor="true"
      :touchStartPreventDefault="false"
      :allowSlidePrev="false"
      :modules="modules"
      class="mySwiper"
    >
        <swiper-slide v-for="card in cards" :key="card" v-slot="{isActive}">
            <Card
            @flip-card="flipped()" 
            :cardName="`${cardsName}`"
            :cardAction="`${cardsAction}`"
            :style="[isActive ? `${this.transformStyle}` : '' ]"
            :class="{card_inner: card_inner, isFlipped: isFlipped}"
            ></Card>
        </swiper-slide>      
    </swiper>
    <div class="msg" v-if="msg">
        <img src="../assets/iconmonstr-check-mark-8-240.png">
        <span class="text">Vierter König wurde gezogen!</span>
        <div class="btnWrapper">
            <router-link to="/">
                <Button text="Hauptmenü"></Button>
            </router-link>
            <a href="/game">
                <Button text="Neu Starten"></Button>
            </a>
        </div>
    </div>
  </template>
  <script>
    // Import Swiper Vue.js components
    import { Swiper, SwiperSlide } from 'swiper/vue';
    // Import Swiper styles
    import 'swiper/css';
    import 'swiper/css/effect-cards';
    // import required modules
    import { EffectCards } from 'swiper';

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
                isOpen: true,
                transformStyle: "",
                activeI: "",
                imageUrl: "",
                cardImg: "",
                currentValue: 0,
                showCardContent: false,
                msg: false,

            }
        },
        computed:
        {
           
        },
        /* eslint-disable */
        mounted()
        {
            const swiper = document.querySelector(".swiper")
            swiper.addEventListener("mousemove" , () => {
                
                const currentSlideProgress = swiper.swiper;
                this.currentValue = Math.floor(currentSlideProgress.progress*1000)
    
                if(this.currentValue != 0 && this.currentValue%(CARD_COUNT/2) === 0 && !(this.currentValue%CARD_COUNT === 0))
                {
                    this.transformStyle = "" 
                    this.showCardContent = false
                }
            })

            swiper.addEventListener("touchmove" , () => {
                
                const currentSlideProgress = swiper.swiper;
                this.currentValue = Math.floor(currentSlideProgress.progress*1000)

                if(this.currentValue != 0 && this.currentValue%(CARD_COUNT/2) === 0 && !(this.currentValue%CARD_COUNT === 0))
                {
                    this.transformStyle = "" 
                    this.showCardContent = false
                } 
                
            })

        },
        /* eslint-disable */
        methods:
        {
            flipped()
            {  
                const swiper = document.querySelector(".swiper").swiper
                console.log(swiper.allowSlideNext)
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
                                this.cardsAction = this.cardsType[0].action
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
                                this.cardsAction = this.cardsType[1].action
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
                                this.cardsAction = this.cardsType[2].action
                                this.cardImg = this.cardsType[2].img
                                this.showCardContent = !this.showCardContent
                                this.cardsType[2].counter++
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
                                this.cardsAction = this.cardsType[3].action
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
                                this.cardsAction = this.cardsType[4].action
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
                                this.cardsAction = this.cardsType[5].action
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
                                this.cardsAction = this.cardsType[6].action
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
                                this.cardsAction = this.cardsType[7].action
                                this.cardImg = this.cardsType[7].img
                                this.showCardContent = !this.showCardContent
                                this.cardsType[7].counter++
                            }else
                            {
                                continue;     
                            }
                            break;
                    }
                    
                    this.isFlipped = false   
                }
            },
        
        }
    };
  </script>

<style scoped>

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

.msg
{
    display: flex;
    justify-content: center;
    flex-direction: column;
    position: absolute;
    text-align: center;
    bottom: 0;
    font-size: 20px;
    color:#2C9113;
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
    padding: 10px;
    margin: 10px 5px;
    border-radius: 10px;
    font-size: 20px;
    background-color: white;
    color: green;
    border: green 1px solid;
}

</style>