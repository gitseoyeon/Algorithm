-- 코드를 입력하세요
SELECT ORDER_ID, PRODUCT_ID, DATE_FORMAT(OUT_DATE, '%Y-%m-%d') OUT_DATE,
CASE
		WHEN DATEDIFF('2022-05-01', OUT_DATE) >= 0
		THEN '출고완료'
		WHEN DATEDIFF('2022-05-01', OUT_DATE) < 0
		THEN '출고대기'
		WHEN OUT_DATE IS NULL
		THEN '출고미정'
	END AS 출고여부
FROM FOOD_ORDER
ORDER BY ORDER_ID;