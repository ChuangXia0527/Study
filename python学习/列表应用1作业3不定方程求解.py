
a,b,c = map(int,input().split())
ls = list()
for i in range(c//a+1):
    if (c-a*i)%b==0:
        y = (c-a*i)//b
        if y>=0:
            ls.append([i,y])
print(ls)
print(len(ls))
