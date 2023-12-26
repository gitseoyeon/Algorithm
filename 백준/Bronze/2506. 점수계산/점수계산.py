n = int(input())
score = 0
total = 0

# 한줄에 여러개의 값을 리스트에 담는다
a_list = list(map(int, input().split()))

for i in range(len(a_list)): # 리스트 값의 길이만큼 데이터 입력 받는다
    if a_list[i] == 1: # 값이 1인 경우
        score += 1
    else :
        score = 0
    total += score
    i += 1

print(total)
