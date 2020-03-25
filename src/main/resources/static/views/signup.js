import addNewUserForm from '../components/addNewUserForm.js'
import footerComponent from '../components/footerComponent.js'

export default {
    components: {
        addNewUserForm,
        footerComponent
    },
    template: `
        <div class="home-container">
            <addNewUserForm/>
            <footerComponent/>
        </div>
    `
}