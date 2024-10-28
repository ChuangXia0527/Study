#t = (1,2,3,4,5)
#y = (5,6,7,8,10)
t = eval(input())
y = eval(input())
n = len(t)
tA = sum(t)/n
yA = sum(y)/n
lt = sum(map(lambda x,y:x*y,t,y)) - n*tA*yA
ly = sum(map(lambda x:x*x,t)) - n*tA**2
k = round(lt/ly,3)
b = round(yA-k*tA,3)
distance = sum(map(lambda x,y:(k*x+b-y)**2, t, y))
distance = round(distance,3)
result = round((n+1)*k+b,3)
print(result)