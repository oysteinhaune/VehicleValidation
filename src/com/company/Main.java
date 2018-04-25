package com.company;

public class Main {
    // Typen: b eller m. Bil eller moped.
    // Drivstoff: h, e, d, b. Hydrogen, elektrisk, diesel, bensin.
    // Registeringsnummer: To bokstaver fire siffer på moped. To bokstaver fem siffer på bil.
    // HY for hydrogen. EL og EK på elektrisk. Bensin og diesel kan ikke ha Æ, Ø, Å, HY,

    public static void main(String[] args) {
	    Vehicle vehicle = new Vehicle('b', 'b', "HT98700");
	    System.out.println(vehicle);
	    System.out.println(vehicle.getDrivstoff());
	    System.out.println(vehicle.getRegisteringsnummer());
        System.out.println(vehicle.getTypen());
        vehicle.setRegisteringsnummer("HO20150");
        System.out.println(vehicle.getRegisteringsnummer());
    }
}
