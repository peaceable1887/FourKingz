<template>
    <img src="../assets/transparent_logo.png">
    <div class="btnWrapper">
        <router-link to="/game">
            <Button text="Spiel starten"></Button>
        </router-link>
        <router-link to="/">
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
        Button
    }
}
</script>

<style scoped>
img
{
    height: 250px;
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
    padding: 15px 40px;
    font-size: 30px;
    border-radius: 10px;
}
</style>