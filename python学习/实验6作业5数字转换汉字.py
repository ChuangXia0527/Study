def num_to_chinese():
    num_map = ['零', '一', '二', '三', '四', '五', '六', '七', '八', '九']

    while True:
        try:
            user_input = input()
            
            if user_input.lower() == 'h':
                raise ValueError("输入错误，请重新输入")
            
            num = int(user_input)
            
            if num <= 9:
                print(f"{num_map[num]}")
                break
            else:
                raise IndexError("输入超出范围")
        
        except ValueError as e:
            if str(e) == "输入错误，请重新输入":
                print("输入错误，请重新输入")
                break
            else:
                print("输入类型错误，请输入整数")
                break
        except IndexError:
            print("输入超出范围")
            break
        except Exception as e:
            print(f"输入错误，请重新输入")
            break

num_to_chinese()
