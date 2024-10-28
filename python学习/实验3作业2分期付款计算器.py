a1 = float(input())
a2 = int(input())
a3 = input()
a4 = float(input())
if a3 == 'ACPI':
    re1 = a1 * a4 * (1 + a4)**a2 / ((1 + a4)**a2 - 1)
    print(round(re1,2))
elif a3 == 'AC':
    re2 = []
    for i in range(1,a2+1):
        re1 = a1 / a2 + (a1 - (i - 1) * a1 / a2) * a4
        re2.append(round(re1,2))
    print(f"[{', '.join(map(str,re2))}]")
else:
    print("还款方式输入错误")


