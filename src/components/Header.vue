<template>
    <div class="container">
        <div class="row">
            <div class="col">
                <div class="box">
                    <Button @click="$emit('atClickArrow')"></Button>
                </div>
            </div>
            <div class="col">
                <div class="box-text">
                    {{text}}
                </div>
            </div>
            <div class="col">
                <div class="box">
                  
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import Button from "../components/Button.vue";

    export default 
    {
        name: "item-header",
        emits:["atClickArrow"],
        components:
        {
            Button,
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
    font-size: 20px;
    font-weight: bold;
}
Button
{
    background: url("../assets/iconmonstr-arrow-left-lined-240.png") no-repeat;
    background-size: 40px 40px;
    height: 40px;  
    width: 40px;
    border: none;
}
</style>