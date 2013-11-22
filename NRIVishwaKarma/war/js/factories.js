'use strict';
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
    
    dataFactory.getUserFactory = function(email){
    	return $http.post('/UserGetServlet',email);
    };
    
    dataFactory.updateUserFactory = function(user){
    	return $http.post('UserUpdateServer',user);
    };
    
    dataFactory.getInterestFactory = function(email){
    	return $http.post('GetInterestServlet',email);
    };
    
    dataFactory.updateInterestFactory = function(interest){
    	return $http.post('UpdateInterestServlet',interest);
    }
 
	return dataFactory;
}]);
