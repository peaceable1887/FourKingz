<!--   
    Version: 3.2.41
    Auhtor: Felix Hansmann
    
    Die Komponente "Settings.vue" ist für die Darstellung und Anwendungslogik, 
    der Einstellungen zuständig. Hier können die Karten mit frei gewählten Aktionen belegt werden.
-->
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
                <input type="text" id="king" class="form-control form-control-sm" name="king" placeholder="König" v-model="king" v-on:keypress="regexPattern($event)" required>
                <label for="king" class="form-label">König:</label>
                <div class="invalid-feedback">Textfeld darf nicht leer sein.</div>
                <div class="valid-feedback"></div>
            </div>
            <div class="form-floating">
                <input type="text" id="queen" class="form-control form-control-sm" name="queen" placeholder="Dame" v-model="queen" v-on:keypress="regexPattern($event)" required>
                <label for="queen" class="form-label">Dame:</label>
                <div class="invalid-feedback">Textfeld darf nicht leer sein.</div>
                <div class="valid-feedback"></div>
            </div>
            <div class="form-floating">
                <input type="text" id="boy" class="form-control form-control-sm" name="boy" placeholder="Bube" v-model="boy" v-on:keypress="regexPattern($event)" required>
                <label for="boy" class="form-label">Bube:</label>
                <div class="invalid-feedback">Textfeld darf nicht leer sein.</div>
                <div class="valid-feedback"></div>
            </div>
            <div class="form-floating">
                <input type="text" id="ten" class="form-control form-control-sm" name="ten" placeholder="Zehn (10)" v-model="ten" v-on:keypress="regexPattern($event)" required>
                <label for="ten" class="form-label">Zehn (10):</label>
                <div class="invalid-feedback">Textfeld darf nicht leer sein.</div>
                <div class="valid-feedback"></div>
            </div>
            <div class="form-floating">
                <input type="text" id="nine" class="form-control form-control-sm" name="nine" placeholder="Neun (9)" v-model="nine" v-on:keypress="regexPattern($event)" required>
                <label for="nine" class="form-label">Neun (9):</label>
                <div class="invalid-feedback">Textfeld darf nicht leer sein.</div>
                <div class="valid-feedback"></div>
            </div>
            <div class="form-floating">
                <input type="text" id="eight" class="form-control form-control-sm" name="eight" placeholder="Acht (8)" v-model="eight" v-on:keypress="regexPattern($event)" required>
                <label for="eight" class="form-label">Acht (8):</label>
                <div class="invalid-feedback">Textfeld darf nicht leer sein.</div>
                <div class="valid-feedback"></div>
            </div>
            <div class="form-floating">
                <input type="text" id="seven" class="form-control form-control-sm" name="seven" placeholder="Sieben (7)" v-model="seven" v-on:keypress="regexPattern($event)" required>
                <label for="seven" class="form-label">Sieben (7):</label>
                <div class="invalid-feedback">Textfeld darf nicht leer sein.</div>
                <div class="valid-feedback"></div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col">
                        <input class="btn" @click="clearCardActionValue()" value="Zurücksetzen">
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
                king: localStorage.getItem("king"),
                queen: localStorage.getItem("queen"),
                boy: localStorage.getItem("boy"),
                ace: localStorage.getItem("ace"),
                ten: localStorage.getItem("ten"),
                nine: localStorage.getItem("nine"),
                eight: localStorage.getItem("eight"),
                seven: localStorage.getItem("seven"),
                snackbar: false,
            }
        },
        mounted()
        {
            
            const form = document.querySelector("form")

            //überprüft ob alle Input-Felder, im Formular, belegt sind und Informiert den Nutzer ggf. wenn ein Feld leer ist.
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
            /**
            * Die Methode "backToMenu" leitet die Nutzer zurück auf die Startseite.
            */
            backToMenu()
            {
                this.$router.push("/")
            },    
            
            /**
            * Die Methode "regexPattern" entscheidet welche Eingabe im für das Input-Feld erlaubt ist.
            * 
            * @param e
            */
            regexPattern(e) 
            {
                let char = String.fromCharCode(e.keyCode);
                if(/^[A-Za-z0-9äöüÄÖÜß\s\\?\\.\\!]+$/.test(char)) return true; 
                else e.preventDefault(); 
            },

            /**
            * Die Methode "onSumbit" prüft ob alle Eingaben getätigt wurden und speichert die in der LocalStorage.
            */
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

            /**
            * Die Methode "truncate" nimmt die Eingabe je Input-Feld entgegen 
            * und schneidet den Text ab einer größe von 60 Zeichen ab.
            * 
            * @param str
            */
            truncate(str) 
            {
                return (str.length > 61) ?
                    str.slice(0, 61 - 1) + '…' : str;
            }, 

            /**
            * Die Methode "clearCardActionValue" leert den LocalenStorage, 
            * wenn die Nutzer auf den Button "Zurücksetzen" klicken.
            */
            clearCardActionValue()
            {
                let keysToRemove = ["king", "queen","boy", "ace","ten", "nine", "eight", "seven"]

                keysToRemove.forEach(key => localStorage.removeItem(key))
                window.location.href = '/settings';
            },
        }
    }
</script>

<style lang="scss" scoped>
.settings
{
    padding: 0;
}
.row
{
    text-align: center;
}
form
{
    height: 600px;
    overflow: scroll;
}
.form-floating
{
    margin:  0 12px 15px 12px;
}
.invalid-feedback
{
    color: var(--color-second);
}
.btn
{
    width: 150px;
    background-color: var(--color-second);
    color: var(--color-main);
    margin: 15px 0 30px 0;
    font-size: 20px;
}
.btn:hover
{
    background-color: var(--color-second);
    color: var(--color-main);
}
@media(max-height: 568px)
{
    form
    {
        height: 400px;
    }
    .btn
    {
        width: 120px;
        font-size: 16px;
    }
}

</style>