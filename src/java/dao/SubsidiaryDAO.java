/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package dao;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import model.City;
import model.Subsidiary;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author pjmaia
 */
public class SubsidiaryDAO extends AbstractDAO<Subsidiary>{
    
    
    public Map<String,String> pick_subsidiaries(Integer city_id){
        Criteria c = super.getSession().createCriteria(Subsidiary.class,"subsidiary");     
        c.add(Restrictions.eq("city.id", city_id));
        c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return createMapSubsidiaries(c.list());
    }    
    
    private Map<String,String> createMapSubsidiaries(List<Subsidiary> list){
        Map<String,String> result = new TreeMap<>();
        for(Subsidiary c :list)  result.put(c.getId().toString(),c.getName());
        return result;
    }
    

    
}
