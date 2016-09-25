class Yelp(object):
    def __init__(self, restaurants, ratings):
        self.restaurants = restaurants
        self.ratings = ratings

    def find(self, coordinates, radius, dining_hour=None, sort_by_rating=False):
        # Returns list of Restaurant within radius.
        #
        #  coordinates: (latitude, longitude)
        #  radius: kilometer in integer
        #  dining_hour: If None, find any restaurant in radius.
        #               Otherwise return list of open restaurants at specified hour.
        #  sort_by_rating: If True, sort result in descending order,
        #                  highest rated first.
        for rest in self.restaurants:
            

class Restaurant(object):
    # where open_hour and close_hour is in [0-23]
    def __init__(self, id, name, latitude, longitude, open_hour, close_hour):
        self.id = id
        self.name = name
        self.coord = (latitude, longitude)
        self.hours = (open_hour, close_hour)

class Rating(object):
    # rating is in [1-5]
    def __init(self, restaurant_id, rating):
        self.restaurant_id = restaurant_id
        self.rating = rating

def main(argv):
    restaurants = [Restaurant(0, "Domino's Pizza", 37.7577, -122.4376, 7, 23), ...]
    ratings = [Rating(0, 3), ...]

    y = Yelp(restaurants, ratings)
    y.find((37.7, -122.6), 5, None, False)
