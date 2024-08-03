






# Uses python3
import sys

def fibonacci_partial_sum_naive(from_, to):
    _sum = 0

    current = 0
    _next  = 1

    for i in range(to + 1):
        if i >= from_:
            _sum += current

        current, _next = _next, current + _next

    return _sum % 10




def get_fibonacci_partial_sum(from_index, to_index):
    if to_index < from_index:
        return 0

    vec = [0, 1] + [0] * 58
    previous, current = 0, 1
    seq_sum = 1

    for i in range(2, 60):
        previous, current = current, (previous + current) % 10
        seq_sum = (seq_sum + current) % 10
        vec[i] = current

    seq_sum = (seq_sum * ((to_index - from_index + 1) // 60 % 10)) % 10

    if from_index // 60 == to_index // 60:
        for i in range(from_index % 60, (to_index % 60) + 1):
            seq_sum = (seq_sum + vec[i]) % 10
    else:
        for i in range(60):
            if i >= from_index % 60:
                seq_sum = (seq_sum + vec[i]) % 10
            if i <= to_index % 60:
                seq_sum = (seq_sum + vec[i]) % 10

    return seq_sum

if __name__ == '__main__':
    input = sys.stdin.read();
    from_, to = map(int, input.split())
    print(get_fibonacci_partial_sum(from_, to))
