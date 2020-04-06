export default {
    template: `
        <div>
            <div v-for="message in messages">
                <p>{{message.message}}</p>
            </div>
            <button @click="onClick">Delete Message</button>
        </div>
    `,
    computed: {
        async showMessages() {
            if(this.$store.state.currentChannel === null) {

            } else {
                
                let response = await fetch('/rest/messages' + this.$store.state.currentChannel.id)
    
                messages = response = await response.json()
            }
        }
    },
    data() {
        return {
            messages: {}
        }
    },
    methods: {
        async onClick() {
            let id = 4
            document.getElementsByClassName()

            let response = await fetch('/rest/messages/' + id, {
                method: 'Delete'
            })
        }
    }
}