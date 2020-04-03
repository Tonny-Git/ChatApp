export default {
    template: `
        <div>
            <button>Delete Message</button>
        </div>
    `,
    data() {

    },
    methods: {
        onClick() {
            let response = await fetch('/rest/messages', {
                method: 'Delete',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(newMessage)
            })
        }
    }
}