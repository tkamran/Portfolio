import random
class Deck:
    cards = []

    def __init__(self):
        self.construct_deck()

    def construct_deck(self):
        v = 2
        for s in ['Clubs', 'Diamonds', 'Hearts', 'Spades']:
            for r in [ 2, 3, 4, 5, 6, 7, 8, 9, 10, 'Jack', 'Queen', 'King', 'Ace' ]:
                self.cards.append(Card(s,r,v))
                v = v+1

    def drawCard(self):
        self.drawC =  self.cards.pop()
        return self.drawC

    def isEmpty(self):
        if(len(self.cards) == 0):
            print("the deck is empty")
        else:
            print("there are cards still in the deck")

    def shuffleDeck(self):
        random.shuffle(self.cards)

class Card:

    def __init__(self, suit, rank, value):
        self.rank = rank
        self.suit = suit
        self.value = value

score1 = 0
score2 = 0
p1 = Deck()
p2 = Deck()
p1.shuffleDeck()
p2.shuffleDeck()
p1.drawCard()


for x in range(5):
    card1 = p1.drawCard()
    card2 = p2.drawCard()

    print("player 1 card: " + str(card1.rank) + " " + str(card1.suit))
    print("player 2 card: " + str(card2.rank) + " " + str(card2.suit))

    if(card1.value > card2.value):
        score1 +=  card1.value + card2.value
        print("player 1 wins")
    else:
        score2 +=  card1.value + card2.value
        print("player 2 wins")

    print("scores: p1: " + str(score1) + " p2: " + str(score2))
