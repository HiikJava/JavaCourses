package org.sibsutis.is.vaadin;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.sibsutis.is.database.model.entity.Student;
import javax.inject.Inject;

import com.vaadin.annotations.Push;
import com.vaadin.annotations.Theme;
import com.vaadin.cdi.CDIUI;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
import org.sibsutis.is.database.facade.StudentFacade;


/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */

@Theme("mytheme")
@CDIUI("")
@Push
@SuppressWarnings("serial")
public class MyUI extends UI 
{

   
private static final Logger log = Logger.getLogger(MyUI.class.getName());

   // private StudentService studentService = StudentService.getInstance();

    @Inject
    private StudentFacade studentFacade;
  
    @Override
    protected void init(VaadinRequest vaadinRequest)
    {
        
        
        final VerticalLayout layout = new VerticalLayout();
        
        final TextField fam = new TextField();
        final TextField i = new TextField();
        final TextField o = new TextField();
        
        fam.setCaption("Введите фамилию:");
        i.setCaption("Введите Имя:");
        o.setCaption("Введите отчество:");
        
        
        
        Button button = new Button("Сохранить");
        button.addClickListener( e -> 
        {
            layout.addComponent(new Label("Thanks " + fam.getValue() 
                    + ", it works!"));
            
            log.log(Level.INFO,"Попытка сохранения в базe данных... ");
            if (studentFacade !=null)
            {
                log.log(Level.INFO,"Менеджер {StudentFacade} доступен");
                Student  s = new Student();
                s.setName(i.getValue());
                s.setSureName(fam.getValue());
                s.setMiddleName(o.getValue());
                studentFacade.create(s);
                
                log.log(Level.INFO,"Менеджер {StudentFacade} экземпляр класса сохранен в БД"); 
                
            } 
            else
                {
            log.log(Level.WARNING,"Менеджер {StudentFacade} не  доступен");
        }
            
        });
        
        layout.addComponents(fam,i,o, button);
        
        setContent(layout);
    }
    

 //   @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
 //   @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
 //   public static class MyUIServlet extends VaadinServlet 
 //   {
 //       
 //       
 //       
 //   }

    
}
