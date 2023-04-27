<template>
    <div class="container">
        <div class="on" v-if="soundIcon">
            <button @click="muteSound()">
                <img src="../assets/iconmonstr-audio-7-240.png" loading="lazy">
            </button>
        </div>
        <div class="off" v-else>
            <button @click="muteSound()">
                <img src="../assets/iconmonstr-audio-11-240.png" loading="lazy">
            </button>
        </div>
    </div>
</template>

<script>

    export default 
    {
        name: "item-sound",
        data()
        {
            return{
                soundIcon: false,
                audio: new Audio()
            }
        },
        mounted()
        {
            if(localStorage.getItem("sound") === "true")
            {
                this.soundIcon = true
            }else
            {
                this.soundIcon = false
            }
        },
        
        methods:
        {
            muteSound()
            {
                this.soundIcon = !this.soundIcon
           
                if(!JSON.parse(localStorage.getItem("sound")))
                { 
                    this.playAudio(require('@/assets/Pisco Sour.mp3'))
                    localStorage.setItem("sound", true)
                }else
                {
                    this.pauseAudio()
                    localStorage.setItem("sound", false)
                }    
            },

            playAudio(url) 
            {
                this.audio.src = url;
                this.audio.play();
            },

            pauseAudio() 
            {
                this.audio.pause();
            }
        }
    }
</script>

<style lang="scss" scoped>
button
{
    border: none;
    background: none;
}
img
{
    height: 35px;
}
@media(max-height: 568px)
{
    img
    {
        height: 25px;
    }
}
</style>