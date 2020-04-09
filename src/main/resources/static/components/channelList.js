export default {
	template: `
	
	<div style="padding: 15px;">
	<h3>Other Channels:</h3>
	<div v-for="(otherChannel, i) in allChannels" :key="otherChannel.id">
				<h4>{{otherChannel.title}}</h4>
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
	},
};
