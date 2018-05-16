
package dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Claims;
import model.Pizza;

@ManagedBean
@Stateless
public class PizzaManager {

  @PersistenceContext
  EntityManager em;
//private String orientation = "horizontal";
 
  public void addPizza(Pizza p){
  em.persist(p);
  }
  public void addClaims(Claims c){
  em.persist(c);
  }
  public void deletePizza(long id){
      Pizza p = em.find(Pizza.class, id);
  em.remove(p);
  }
  public List<Pizza> getAllPizzas(){
      Query q= em.createQuery("SELECT p FROM Pizza p order by p.id");
      return q.getResultList();
  }
  public List<Claims> getAllClaims(){
      Query q= em.createQuery("SELECT c FROM Claims c order by c.id");
      return q.getResultList();
  }

 
// 
//    public String getOrientation() {
//        return orientation;
//    }
// 
//    public void setOrientation(String orientation) {
//        this.orientation = orientation;
//    }
}
 
  
  

