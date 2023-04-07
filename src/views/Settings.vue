<template>
    <Header class="settings" @atClickArrow="backToMenu()" text="Einstellungen"></Header>
    <div class="container">
        <form @submit.prevent="onSubmit" novalidate>
            <div class="form-floating">
                <input type="text" id="ace" class="form-control form-control-sm" name="ace" placeholder="Ass" v-model="ace" v-on:keypress="regexPattern($event)" required>
                <label for="ace" class="form-label">Ass:</label>
                <div class="invalid-feedback">Textfeld darf nicht leer sein.</div>
                <div class="valid-feedback"></div>
            </div>
            <div class="form-floating">
                <input type="text" id="king" class="form-control form-control-sm" name="king" v-model="king" v-on:keypress="regexPattern($event)" required>
                <label for="king" class="form-label">König:</label>
                <div class="invalid-feedback">Textfeld darf nicht leer sein.</div>
                <div class="valid-feedback"></div>
            </div>
            <div class="form-floating">
                <input type="text" id="queen" class="form-control form-control-sm" name="queen" v-model="queen" v-on:keypress="regexPattern($event)" required>
                <label for="queen" class="form-label">Dame:</label>
                <div class="invalid-feedback">Textfeld darf nicht leer sein.</div>
                <div class="valid-feedback"></div>
            </div>
            <div class="form-floating">
                <input type="text" id="boy" class="form-control form-control-sm" name="boy" v-model="boy" v-on:keypress="regexPattern($event)" required>
                <label for="boy" class="form-label">Bube:</label>
                <div class="invalid-feedback">Textfeld darf nicht leer sein.</div>
                <div class="valid-feedback"></div>
            </div>
            <div class="form-floating">
                <input type="text" id="ten" class="form-control form-control-sm" name="ten" v-model="ten" v-on:keypress="regexPattern($event)" required>
                <label for="ten" class="form-label">Zehn (10):</label>
                <div class="invalid-feedback">Textfeld darf nicht leer sein.</div>
                <div class="valid-feedback"></div>
            </div>
            <div class="form-floating">
                <input type="text" id="nine" class="form-control form-control-sm" name="nine" v-model="nine" v-on:keypress="regexPattern($event)" required>
                <label for="nine" class="form-label">Neun (9):</label>
                <div class="invalid-feedback">Textfeld darf nicht leer sein.</div>
                <div class="valid-feedback"></div>
            </div>
            <div class="form-floating">
                <input type="text" id="eight" class="form-control form-control-sm" name="eight" v-model="eight" v-on:keypress="regexPattern($event)" required>
                <label for="eight" class="form-label">Acht (8):</label>
                <div class="invalid-feedback">Textfeld darf nicht leer sein.</div>
                <div class="valid-feedback"></div>
            </div>
            <div class="form-floating">
                <input type="text" id="seven" class="form-control form-control-sm" name="seven" v-model="seven" v-on:keypress="regexPattern($event)" required>
                <label for="seven" class="form-label">Sieben (7):</label>
                <div class="invalid-feedback">Textfeld darf nicht leer sein.</div>
                <div class="valid-feedback"></div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col">
                        <input class="btn" value="Zurücksetzen">
                    </div>
                    <div class="col">
                        <input class="btn" type="submit" value="Speichern">
                    </div>
                </div>
            </div>   
        </form>
    </div>
</template>

<script>
import Header from "../components/Header.vue";

    export default 
    {
        name: "item-settings",
        components:
        {
            Header,
        },  
        data()
        {
            return{
                king: "Du musst Trinken.",
                queen: "Alle Frauen müssen trinken!",
                boy: "Alle Männer müssen trinken!",
                ace: "Jeder muss trinken!",
                ten: "Wähle eine Wortgruppe",
                nine: "Klopfen!",
                eight: "Ich packe meinen Koffer",
                seven: "Schimpfwort",
                snackbar: false,
            }
        },
        mounted()
        {
            const form = document.querySelector("form")

            form.addEventListener("submit", e => {
                if(!form.checkValidity())
                {
                    e.preventDefault()
                }

                form.classList.add("was-validated")
            })
        },
        methods:
        {
            backToMenu()
            {
                this.$router.push("/")
            },          
            regexPattern(e) 
            {
                let char = String.fromCharCode(e.keyCode);
                if(/^[A-Za-z0-9\s\\?\\.\\!]+$/.test(char)) return true; 
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

                    this.snackbar = true
                    localStorage.setItem("snackbar", this.snackbar)
                    window.location.href = '/';
                }
                
            },
            truncate(str) 
            {
                return (str.length > 61) ?
                    str.slice(0, 61 - 1) + '…' : str;
            }
        }
    }
</script>

<style lang="scss" scoped>
.settings
{
    padding: 0;
}
.container
{
    touch-action:pan-y;
}
.form-floating
{
    margin:  0 12px 15px 12px;
}
.invalid-feedback
{
    color: #222847;
}
.btn
{
    font-weight: bold;
    width: 100%;
    background-color: #222847;
    color: #ed9623;
    margin: 15px 0 30px 0;
}

</style>