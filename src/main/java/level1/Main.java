package level1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static long price;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<>();

        System.out.println("""
                [ SHAKESHACK MENU ]
                1. ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거
                2. SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거
                3. Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거
                4. Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거
                0. 종료      | 종료""");

        while (true){
            System.out.print("메뉴를 선택하세요. 0 부터 4 까지 입력 : ");
            String inputNum = sc.nextLine();

            switch (inputNum){
                case "1" :
                    System.out.println("1. ShackBurger 6900원");
                    list.add("ShackBurger");
                    price += 6900;
                    break;
                case "2" :
                    System.out.println("2. SmokeShack 8900원");
                    list.add("SmokeShack");
                    price += 8900;
                    break;

                case "3" :
                    System.out.println("3. Cheeseburger 6900원");
                    list.add("Cheeseburger");
                    price += 6900;
                    break;

                case "4" :
                    System.out.println("4. Hamburger 5400원");
                    list.add("Hamburger");
                    price += 5400;
                    break;

                case "0" :
                    System.out.println("0. 종료      | 종료");
                    break;

                default :
                    System.out.println("잘못입력");
                    break;
            }

            System.out.println("선택한 메뉴 목록");

            for (String s : list) {
                System.out.println(s + "  ");
            }

            System.out.println("가격 : " + price);

            if("0".equals(inputNum)){
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }
    }
}
