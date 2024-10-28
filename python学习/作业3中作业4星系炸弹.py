from datetime import datetime, timedelta
date = input()
boom_day = int(input())
start_date = datetime.strptime(date,"%Y,%m,%d")
over_date = start_date + timedelta(days=boom_day)
print(over_date.strftime("%Y-%m-%d"))