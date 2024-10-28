#获取用户输入月份，输出该月有多少天（考虑闰年）。
date = input()
year, month = map(int, date.split(','))
is_lean = (year % 100 ==0 and year % 4==0) or (year % 400 == 0)
if month == 2:
    if is_lean:
        print("29")
    else:
        print("28")
if month in [1,3,5,7,8,10,12]:
    print("31")
elif month in [4,6,9,11]:
    print("30")
