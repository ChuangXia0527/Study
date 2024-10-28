dic = {'admin':'123456','administrator':'12345678','root':'password'}
time = 3
for i in range(time):
    name = input()
    passes = input()
    if name in dic and dic[name] == passes:
        print('登录成功')
        break
    else:
        print('登录失败')
        
        