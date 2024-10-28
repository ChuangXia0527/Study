#第一个输入是n，代表课程数
#第二个输入是m，代表人数
n,m = map(int,input().split())
scores = list()
for _ in range(m):
    scores.append(list(map(float,input().split())))
for i in range(n):
    all = 0
    for j in range(m):
        all +=scores[j][i]
    avg = all/m
    print(f"{avg:.1f}")
    

