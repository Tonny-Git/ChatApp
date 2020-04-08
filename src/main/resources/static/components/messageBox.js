export default {
    template: `
        <div class="message-box-div">
            <div v-for="message in showMessages">
                <p>{{message.sender.username}}: {{message.message}}</p>
            </div>
            <button @click="onClick">Delete Message</button>
        </div>
    `,
    computed: {
        showMessages() {
            if(this.$store.state.currentChannelMessages === null) {
                return {}
            } else {
                return this.$store.state.currentChannelMessages
            }
        }
    },
    methods: {
        async onClick() {
            //Fix later
            let id = 4
            document.getElementsByClassName()

            let response = await fetch('/rest/messages/' + id, {
                method: 'Delete'
            })
        }
    }
}