userinput1 = input("Enter Rock / Paper/ Scissor for User1: ")
userinput2 = input("Enter Rock / paper/ Scissor for user2: ")
if userinput1 == "Rock":
    if userinput2 == "Scissor":
        print("Rock wins")
    else:
        print("Paper wins")
elif userinput1 == "Scissor":
    if userinput2 == "Paper":
        print("Scissor wins")
    else:
        print("Rock wins")
elif userinput1 == "Paper":
    if userinput2 == "Rock":
        print("Scissor Paper")
    else:
        print("Rock Scissor")
else:
        print("Invalid input! You have not entered Rock, Paper or Scissors, try again.")
