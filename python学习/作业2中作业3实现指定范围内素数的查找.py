n = eval(input())
m = eval(input())
# 修改后正确代码为
primes = [i for i in range(n, m+1) if all(i % p != 0 for p in range(2, int(i**0.5) + 1))]
print(primes)