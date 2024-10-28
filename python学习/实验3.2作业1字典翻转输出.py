try:
 d = {}
 a = input()
 b = eval(a)
 for i in b:
     d[b[i]] = i
 print(d)
except:
 print('输入错误')