






import math


def optimal_summands(n):
    summands = []
    # write your code here
    k = math.floor((-1 + math.sqrt(1+8*n)) /2 )
    
    for i in range(1, k):
        summands.append(i)
        
    summands.append(int(n - k*(k-1) / 2))
    
    return summands


if __name__ == '__main__':
    n = int(input())
    summands = optimal_summands(n)
    print(len(summands))
    print(*summands)
