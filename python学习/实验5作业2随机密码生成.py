
import random

def genpwd(length):
    passwd = ''
    for i in range(length):
        passwd += str(random.randint(1,9))
    return passwd

length = eval(input())
random.seed(17)
for i in range(3):
    print(genpwd(length))
