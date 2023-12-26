total = int(input())
k_total = int(input())
m_total = int(input())
k_max = int(input())
m_max = int(input())

a = k_total // k_max
b = m_total // m_max

if (k_total % k_max != 0) :
    a += 1

if (m_total % m_max):
    b += 1

if (a > b):
    total -= a
else:
    total -= b

print(total)