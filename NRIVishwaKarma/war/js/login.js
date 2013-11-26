app.controller("modalInstanceCtrl", function ($scope, $rootScope, $route, $modalInstance, 
		$cookies, dataFactory, $location) {
	
	$scope.showLogin = true;
	$scope.showForgotPassword = false;
	$scope.showSecurityQuestion = false;
	$scope.showResetPassword = false;
	$scope.showResetMsg = false;
	$scope.showEmailReset = false;
	$scope.resetMsg = "Please wait...";
	$scope.errorMsg = "";
	$scope.securityQuestion = "";
	$scope.input = {};
	
	$scope.forgotPassword = function() {
		$scope.errorMsg = "";
		$("#forgotLink").removeAttr("href");
		$scope.showLogin = false;
		$scope.showForgotPassword = true;
	};
	
	$scope.checkEmailForQuestion = function() {
		$scope.errorMsg = "";
		var data = {
			email: $scope.input.email
		};
		console.log($scope.input.email);
		dataFactory.getSecurityQuestion(JSON.stringify(data))
			.success(function(results) {
				if(results.status == "true") {
					$scope.securityQuestion = results.question;
					$scope.showForgotPassword = false;
					$scope.showSecurityQuestion = true;
				} else {
					$scope.errorMsg = "Email address not found.";
				}
			})
			.error(function(error) {
				$scope.errorMsg = "A server error occured. Please try again.";
			});
	};
	
	$scope.sendResetEmail = function() {
		$("#resetLink").removeAttr("href");
		$scope.showLogin = false;
		$scope.showForgotPassword = false;
		$scope.showSecurityQuestion = false;
		$scope.showResetPassword = false;
		$scope.showResetMsg = true;
		var data = {
			email: $scope.input.email
		};
		dataFactory.forgotPassword(JSON.stringify(data))
			.success(function(results) {
				if(results.status == "true") {
					$scope.resetMsg = "A reset link has been sent to your email.";
				} else {
					$scope.resetMsg = "Server failed to send a reset email. Please try again.";
				}
			})
			.error(function(error) {
				$scope.resetMsg = "Server failed to send a reset email. Please try again.";
			});
	};
	
	$scope.checkAnswer = function() {
		$scope.errorMsg = "";
		var data = {
			email: $scope.input.email,
			answer: $scope.input.answer
		};
		console.log(data);
		dataFactory.checkSecurityAnswer(JSON.stringify(data))
			.success(function(results) {
				if(results.status == "true") {
					$scope.securityQuestion = results.question;
					$scope.showSecurityQuestion = false;
					$scope.showResetPassword = true;
				} else {
					$scope.errorMsg = "Incorrect answer.";
				}
			})
			.error(function(error) {
				$scope.errorMsg = "A server error occured. Please try again.";
			});
	};
	
	$scope.resetPassword = function() {
		// ng-minlength returns undefined if less than minlength. Not setting a minlength 
		// on confPassword means they won't be equal unless correct length and match.
		if($scope.input.resetPassword != $scope.input.confPassword) {
			$scope.errorMsg = "Must be at least 8 characters and match.";
			return;
		}
		$scope.errorMsg = "";
		var data = {
			email: $scope.input.email,
			password: $scope.input.resetPassword
		};
		console.log(data);
		dataFactory.updatePassword(JSON.stringify(data))
			.success(function(results) {
				if(results.status == "true") {
					$scope.resetMsg = "You have successfully reset your password.";
					$scope.securityQuestion = results.question;
					$scope.showResetPassword = false;
					$scope.showResetMsg = true;
				} else {
					$scope.errorMsg = "Failed to update password. Try again.";
				}
			})
			.error(function(error) {
				$scope.errorMsg = "A server error occured. Please try again.";
			});
	};
	
	$scope.login = function () {
		if($scope.input.password == undefined) {
			$scope.errorMsg = "Must be between 8 and 100 characters.";
			return;
		}
		$scope.errorMsg = "";
		
		var data = {
			email: $scope.input.email,
			password: $scope.input.password
		};
		console.log($scope.input.email);
		console.log($scope.input.password);
		dataFactory.login(JSON.stringify(data))
			.success(function(results) {
				if(results.status == "true") {
					$cookies.signedIn = "true";
					$cookies.email = $scope.input.email;
					$cookies.password = $scope.input.password;
					$rootScope.userEmail = $scope.input.email;
					$rootScope.profileUser = $scope.input.email;
					$rootScope.showLoggedInUser = true;
					$location.path("/Profile");
					$modalInstance.close();
				} else if(results.status == "false") {
					$scope.errorMsg = results.message;
				}
			})
			.error(function(error) {
				$scope.errorMsg = "A server error occured. Please try again.";
			});
	};
	
	$scope.ok = function () {
	    $modalInstance.close();
	};

	$scope.cancel = function () {
		$modalInstance.dismiss('cancel');
	};
});

app.controller("loginCtrl", function ($scope, $rootScope, $cookies, $route, dataFactory, $location) {
	$scope.showLogin = true;
	$scope.showForgotPassword = false;
	$scope.showSecurityQuestion = false;
	$scope.showResetPassword = false;
	$scope.showResetMsg = false;
	$scope.showEmailReset = false;
	$scope.resetMsg = "Please wait...";
	$scope.errorMsg = "";
	$scope.securityQuestion = "";
	$scope.input = {};
	
	var urlParts = window.location.href.split("?");
	var uri = new Uri("?" + urlParts[1]);

	if(uri.getQueryParamValue('reset_token') != undefined) {
		console.log("here!!!!!");
		$scope.showLogin = false;
		$scope.showResetPassword = true;
		$scope.showEmailReset = true;
	}
	
	$scope.sendTokenAndPassword = function() {
		var data = {
			password: $scope.input.resetPassword,
			token: uri.getQueryParamValue('reset_token')
		};
		dataFactory.resetPassword(JSON.stringify(data))
			.success(function(results) { 
				if(results.status == "true") {
					$scope.showResetPassword = false;
					$scope.showEmailReset = false;
					$scope.showResetMsg = true;
					$scope.resetMsg = "You have successfully changed your password.";
				} else {
					$scope.showResetPassword = false;
					$scope.showEmailReset = false;
					$scope.showResetMsg = true;
					$scope.resetMsg = "Your reset password link has expired. Please request a new one.";
				}
			})
			.error(function(error) {
				$scope.errorMsg = "A server error occured. Please try again.";
			});
	};
	
	$scope.forgotPassword = function() {
		$scope.errorMsg = "";
		$("#forgotLink").removeAttr("href");
		$scope.showLogin = false;
		$scope.showForgotPassword = true;
	};
	
	$scope.checkEmailForQuestion = function() {
		$scope.errorMsg = "";
		var data = {
			email: $scope.input.email
		};
		console.log($scope.input.email);
		dataFactory.getSecurityQuestion(JSON.stringify(data))
			.success(function(results) {
				if(results.status == "true") {
					$scope.securityQuestion = results.question;
					$scope.showForgotPassword = false;
					$scope.showSecurityQuestion = true;
				} else {
					$scope.errorMsg = "Email address not found.";
				}
			})
			.error(function(error) {
				$scope.errorMsg = "A server error occured. Please try again.";
			});
	};
	
	$scope.checkAnswer = function() {
		$scope.errorMsg = "";
		var data = {
			email: $scope.input.email,
			answer: $scope.input.answer
		};
		console.log(data);
		dataFactory.checkSecurityAnswer(JSON.stringify(data))
			.success(function(results) {
				if(results.status == "true") {
					$scope.securityQuestion = results.question;
					$scope.showSecurityQuestion = false;
					$scope.showResetPassword = true;
				} else {
					$scope.errorMsg = "Incorrect answer.";
				}
			})
			.error(function(error) {
				$scope.errorMsg = "A server error occured. Please try again.";
			});
	};
	
	$scope.sendResetEmail = function() {
		$("#resetLink").removeAttr("href");
		$scope.showLogin = false;
		$scope.showForgotPassword = false;
		$scope.showSecurityQuestion = false;
		$scope.showResetPassword = false;
		$scope.showResetMsg = true;
		var data = {
				email: $scope.input.email
			};
		dataFactory.forgotPassword(JSON.stringify(data))
				.success(function(results) {
					if(results.status == "true") {
						$scope.resetMsg = "A reset link has been sent to your email.";
					} else {
						$scope.resetMsg = "Server failed to send a reset email. Please try again.";
					}
				})
				.error(function(error) {
					$scope.resetMsg = "Testing Server failed to send a reset email. Please try again.";
				});
	};
	
	$scope.resetPassword = function() {
		// ng-minlength returns undefined if less than minlength. Not setting a minlength 
		// on confPassword means they won't be equal unless correct length and match.
		if($scope.input.resetPassword != $scope.input.confPassword) {
			$scope.errorMsg = "Must be at least 8 characters and match.";
			return;
		}
		$scope.errorMsg = "";
		var data = {
			email: $scope.input.email,
			password: $scope.input.resetPassword
		};
		console.log(data);
		dataFactory.updatePassword(JSON.stringify(data))
			.success(function(results) {
				if(results.status == "true") {
					$scope.securityQuestion = results.question;
					$scope.showResetPassword = false;
					$scope.showResetMsg = true;
				} else {
					$scope.errorMsg = "Failed to update password. Try again.";
				}
			})
			.error(function(error) {
				$scope.errorMsg = "A server error occured. Please try again.";
			});
	};
	
	$scope.login = function () {
		if($scope.input.password == undefined) {
			$scope.errorMsg = "Must be between 8 and 100 characters.";
			return;
		}
		$scope.errorMsg = "";
		var data = {
			email: $scope.input.email,
			password: $scope.input.password
		};
		console.log($scope.input.email);
		console.log($scope.input.password);
		dataFactory.login(JSON.stringify(data))
			.success(function(results) {
				if(results.status == "true") {
					$cookies.signedIn = "true";
					$cookies.email = $scope.input.email;
					$cookies.password = $scope.input.password;
					$rootScope.profileUser = $scope.input.email;
					$rootScope.userEmail = $scope.input.email;
					$rootScope.showLoggedInUser = true;
					$location.path("/Profile");
					$modalInstance.close();
				} else if(results.status == "false") {
					$scope.errorMsg = results.message;
				}
			})
			.error(function(error) {
				$scope.errorMsg = "A server error occured. Please try again.";
			});
	};
});