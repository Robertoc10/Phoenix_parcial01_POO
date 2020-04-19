package com.RCCM.x00087619;



public final class CalculadoraImpuestos {
    private static double totalRenta;
    private static double totalISSS;
    private static double totalAFP;



    private CalculadoraImpuestos() {

    }

    public static double calcularPago(Empleado a){
        double renta=0.0;
        double afp=0.0;
        double isss=0.0;
        double restante=0.0;
        double sueldoLiquido=0.0;

        if(a instanceof ServicioProfesional){
            renta= 0.1*(a.getSalario());
            sueldoLiquido= a.getSalario()-renta;
            totalRenta+=renta;
            return sueldoLiquido;
        }else {
          afp= a.getSalario()*(0.0625);
          isss=(a.getSalario()*(0.03));
          totalAFP+=afp;
          totalISSS+=isss;
         restante= (a.getSalario()-afp-isss);
         if(restante>=0.01&&restante<=472.00){
            renta=0;
             totalRenta+=renta;
         }
         else if(restante>=472.01&&restante<=895.24){
           renta=(0.1*(restante-472)+17.67);
             totalRenta+=renta;
         }
         else if(restante>=895.25&&restante<=2038.10){
             renta=(0.2*(restante-895.24)+60);
             totalRenta+=renta;
         }else{
             renta=(0.3*(restante-2038.10)+288.57);
             totalRenta+=renta;
         }

         sueldoLiquido=restante-renta;
        }
        return sueldoLiquido;

    }


    public static String mostrarTotales(){

    return "Renta total: "+totalRenta + "\n"+
            "ISSS total: " + totalISSS+ "\n"+
            "AFP total: "+ totalAFP;
    }

}
