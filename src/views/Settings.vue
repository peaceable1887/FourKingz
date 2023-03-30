<template>
    <h2>Karten selbst belegen</h2>
    <form @submit.prevent="onSubmit">
        <label for="king">König:</label><br>
        <input type="text" id="king" name="king" v-model="king" v-on:keypress="regexPattern($event)" required><br><br>
        <label for="queen">Dame:</label><br>
        <input type="text" id="queen" name="queen" v-model="queen" v-on:keypress="regexPattern($event)" required><br><br>
        <label for="boy">Bube:</label><br>
        <input type="text" id="boy" name="boy" v-model="boy" v-on:keypress="regexPattern($event)" required><br><br>
        <label for="ace">Ass:</label><br>
        <input type="text" id="ace" name="ace" v-model="ace" v-on:keypress="regexPattern($event)" required><br><br>
        <label for="ten">Zehn (10):</label><br>
        <input type="text" id="ten" name="ten" v-model="ten" v-on:keypress="regexPattern($event)" required><br><br>
        <label for="nine">Neun (9):</label><br>
        <input type="text" id="nine" name="nine" v-model="nine" v-on:keypress="regexPattern($event)" required><br><br>
        <label for="eight">Acht (8):</label><br>
        <input type="text" id="eight" name="eight" v-model="eight" v-on:keypress="regexPattern($event)" required><br><br>
        <label for="seven">Sieben (7):</label><br>
        <input type="text" id="seven" name="seven" v-model="seven" v-on:keypress="regexPattern($event)" required><br><br>
        <div class="btnWrapper">
            <router-link to="/">
                <input type="submit" value="Zurück">
            </router-link>
            <input type="submit" value="Speichern">
        </div>   
    </form>
    <div id="snackbar">Erfolgreich gespeichert</div>
</template>

<script>
    export default 
    {
        name: "item-settings",
        data()
        {
            return{
                king: null,
                queen: null,
                boy: null,
                ace: null,
                ten: null,
                nine: null,
                eight: null,
                seven: null,
            }
        },
        methods:
        {
            regexPattern(e) 
            {
                let char = String.fromCharCode(e.keyCode);
                if(/^[A-Za-z0-9\s\\?]+$/.test(char)) return true; 
                else e.preventDefault(); 
            },
           
            onSubmit()
            {

                if (this.king && this.queen && this.boy && this.ace 
                && this.ten && this.nine && this.eight && this.seven)  
                {
                    localStorage.setItem("king", this.truncate(this.king))
                    localStorage.setItem("queen", this.truncate(this.queen))
                    localStorage.setItem("boy", this.truncate(this.boy))
                    localStorage.setItem("ace", this.truncate(this.ace))
                    localStorage.setItem("ten", this.truncate(this.ten))
                    localStorage.setItem("nine", this.truncate(this.nine))
                    localStorage.setItem("eight", this.truncate(this.eight))
                    localStorage.setItem("seven", this.truncate(this.seven))

                    this.sucMsg()
                }
                
            },
            
            sucMsg()
            {
                let x = document.getElementById("snackbar");
                x.className = "show";
                setTimeout(function(){ x.className = x.className.replace("show", ""); }, 3000);
            },

            truncate(str) 
            {
                return (str.length > 31) ?
                    str.slice(0, 31 - 1) + '…' : str;
            }
        }
    }
</script>

<style lang="scss" scoped>
h2
{
    font-family: Impact, Regular;
    background-color: #ccc661;
    color: #441d1d;
    position: fixed;
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
.errMsg
{
    color: red;
 
}
#snackbar {
  visibility: hidden;
  min-width: 250px;
  margin-left: -125px;
  background-color: #441d1d;
  color: #ccc661;
  text-align: center;
  border-radius: 2px;
  padding: 16px;
  position: fixed;
  z-index: 1;
  left: 50%;
  bottom: 30px;
  font-size: 17px;
}
@media screen and (orientation: landscape) {
    h2 
    {
        background-color: white;
     
        color: #441d1d;
        position: absolute;
        top: 30px;
        box-shadow: none;
        font-size: 26px;
    }
    form
    {
        height: 50%;
    }
    .btnWrapper
    {
        justify-content: space-around;
        padding: 20px;
    }
}

#snackbar.show {
  visibility: visible;
  -webkit-animation: fadein 0.5s, fadeout 0.5s 2.5s;
  animation: fadein 0.5s, fadeout 0.5s 2.5s;
}

@-webkit-keyframes fadein {
  from {bottom: 0; opacity: 0;} 
  to {bottom: 30px; opacity: 1;}
}

@keyframes fadein {
  from {bottom: 0; opacity: 0;}
  to {bottom: 30px; opacity: 1;}
}

@-webkit-keyframes fadeout {
  from {bottom: 30px; opacity: 1;} 
  to {bottom: 0; opacity: 0;}
}

@keyframes fadeout {
  from {bottom: 30px; opacity: 1;}
  to {bottom: 0; opacity: 0;}
}
</style>