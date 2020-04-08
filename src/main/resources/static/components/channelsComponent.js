//Not being used
import messages from "./messages.js";

export default {
	components: {
		messages
	},
	template: `
  <div class="channelComponent">
    <div class="headerCard" v-if="hasJoinedChannels()">
      <h2 class="channelNameHeader">{{ channel.name }}</h2>
      <button class="leaveChannelButton" @click="leaveChannel" v-if="channel.adminid != currentUser.id">Leave channel</button>
      <button class="goToAdminWindow" @click="goToAdminWindow" v-if="isAdmin()">Administre</button>
    </div>
   </div>
  `,

	data() {
		return {
			adminWindowOpen: false,
			channelId: ""
		};
	},

	computed: {
		channel() {
			return this.$store.state.currentChannel;
		},
		allChannels() {
			return this.$store.state.channels;
		},
		userChannels() {
			return this.$store.state.userChannels;
		},
		users() {
			return this.$store.state.users;
		},
		online() {
			return this.$store.state.onlineUsers;
		},
		currentUser() {
			return this.$store.state.currentUser;
		},
		offline() {
			return this.users.filter((user) => user.online === false);
		},
		allUserChannels() {
			return this.$store.state.allUserChannels;
		}
	},
	methods: {
		hasJoinedChannels() {
			if (this.userChannels.length > 0) {
				return true;
			} else return false;
		},

		isAdmin() {
			if (
				this.currentUser.id === this.channel.adminid &&
				this.channelId === this.channel.id
			) {
				return true;
			} else {
				this.channelId = this.channel.id;
				this.adminWindowOpen = false;
				return false;
			}
		},

		goToAdminWindow() {
			if (!this.adminWindowOpen) {
				this.adminWindowOpen = true;
			} else this.adminWindowOpen = false;
		},

		async leaveChannel() {
			const srvMsg = this.currentUser.username + " ...Has left!";

			const newServerMessage = {
				message: srvMsg,
				channel_id: this.channel.id,
				time: Date.now()
			};

			try {
				await fetch("/rest/messages", {
					method: "POST",
					headers: {
						"Content-Type": "application/json"
					},
					body: JSON.stringify(newServerMessage)
				});
			} catch (error) {
				console.log(error);
			}

			const userChannelToDelete = {
				channel_id: this.channel.id,
				user_id: this.currentUser.id
			};

			try {
				await fetch("/rest/userxchannel", {
					method: "DELETE",
					headers: {
						"Content-Type": "application/json"
					},
					body: JSON.stringify(userChannelToDelete)
				});
			} catch (error) {
				console.log(error);
			}
		}
	},

	mounted() {
		this.channelId = this.channel.id;
	}
};
