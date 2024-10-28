money = 1000
option = int(input())
while True:
 if option == 1:
     option1 = int(input())
     if option1>money:
        print('Insufficient Funds')
        break
     elif option1<100 or option1%100!=0:
        print('Incorrect Amount')
        break
     elif option1>=100 and option1 % 100 ==0:
        money = money - option1
        print(f'Balance:{money}')
        break
 elif option == 2:
     option2 = float(input())
     if option2 >=100 and option2%100==0:
        money = money + option2
        print(f'Balance:{money:.0f}')
        break
     elif option2<100 or option2%100!=0:
        print('Incorrect Amount')
        break
 else:
    print('Wrong Option')
    break
        

     