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
            buttonText: "Login"
        }
    },
    methods: {
        onButtonClick() {
            this.login = !this.login
            this.buttonText = this.login ? "Login" : "Cancel"
        }
    }
}