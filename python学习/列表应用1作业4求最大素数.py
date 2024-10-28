#从键盘输入一个整数n，输出1~n之间的最大素数
#不要修改原代吗结构，只改正其中错误的行
n = eval(input())
max = -1  
for i in range(2, n + 1):  
    for k in range(2, int(i**0.5) + 1):  
        if i % k == 0:
            break
    else:
        max = i 
if max != -1:
    print(max)  