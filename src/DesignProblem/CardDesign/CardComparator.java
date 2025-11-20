package DesignProblem.CardDesign;

public interface CardComparator {
    int compare(Card c1,Card c2);
}
class RankComparator implements CardComparator {
    @Override
    public int compare(Card c1, Card c2) {
        return Integer.compare(c1.getRank().ordinal(), c2.getRank().ordinal());
    }
}

class SuitComparator implements CardComparator{

    @Override
    public int compare(Card c1, Card c2) {
        return Integer.compare(c1.getSuit().ordinal(),c2.getSuit().ordinal());
    }
}

class RankThenSuitComparator implements CardComparator{
    @Override
    public int compare(Card c1, Card c2) {
        int rankCompare = new RankComparator().compare(c1, c2);
        if (rankCompare != 0) {
            return rankCompare;
        }
        return new SuitComparator().compare(c1, c2);
    }
}