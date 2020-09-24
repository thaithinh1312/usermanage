package assignment3;

public interface BorrowInfo extends Comparable<User>, Cloneable
{
    int getMaxNumberOfAllowedBook();
    public User clone() throws CloneNotSupportedException;
}
