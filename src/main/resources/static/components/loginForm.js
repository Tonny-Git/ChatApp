export default {
    template: `
        <form @submit.prevent="login">
            <div class="sign-up-text">
                <h2>Login</h2>
            </div>
            <input class="normal-input" type="text" v-model="username" placeholder="Enter your username...">
            <input class="normal-input" type="password" v-model="password" placeholder="Enter your password...">
            <button class="button">Submit</button>
        </form>
    `,
    data() {
        return {
            username: '',
            password: ''
        }
    },
    methods: {
        async login() {
            console.log('Hello')
            const credentials = 'username=' + encodeURIComponent(this.username)
            + '&password=' + encodeURIComponent(this.password)

            let response = await fetch("/login", {
                method: "POST",
                headers: { "Content-Type": "application/x-www-form-urlencoded" },
                body: credentials
            });

            if(response.url.includes('error')) {
                console.log('Wrong username/password');
            } else {
                let user = await fetch('/auth/whoami')
                user = await user.json()
                this.$store.commit('setCurrentUser', user)
                this.$router.push('/')
            }

            /*
            //Test.. Continue here
            let user = {
                username: this.username,
                password: this.password
            }

            let result = await fetch('/rest/users/login', {
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
            */
        }

    }
}