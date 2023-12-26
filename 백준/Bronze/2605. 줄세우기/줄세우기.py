n  = int(input())
n_list = list(map(int, input().split()))
s_list = []

for i in range (n):
    s_list.insert(i-n_list[i], i+1)

for i in s_list:
    print(i, end = ' ')

