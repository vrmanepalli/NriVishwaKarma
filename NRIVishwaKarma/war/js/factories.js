angular.module('NRIVishwaKarma')
.factory('dataFactory', ['$http', function($http) {
	var dataFactory = {};
    
	dataFactory.login = function(json) {
    	return $http.post('/Login', json);
    };
    
    dataFactory.forgotPassword = function(json) {
    	return $http.post('/ForgotPass', json);
    };
	
    dataFactory.registerUser = function(json) {
    	return $http.post('/register', json);
    };
 
	return dataFactory;
}]);