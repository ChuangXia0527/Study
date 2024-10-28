list1 = eval(input())
sorted_list = sorted(list1, key=lambda x: (abs(x), x),reverse= True)
result = ','.join(map(str, sorted_list))
print(result)
