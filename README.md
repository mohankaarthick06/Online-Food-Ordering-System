# Online-Food-Ordering-System
The Online Food Ordering System is designed to connect customers, restaurants, and delivery services on a single platform. Customers can register, search for restaurants, view menus, place orders, and make payments. Restaurants can manage their menus, update availability, and process incoming orders. Delivery agents (if included) can track and update the status of orders. The system maintains all data such as user profiles, restaurant details, menu items, and order history in a database (e.g., MongoDB) for efficient storage, retrieval, and reporting.The target users of this system are customers who order food online, restaurants that manage menus and orders, and delivery agents who handle order deliveries and status updates.

✅Core Features:

1.User Module: Customer registration, login, profile management.

2.Restaurant Module: Manage restaurant details, menus, and pricing.

3.Order Module: Place new orders, update/cancel orders, track status.

4.Payment Module: Record payment details (cash/online).

5.Reports & Analytics: Order history, top-selling items, restaurant performance.


🔹OOP Concepts in Online Food Ordering System :

1.Class & Object – Users, Restaurants, MenuItems, Orders are modeled as classes; real entities are objects.

2.Encapsulation – User details, menu data, and payment info are kept private with controlled access.

3.Inheritance – Customer, Admin, and DeliveryAgent inherit from a common User class.

4.Polymorphism – Payment methods override processPayment(); Orders allow adding items in different ways.

5.Abstraction – Payment is defined as an abstract class; specific types (Cash, Online, Card) provide implementations.


