








def fibonacci_huge_naive(n, m):
    if n <= 1:
        return n

    previous = 0
    current  = 1

    for _ in range(n - 1):
        previous, current = current, previous + current

    return current % m

def get_fibonacci_huge(n, m):
    if n <= 1:
        return n

    previous, current = 0, 1
    pisano = [0, 1]

    while True:
        tmp_previous = previous
        previous = current
        current = (tmp_previous + current) % m
        pisano.append(current)
        if current == 1 and previous == 0:
            break
        
    return pisano[n % len(pisano)]

if __name__ == '__main__':
    n, m = map(int, input().split())
    print(get_fibonacci_huge(n, m))
