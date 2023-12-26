x_list = [] # 입력 받은 수에 42를 나눈 값을 저장하는 리스트

for i in range(10): 
    # 10개의 정수를 입력 받는 반복문
    n = int(input())
    x_list.append(n % 42) # 입력 받은 수를 42로 나눈 나머지의 값을 리스트 안에 추가한다

y_set = set(x_list) # x_list의 값들을 y_set이라는 집합 자료형으로 변경 (중복 제거)

print(len(y_set)) # y_set 길이 출력