var app = angular.module("NRIVishwaKarma", ['ui.bootstrap', 'ngCookies', 'imageupload']).config(function($routeProvider) {
	$routeProvider.when("/Home", {
		templateUrl: "pages/home.html",
		controller: "homeCtrl"
	})
	.when("/Login", {
		templateUrl: "pages/loginEmbedded.html",
		controller: "loginCtrl"
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

app.controller("NRIVishwaKarmaCtrl", function($scope, $rootScope, $modal, $log, $cookies) {
	
	$rootScope.showLoggedInUser = false;
	$rootScope.userEmail = "";
	
	if($cookies.signedIn == "true") {
		$rootScope.showLoggedInUser = true;
		$rootScope.userEmail = $cookies.email;
		$rootScope.profileUser = $rootScope.userEmail;
	}
	
	$scope.openLogin = function () {
		
		var modalInstance = $modal.open({
			templateUrl: 'pages/login.html',
			controller: "modalInstanceCtrl"
		});

		modalInstance.result.then(function (selectedItem) {
			$scope.selected = selectedItem;
		}, function () {
			$log.info('Modal dismissed at: ' + new Date());
		});
	};
	
	$scope.logOut = function() {
		$cookies.signedIn = "false";
		$cookies.email = "";
		$cookies.password = "";
		$rootScope.showLoggedInUser = false;
		$rootScope.userEmail = "";
	};
	
});  