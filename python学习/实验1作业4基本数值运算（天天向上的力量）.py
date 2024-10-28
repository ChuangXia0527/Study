num = float(input())
num1 = 1*pow(1+(num/100),365)
num2 = 1*pow(1-(num/100),365)
print("天天努力的结果{:.3f}，天天躺平的结果{:.3f}".format(num1,num2))