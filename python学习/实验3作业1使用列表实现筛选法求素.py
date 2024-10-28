a = int(input())  
b = list(range(2, a+1))  

for i in range(2, int(a ** 0.5) + 1):  
    b = list(filter(lambda x: x == i or x % i != 0, b))  

print(b)

