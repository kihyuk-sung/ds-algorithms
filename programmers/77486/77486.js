function solution(enroll, referral, seller, amount) {
  // 알고리즘 실행 코드
  const reversedTree = initReversedTree(enroll, referral);
  const profits = initProfits(enroll);

  // 한 판매인에 대해서 계산
  for (let index = 0; index < seller.length; index++) {
    const s = seller[index];
    const a = amount[index];

    calculateReferralsProfit(s, a);
  }

  return [...profits.values()];

  // 해당 판매자에 의한 수익 분배를 계산
  function calculateReferralsProfit(seller, amount) {
    let currentSeller = seller;
    let profit = amount * 100;

    while (currentSeller !== '-') {
      const currentReferralProfit = profits.get(currentSeller);

      // 추천인에게 보낼 금액 10%
      const profitForReferral = Math.floor(profit / 10);

      // 90%를 자신의 수익으로 계산하여 저장
      profits.set(currentSeller, currentReferralProfit + profit - profitForReferral);

      // 추천인에게 보낼 금액이 없으면 while 문을 끝냄
      if (profitForReferral === 0) {
        break;
      }

      // 그렇지 않은 경우, 다음 반복문을 위해 추천인으로 설정
      currentSeller = reversedTree.get(currentSeller);
      profit = profitForReferral;
    }
  }
}

// child가 parent를 가리키는 그래프 (reversedTree)를 초기화
function initReversedTree(enroll, referral) {
  const result = new Map();
  enroll.forEach((e, index) => {
    result.set(e, referral[index]);
  })
  return result;
}

// enroll 순서에 맞게 Profit을 구성할 수 있도록 seller - profit을 0으로 초기화
function initProfits(enroll) {
  const result = new Map();
  enroll.forEach(e => {
    result.set(e, 0);
  })
  return result;
}
