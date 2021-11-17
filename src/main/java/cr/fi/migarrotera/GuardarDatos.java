package cr.fi.migarrotera;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import javax.inject.Named;

@Named
public class GuardarDatos implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        int ingreso = (int) delegateExecution.getVariable("monto");
        int montoSolicit = (int) delegateExecution.getVariable("montoSolicitado");
        double porcentaje;
        porcentaje = ingreso * 0.8;
        if (porcentaje > montoSolicit) {
            System.out.println(porcentaje);
            delegateExecution.setVariable("requierePrenda",true);
        } else {
            System.out.println("Desea agregar una prenda? ");
            delegateExecution.setVariable("requierePrenda",false);
        }
    }

}
