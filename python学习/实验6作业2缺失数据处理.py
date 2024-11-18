import csv

s = input()

file_path = "python学习\\filldata.csv"
data = []

with open(file_path, "r", encoding="GBK") as file:
    reader = csv.reader(file)
    for row in reader:
        row = [s if cell == '' or cell is None else cell for cell in row]
        data.append(row)

print(data)
