n = int(input())

for _ in range(n) :
    score = 0
    bonus = 0
    quiz = input()
    for i in quiz :
        if i == 'O':
            bonus += 1
            score += bonus
        else :
            bonus = 0
    print(score)