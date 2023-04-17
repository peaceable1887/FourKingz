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
                soundOn: true,
            }
        },
        methods:
        {
            muteSound()
            {
                let beat = new Audio();
                beat.play();
                    
                this.soundOn = !this.soundOn;
              
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