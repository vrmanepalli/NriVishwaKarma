var app = angular.module("NRIVishwaKarma", ['ui.bootstrap', 'ngCookies', 'imageupload']).config(function($routeProvider) {
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

app.controller("NRIVishwaKarmaCtrl", function($scope, $modal, $log, $cookies) {
	
	$scope.showLoggedInUser = false;
	
	if($cookies.signedIn == true) {
		$scope.showLoggedInUser = true;
	}
	
	$scope.items = [$scope.showLoggedInUser];
	
	$scope.open = function () {
		
		var modalInstance = $modal.open({
			templateUrl: 'pages/login.html',
			controller: "modalInstanceCtrl",
			resolve: {
				items: function () {
					return $scope.items;
			    }
			}
		});

		modalInstance.result.then(function (selectedItem) {
			$scope.selected = selectedItem;
		}, function () {
			$log.info('Modal dismissed at: ' + new Date());
		});
	};
});  