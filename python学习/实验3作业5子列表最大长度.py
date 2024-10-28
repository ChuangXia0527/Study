list1 = eval(input())
maxlen = 0
def find_max(a):
    lena = len(a)
    global maxlen
    maxlen = max(lena,maxlen)
    for i in range(lena):
        if isinstance(a[i],list):
            find_max(a[i])
find_max(list1)
print(maxlen)
