def fbi(n):
    small = n-2
    big = n-1
    if n==1 or n==2:
        return 1
    else:
        return fbi(small)+fbi(big)

n = eval(input())
print(fbi(n))