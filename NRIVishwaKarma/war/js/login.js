app.controller("modalInstanceCtrl", function ($scope, $rootScope, $modalInstance, 
		$cookies, dataFactory, items) {
	$scope.showForgotPassword = false;
	$scope.input = {};
	
	$scope.forgotPassword = function() {
		$("#forgotLink").removeAttr("href");
		$scope.showForgotPassword = true;
	};
	
	$scope.sendResetEmail = function() {
		var data = {
			email: $scope.input.email
		};
		console.log($scope.input.email);
		dataFactory.forgotPassword(JSON.stringify(data))
			.success(function(results) {
				console.log(results);
			})
			.error(function(error) {
					console.log(error);
			});
	}
	
	$scope.login = function () {
		
		var data = {
			email: $scope.input.email,
			password: $scope.input.password
		};
		console.log($scope.input.email);
		console.log($scope.input.password);
		dataFactory.login(JSON.stringify(data))
			.success(function(results) {
				if(results.status == "true") {
					$cookies.signedIn = true;
					$cookies.email = $scope.input.email;
					$cookies.password = $scope.input.password;
					console.log(results);
				} else if(results.status == "false") {
					$scope.errorMsg = results.message;
				}
			})
			.error(function(error) {
				console.log(error);
			});
	};

	$scope.cancel = function () {
		$modalInstance.dismiss('cancel');
	};
});