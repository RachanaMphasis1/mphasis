package com.java.cms;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class CanteenMain {
	
static Scanner sc =  new Scanner(System.in);
	
public static void main(String[] args) {
	int choice;
	do {
		System.out.println(" O P T I O N S");
		System.out.println(" -------------");
		System.out.println("1. Show Restaurant");
		System.out.println("2. Search by Restaurant Id");
		System.out.println("3. Add Restaurant");
		System.out.println("4. Show Menu");
		System.out.println("5. Search Menu");
		System.out.println("6. Add Menu");
		System.out.println("7. Show Vendor");
		System.out.println("8. Search Vendor");
		System.out.println("9. Add Vendor");
		System.out.println("10. Show Customer");
		System.out.println("11. Search Customer");
		System.out.println("12. Add Customer");
		System.out.println("13. Search Wallet by Customer id");
		System.out.println("14. Search Wallet by Wallet id");
		System.out.println("15. Place Order");
		System.out.println("16. Accept Or Reject Order");
		System.out.println("17. Customer Orders");
		System.out.println("18. Customer Pending Orders");
		System.out.println("19. Vendor Orders");
		System.out.println("20. Vendor Pending Orders");
		System.out.println("Enter Your Choice   ");
		choice = sc.nextInt();
		switch(choice) {
			case 1 :
				showRestaurant();
				break;
			case 2 :
			try {
				searchRestaurant();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				break;	
			case 3: 
				try {
					addRestaurant();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			case 4 : 
				showMenu();
				break;
			case 5 :
			try {
				searchMenu();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				break;
				
			case 6: 
				try {
					addMenu();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			case 7 :
				showVendor();
				break;
			case 8 : 
			try {
				searchVendor();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				break;
				
			case 9: 
				try {
					addVendor();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			case 10 :
				showCustomer();
				break;
			case 11 :
			try {
				searchCustomer();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				break;
				
			case 12: 
				try {
					addCustomer();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			case 13 :
			try {
				searchWalletbycid();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				break;
				
			case 14 :
			try {
				searchWalletbywid();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				break;
				
			case 15 : 
			try {
				placeOrder();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
			case 16 : 
				try {
					acceptOrReject();
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
				break;
			
	         case 17 :
			    customerOrders();
		      break;
		
	         case 18 :
		        customerPendingOrders();
	         break;
	         
	         case 19 :
		      vendorOrders();
	         break;
	
             case 20 :
	          vendorPendingOrders();
             break;
     }
				
	}while(choice!=21);
	
}

public static void showRestaurant() {
	try {
		List<Restaurant> restaurantList = new RestaurantDAO().showRestaurant();
		for (Restaurant restaurant : restaurantList) {
			System.out.println(restaurant);
		}
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public static void searchRestaurant() throws ClassNotFoundException, SQLException {
	int rid;
	System.out.println("Enter Restaurant id   ");
	rid = sc.nextInt();
	Restaurant restaurant = new RestaurantDAO().searchRestaurant(rid);
	System.out.println(restaurant);
}

public static void addRestaurant() throws ClassNotFoundException, SQLException {
	Restaurant restaurant = new Restaurant();
	System.out.println("Enter restaurantName   ");
	restaurant.setrestaurantName(sc.next());
	System.out.println("Enter city  ");
	restaurant.setcity(sc.next());
	System.out.println("Enter branch  ");
	restaurant.setbranch(sc.next());
	System.out.println("Enter email  ");
	restaurant.setemail(sc.next());
	System.out.println("Enter contactNo  ");
	restaurant.setcontactNo(sc.next());
	try {
		RestaurantDAO dao = new RestaurantDAO();
		System.out.println(dao.addRestaurant(restaurant));
	}catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	  }
}

public static void showMenu() {
	int restaurantId;
	System.out.println("Enter Restaurant Id");
	restaurantId = sc.nextInt();
	try {
	List<Menu> menuList = new MenuDAO().showMenu(restaurantId);
	for (Menu menu : menuList) {
		System.out.println(menu);
	}
}catch (ClassNotFoundException | SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
  }
}

	public static void searchMenu() throws ClassNotFoundException, SQLException {
		int menuid;
		System.out.println("Enter Menu id   ");
		menuid = sc.nextInt();
		Menu menu = new MenuDAO().searchMenu(menuid);
		System.out.println(menu);
	}
	
	public static void addMenu() throws ClassNotFoundException, SQLException {
		Menu menu = new Menu();
		System.out.println("Enter Restaurant ID   ");
		menu.setrestaurantID(sc.nextInt());
		System.out.println("Enter Item Name   ");
		menu.setitemName(sc.next());
		System.out.println("Enter Menu Type  ");
		menu.setmenuType(sc.next());
		System.out.println("Enter Calories  ");
		menu.setcalories(sc.nextInt());
		System.out.println("Enter Price   ");
		menu.setprice(sc.nextInt());
		try {
			MenuDAO dao = new MenuDAO();
			System.out.println(dao.addMenu(menu));
		}catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  }
		
	public static void showVendor() {
		
		try {
			List<Vendor> vendorList;
			vendorList = new VendorDAO().showVendor();
			for (Vendor vendor : vendorList) {
				System.out.println(vendor);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void searchVendor() throws ClassNotFoundException, SQLException {
	int vendorid;
	System.out.println("Insert Vendor ID  ");
	vendorid= sc.nextInt();
	Vendor vendor = new VendorDAO().searchVendor(vendorid);
	System.out.println(vendor);
	
	}
	
	
	public static void addVendor() throws ClassNotFoundException, SQLException {
		Vendor vendor = new Vendor();
		System.out.println("Enter vendorName   ");
		vendor.setvendorName(sc.next());
		System.out.println("Enter vendorCity  ");
		vendor.setvendorCity(sc.next());
		System.out.println("Enter vendorState  ");
		vendor.setvendorState(sc.next());
		System.out.println("Enter vendorEmail  ");
		vendor.setvendorEmail(sc.next());
		System.out.println("Enter vendorMobile  ");
		vendor.setvendorMobile(sc.next());
		try {
			VendorDAO dao = new VendorDAO();
			System.out.println(dao.addVendor(vendor));
		}catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		  }
	}
	
	
	public static void showCustomer() {
		try {
			List<Customer> customerList;
			customerList = new CustomerDAO().showCustomer();
			for (Customer customer : customerList) {
				System.out.println(customer);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void searchCustomer() throws ClassNotFoundException, SQLException {
		int customerid;
		System.out.println("Insert Customer Id   ");
		customerid = sc.nextInt();
		Customer customer = new CustomerDAO().searchCustomer(customerid);
		System.out.println(customer);
	}
	
	public static void addCustomer() throws ClassNotFoundException, SQLException {
		Customer customer = new Customer();
		System.out.println("Enter firstName   ");
		customer.setfirstName(sc.next());
		System.out.println("Enter lastName  ");
		customer.setlastName(sc.next());
		System.out.println("Enter gender  ");
		customer.setgender(sc.next());
		System.out.println("Enter dob  ");
		customer.setdob(sc.next());
		System.out.println("Enter maritialStatus  ");
		customer.setmaritialStatus(sc.next());
		System.out.println("Enter address1   ");
		customer.setaddress1(sc.next());
		System.out.println("Enter address2  ");
		customer.setaddress2(sc.next());
		System.out.println("Enter city  ");
		customer.setcity(sc.next());
		System.out.println("Enter state  ");
		customer.setstate(sc.next());
		System.out.println("Enter zipcode ");
		customer.setzipcode(sc.nextInt());
		System.out.println("Enter country  ");
		customer.setcountry(sc.next());
		try {
			CustomerDAO dao = new CustomerDAO();
			System.out.println(dao.addCustomer(customer));
		}catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		  }
	}
	
	
	public static void searchWalletbycid() throws ClassNotFoundException, SQLException {
		int customerid;
		System.out.println("Enter customer Id to search wallet  ");
		customerid = sc.nextInt();
		List<Wallet> wallet = new WalletDAO().searchByCustomerID(customerid);
		System.out.println(wallet);
		
	}
	public static void searchWalletbywid() throws ClassNotFoundException, SQLException {
		int walletid;
		System.out.println("Enter wallet Id to search wallet  ");
		walletid = sc.nextInt();
		Wallet wallet = new WalletDAO().searchByWalletId(walletid);
		System.out.println(wallet);
		
	}
	
	public static void placeOrder() throws ClassNotFoundException, SQLException {
		Orders order = new Orders();
		System.out.println("Enter Customer Id   ");
		order.setcustomerID(sc.nextInt());
		System.out.println("Enter Vendor Id  ");
		order.setvendorID(sc.nextInt());
		System.out.println("Enter Menu Id  ");
		order.setmenuID(sc.nextInt());
		System.out.println("Enter Wallet Id  ");
		order.setwalletID(sc.nextInt());
		System.out.println("Enter Quantity Ordered  ");
		order.setQuantityOrdered(sc.nextInt());
		System.out.println("Enter Comments  ");
		order.setcomments(sc.next());
		OrdersDAO dao = new OrdersDAO();
		System.out.println(dao.placeOrder(order));
	}
	
	public static void acceptOrReject() throws ClassNotFoundException, SQLException {
		int vendorId;
		int orderId;
		String status;
		System.out.println("Enter Vendor Id   ");
		vendorId = sc.nextInt();
		System.out.println("Enter Order Id   ");
		orderId = sc.nextInt();
		System.out.println("Enter Status   ");
		status =sc.next();
		System.out.println(new OrdersDAO().acceptOrRejectOrder(orderId, vendorId, status));
	}
		
	
	
	public static void customerOrders() {
		int customerID;
		System.out.println("Enter customer Id to search Orders  ");
		customerID = sc.nextInt();
		try {
			List<Orders> ordersList = new OrdersDAO().customerOrders(customerID);
		for (Orders orders : ordersList) {
			System.out.println(orders);
		}
	}catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	  }
	}
	
	public static void customerPendingOrders() {
		int customerID;
		System.out.println("Enter customer Id to search Pending Orders  ");
		customerID = sc.nextInt();
		try {
			List<Orders> ordersList = new OrdersDAO().customerPendingOrders(customerID);
		for (Orders orders : ordersList) {
			System.out.println(orders);
		}
	}catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	  }
	}
	
	public static void vendorOrders() {
		int vendorID;
		System.out.println("Enter vendorID to search Orders  ");
		vendorID = sc.nextInt();
		try {
			List<Orders> ordersList = new OrdersDAO().vendorsOrders(vendorID);
		for (Orders orders : ordersList) {
			System.out.println(orders);
		}
	}catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	  }
	}
	
	public static void vendorPendingOrders() {
		int vendorID;
		System.out.println("Enter vendorID to search Pending Orders  ");
		vendorID = sc.nextInt();
		try {
			List<Orders> ordersList = new OrdersDAO().vendorPendingOrders(vendorID);
		for (Orders orders : ordersList) {
			System.out.println(orders);
		}
	}catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	  }
	}
}