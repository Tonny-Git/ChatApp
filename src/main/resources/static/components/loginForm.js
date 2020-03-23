export default {
    template: `
        <form @prevent.default="">
            <input type="text" v-model="username" placeholder="Enter your username...">
            <input type="password" v-model="password" placeholder="Enter your password...">
            <button>Submit</button>
        </form>
    `,
    data() {
        return {
            username: '',
            password: ''
        }
    },
    methods: {
        async Login() {
            //Test.. Continue here
            let user = {
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

            this.$store.commit('setCurrentUser', result)

            this.username = ''
            this.password = ''
        }

    }
}