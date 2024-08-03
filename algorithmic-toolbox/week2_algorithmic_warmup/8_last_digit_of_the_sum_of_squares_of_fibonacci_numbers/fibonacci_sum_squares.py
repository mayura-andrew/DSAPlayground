def fibonacci_sum_squares_naive(n):
    if n <= 1:
        return n

    previous, current, sum = 0, 1, 1

    for _ in range(n - 1):
        previous, current = current, previous + current
        sum += current * current

    return sum % 10

def fibonacci_sum_squares(n):
    if n <= 1:
        return n

    previous, current = 0, 1
    seq_sum = 1

    for _ in range(2, 60):
        previous, current = current, (previous + current) % 10
        seq_sum = (seq_sum + current * current) % 10

    seq_sum = (seq_sum * (n // 60 % 10)) % 10

    previous, current = 0, 1
    for i in range(60):
        if i <= 1 and i <= n % 60:
            seq_sum = (seq_sum + i) % 10
        elif i <= n % 60:
            previous, current = current, (previous + current) % 10
            seq_sum = (seq_sum + current * current) % 10

    return seq_sum


if __name__ == '__main__':
    n = int(input())
    print(fibonacci_sum_squares(n))
