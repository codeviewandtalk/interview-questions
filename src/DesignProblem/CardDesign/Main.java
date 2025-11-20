package DesignProblem.CardDesign;

public class Main {
    public static void main(String[] args) {
        Card card1 = new Card(Suit.HEARTS, Rank.TEN);
        Card card2 = new Card(Suit.SPADES, Rank.TEN);
        Card card3 = new Card(Suit.CLUBS, Rank.ACE);

        CardComparator rankComparator = new RankComparator();
        CardComparator suitComparator = new SuitComparator();
        CardComparator rankThenSuitComparator = new RankThenSuitComparator();

        System.out.println("Comparing by Rank:");
        printComparison(card1, card2, rankComparator);

        System.out.println("\nComparing by Suit:");
        printComparison(card1, card2, suitComparator);

        System.out.println("\nComparing by Rank then Suit:");
        printComparison(card1, card2, rankThenSuitComparator);

        System.out.println("\nComparing " + card3 + " and " + card1 + " by Rank:");
        printComparison(card3, card1, rankComparator);
    }
    private static void printComparison(Card c1, Card c2, CardComparator comparator) {
        int result = comparator.compare(c1, c2);
        if (result < 0) {
            System.out.println(c2 + " is higher than " + c1);
        } else if (result > 0) {
            System.out.println(c1 + " is higher than " + c2);
        } else {
            System.out.println(c1 + " and " + c2 + " are equal");
        }
    }
}
