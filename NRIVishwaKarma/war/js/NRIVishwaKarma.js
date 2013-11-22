'use strict';
var app = angular.module("NRIVishwaKarma", ['$strap.directives','imageupload']).config(function($routeProvider) {
	$routeProvider.when("/Home", {
		templateUrl: "pages/home.html",
		controller: "homeCtrl"
	})
	.when("/NewUser", {
		templateUrl: "pages/newUser.html",
		controller: "newUserCtrl"
	})
	.when("/ProfileInformation", {
		templateUrl: "pages/userDescriptions.html",
	})
	.when("/News", {
		templateUrl: "pages/news.html",
		controller: "newsCtrl"
	})
	.when("/Wall", {
		templateUrl: "pages/wall.html",
		controller: "wallCtrl"
	})
	.when("/Profile", {
		templateUrl: "pages/profile.html",
		controller: "profileCtrl"
	})
	.otherwise({redirectTo: '/Home'});
});

app.controller("NRIVishwaKarmaCtrl", function($scope) {
	
});