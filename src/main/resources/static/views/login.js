import loginForm from '../components/loginForm.js'
import footerComponent from '../components/footerComponent.js'

export default {
    components: {
        loginForm,
        footerComponent
    },
    template: `
        <div class="home-container">
            <div class="home">
                <loginForm/>
                <div class="take-space-div"></div>
            </div>
            <footerComponent/>
        </div>
    `
}