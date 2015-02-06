var app = angular.module('AutomatedTest',['ngRoute']);

app.config(function($routeProvider) {
	console.log("routeProvider");
	$routeProvider
	.when('/dashboard', {
		templateUrl: 'template/dashBoard.html',
		controller : 'dashBoardCtrl'
	})
	.when('/phpunit', {
		templateUrl: 'template/phpUnit.html',
		controller : 'phpUnitCtrl'
	})
	.otherwise(
	{
		templateUrl: 'template/dashBoard.html',
		controller : 'dashBoardCtrl'
	})
})

app.controller("dashBoardCtrl", function($scope) {
	console.log("dashBoardCtrl");
});

app.controller("phpUnitCtrl", function($scope, $http) {
	$scope.upload = function()
	{
		var data = new FormData();
		jQuery.each($('#file')[0].files, function(i, file) {
			console.log(file);
			data.append('file', file);
		});
		$.ajax({
			url: "/upload",
			type: 'POST',
			data: data,
			cache: false,
			processData: false, // Don't process the files
			contentType: false, // Set content type to false as jQuery will tell the server its a query string request
			success: function(data, textStatus, jqXHR)
			{
				console.log(data);
				
			},
			error: function(jqXHR, textStatus, errorThrown)
			{
				alert("長太帥，上傳失敗");
			}
		});
	}
});