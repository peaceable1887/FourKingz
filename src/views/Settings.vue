<template>
    <h2>Karten selbst belegen</h2>
    <form @submit.prevent="onSubmit">   
        <label for="king">König:</label><br>
        <input type="text" id="king" name="king" v-model="king" required><br><br>
        <label for="queen">Dame:</label><br>
        <input type="text" id="queen" name="queen" v-model="queen" required><br><br>
        <label for="boy">Bube:</label><br>
        <input type="text" id="boy" name="boy" v-model="boy" required><br><br>
        <label for="ace">Ass:</label><br>
        <input type="text" id="ace" name="ace" v-model="ace" required><br><br>
        <label for="ten">Zehn (10):</label><br>
        <input type="text" id="ten" name="ten" v-model="ten" required><br><br>
        <label for="nine">Neun (9):</label><br>
        <input type="text" id="nine" name="nine" v-model="nine" required><br><br>
        <label for="eight">Acht (8):</label><br>
        <input type="text" id="eight" name="eight" v-model="eight" required><br><br>
        <label for="seven">Sieben (7):</label><br>
        <input type="text" id="seven" name="seven" v-model="seven" required><br><br>
        <div class="btnWrapper">
            <router-link to="/">
                <input type="submit" value="Zurück">
            </router-link>
            <input type="submit" value="Speichern">
        </div>   
    </form>
</template>

<script>
    export default 
    {
        name: "item-settings",
        data()
        {
            return{
                king: "",
                queen: "",
                boy: "",
                ace: "",
                ten: "",
                nine: "",
                eight: "",
                seven: "",
            }
        },
        methods:
        {
            onSubmit()
            {
                //eingabelänge noch abfangen
                localStorage.setItem("king", this.king)
                localStorage.setItem("queen", this.queen)
                localStorage.setItem("boy", this.boy)
                localStorage.setItem("ace", this.ace)
                localStorage.setItem("ten", this.ten)
                localStorage.setItem("nine", this.nine)
                localStorage.setItem("eight", this.eight)
                localStorage.setItem("seven", this.seven)
            },
        }
    }
</script>

<style lang="scss" scoped>
h2
{
    font-family: Impact, Regular;
    background-color: #ccc661;
    color: #441d1d;
    position: absolute;
    top:0;
    width: 100%;
    margin: 0;
    padding: 10px;
    font-size: 20px;
    text-align: center;
    box-shadow: 0px 0.5px 5px 0px rgba(0,0,0,0.75);
    -webkit-box-shadow: 0px 0.5px 5px 0px rgba(0,0,0,0.75);
    -moz-box-shadow: 0px 0.5px 5px 0px rgba(0,0,0,0.75);
}
form
{
    width: 100%;
    margin: 15px 0 0 0;
}
label
{
    color: #441d1d;
    font-size: 18px;
}
.btnWrapper
{
    display:flex;
    flex-direction: row;
    justify-content: space-between;
}
input
{
    width: 98%;
    height: 20px;
}
input[type=submit]
{
    margin: 5px 0 0 0 ;
    width: 150px;
    height: 40px;
    background-color: #ccc661;
    color: #441d1d;
    border: none;
    font-family: Impact, Regular;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    cursor: pointer;
    padding: 6px 25px;
    font-size: 20px;
    border-radius: 10px;
}
input[type=submit]:hover
{
    background-color: #441d1d;
    color: #ccc661;
}
</style>