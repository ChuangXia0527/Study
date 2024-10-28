x = input()
ls = list(map(int, x.split()))
y = int(input())
found = False
for i in ls[:]:  
    if i == y:
        ls.remove(i)
        found = True

if not found:
    print('NOT FOUND')
else:
    print(ls)