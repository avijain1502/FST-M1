import pandas as pd

data = {
    "Usernames": ["admin", "Charles", "Deku"],
    "Passwords": ["password", "Charl13", "AllMight"]
}

dataframe = pd.DataFrame(data)

# Print the DataFrame
print(dataframe)

"""
 Write the DataFrame to a CSV file
 To avoid writing the index numbers to the file as well
 the index property is set to false
"""
dataframe.to_csv("../inputs/sample.csv", index=False)

creds = pd.read_csv("../inputs/sample.csv")
print(creds)
print("-----------------------------------------")
print(creds["Usernames"])
print("-----------------------------------------")
print(creds["Usernames"],creds["Passwords"])
print("-----------------------------------------")
print(creds.sort_values("Usernames",ascending=True))
print("-----------------------------------------")
print(creds.sort_values("Usernames",ascending=False))