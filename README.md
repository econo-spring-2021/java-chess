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
* [ ] 콘솔 기능 추가
  * [ ] 명령어 안내 콘솔 출력 구현
  * [ ] move 명령 입력 받기
  * [ ] move 명령 수행 코드 작성