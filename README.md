# 키오스크 과제입니다.


## level1

제가 문제를 잘못 이해하여 레벨1부터 도전과제 1에서 요구하는 내용과 비슷한 코드를 짜게 됐습니다.</br>
메뉴들이 출력되면 해당 메뉴의 번호를 고릅니다. 고른 메뉴들과 가격이 출력되는 코드입니다.
</br>

## level2

메뉴아이템 클래스가 추가되어 메뉴를 메뉴아이템에서 관리하며 메인 클래스에서 실행하게 되는 구조로 바뀌었습니다.</br>
메뉴의 저장과 출력은 여전히 메인 클래스에서 맡고 있습니다.
</br>

## level3

키오스크 클래스를 만들어 전체적인 순서 제어는 이제 메인 클래스가 아닌 키오스크 클래스가 담당합니다.</br>
메인에서는 이제 메뉴 아이템 클래스를 리스트로 선언해 키오스크 클래스에 생성자로 메뉴에 대한 정보를 넘겨줍니다.
</br>

## level4

메뉴 클래스가 추가됩니다. 메뉴 클래스는 카테고리를 담당하는 클래스입니다. </br>
키오스크에서 관리하던 메뉴리스트를 메뉴 클래스가 관리합니다.</br>
카테고리가 생겨남에 따라 햄버거와 음료 카테고리가 추가됐습니다.</br>
이제 각 카테고리에 해당하는 메뉴를 고를 수 있습니다.(햄버거 고르다가 돌아가서 음료를 골라도 메뉴의 이름과 총 가격이 출력됨.)
</br>

## level5

처음부터 캡슐화를 염두해두고 코드를 작성해 이 단계는 넘어갔습니다.
</br>

## level6

장바구니 개념이 추가됐습니다.</br>
메뉴를 선택하면 이제 장바구니에 추가할지 여부 선택 및 선택시 메뉴가 장바구니에 추가됩니다.</br>
장바구니에 메뉴가 담기면 주문할지 취소할지 선택 여부가 나옵니다.</br>
주문한다고 선택하면 최종적으로 주문할지 메뉴판으로 돌아갈지 출력됩니다.</br>
최종 단계에서 메뉴판으로 돌아가면 장바구니 내역은 삭제되지 않으며 다시 선택한 메뉴와 합산하여 출력됩니다.
