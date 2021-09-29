class HousePark:
    lastname="박"
    def __init__(self, name):
        self.fullname=self.lastname+name
    def travel(self, where):
        print("%s,%s 여행을 가다." %(self.fullname, where))
pey = HousePark("응용")
pey.travel("부산")
print(pey.lastname)
print(pey.fullname)