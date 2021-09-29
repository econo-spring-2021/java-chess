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
* [x] 이동 경로에 장애물이 있는 경우, 뛰어넘어서 이동할 수 없는 체스말의 isAbleToMove() 수정
* [x] 목적이에 아군이 있는 경우, 체스말의 isAbleToMove() 수정
* [x] Move() 관련하여 부족한 테스트 코드 추가

# 2 step Feedback 
* [x] 피드백 응답
* [x] 이동 명령의 좌표 파싱을 controller에서 view로 
* [x] ChessBoard의 타입을 List에서 Array로
* [x] ChessUnitType의 대소문자 필드를 통일하고 toUpperCase()/toLowerCase() 활용