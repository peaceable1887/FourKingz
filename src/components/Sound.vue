<template>
    <div class="container">
        <div class="on" v-if="soundOn">
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
                soundOn: false,
                audio: new Audio()
            }
        },
        methods:
        {
            muteSound()
            {
                this.soundOn = !this.soundOn;

                if(this.soundOn)
                { 
                    this.playAudio(require('@/assets/Pisco Sour.mp3'))
                }else
                {
                    this.pauseAudio()
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
</style>