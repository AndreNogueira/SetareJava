/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package beans;

import java.util.Comparator;

/**
 *
 * @author pjmaia
 */
public class CarCostComparator implements Comparator<CarCost>{
    @Override
    public int compare(CarCost cc1, CarCost cc2) {
        if(cc1.getCost() > cc2.getCost()) return 1;
        else if(cc1.getCost() < cc2.getCost()) return -1;
        else return 0;
    }
}
