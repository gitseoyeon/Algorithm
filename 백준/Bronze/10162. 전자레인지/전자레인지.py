n = int(input()) # 정수 하나 입력
button = [300, 60, 10] # 5분, 1분, 10초 단위를 초 단위로 바꿔서 button 이라는 리스트에 담는다.
click = [0, 0, 0] # 각각의 버튼을 몇번 클릭해야하는지에 대한 정보 저장하는 리스트

for i in range(len(button)) : # 3번 반복
    if (n >= button[i]): # 입력 받은 수가 버튼 리스트들의 값과 비교해서 계산
        click[i] = n // button[i] # click 리스트에 입력받은 수와 button 리스트들의 값의 몫(=몇번 클릭하는지) 저장
        n %= button[i] # 입력 받은 수와 button 리스트 안의 값을 나눈 나머지의 값을 n 변수에 다시 넣는다.

if(n > 0): # 10초 단위로까지 나누어 떨어지지 않으면 -1을 출력
    print(-1)
else: # 몇번 클릭하는지 출력
    print(click[0], click[1], click[2])