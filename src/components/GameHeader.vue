<template>
    <table v-if="portait">
        <tr>
            <th>
                <Button @click="$emit('overlay')"></Button>
            </th>
            <th>Restkarten: <span>{{ cards }}</span></th>
            <th>Könige: <span>{{ kings }}</span></th>
        </tr>
    </table>
    <div class="landscapeContent" v-if="!portait">
        <div class="cardCount">
            Restkarten: <span>{{ cards }}</span>
            Könige: <span>{{ kings }}</span>
        </div>
       <div class="btnWrapper" @click="$emit('overlay')">
            <Button ></Button>
            <span>Beenden</span>
       </div>    
    </div>
</template>

<script>
import Button from "../components/Button.vue";
    export default 
    {
        name: "item-header",
        emits:["overlay"],
        components:
        {
            Button,
        },
        props:
        {
            cards: String,
            kings: String,
        },
        data()
        {
            return{
                portait: Boolean,
            }
        },
        created()
        {
            const portrait = window.matchMedia("(orientation: portrait)").matches

            if(portrait)
            {
                this.portait = true
            }else
            {
                this.portait = false
            }
        },
        mounted()
        {
            window.matchMedia("(orientation: portrait)").addEventListener("change", e =>
            {
                const portrait = e.matches;

                if(portrait)
                {
                    this.portait = true
                }else
                {
                    this.portait = false
                }
            });
        },
    }
    
</script>

<style lang="scss" scoped>
table
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
    box-shadow: 0px 0.5px 5px 0px rgba(0,0,0,0.75);
    -webkit-box-shadow: 0px 0.5px 5px 0px rgba(0,0,0,0.75);
    -moz-box-shadow: 0px 0.5px 5px 0px rgba(0,0,0,0.75);
}

span
{
    color: black;
}
Button
{
    background: url("../assets/iconmonstr-door-6-240.png");
    background-size: 30px 30px;
    height: 30px;  
    width: 30px;
    border: none;
    margin: auto;
}

.landscapeContent
{
    position: fixed;
    left: 30px;
    bottom: 30px;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    height: 80%;
    font-size: 20px;
}
.landscapeContent .btnWrapper
{
    display: flex;
    justify-content: center;
    flex-direction: column;
    text-decoration: none;
    color:#441d1d;
    align-items: center;
}
.cardCount
{
    display: flex;
    flex-direction: column;
    align-items: center;
    color: #441d1d;
}
.cardCount span
{
    padding: 20px 0;
}
.landscapeContent .btnWrapper Button
{
    background-size: 50px 50px;
    height: 50px;  
    width: 50px;
}
.landscapeContent .btnWrapper span
{
    color:#441d1d;
    font-size: 18px;
}
@media screen and (orientation: landscape) {
    table 
    {
        position: fixed;
        z-index: 10;
    }
}

</style>