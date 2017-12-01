"use strict";
const textArea = document.getElementById('messagelist');
function shouldScroll() {
	var needToScroll = textArea.scrollTop + textArea.clientHeight === textArea.scrollHeight;
	if (!needToScroll) {
		scrollToBottom();
	}
}
function scrollToBottom() {
	textArea.scrollTop = textArea.scrollHeight;
}

var Chat = Chat || {};

Chat.sendMessage = function() {
	var userName = document.getElementById('userName').textContent;
	var text = $('#usertextentry');
	var msg = userName.trim() + ': ';
	var message = msg.concat(text.val());
	if (message != '') {
		console.log(message);
		Chat.socket.send(message);
		text.val('');
	}

};

Chat.sendJoinMessage = function() {
	var userName = document.getElementById('userName').textContent;
	var message = userName.trim() + " Has Joined The Chat Room";
	Chat.socket.send(message);
}

Chat.connect = function(host) {
	if ('WebSocket' in window) {
		Chat.socket = new WebSocket(host);
	} else if ('MozWebSocket' in window) {
		socket = new MozWebSocket(host);
	} else {
		console.log('Error: WebSocket is not supported by this browser.');
		return;
	}

	Chat.socket.onopen = function() {
		console.log("Info: connection opened");
		Chat.sendJoinMessage();
		$('#usertextentry').keydown(function(evt) {
			if (evt.keyCode == 13) {
				Chat.sendMessage();
			}
		});
	};

	Chat.socket.onclose = function() {
		console.log("Info: connection closed");
	};

	Chat.socket.onmessage = function(message) {
		console.log("message: " + message.data);
		shouldScroll();
		$('#messagelist').text(message.data);
	};

};

Chat.initialize = function() {
	var ep = '/endpoint';
	if (window.location.protocol == 'http:') {
		Chat.connect('ws://' + window.location.host + ep);
	} else {
		Chat.connect('wss://' + window.location.host + ep);
	}
};

Chat.initialize();
