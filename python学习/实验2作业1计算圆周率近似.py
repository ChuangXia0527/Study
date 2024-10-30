import random
seed1 = int(input())
n = int(input())
c = 0
random.seed(seed1)
for i in range(0,n):
 x = random.uniform(-1,1)
 y = random.uniform(-1,1)
 if(x**2+y**2 <= 1):
   c = c + 1 
pai = c/n*4
print(pai)

