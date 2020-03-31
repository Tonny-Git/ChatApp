export default {
    template: `
      <div id="app">
        <nav>
          <router-link to="/">Home</router-link>
          <router-link to="/chatapp">Chat App</router-link>
        </nav>
  
        <main>
          <router-view />
        </main>
      </div>
    `,
    async created() {
      let user = await fetch('/auth/whoami')

      try {
        user = await user.json()
        console.log(user)
      } catch {
        console.log('Client not auth')
      }
    }
  }