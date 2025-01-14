package level2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<MenuItem> menuList = new ArrayList<>();
        menuList.add(new MenuItem("shackBurger", 6900, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuList.add(new MenuItem("SmokeShack", 8900, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuList.add(new MenuItem("Cheeseburger", 6900, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuList.add(new MenuItem("Hamburger", 5400, "비프패티를 기반으로 야채가 들어간 기본버거"));
        Scanner sc = new Scanner(System.in);
        List<String> menuName = new ArrayList<>();  //고른 메뉴 이름 저장용

        System.out.println("[ SHAKESHACK MENU ]");  //메뉴 목록 출력
        for (int i = 0; i < menuList.size(); i++) {
            System.out.println((i + 1) + ". " + menuList.get(i));
        }
        System.out.println("0. 종료 | 종료");

        while (true){
            System.out.print("메뉴 선택. 0 부터 4 까지 입력 : ");
            String inputNum = sc.nextLine();

            switch (inputNum){
                case "1" :
                    menuName.add(menuList.get(0).getFoodName());    //고른 메뉴 저장
                    MenuItem.totalPrice(menuList.get(0).getPrice());    //고른 메뉴 가격 저장
                    break;
                case "2" :
                    menuName.add(menuList.get(1).getFoodName());
                    MenuItem.totalPrice(menuList.get(1).getPrice());
                    break;

                case "3" :
                    menuName.add(menuList.get(2).getFoodName());
                    MenuItem.totalPrice(menuList.get(2).getPrice());
                    break;

                case "4" :
                    menuName.add(menuList.get(3).getFoodName());
                    MenuItem.totalPrice(menuList.get(3).getPrice());
                    break;

                case "0" :
                    System.out.println("프로그램을 종료합니다.");
                    break;

                default :
                    System.out.println("잘못입력");
                    break;
            }

            System.out.println("선택한 메뉴 목록");//골랐던 메뉴 이름 출력 반복문
            for (String menu : menuName) {
                System.out.println(menu);
            }
            System.out.println("가격 : " + MenuItem.getTotalPrice()); //골랐던 메뉴 총합 가격

            if("0".equals(inputNum)){
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }
    }
}
