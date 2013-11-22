app.controller("modalInstanceCtrl", function ($scope, $rootScope, $modalInstance, dataFactory) {
	$scope.showForgotPassword = false;
	
	$scope.forgotPassword = function() {
		$("#forgotLink").removeAttr("href");
		$scope.showForgotPassword = true;
	};
	
	$scope.sendResetEmail = function() {
		var data = {
				email: $scope.email
			};
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
			email: $scope.email,
			password: $scope.password
		};
		dataFactory.login(JSON.stringify(data))
			.success(function(results) {
				console.log(results);
			})
			.error(function(error) {
						console.log(error);
			});
	};

	$scope.cancel = function () {
		$modalInstance.dismiss('cancel');
	};
});