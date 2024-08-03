def fibonacci_naive(n):
    if n <= 1:
        return n
    return fibonacci_number(n - 1) + fibonacci_number(n - 2)

def fibonacci_number(n, memo={}):
    if n in memo:
        return memo[n]
    if n <= 1:
        return n
    memo[n] = fibonacci_number(n - 1, memo) + fibonacci_number(n - 2, memo)
    return memo[n]




if __name__ == '__main__':
    input_n = int(input())
    print(fibonacci_number(input_n))
