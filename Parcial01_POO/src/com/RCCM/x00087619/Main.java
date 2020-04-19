package com.RCCM.x00087619;
import java.util.Scanner;
import java.util.InputMismatchException;
public class Main {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        String menusecundario = "1. Calcular pago de empleado\n" +
                "2. Ver totales de impuestos cobrados\n" +
                "0. Regresar\t";
        String menuPrincipal = "1. Empleado con plaza fija\n" +
                "2. Empleado de servicio profesional\n" +
                "0. Salir\t";

        byte op=0;
        byte op2=0;
        byte op3=0;
        String nombre,puesto,totales;
        double salario,pago;
        int extension,mesescontrato;
        do{
            System.out.print(menuPrincipal); op = in.nextByte(); in.nextLine();
            switch (op){
                case 1:
                    System.out.print(menusecundario); op2 = in.nextByte(); in.nextLine();
                    switch(op2){
                        case 1:
                              try{
                            System.out.println("Nombre del empleado:"); nombre= in.nextLine();
                            System.out.println("Puesto:"); puesto= in.nextLine();
                            System.out.println("Salario:"); salario= in.nextDouble();
                            if(salario<=0)
                                throw new ArithmeticException("Salario no valido!.");

                            System.out.println("Extensión:"); extension= in.nextInt();
                            PlazaFija emp = new PlazaFija(nombre,puesto,salario,extension);

                            pago=CalculadoraImpuestos.calcularPago(emp);
                            System.out.println("Su salario liquido es: " + pago);
                            break;
                              } catch (InputMismatchException e){
                                  System.out.println("Problema con el Scanner!");
                              }
                              catch (ArithmeticException e) {
                                  System.out.println("Error: " + e.getMessage());
                              }
                        case 2:
                          totales= CalculadoraImpuestos.mostrarTotales();
                            System.out.println(totales);
                            break;

                    }
                    break;
                case 2:
                    System.out.print(menusecundario); op3 = in.nextByte(); in.nextLine();
                    switch(op3){
                        case 1:
                            try{
                            System.out.println("Nombre del empleado:"); nombre= in.nextLine();
                            System.out.println("Puesto:"); puesto= in.nextLine();
                            System.out.println("Salario:"); salario= in.nextDouble();
                                if(salario<=0)
                                    throw new ArithmeticException("Salario no valido!.");
                            System.out.println("Meses del contrato:"); mesescontrato= in.nextInt();
                            ServicioProfesional emp1 = new ServicioProfesional(nombre,puesto,salario,mesescontrato);
                            pago=CalculadoraImpuestos.calcularPago(emp1);
                            System.out.println("Su salario liquido es: " + pago);
                    break;
                            } catch (InputMismatchException e){
                                System.out.println("Problema con el Scanner!");
                            }
                            catch (ArithmeticException e) {
                                System.out.println("Error: " + e.getMessage());
                            }
                        case 2:
                            totales= CalculadoraImpuestos.mostrarTotales();
                            System.out.println(totales);
                            break;
                        }

            }

        } while(op != 0);

    }




}
