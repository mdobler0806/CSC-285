import java.text.NumberFormat;
import java.util.Locale;

public class Stock {
    private String tickerSymbol;
    private double currentPrice;
    private int numSharesOwned;
    private final NumberFormat cashFormat = NumberFormat.getCurrencyInstance(Locale.US);
    public Stock(String tickerSymbol, double currentPrice)
    {
        this.tickerSymbol = tickerSymbol;
        this.currentPrice = currentPrice;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }
    public void buyShares(int numSharesToBuy)
    {
        this.numSharesOwned += numSharesToBuy;
    }
    public void sellShares(int numSharesToSell)
    {
        if(numSharesToSell <= numSharesOwned)
        {
            numSharesOwned -= numSharesToSell;
        }
    }
    public double getTotalValue()
    {
        return (this.getCurrentPrice() * this.numSharesOwned);
        //return cashFormat.format(this.getCurrentPrice() * this.numSharesOwned);
    }

}
