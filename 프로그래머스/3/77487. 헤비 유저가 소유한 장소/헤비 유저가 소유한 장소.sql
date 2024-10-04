-- 코드를 입력하세요
SELECT P.ID, P.NAME, P.HOST_ID
FROM PLACES P JOIN (
    SELECT COUNT(HOST_ID), ID, NAME, HOST_ID,
    CASE WHEN COUNT(HOST_ID) > 1 THEN 'O' 
    END CHECKED
    FROM PLACES
    GROUP BY HOST_ID
) A ON P.HOST_ID = A.HOST_ID
WHERE CHECKED = 'O'
ORDER BY P.ID;
