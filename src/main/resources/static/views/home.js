import loginOrCreateDiv from '../components/loginOrCreateDiv.js'
import loginForm from '../components/loginForm.js'
import footerComponent from '../components/footerComponent.js'

export default {
    components: {
        loginOrCreateDiv,
        loginForm,
        footerComponent
    },
    template: `
        <div class="home-container">
            <div class="home">
                <div>
                    <h1>Welcome to chatapp!</h1>
                </div>
                <div class="submit-div">
                    <loginForm v-if="!login"/>
                    <button class="button" @click="onButtonClick">{{buttonText}}</button>
                    <loginOrCreateDiv v-if="login"/>
                </div>
                <div class="take-space-div"></div>
            </div>
            <footerComponent/>
        </div>
    `,
    data() {
        return {
            login: true,
            buttonText: "Login",
            isCurrentUser: false
        }
    },
    methods: {
        onButtonClick() {
            this.login = !this.login
            this.buttonText = this.login ? "Login" : "Cancel"

            this.checkIfUserIsLoggedIn()
            if(this.isCurrentUser) {
                console.log("There is an user!")
            } else {
                console.log("There not an user: " + this.$store.state.currentUser)
            }
        },
        checkIfUserIsLoggedIn() {
            if(this.$store.state.currentUser === null) {
                this.isCurrentUser = false;
            } else {
                this.isCurrentUser = true;
            }
        }
    },
}