
users = {
    "aaa": "123456",
    "bbb": "888888",
    "ccc": "333333"
}
username = input()
password = input()
if username not in users:
    print("Wrong User")
elif users[username] != password:
    print("Fail")
else:
    print("Success")