<template>
    <img src="../assets/transparent_logo.png">
    <div class="btnWrapper">
        <router-link to="/game">
            <Button text="Spiel starten"></Button>
        </router-link>
        <router-link to="/settings">
            <Button text="Einstellungen"></Button>
        </router-link>
    </div>
</template>

<script>
import Button from "../components/Button.vue";

export default 
{
    name: "item-menu",
    components:
    {
        Button,
    },
}
</script>

<style scoped>
.menu
{
    height: 100%;
    display: flex;
    justify-content: center;
    align-items: center;
    touch-action: none;
    flex-direction: column;
    margin: 10px;
}
img
{
    height: 200px;
    margin-bottom: 40px;
    top: 0;
}
.btnWrapper
{
    display: flex;
    flex-direction: column;
}
.btnWrapper Button
{
    margin: 20px 30px;
    width: 250px;
    padding: 12px 40px;
    font-size: 26px;
    border-radius: 10px;
}
@media screen and (orientation: landscape) {
    img
    {
        height: 150px;
        margin-bottom: 20px;
        top: 0;
    }
    .btnWrapper Button
    {
        margin: 10px 30px;
        width: 200px;
        padding: 8px 20px;
        font-size: 22px;
        border-radius: 10px;
    }
}
</style>