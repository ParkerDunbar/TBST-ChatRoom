"use strict";

var Chat = Chat || {};
Chat.connect = function(host) {
	if ('WebSocket' in window) {
		Chat.socket = new WebSocket(host);
	} else if ('MozWebSocket' in window) {
		Chat.socket = new MozWebSocket(host);
	}

	Chat.socket.onopen = function() {
		Chat.sendJoinMessage();
		Chat.sendGetMessageList();
	}// happens wwhen connetion is astablished
	Chat.socket.onclose = function() {
	}// happens when connection is closed
	Chat.socket.onmessage = function() {
		
	}// happends when resived a message
}
Chat.sendMessage = function() {
	
	Chat.socket.send();
}// set upt chat message
Chat.sendJoinMessage = function()// set up join message
{
}
Chat.sendGetMessageList = function()// set up get message list
{
}
Chat.initialize = function() {
	var ep = '/SmallChatRoom/endpoint';
	if (window.location.protocol == 'http:') {
		Chat.connect('ws://' + window.location.host + ep);
	} else {
		connect('wss://' + window.location.host + ep);
	}
};

Chat.initialize();
