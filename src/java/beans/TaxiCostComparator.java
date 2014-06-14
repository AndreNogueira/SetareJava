package beans;

import java.util.Comparator;

public class TaxiCostComparator implements Comparator<TaxiCost>{

    @Override
    public int compare(TaxiCost tc1, TaxiCost tc2) {
        if(tc1.getCost() > tc2.getCost()) return 1;
        else if(tc1.getCost() < tc2.getCost()) return -1;
        else return 0;
    }
    
}
