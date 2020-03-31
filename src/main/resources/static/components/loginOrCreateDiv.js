export default {
    template: `
        <div>
            <a class="button" @click="onButtonClick">{{buttonTest}}</a>
            <router-link v-if="!isCurrentUser" class="button" to="/signup">Create new account</router-link>
        </div>
    `,
    computed: {
        buttonTest() {
            if(this.$store.state.currentUser === null) {
                this.isCurrentUser = false;
                return "Login";
            } else {
                this.isCurrentUser = true;
                return "Logout";
            }
        }
    },
    data() {
        return {
            isCurrentUser: false
        }
    },
    created() {
        //<button class="button" @click="onButtonClick">{{buttonText}}</button
    },
    methods: {

        //Fix to work
        onButtonClick() {
            if(this.isCurrentUser) {
                //console.log("There is an user! " + + this.$store.state.currentUser)
                console.log(this.isCurrentUser)
            } else {
                //this.$router.push('/login')
                console.log(this.isCurrentUser)
            }
        }
    }
}