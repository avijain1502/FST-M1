username = input("Enter username:")
age = input("Enter age:")

age = int(age)
plusyear = 100 - age
year = 2024 + plusyear
print(username + " will turns age 100 in the year "+ str(year))
print(username + " will turns age 100 in the year "+ {}.format(year))