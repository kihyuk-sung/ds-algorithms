# 다단계 칫솔 판매

https://programmers.co.kr/learn/courses/30/lessons/77486

## 풀이 과정

1. 자식에서 부모로 향하는 인접리스트 그래프 구성
2. enroll 순서로 profit 저장하는 Map 구성
3. seller 한명에 대해서 이익 분배 계산
  - 판매 금액에 대해서 90%는 해당 판매원에게 분배
  - 나머지 10%는 추천인 쪽으로 넘겨서 다시 계산
  - 이때, 추천인에게 갈 금액이 0이라면 빠른 종료

4. Map의 value들을 결과로 반환.

