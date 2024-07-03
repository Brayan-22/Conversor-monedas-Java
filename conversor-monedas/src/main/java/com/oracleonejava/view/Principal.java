package com.oracleonejava.view;

import java.util.Currency;
import java.util.Locale;
import java.util.Scanner;

import com.oracleonejava.models.Moneda;
import com.oracleonejava.persistence.impl.CurrencyApi;
import com.oracleonejava.services.ConverterService;
import com.oracleonejava.services.impl.ConverterServiceImpl;
import com.oracleonejava.utils.CurrencyEnum;

public class Principal {
    private ConverterService cService;
    public Principal(){
        this.cService = new ConverterServiceImpl(new CurrencyApi());
    }

    public void iniciar() {
        var opciones = """
                1. dolar --> peso argentino
                2. peso argentino --> dolar
                3. dolar --> real brasileño
                4. real brasileño --> dolar
                5. dolar --> peso colombiano
                6. peso colombiano --> dolar
                0. salir""";
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Seleccione una opcion:");
            System.out.println(opciones);
            var opcion = scanner.nextInt();
            if (opcion == 0) break;
            conversiones(opcion);
        }
    }
    private void conversiones(int opcion){
        Scanner scanner = new Scanner(System.in);
        var error = "Error, vuelva a intentarlo";
        System.out.println("Ingrese el valor que desea convertir");
        var valor = scanner.nextDouble();
        Moneda actual = null;
        Moneda nueva = null;
        switch (opcion) {
            case 1:
                actual = new Moneda(valor, Currency.getInstance(CurrencyEnum.USD.toString()));
                nueva = cService.conversion(actual, CurrencyEnum.ARS);
                break;
            case 2:
                actual = new Moneda(valor, Currency.getInstance(CurrencyEnum.ARS.toString()));
                nueva = cService.conversion(actual, CurrencyEnum.USD);
                break;
            case 3:
                actual = new Moneda(valor, Currency.getInstance(CurrencyEnum.USD.toString()));
                nueva = cService.conversion(actual, CurrencyEnum.BRL);
                break;
            case 4:
                actual = new Moneda(valor, Currency.getInstance(CurrencyEnum.BRL.toString()));
                nueva = cService.conversion(actual, CurrencyEnum.USD);
                break;
            case 5:
                actual = new Moneda(valor, Currency.getInstance(CurrencyEnum.USD.toString()));
                nueva = cService.conversion(actual, CurrencyEnum.COP);
                break;
            case 6:
                actual = new Moneda(valor, Currency.getInstance(CurrencyEnum.COP.toString()));
                nueva = cService.conversion(actual, CurrencyEnum.USD);
                break;
            default:
                break;
        }
        if (nueva != null) {
            var res = String.format("El valor  de %f %s es: %f %s ", actual.getValor(),actual.getCurrencySymbol(),nueva.getValor(),nueva.getCurrencySymbol());
            System.out.println(res);
        }else{
            System.out.println(error);
        }
    }

}
