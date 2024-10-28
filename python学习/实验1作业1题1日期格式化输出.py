#日期格式化输出
year = input() # 输入当前年，2020
month = input() # 输入当前月，09
date = input() # 输入当前日，16
print(year, month, date)
print(f"{year}-{month}-{date}")
print(f"{year}/{month}/{date}")
print(f"{month},{date},{year}")
print("{}年{}月{}日".format(year, month, date))
print(year + "年" + month + "月" + date + "日")
