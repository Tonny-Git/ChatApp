export default {
    template: `
        <form @submit.prevent="submitNewUser" class="home">
            <div class="sign-up-text">
                <h2>Sign up</h2>
                <h3>Please fill in this form to create an account</h3>
            </div>
            <div class="sign-up-form">
                <input type="text" v-model="firstName" required placeholder="Enter your first name...">
                <input type="text" v-model="lastName" required placeholder="Enter your last name...">
                <input type="text" v-model="email" required placeholder="Enter your email...">
                <input type="text" v-model="username" required placeholder="Enter your username...">
                <input type="password" v-model="password" required placeholder="Enter your password...">
                <button class="button">Submit</button>
            </div>
        </form>
    `,
    data() {
        return {
            firstName: '',
            lastName: '',
            email: '',
            username: '',
            password: ''
        }
    },
    methods: {
        async submitNewUser() {
            let user = {
                firstName: this.firstName,
                lastName: this.lastName,
                email: this.email,
                username: this.username,
                password: this.password,
                isActive: true
            }

            let result = await fetch('/rest/users', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(user)
            })

            result = await result.json()

            this.$store.commit('setCurrentUser', result)

            this.firstName = ''
            this.lastName = ''
            this.email = ''
            this.username = ''
            this.password = ''
        }
    }
}