import loginOrCreateDiv from '../components/loginOrCreateDiv.js'
import loginForm from '../components/loginForm.js'

export default {
    components: {
        loginOrCreateDiv,
        loginForm
    },
    template: `
        <div>
            <h1>Start Page</h1>
            <loginOrCreateDiv v-if="login"/>
            <loginForm v-else/>
            <button @click="onButtonClick">{{buttonText}}</button>
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