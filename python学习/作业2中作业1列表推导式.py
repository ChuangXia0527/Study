scores = {"Zhang San": 45, "Li Si": 78, "Wang Wu": 40,"Zhou Liu": 96,"Zhao Qi": 65, "Sun Ba": 90,"Zheng Jiu": 78, "Wu Shi": 99,"Dong Shiyi": 60}
result = sum(scores.values())
print(f"最高分是:{max(scores.values())},最低分是{min(scores.values())},平均分是{result/9:.3f}")

def find_key_by_value(dictionary, value):
    for key, val in dictionary.items():
        if val == value:
            return key
    return None  

print(f"最高分对应的学生是{find_key_by_value(scores, max(scores.values()))}")