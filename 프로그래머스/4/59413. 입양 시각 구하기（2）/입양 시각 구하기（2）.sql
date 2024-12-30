-- 코드를 입력하세요
SET @hour := -1;

SELECT @hour := @hour + 1 hour,
    (SELECT COUNT(HOUR(DATETIME))
    FROM ANIMAL_OUTS
    WHERE HOUR(DATETIME) = @hour) COUNT
FROM ANIMAL_OUTS
WHERE @hour + 1 < 24