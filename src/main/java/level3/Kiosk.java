package level3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private List<MenuItem> menuList;
    private Scanner sc = new Scanner(System.in);

    public Kiosk(List<MenuItem> menuList) {
        this.menuList = menuList;
    }

    public void start(){    //시작하면서 메뉴 목록이랑 사용자가 입력해야할 키 알려주는 메서드
        System.out.println("[ SHAKESHACK MENU ]");

        for (int i = 0; i < menuList.size(); i++) {
            System.out.println((i + 1) + ". " + menuList.get(i));
        }

        System.out.println("0. 종료 | 종료");
        System.out.print("메뉴를 선택해주세요. (0 : 종료, 1 ~ 4 : 메뉴선택) : ");
        compareInput(); //사용자가 입력한 번호에 해당하는 메뉴 찾고 저장하는 메서드 호출
    }

    private void compareInput(){    //사용자가 입력한 번호에 해당하는 메뉴 찾고 저장하는 메서드
        List<String> menuName = new ArrayList<>();  //고른 메뉴 이름 저장용

        while (true){
            String inputNum = sc.nextLine();    //사용자한테 입력받는 메뉴 번호

            switch (inputNum){
                case "1" :
                    menuName.add(menuList.get(0).getFoodName());    //고른 메뉴 이름 저장
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
                    System.out.println("잘못입력했습니다. 다시 입력해주세요 (0: 종료, 1 ~ 4 : 메뉴선택");
                    break;
            }

            printSelectedMenu(menuName);    //선택한 메뉴 목록, 가격 출력 메서드 호출

            if(!exitProgram(inputNum)){   //프로그램 종료 메서드 호출
                break;
            }

        }
    }

    private void printSelectedMenu(List<String> menuName){  //고른 메뉴 이름, 가격 알려주는 메서드
        System.out.println("선택한 메뉴 목록");

        for (String menu : menuName) {
            System.out.println(menu);
        }

        System.out.println("가격 : " + MenuItem.getTotalPrice());
    }

    private boolean exitProgram(String inputNum){    //프로그램 종료 메서드
        return !"0".equals(inputNum);
    }
}
