/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package dao;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
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
        for(Subsidiary c :list)  result.put(c.getName(),c.getId().toString());
        return result;
    }
    
    public Map<String,String> drop_subsidiaries(Integer city_id, Integer agency_id){
        Criteria c = super.getSession().createCriteria(Subsidiary.class,"subsidiary");
        c.add(Restrictions.eq("city.id", city_id));
        c.add(Restrictions.eq("agency.id", agency_id));
        c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return createMapSubsidiaries(c.list());
    }
    
    public int [] other_subsidiaries(int pick_city_id, int drop_city_id, int pick_subsidiary_id){
        
        Criteria c = super.getSession().createCriteria(Subsidiary.class,"subsidiary");
        c.add(Restrictions.eq("city.id", pick_city_id));
        List<Subsidiary> pick = c.list();
        
        Criteria cr = super.getSession().createCriteria(Subsidiary.class,"subsidiary");
        cr.add(Restrictions.eq("city.id", drop_city_id));
        List<Subsidiary> drop= cr.list();
        
        int agency_id = super.find(pick_subsidiary_id).getAgency().getId();
        
        //get the remaining existing subsidiaries from same agency at pick city and drop
        int [] other_subs = null;        
        for (Subsidiary p : pick) {
            for (Subsidiary d : drop) {
                if ((p.getAgency().getId() == d.getAgency().getId()) && (p.getAgency().getId() != agency_id)) {
                    other_subs[other_subs.length] = p.getAgency().getId(); 
                }
            }
        }
        return other_subs;        
    }

}
