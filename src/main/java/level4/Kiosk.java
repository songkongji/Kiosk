package level4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private Scanner sc = new Scanner(System.in);
    private List<Menu> categories;
    private List<MenuItem> menuList;

    public Kiosk(List<Menu> categories) {
        this.categories = categories;
    }

    public void start(){    //시작하면서 메뉴 목록이랑 사용자가 입력해야할 키 알려주는 메서드
        while (true){
            System.out.println("카테고리 선택 (종료 : 0)");

            for (int i = 0; i < categories.size(); i++) {
                System.out.println((i + 1) + ". " + categories.get(i).getCategory());
            }

            String inputCategory = sc.nextLine();

            if(exitProgram(inputCategory)){   //프로그램 종료 메서드 호출
                break;
            }

            compareCategory(inputCategory); //고른 카테고리 판별 메서드 호출
        }
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
                    System.out.println("프로그램 종료");
                    break;

                default :
                    System.out.println("잘못입력했습니다. 다시 입력해주세요 (0: 종료, 1 ~ 4 : 메뉴선택");
                    break;
            }

            printSelectedMenu(menuName);    //선택한 메뉴 목록, 가격 출력 메서드 호출

            if(exitProgram(inputNum)){   //프로그램 종료 메서드 호출
                break;
            }
        }
    }

    private void printSelectedMenu(List<String> menuName){  //고른 메뉴 이름, 가격 알려주는 메서드
        System.out.println("선택한 메뉴 목록");

        for (String menu : menuName) {
            System.out.println(menu);
        }

        System.out.println("가격 : " + MenuItem.getTotalPrice() + "원");
    }

    private boolean exitProgram(String inputNum){    //프로그램 종료 메서드
        return "0".equals(inputNum);
    }

    private void compareCategory(String category){ // 고른 카테고리에 따라 분기점
        if("1".equals(category)){
            menuList = categories.get(0).getMenuItems();    //1번이니까 햄버거 저장
            selectMenu(category);   //메뉴 출력 메서드 호출
            compareInput(); //사용자가 입력한 번호에 해당하는 메뉴 찾고 저장하는 메서드 호출
        } else if("2".equals(category)){
            menuList = categories.get(1).getMenuItems();    //2번이니까 음료수 저장
            selectMenu(category);
            compareInput();
        } else {
            System.out.println("잘못 입력하셨습니다. 다시입력해주세요");
            start();    //다시 시작부터
        }
    }

    private void selectMenu(String category){    //메뉴 출력
        if("1".equals(category))
            System.out.println("[ SHAKESHACK MENU ]");
        else if ("2". equals(category))
            System.out.println("[ DRINK MENU ]");

        for (int i = 0; i < menuList.size(); i++) {
            System.out.println((i + 1) + ". " + menuList.get(i));
        }

        System.out.println("0. 종료 | 종료");
        System.out.print("메뉴를 선택해주세요. (0 : 종료, 1 ~ 4 : 메뉴선택) : ");
    }
}
