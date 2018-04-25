package com.company;

public class Vehicle {
    private char typen;
    private char drivstoff;
    private String registeringsnummer;

    public Vehicle(char typen, char drivstoff, String registeringsnummer) {
        this.typen = this.isValidType(typen);
        this.drivstoff = this.isValidDrivstoff(drivstoff);
        this.registeringsnummer = this.isValidRegisteringsNummer(registeringsnummer);
    }

    public char getTypen() {
        if (this.typen == 'm') {
            return 'M';
        } else {
            return 'C';
        }
    }

    public char getDrivstoff() {
        return drivstoff;
    }

    public String getRegisteringsnummer() {
        return registeringsnummer;
    }

    public void setRegisteringsnummer(String registeringsnummer) {
        this.registeringsnummer = this.isValidRegisteringsNummer(registeringsnummer);
    }

    public char isValidType(char typen) {
        if(typen == 'm' || typen == 'b') {
            return typen;
        }
        else {
            throw new IllegalArgumentException("Typen må være m eller b.");
        }
    }

    public char isValidDrivstoff(char drivstoff) {
        if (this.typen == 'm' && drivstoff == 'h') {
            throw new IllegalArgumentException("Motorsykler kan ikke kjøre på hydrogen.");
        } else if (drivstoff == 'e' || drivstoff == 'd' || drivstoff == 'b') {
            return drivstoff;
        } else {
            throw new IllegalArgumentException("Drivstoff typen kan bare være h, e, d eller b.");
        }
    }

    public String isValidRegisteringsNummer(String regNummer) {
        String regNummerSub = regNummer.substring(0, 2);
        String firstChar = regNummer.substring(0, 1);
        String secondChar = regNummer.substring(1, 2);

        if (this.typen == 'm' && regNummer.length() != 6) {
            throw new IllegalArgumentException("Registeringsnummeret for motorsykkel må være på 2 bokstaver og 4 sifre.");
        } else if (this.typen == 'b' && regNummer.length() != 7) {
            throw new IllegalArgumentException("Registeringsnummeret for bil må være på 2 bokstaver og 5 sifre.");
        } else if (firstChar.equals(firstChar.toLowerCase()) || secondChar.equals(secondChar.toLowerCase())) {
            throw new IllegalArgumentException("Bokstavene må være store på registeringsnummeret.");
        }

        if (this.drivstoff == 'e') {
            if (regNummerSub.equals("EK") || regNummerSub.equals("EL")) {
                return regNummer;
            }
            else {
                throw new IllegalArgumentException("Registeringsnummeret for elbil må begynne på EL eller EK.");
            }
        } else if (this.drivstoff == 'h') {
            if (regNummerSub.equals("HY")) {
                return regNummer;
            }
            else {
                throw new IllegalArgumentException("Registeringsnummeret for hydrogen må begynne på HY.");
            }
        } else if (this.drivstoff == 'b') {
            if (regNummerSub.equals("EK") || regNummerSub.equals("EL") || regNummerSub.equals("HY") ||
                    firstChar.equals("Æ") || firstChar.equals("Ø") || firstChar.equals("Å") ||
                    secondChar.equals("Æ") || secondChar.equals("Ø") || secondChar.equals("Å")) {
                throw new IllegalArgumentException("Registeringsnummeret kan ikke inneholde EK, EL, HY, Æ, Ø og Å.");
            }
            else {
                return regNummer;
            }
        }
        else {
            throw new IllegalArgumentException("Noe er feil med reg.nummeret.");
        }
    }

    public String toString() {
        return this.typen + " " + this.drivstoff + " " + this.registeringsnummer;
    }
}
