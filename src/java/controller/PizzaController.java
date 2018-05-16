package controller;

import dao.PizzaManager;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import model.Claims;
import model.Pizza;

@Named(value = "pizzaController")
@RequestScoped
public class PizzaController {

    @Inject
    private PizzaManager pm;
 
    private String name;
    private double price=45;
    private String type;
    private List<String> Type;
    private String menu;

    private String description;
    private List<Pizza> allPizzas;
    private List<Claims> AllClaims;
     private String orientation = "horizontal";
     
    
     
     
    public void submit() {
        Pizza p = new Pizza(name, price, type);
        pm.addPizza(p);
        allPizzas = pm.getAllPizzas();
    }

    public List<Pizza> showAll() {
        allPizzas = pm.getAllPizzas();
        return allPizzas;
    }
    public List<Claims> showClaims() {
        AllClaims = pm.getAllClaims();
        return AllClaims;
    }

    public String sent() {
        Claims c = new Claims(description);
        pm.addClaims(c);
         AllClaims = pm.getAllClaims();
//         description = "";
         return "";
       
    }
   

    public void selectpizza() {

    }

    public void buttonAction(ActionEvent actionEvent) {
        addMessage("Welcome to Primefaces!!");
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public PizzaController() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Pizza> getAllPizzas() {
        return pm.getAllPizzas();
    }

    public void setAllPizzas(List<Pizza> allPizzas) {
        this.allPizzas = allPizzas;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public List<Claims> getAllClaims() {
        return pm.getAllClaims();
    }

    public void setAllClaims(List<Claims> AllClaims) {
        this.AllClaims = AllClaims;
    }
   
    public double priceMin() {
        return price-15;
    }
   
    public double priceMax() {
      return price+15;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }
   
    
 
   
}
