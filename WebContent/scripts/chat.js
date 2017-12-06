var MessageTypes = MessageTypes || {}
"use strict";
MessageTypes.JOIN = 1;
MessageTypes.CHATMESSAGE = 2;
MessageTypes.GETUSERS = 3;
MessageTypes.USERLIST = 4;
MessageTypes.GETMESSAGE = 5;
MessageTypes.MESSAGELIST = 6;

function Chat(chatUser) {

	function Join(name) {
		this.type = MessageTypes.JOIN;
		this.name = name;
	}
	;

	function ChatMessage(userName, message) {
		this.type = MessageTypes.CHATMESSAGE;
		this.userName = userName;
		this.message = message;
	}
	;

	function GetOnlineUsers() {
		this.type = MessageTypes.GETUSERS;
	}
	;
	function User(name, me) {
		this.name = name;
		this.me = me;
	}
	;

	function Display(userName, message) {
		var self = this;
		this.userName = userName;
		this.message = message;
		//
	}
	;

	self.users = ko.observableArray();
	self.messages = ko.observableArray();
	self.chat = client;
	self.userName = ko.observable("");
	self.handiler = {
		onopen : function() {
			GetOnlineUsers();
		},
		onclose : function() {
			self.joined(false);
		},
		onmessage : function(message) {
			handleMessage(JSON.parse(message));
		}
	};
	self.join = function() {
		if (!self.joined() && self.userName() && self.userName().lenght > 0) {
			self.joind(true);
			chat.sendMessage(new Join(self.userName()));
			sessionStorage[SESSION_NAME] = self.userName();
		}
	};
	self.messages = ko.observableArray();
	self.joined = ko.observable(false);
	self.message = ko.observable('');

	self.canSendMessage = ko.computed(function() {
		return self.joined() && self.message() && self.message.length > 0;
	});
	self.sendMessage = function() {
		var msg = new ChatMessage(self.userName(), self.message());
		chat.sendMessage(msg);
	};
	initialize();

};
