-- 코드를 입력하세요
# SELECT YEAR(SALES_DATE) YEAR, MONTH(SALES_DATE) MONTH, 
# COUNT(MONTH(SALES_DATE)) PURCHASED_USERS,
# ROUND(COUNT(MONTH(SALES_DATE))/
# (SELECT COUNT(*) 
# FROM USER_INFO
# WHERE YEAR(JOINED) = 2021), 1) PURCHASED_USERS
# FROM(
#     SELECT O.ONLINE_SALE_ID, S.USER_ID, O.PRODUCT_ID, O.SALES_AMOUNT, O.SALES_DATE
#     FROM ONLINE_SALE O JOIN (
#         SELECT USER_ID, JOINED
#         FROM USER_INFO
#         WHERE YEAR(JOINED) = 2021
#     ) S ON O.USER_ID = S.USER_ID
# ) A
# GROUP BY YEAR, MONTH
# ORDER BY YEAR, MONTH

SELECT YEAR(O.SALES_DATE) YEAR, MONTH(O.SALES_DATE) MONTH, COUNT(DISTINCT(U.USER_ID)) PURCHASED_USERS,
ROUND(COUNT(DISTINCT(U.USER_ID)) / 
     (SELECT COUNT(*)
     FROM USER_INFO
     WHERE YEAR(JOINED) = 2021), 1) PUCHASED_RATIO
FROM USER_INFO U JOIN ONLINE_SALE O ON U.USER_ID = O.USER_ID
WHERE YEAR(U.JOINED) = 2021
GROUP BY YEAR, MONTH
ORDER BY YEAR, MONTH
