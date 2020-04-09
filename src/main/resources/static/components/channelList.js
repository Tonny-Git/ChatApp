export default {
	template: `
		<div style="padding: 15px;">
		<h3>Other Channels:</h3>
			<div v-for="(otherChannel, i) in allChannels" :key="otherChannel.id" class="channel-name-div">
				<h4>{{otherChannel.title}}</h4>
				<button @click="onClickJoinChannel(i)">Join</button>
			</div>
		</div>
    `,
	computed: {
		allChannels() {
			if (this.$store.state.otherChannels === null) {
				return {};
			} else {
				return this.$store.state.otherChannels;
			}
		},
	},
	methods: {
		async goToChannel(channel) {
			if (!this.userChannels.includes(channel))
				this.addChannelToUserChannels(channel);
			this.$store.commit("setCurrentChannel", channel);
		},

		otherChannels() {
			return true;
		},
		isChannelJoined(channelId) {
			let isItJoined = true;

			for (let channel of this.userChannels) {
				if (channel.id === channelId) {
					isItJoined = false;
					break;
				}
			}
			return isItJoined;
		},
		async onClickJoinChannel(i) {
            let userChannelRelation = {
                userId: this.$store.state.currentUser.id,
                channelId: this.$store.state.otherChannels[i].id
            }
            let response = await fetch('/rest/relation', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(userChannelRelation)
            })
        }
	},
};
