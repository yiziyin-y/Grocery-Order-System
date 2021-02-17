var cartApp = angular.module ("cartApp", []);

function calGrandTotal() { 
	 var grandTotal = 0;
   
     for (var i = 0; i < $products.length; i++){
         grandTotal += $products[i].price;
     }

     return grandTotal;
	}
  
cartApp.controller("cartCtrl", function($scope, $http){

    $scope.refreshCart = function(){
       $http.get('/MyOnlineShopping/rest/cart/' + $scope.cartId).success(function (data){
           $scope.cart = data;
       });
    };
 
    $scope.clearCart = function(){
        $http.delete('/MyOnlineShopping/rest/cart/' + $scope.cartId).success($scope.refreshCart());
    };
    
    $scope.initCartId = function(cartId){v 
        $scope.cartId = cartId;
        $scope.refreshCart(cartId);
    };

   

  $scope.addToCart = function(productId){
	 
        $http.put('/MyOnlineShopping/rest/cart/add/' + productId).success(function (){
            alert('Product successfully added to the cart!');
        });
    };
    
    $scope.removeFromCart = function(productId){
    	
        $http.put('/MyOnlineShopping/rest/cart/remove/' + productId).success(function(data){
        	
           $scope.refreshCart();
           
        });
    };

    $scope.calGrandTotal = function(){
        var grandTotal = 0;
        //alert('Product successfully added to the cart hahhahahaha!');
        for (var i = 0; i < $scope.cart.cartItems.length; i++){
            grandTotal += $scope.cart.cartItems[i].totalPrice;
        }

        return grandTotal;
    }
});