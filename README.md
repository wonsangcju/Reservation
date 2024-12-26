# Reservation
학생식당 자리 예약 프로그램

## 1. 개요
### 1.1 목적
Reservation 프로그램은 학생 식당에 가기 전 미리 자리를 예약할 수 있는 프로그램입니다.
### 1.2 대상
학생 식당을 이용하는 모든 교직원, 학생들이 사용할 수 있습니다.

## 2. 프로그램의 중요성 및 필요성
- Reservation 프로그램을 사용하면 학생 식당에 가기 전에
- 식단표를 통해 금주의 메뉴를 확인할 수 있고
- 미리 자리를 예약하고 식당에 갈 수 있어
- 식당에 가서 급하게 자리를 정하느라 헤매지 않을 수 있습니다.

## 3. 프로그램 수행 절차
### 3.1 클래스 다이어그램
![Reservatiom drawio](https://github.com/user-attachments/assets/a870c48f-d1f7-4b8b-ac2f-bf0a2e268325)
### 3.2 수행 절차
![로그인 화면](https://github.com/user-attachments/assets/0a025a7d-7b94-49c5-93b0-4f4b4504784a)
- 처음 프로그램을 실행하게 되면 로그인 화면이 나타나게 됩니다.
- 로그인 화면에서 아이디와 비밀번호를 입력하면 로그인을 할 수 있습니다.
  
![아이디 비밀번호 미작성](https://github.com/user-attachments/assets/0282e124-8860-4ee5-8aa2-774788f8ffad)
- 아이디나 비밀번호를 작성하지 않고 로그인 버튼을 누르게 된다면 경고 메세지가 나타나게 됩니다.

![아이디 비밀번호 불일치](https://github.com/user-attachments/assets/ca266942-67f5-4831-90f6-9d8da4b7841f)
- 회원가입 정보와 아이디, 비밀번호가 일치하지 않을 경우 오류 메세지가 나타나게 됩니다.

![로그인 성공](https://github.com/user-attachments/assets/f2947363-0465-4b3f-bec8-7e1800c8ae3a)
- 회원가입 정보와 아이디, 비밀번호가 일치할 경우 성공 메세지가 나타나고 예약 화면으로 이동하게 됩니다.

![회원가입 화면](https://github.com/user-attachments/assets/3dcc5a07-d978-4730-939d-ddacc21630e7)
- 회원가입 버튼을 누르게 되면 회원가입 화면으로 이동하게 됩니다.
- 회원가입 화면에서 아이디와 비밀번호를 입력하여 회원정보를 등록할 수 있습니다.

![아이디 중복](https://github.com/user-attachments/assets/32301aaa-0360-4fa7-8a7f-5733c3064d56)
- 아이디를 작성하고 중복 검사 버튼을 누르면 아이디 중복 검사를 실행하게 되는데
- 회원가입 정보에 이미 저장돼있는 아이디와 겹칠 경우 중복 메세지가 나타나게 됩니다.

![아이디 사용 가능](https://github.com/user-attachments/assets/9469691a-914b-400a-ab62-cb7f91d6af0b)
- 회원가입 정보에 저장돼있는 아이디와 겹치지 않을 경우 사용 가능 메세지가 나타나게 됩니다.

![회원가입 완료](https://github.com/user-attachments/assets/ee6d14e6-3587-412f-baad-54685399caf9)
- 아이디와 비밀번호를 모두 작성하고 회원가입 완료 버튼을 누르게 된다면 완료 메세지가 나타나고 로그인 화면으로 이동하게 됩니다.

![예약 화면](https://github.com/user-attachments/assets/3077c69f-09ff-4182-999c-9b1fc3f9d993)
- 예약 화면에서는 자리를 선택해서 자리를 예약할 수도 있고
- 메뉴 버튼을 눌러 다른 화면으로 이동할 수 있습니다.

![좌석 선택](https://github.com/user-attachments/assets/172a0b7d-1281-4d81-b9ad-9225ceb6d9f4)
- 좌석을 선택하게 되면 선택한 좌석의 번호에 대한 문구가 나타나게 됩니다.

![예약 완료 화면](https://github.com/user-attachments/assets/ebc598a2-02c2-4d2d-97f5-ad4499db6013)
- 좌석을 선택하고 예약 버튼을 누르게 되면 예약 완료 화면으로 이동하게 됩니다.
- 예약 완료 화면에서 홈 버튼을 누르게 되면 다시 예약 화면으로 이동하게 됩니다.

![예약 취소](https://github.com/user-attachments/assets/3e49c16c-59bc-4836-9dd5-1d3155550ea2)
- 예약했던 좌석을 선택하고 예약 취소 버튼을 누르면 예약 취소 문구가 나타나고 선택한 좌석의 예약이 취소됩니다.

![예약 취소 실패](https://github.com/user-attachments/assets/7b3cb4eb-5ec4-4c9a-af8b-bd6d339bc9c2)
- 예약 취소 실패 버튼을 눌렀는데 선택한 좌석이 예약되어 있지 않은 경우 취소할 예약이 없다는 문구가 나타나게 됩니다.

![메뉴 화면](https://github.com/user-attachments/assets/b0ae18de-6e1f-4956-a32b-c6b8adf1b09c)
- 좌상단 메뉴 버튼을 누르게 되면 메뉴 화면으로 이동하게 됩니다.
- 각 버튼을 누르면 해당하는 화면으로 이동하게 됩니다.

![식단표](https://github.com/user-attachments/assets/5377e356-c730-4d59-b587-aba795854d68)
- 식단표에서는 그 주의 요일에 따른 메뉴를 알 수 있습니다.
- 메인 화면 버튼을 누르면 예약 화면으로 이동하게 됩니다.

## 4. 느낀점
- 다른 클래스 파일에서 참조하여 사용하는 법, 카드레이아웃 사용법 등을 배웠고
- 프로그램을 아무것도 없이 1부터 만드니까
- 프로그램 구상하는 것부터 어려웠고 구조를 짜고 서로 충돌나지는 않는지 확인하고
- 기능을 하나하나 구현하는 것이 너무 어려웠습니다.
- 완성 자체는 어떻게든 했는데 코드가 너무 난잡한 것 같아서
- 다음에 또 프로그램을 만들게 된다면 코드가 너무 꼬여있지 않고
- 최대한 깔끔하게 코드를 짜기 위해 더 신경쓰게 될 것 같습니다.
