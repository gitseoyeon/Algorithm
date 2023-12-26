while True :
    n_list = []
    num = input()
    if num == '0':
        break;
    for i in num:
        n_list.append(i)

    sum = 0

    for i in n_list:
        sum += 1
        
        if i == '0':
           sum += 4
        elif i == '1':
           sum += 2
        else:
           sum += 3
       
    sum += 1
    print(sum)
