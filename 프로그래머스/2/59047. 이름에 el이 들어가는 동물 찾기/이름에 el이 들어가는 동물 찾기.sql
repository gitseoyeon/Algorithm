-- 코드를 입력하세요
SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
WHERE (NAME LIKE '%EL%' || '%El%' || '%eL' || '%el%') && (ANIMAL_TYPE = 'Dog')
ORDER BY NAME;