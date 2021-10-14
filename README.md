# java-chess
체스 미션을 진행하는 저장소

# 1 step features
* [x] Initialize chess game
  * [x] Initialize chessboard
  * [x] Initialize unit
  * [x] Locate initial unit to initial position
* [x] Feature console
  * [x] Print announcement
  * [x] Execution the command according to input

# 2 step features
* [x] ChessUnit을 상속하는 체스 종류별 체스말들의 클래스 구현하기
  * [x] 체스판 기준 변경에 따른 체스판 관련 코드 변경 - (0,0) 즉 (1,a)가 좌하단 (현재는 좌상단)
  * [x] 체스 이동 코드 추가 (ChessUnit -> ChessBoard 조작)
* [x] 콘솔 기능 추가
  * [x] 명령어 안내 콘솔 출력 구현
  * [x] move 명령 입력 받기
  * [x] move 명령 수행 코드 작성
* [x] 이동 경로에 장애물이 있는 경우, 뛰어넘어서 이동할 수 없는 체스말의 isA****bleToMove() 수정
* [x] 목적이에 아군이 있는 경우, 체스말의 isAbleToMove() 수정
* [x] Move() 관련하여 부족한 테스트 코드 추가

# 2 step Feedback 
* [x] 피드백 응답
* [x] 이동 명령의 좌표 파싱을 controller에서 view로 
* [x] ChessBoard의 타입을 List에서 Array로
* [x] ChessUnitType의 대소문자 필드를 통일하고 toUpperCase()/toLowerCase() 활용

# Refactoring after reviewing 
* [x] 명명된 이름들 간소화
* [x] 체스말 위치&이동에 대한 정보와 관렴 함수들 클래스화 (Position.java)
* [x] 게임 로직 코드에서의 Position 클래스와 관련된 예외 처리
* [x] Exception 추가 및 처리
* [ ] 체스말의 interface 리팩토링과 MovableStrategy interface 도입****

# 3 step features
* [x] King이 죽으면 게임 종료 
* [ ] status 명령어 구
  * [x] test case
  * [x] 승패 판별 구현
  * [x] 점수 판별 구현
  * [x] input, output

# Refactoring after feedback
* [x] Fix Chessboard initializing test
* [x] instanceof 사용 부분 리펙토링
* [x] Rook class의 잘못된 TYPE 고치기 
* [x] javadoc 주석 작성
* [x] 반복된 한줄 . 수정
* [ ] 명령어 switch 수정 