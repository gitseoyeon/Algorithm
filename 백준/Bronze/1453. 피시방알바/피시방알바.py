total = int(input())
count = 0

a_list = list(map(int, input().split()))
seat = []

for i in range(total):
    if a_list[i] in seat:
        count += 1
    else:
        seat.append(a_list[i])

print(count)