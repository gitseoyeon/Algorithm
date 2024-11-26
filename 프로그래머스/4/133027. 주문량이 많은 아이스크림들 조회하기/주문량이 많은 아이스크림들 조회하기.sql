-- 코드를 입력하세요
SELECT J.FLAVOR
FROM FIRST_HALF F JOIN JULY J ON F.FLAVOR = J.FLAVOR
GROUP BY J.FLAVOR
ORDER BY SUM(F.TOTAL_ORDER) + SUM(J.TOTAL_ORDER) DESC
LIMIT 3;
