







def gcd(x, y):
    a = max(x, y)
    b = min(x, y)
    
    if b == 0:
        return a
    else:
        return gcd(b, a % b)
    
def lcm(a, b):
    g = gcd(a, b)
    return a * b // g


if __name__ == '__main__':
    a, b = map(int, input().split())
    print(lcm(a, b))

