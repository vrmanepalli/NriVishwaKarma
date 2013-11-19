app.controller('profileCtrl',function($scope,$rootScope){
	if($rootScope.user === undefined){
		console.log("in if");
		$scope.imageUrl = "../img/profile.png";
		$scope.numOfMessage = "0";
		$scope.numOfPhoto = "0";
		$scope.numOfVideo = "0";
		$scope.numOfFriends = "0";
		$scope.numOfGroups = "0";
	}
	else{$scope.imageUrl = $rootScope.user.imageUrl; console.log("in else");}
})