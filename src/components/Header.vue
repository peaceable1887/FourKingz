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
    height: 40px;  
    width: 40px;
    border: none;
    -webkit-box-shadow: none;
            box-shadow: none;
}
Button:active
{
    -webkit-transform: scale(.98);
        -ms-transform: scale(.98);
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
        font-size: 20px;
    }
    Button
    {
        background-size: 30px 30px;
        height: 30px;  
        width: 30px;
    }
}

</style>