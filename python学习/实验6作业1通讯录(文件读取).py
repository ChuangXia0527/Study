import csv


def read_csv_to_dict(file_path):
    data_dict = {}
    with open(file_path, mode='r', encoding='GBK') as file:
        reader = csv.reader(file)
        for row in reader:
            data_dict[row[0]] = [row[1], row[2]]
    return data_dict


def process_input(data_dict):
    user_input = input().strip()
    if user_input == 'A':
        for key, value in data_dict.items():
            print(f"{key} {value[0]} {value[1]}")
    elif user_input == 'D':
        print(data_dict)
    else:
        print("ERROR")


if __name__ == "__main__":
    file_path = "python学习\info.csv"
    try:
        data_dict = read_csv_to_dict(file_path)
        process_input(data_dict)
    except FileNotFoundError:
        print("文件未找到，请检查路径！")
    except Exception as e:
        print(f"发生错误：{e}")
