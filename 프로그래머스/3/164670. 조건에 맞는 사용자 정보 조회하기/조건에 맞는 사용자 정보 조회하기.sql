-- 코드를 입력하세요
select u.USER_ID, u.NICKNAME, CONCAT(u.CITY, " ", u.STREET_ADDRESS1, " ", u.STREET_ADDRESS2) 전체주소, 
CONCAT(SUBSTR(TLNO, 1, 3), "-", SUBSTR(TLNO, 4, 4), "-", SUBSTR(TLNO, 8, 4)) 전화번호 from USED_GOODS_BOARD b join USED_GOODS_USER u on b.WRITER_ID = u.USER_ID
group by u.USER_ID HAVING COUNT(u.USER_ID) >= 3 
order by u.USER_ID desc;