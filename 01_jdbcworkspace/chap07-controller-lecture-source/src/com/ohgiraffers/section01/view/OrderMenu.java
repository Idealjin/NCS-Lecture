package com.ohgiraffers.section01.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.ohgiraffers.section01.controller.OrderController;
import com.ohgiraffers.section01.model.dto.CategoryDTO;
import com.ohgiraffers.section01.model.dto.MenuDTO;
import com.ohgiraffers.section01.model.dto.OrderDTO;
import com.ohgiraffers.section01.model.dto.OrderMenuDTO;
import com.ohgiraffers.section01.model.service.OrderService;

public class OrderMenu {

	private OrderController orderController = new OrderController();
	
	public void displayMainMenu() {
	
		/*
		 * 반복
		 * ------------------------------------
		 * 1. 카테고리 조회
		 * 2. 해당 카테고리의 메뉴 조회
		 * 3. 사용자에게 어떤 메뉴를 주문받을 것인지 입력
		 * 4. 주문할 수량 입력
		 * ------------------------------------
		 * 5. 주문
		 * */
		
		Scanner sc = new Scanner(System.in);
		
		List<OrderMenuDTO> orderMenuList = new ArrayList<>();
		
		int totalOrderPrice = 0;
		
		do {
			System.out.println("============= 음식 주문 프로그램 =============");
			List<CategoryDTO> categoryList = orderController.selectAllCategory();
			
			for(CategoryDTO category : categoryList) {
				System.out.println(category.getName());
			}
			
			System.out.println("==========================================");
			System.out.println("주문하실 카테고리를 선택해주세요 :");
			String inputCategory = sc.nextLine();
			
			int categoryCode = 0;
			for(int i =0; i < categoryList.size(); i++) {
				CategoryDTO category = categoryList.get(i);
				
				if(category.getName().equals(inputCategory)) {
					categoryCode = category.getCode();
				}
				
			}
			
			System.out.println("============== 주문 가능 메뉴 ===============");
			List<MenuDTO> menuList = orderController.selectMenuBy(categoryCode);
			
			for(MenuDTO menu : menuList) {
				System.out.println(menu.getName() + " : " + menu.getPrice() + "원");
			}
			
			System.out.print("주문 하실 메뉴를 선택해주세요 : ");
			String inputMenu = sc.nextLine();
			
			int menuCode = 0;
			int menuPrice = 0;
			for(int i = 0; i < menuList.size(); i++) {
				MenuDTO menu = menuList.get(i);
				if(menu.getName().equals(inputMenu)){
					menuCode = menu.getCode();
					menuPrice = menu.getPrice();
				}
			}
			
			System.out.print("주문하실 수량을 입력하세요. : ");
			int orderAmount = sc.nextInt();
			
			OrderMenuDTO orderMenu = new OrderMenuDTO();
			orderMenu.setMenuCode(menuCode);
			orderMenu.setOrderAmount(orderAmount);
			
			orderMenuList.add(orderMenu);
			totalOrderPrice += (menuPrice * orderAmount);
			
			
			System.out.print("계속 주문 하시겠습니까? (예 / 아니오) : ");
			
			sc.nextLine();
			
			boolean isContinue = sc.nextLine().equals("예")? true : false;
			
			if(!isContinue) {
				break;
			}
			
		} while(true);
		
//		orderController.registOrder(orderMenuList, totalOrderPrice)
		//맵을 이용하면 2개 값을 하나로 보내줄수있다. 맵 중요!!
		Map<String, Object> requestMap = new HashMap<>();
		requestMap.put("totalOrderPrice", totalOrderPrice);
		requestMap.put("orderMenuList", orderMenuList);
		
		orderController.registOrder(requestMap);
		
			
	}

}
