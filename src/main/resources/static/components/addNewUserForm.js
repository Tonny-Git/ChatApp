export default {
    template: `
        <form @submit.prevent="submitNewUser">
            <input type="text" v-model="firstName" required placeholder="Enter your first name...">
            <input type="text" v-model="lastName" required placeholder="Enter your last name...">
            <input type="text" v-model="email" required placeholder="Enter your email...">
            <input type="text" v-model="username" required placeholder="Enter your username...">
            <input type="text" v-model="password" required placeholder="Enter your password...">
            <button>Submit</button>
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
                password: this.password
            }

            let result = await fetch('/rest/users', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(user)
            })

            result = await result.json()

            //add to store?

            this.firstName = ''
            this.lastName = ''
            this.email = ''
            this.username = ''
            this.password = ''
        }
    }
}