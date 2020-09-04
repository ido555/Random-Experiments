import json as j

json = j.load(open("StreamingHistory0.json", "r", 4096, "utf-8"))
ms = 0
for obj in json:
    print(obj['msPlayed'])
    ms += int(obj['msPlayed'])

print("total ms = " + str(ms))
hours = ((ms / 1000) / 60) / 60
print("total hours = " + str(hours))
