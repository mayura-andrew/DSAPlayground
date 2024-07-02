import time


def fibonacci(n, memo={}):
    if n <= 1:
        return n
    if n in memo:
        return memo[n]
    memo[n] = fibonacci(n - 1, memo) + fibonacci(n - 2, memo)
    return memo[n]

start = time.time()
result = fibonacci(50)
elapsed = time.time() - start
print(f"The 50th Fibonacci number is: {result}\nCalculation time: {elapsed:.6f} seconds")



def gcd(a, b):
    while b != 0:
        a, b = b, a % b
        
    return a

start = time.time()
result = gcd(357, 234)
elapsed = time.time() - start
print(f"The greatest common divisor of 357 and 234 is: {result}\nCalculation time: {elapsed:.6f} seconds")

        