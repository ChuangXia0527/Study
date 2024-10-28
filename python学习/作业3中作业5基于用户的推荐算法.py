import random

n = eval(input())
m = eval(input())
p = eval(input())

random.seed(n)
data = {'user'+str(i):{'film'+str(random.randrange(1, p)) for j in range(random.randrange(p))} for i in range(m)}
user = {'film1', 'film2', 'film3'}

similarUser, films = max(data.items(),\
                         key=lambda item: (item[1]!=user, len(item[1]&user)))

re_films = list(films - user)
print(sorted(re_films))