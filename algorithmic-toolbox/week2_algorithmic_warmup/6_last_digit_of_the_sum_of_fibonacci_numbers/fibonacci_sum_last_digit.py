def fibonacci_sum_naive(n):
    if n <= 1:
        return n

    previous, current, _sum = 0, 1, 1

    for _ in range(n - 1):
        previous, current = current, previous + current
        _sum += current

    return _sum % 10


def fibonacci_sum(n):
    if n <=1:
        return n
    previous, current = 0, 1
    res_sum, seq_sum = 1, 1
    
    for _ in range(59):
        previous, current = current, previous + current
        seq_sum = (seq_sum + current) % 10
        
        if _ < (n - 1) % 60:
            res_sum = (res_sum + current) % 10
    return (seq_sum * ((n - 1) // 60) + res_sum) % 10

if __name__ == '__main__':
    n = int(input())
    print(fibonacci_sum(n))
