<template>
    <div class="container">
        <div class="row">
            <div class="col-lg-4 col">
                <div class="box">
                    <Button @click="$emit('atClickArrow')"></Button>
                </div>
            </div>
            <div class="col-lg-4 col">
                <div class="box-text">
                    {{text}}
                </div>
            </div>
            <div class="col-lg-4 col">
                <div class="box-sound">
                    <Sound></Sound>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    //Import required components
    import Button from "../components/Button.vue";
    import Sound from "../components/Sound.vue"

    export default 
    {
        name: "item-header",
        emits:["atClickArrow", "atClickQuestionmark"],
        components:
        {
            Button,
            Sound
        },
        props:
        {
            text: String,
        },
    }
</script>

<style lang="scss" scoped>
.row
{
    padding: 15px 15px;
}

.box-text
{
    text-align: center;
    font-size: 24px;
    color: var(--color-second);
}
.box-sound
{
    padding-top: 2px;
    float: right
}
Button
{
    background: url("../assets/arrow-left-toon.png") no-repeat;
    background-size: 40px 40px;
    height: 40px;  
    width: 40px;
    border: none;
}
Button:active
{
    box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24), 0 17px 50px 0 rgba(0,0,0,0.19);
    transform: scale(.98);
}
@media(max-height: 568px)
{
    .row
    {
        padding: 8px 15px;
    }
    .box-text
    {
        font-size: 18px;
    }
    Button
    {
        background-size: 30px 30px;
        height: 30px;  
        width: 30px;
    }
}

</style>