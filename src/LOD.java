
// import java.awt.Dialog;

// // LOD principle stands for = Law of demeter

// // The Law of Demeter 
// // (also known as the Principle of Least Knowledge) 

// // says an object should only call methods on:
// // Itself
// // Its own fields
// // Its method parameters
// // Objects it creates

// // Bad example of the Law of Demeter

// // public class LOD {
// //   void displayFirstItemPrice(Customer customer) {
// //     Money price = customer.getShoppingCart().getItems().get(0).getProduct().getPrice();
// //     System.out.println("Price of the first item: " + price.getAmount());
// // }  
// // }

// // Good example of the Law of Demeter

// class ShoppingCart{
//     public Money getFirstItemPrice(){
//         if(items.isEmpty()){
//             return Money.ZERO;
//         } else {
//             return items.get(0).getProduct().getPrice();
//         }
//     }
// }


// class Customer{
//     public Money getFirstItemPrice(){
//         return shoppingCart.getFirstItemPrice();
//     }
// }

// void displayFirstItemPrice(Customer customer){
//     Money price = customer.getFirstItemPrice();
//     System.out.println("Price of the first item: " + price.getAmount());
// }