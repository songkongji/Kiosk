package level6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private final Scanner sc = new Scanner(System.in);
    private final List<Menu> categories;
    private List<MenuItem> menuList;
    private final List<String> menuName = new ArrayList<>();  //고른 메뉴 이름 저장용

    public Kiosk(List<Menu> categories) {
        this.categories = categories;
    }

    public void start(){    //시작하면서 메뉴 목록이랑 사용자가 입력해야할 키 알려주는 메서드
        while (true){
            System.out.println("카테고리 선택 (종료 : 0)");

            System.out.println("0. 종료");
            for (int i = 0; i < categories.size(); i++) {
                System.out.println((i + 1) + ". " + categories.get(i).getCategory());
            }

            String inputCategory = sc.nextLine();

            if(exitProgram(inputCategory)){   //프로그램 종료 메서드 호출
                break;
            }

            if(compareCategory(inputCategory)) { //고른 카테고리 판별 및 반환값에 따라 프로그램 종료
                break;
            }
        }
    }

    private String compareInput(String category){    //사용자가 입력한 번호에 해당하는 메뉴 찾고 저장하는 메서드
        String input = "";

        while (true){
            String inputNum = sc.nextLine();    //사용자한테 입력받는 메뉴 번호

            if ("0".equals(inputNum)) {
                System.out.println("프로그램 종료");
                return "0"; // 종료를 위해 0 반환
            }

            switch (inputNum){
                case "1" :
                    input = inputReturn(inputNum);
                    addMenu(input, inputNum);
                    break;

                case "2" :
                    input = inputReturn(inputNum);
                    addMenu(input, inputNum);
                    break;

                case "3" :
                    input = inputReturn(inputNum);
                    addMenu(input, inputNum);
                    break;

                case "4" :
                    input = inputReturn(inputNum);
                    addMenu(input, inputNum);
                    break;

                case "000" :
                    System.out.println("뒤로");
                    return inputNum;

                default :
                    System.out.println("잘못입력했습니다. 다시 입력해주세요 (0: 종료, 1 ~ 4 : 메뉴선택, 000 : 뒤로");
                    break;
            }

            if(!menuName.isEmpty())
                printSelectedMenu(menuName, category);    //선택한 메뉴 목록, 가격 출력 메서드 호출

            input = inputNum;

            if(exitProgram(inputNum)){   //프로그램 종료 메서드 호출
                break;
            }

        }
        return input;
    }

    private void printSelectedMenu(List<String> menuName, String category){  //고른 메뉴 이름, 가격 알려주는 메서드
        System.out.println("[ ORDER MENU ] \n4. Orders     | 장바구니를 확인 후 주문합니다.\n5. Cancel     | 진행중인 주문을 취소합니다.");

        String input = sc.nextLine();
        if("4".equals(input)){
            System.out.println("아래와 같이 주문 하시겠습니까?\n[ Orders ]");
            for (String menu : menuName) {
                System.out.println(menu);
            }
            System.out.println("[ Total }");
            System.out.println("가격 : " + MenuItem.getTotalPrice() + "원");
            System.out.println("1. 주문     2. 메뉴판");
            String selectInput = sc.nextLine();

            if ("1".equals(selectInput)){
                System.out.println("주문이 완료되었습니다. 금액은 " + MenuItem.getTotalPrice() + "원 입니다.\n계속 주문하려면 1 ~ 4 입력, 종료시 0 입력");
            } else if ("2".equals(selectInput)) {
                selectMenu(category);
            } else {
                System.out.println("잘못 입력하셨습니다.");
            }
        } else if ("5".equals(input)) {
            menuName.removeAll(menuName);
            MenuItem.totalPrice(-MenuItem.getTotalPrice());
            System.out.println("장바구니가 초기화됐습니다. 다시 선택하세요.(1 ~ 4 입력시 메뉴선택, 0 입력시 종료");
        }
    }

    private boolean exitProgram(String inputNum){    //프로그램 종료 메서드
        return "0".equals(inputNum);
    }

    private boolean compareCategory(String category){ // 고른 카테고리에 따라 분기점
        if("1".equals(category)){
            menuList = categories.get(0).getMenuItems();    //1번이니까 햄버거 저장
            selectMenu(category);   //메뉴 출력 메서드 호출
        } else if("2".equals(category)){
            menuList = categories.get(1).getMenuItems();    //2번이니까 음료수 저장
            selectMenu(category);
        } else {
            System.out.println("잘못 입력하셨습니다. 다시입력해주세요");
            start();    //다시 시작부터
        }

        String exit = compareInput(category);   //메뉴 고르는 메서드 호출하면서 반환값 받기
        return exitProgram(exit);
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
        System.out.print("메뉴를 선택해주세요. (0 : 종료, 1 ~ 4 : 메뉴선택, 000 : 돌아가기) : ");
    }

    private String inputReturn(String input) {  //compareInput에서 장바구니에 추가할지 여부 확인
        System.out.println(menuList.get(Integer.parseInt(input) - 1) +"\n위 메뉴를 장바구니에 추가하시겠습니까? \n1. 확인         2.취소");
        return sc.nextLine();
    }

    private void addMenu(String input, String inputNum){ //compareInput에서 장바구니 추가 메서드
        int index = Integer.parseInt(inputNum) - 1;
        if("1".equals(input)){
            menuName.add(menuList.get(index).getFoodName());    //고른 메뉴 이름 저장
            MenuItem.totalPrice(menuList.get(index).getPrice());    //고른 메뉴 가격 저장
            System.out.println(menuList.get(index).getFoodName() + "가 장바구니에 추가되었습니다. 계속진행해주세요");
        } else if ("2".equals(input)) {
            System.out.println("취소되었습니다. 계속 진행해주세요");
        } else {
            System.out.println("잘못 입력하셨습니다. 다시 진행해주세요");
        }
    }
}
