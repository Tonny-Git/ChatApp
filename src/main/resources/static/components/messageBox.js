export default {
    template: `
        <div>
            <button @click="onClick">Delete Message</button>
        </div>
    `,
    data() {
        return {

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